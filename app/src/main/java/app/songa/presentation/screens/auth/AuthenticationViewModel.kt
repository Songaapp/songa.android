package app.songa.presentation.screens.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthenticationViewModel : ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())
//    val profile = MutableStateFlow()

    private fun toggleAuthenticationMode() {
        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationMode = if (
            authenticationMode == AuthenticationMode.SIGN_IN
        ) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(
            authenticationMode = newAuthenticationMode
        )
    }
    private fun updateFirstName(firstname: String) {
        uiState.value = uiState.value.copy(
            first_name = firstname
        )
    }
    private fun updateLastName(lastname: String) {
        uiState.value = uiState.value.copy(
            last_name = lastname
        )
    }
    private fun updatePhone(phone: String) {
        uiState.value = uiState.value.copy(
            phone = phone
        )
    }
    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }
        uiState.value = uiState.value.copy(
            password = password,
            passwordRequirements = requirements.toList()
        )
    }

    private fun authenticate() {
        val authenticationMode = uiState.value.authenticationMode
       if(!uiState.value.isLoading) {
           uiState.value = uiState.value.copy(
               isLoading = true
           )
           // trigger network request
//           sendRequest(
//               id = "1",
//           )
           authRequest()
       }
    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(
            error = null
        )
    }

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
            is AuthenticationEvent.FirstNameChanged -> {
                updateFirstName(authenticationEvent.firstname)
            }
            is AuthenticationEvent.LastNameChanged -> {
                updateLastName(authenticationEvent.lastname)
            }
            is AuthenticationEvent.PhoneChanged -> {
                updatePhone(authenticationEvent.phone)
            }
            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }
            is AuthenticationEvent.Authenticate -> {
                authenticate()
            }
            is AuthenticationEvent.ErrorDismissed -> {
                dismissError()
            }
        }
    }

    private  fun sendRequest(
        id: String,
//        profileState: MutableState<ProfileModel>
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.109:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(AuthenticationAPI::class.java)

        val call: Call<UserModel?>? = api.getUserById(id);

        call!!.enqueue(object: Callback<UserModel?> {
            override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {
                if(response.isSuccessful) {
                    Log.d("Main", "--------> success! " + response.body().toString())
//                    profileState.value = response.body()!!.profile
                }
            }

            override fun onFailure(call: Call<UserModel?>, t: Throwable) {
                Log.e("Main", "--------> Failed mate " + t.message.toString())
            }
        })
        Log.d("Main", "--------> Done")
    }

    private  fun authRequest() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://songa-api.onrender.com/api/users/auth/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(AuthenticationAPI::class.java)

        //        val dataModel = if(uiState.value.authenticationMode == AuthenticationMode.SIGN_IN) {LoginModel(phone = uiState.value.phone, password = uiState.value.password)} else {
//            RegisterModel(first_name = uiState.value.firstname, last_name = uiState.value.lastname, phone = uiState.value.phone, password = uiState.value.password)
//        }

        val dataModel = LoginModel(phone = uiState.value.phone, password = uiState.value.password)

        val call: Call<AuthModelLogin?>? = api.login(dataModel)

        call!!.enqueue(object: Callback<AuthModelLogin?> {
            override fun onResponse(call: Call<AuthModelLogin?>, response: Response<AuthModelLogin?>) {
                // Log request headers
                val requestHeaders = call.request().headers.toString()
                Log.d("Main", "Request Headers: $requestHeaders")

                // Log request payload
                val requestBody = call.request().body?.toString() ?: ""
                Log.d("Main", "Request Payload: $requestBody")

                // Log response headers
                val responseHeaders = response.headers().toString()
                Log.d("Main", "Response Headers: $responseHeaders")

                val responseBody = response.body().toString()
                Log.d("Main", "Response Body: $responseBody")

                if(response.isSuccessful) {
                    val model: AuthModelLogin? = response.body()
                    Log.d("Main", "--------> success! " + response.body().toString())
                    Log.d("Main", "--------> success Auth! " + model.toString())
                    Log.d("Main", "--------> success Auth Message! " + model.toString())

                    val msg = model!!.message
                    val user = model!!.user

                    if(uiState.value.isLoading) {
                        uiState.value = uiState.value.copy(
                            isLoading = false,
                        )
                    }
                    if(msg == "login successfull, using old token") {
                        uiState.value = uiState.value.copy(
                            isSignedIn = true,
                            first_name = user!!.first_name,
                            last_name = user!!.last_name,
                            phone = user!!.phone,
                            email = user!!.email,
                            avatar = user!!.avatar,
                            id = user!!.id,
                            address = user!!.address,
                            sessionToken = user!!.sessionToken
                        )
                        Log.d("Main", "--------> success Auth Session! " + uiState.value.sessionToken)
                    }
                    else {
                        uiState.value = uiState.value.copy(
                            error = "Incorrect phone/password"
                        )
                    }

                }
            }

            override fun onFailure(call: Call<AuthModelLogin?>, t: Throwable) {
                Log.e("Main", "--------> Failed mate " + t.message.toString())
                if(uiState.value.isLoading) {
                    uiState.value = uiState.value.copy(
                        isLoading = false
                    )
                }
            }
        })
    }

}