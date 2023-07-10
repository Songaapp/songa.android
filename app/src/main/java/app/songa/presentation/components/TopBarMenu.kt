package app.songa.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.songa.R
import app.songa.presentation.theme.GreenPrimary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun TopBarMenu(scope: CoroutineScope, scaffoldState: ScaffoldState) {

    TopAppBar(
        title = {},
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
                scope.launch { scaffoldState.drawerState.open() }
            }) {
                Image(
                    painter = painterResource(id = R.drawable.menuiconwhite),
                    contentDescription = "Green Logo",
                    modifier = Modifier.size(
                        width = 35.dp, height = 24.dp,
                    )
                )
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
    )
}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {},
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        actions = {
            IconButton(onClick = {
                expanded = true
            }) {
                Image(
                    painter = painterResource(id = R.drawable.greenlogo),
                    contentDescription = "Green Logo",
                    modifier = Modifier.size(width = 57.dp, height = 61.dp)
                )
            }
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }, modifier = Modifier
                .background(Color.Transparent)
                .width(190.dp)
                .padding(horizontal = 10.dp)
            ) {
                Button(onClick = {
                    navController.navigate("website_screen")
                },
                    border = BorderStroke(2.dp, GreenPrimary),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 20.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 20.dp
                    ),
                    modifier = Modifier.width(170.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.worldicongreen),
                        contentDescription ="Visit website button icon",
                        modifier = Modifier.size(20.dp))

                    Text(
                        "Visit Website",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.dp,),
                        fontSize = 15.sp,
                    )
                }
                Spacer(modifier = Modifier
                    .height(8.dp)
                )
                Button(onClick = {
                    navController.navigate("faqs_screen")
                },
                    border = BorderStroke(2.dp, GreenPrimary),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 20.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 20.dp
                    ),
                    modifier = Modifier
                        .width(170.dp)
                        .padding(end = 50.dp),
                ) {
                    Image(
                        painterResource(id = R.drawable.bookicongreen),
                        contentDescription = "F.A.Qs button icon",
                        modifier = Modifier.size(20.dp)
                    )

                    Text(
                        "F.A.Qs",
                        fontFamily = ibmplexsanshebrew,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 15.sp,
                    )
                }

            }
        },
    )
}