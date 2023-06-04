package app.songa.data.models.login

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.util.InternalAPI

interface UserRepository {
    suspend fun login(phone: String, password: String): LoginResponse
}

@Suppress("OPT_IN_IS_NOT_ENABLED")
class UserRepositoryImpl(private val httpClient: HttpClient) : UserRepository {
    @OptIn(InternalAPI::class)
    override suspend fun login(phone: String, password: String): LoginResponse {
        val response: HttpResponse = httpClient.post("https://songa-api.onrender.com/api/users/auth/login-user") {
            header(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            body = LoginRequest(phone, password)
        }

        return response.body()
    }
}


