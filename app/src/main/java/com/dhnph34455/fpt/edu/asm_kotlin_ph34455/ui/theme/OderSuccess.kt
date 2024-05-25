package com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.R

@Composable
fun OderSuccess(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SUCCESS!",
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),
            fontWeight = FontWeight.W700,
            fontSize = 40.sp
        )
        Box(
            modifier = Modifier
                .height(250.dp)
                .width(250.dp),
            Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.test),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(Color(0xFFF3F1F1))
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Image(
                    painter = painterResource(id = R.drawable.image_success),
                    contentDescription = "",
                    modifier = Modifier
                        .height(170.dp)
                        .width(170.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.image_v), contentDescription = "",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
            }
        }
        Text(
            text = "Your order will be delivered soon.\nThank you for choosing our app!",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.nunitosans)),
            fontWeight = FontWeight.W700,
            color = Color("#606060".toColorInt())
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(300.dp)
                .height(60.dp)
                .background(color = Color.Black)
                .clickable { },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,


            ) {
            Text("Track your orders", fontSize = 18.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(300.dp)
                .height(60.dp)
                .background(color = Color.White)
                .clickable { navController.navigate("home")}
                .border(
                    width = 2.dp, // Độ dày của viền
                    color = Color.Black, // Màu của viền
                    shape = RoundedCornerShape(8.dp) // Hình dạng của viền (nên giống với clip)
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,


            ) {
            Text("BACK TO HOME", fontSize = 18.sp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewOder() {
    val navController = rememberNavController()
    OderSuccess(navController)
}