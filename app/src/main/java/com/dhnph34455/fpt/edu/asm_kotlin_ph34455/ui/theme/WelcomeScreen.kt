package com.dhnph34455.fpt.edu.asm_kotlin_ph34455

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavHostController) {
    Scaffold(

    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.welcome), contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "MAKE YOUR",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF606060)
                    )
                    Text(
                        text = "HOME BEAUTIFUL",
                        fontSize = 35.sp,
                        fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                        fontWeight = FontWeight.W700,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 15.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.width(300.dp),
                            fontSize = 18.sp,
                            style = TextStyle(
                                lineHeight = 30.sp
                            ),
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            fontWeight = FontWeight.W700,
                            color = Color(0xFF808080)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .width(160.dp)
                        .height(50.dp)
                        .background(color = Color.Black)
                        .clickable { navController.navigate("login") }
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center

                ) {
                    Text("Get Started", fontSize = 20.sp, color = Color.White)
                }
            }

        }
    }


}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_6_pro")
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}
