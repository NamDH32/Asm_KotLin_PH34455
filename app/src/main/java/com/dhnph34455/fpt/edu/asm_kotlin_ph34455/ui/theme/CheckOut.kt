package com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutSceen(navController : NavHostController) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text("Check out", fontFamily = FontFamily(Font(R.font.merriweather_regular)))
            },
            navigationIcon = {
                IconButton(onClick = {navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        modifier = Modifier
                            .height(20.dp)
                            .width(8.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                titleContentColor = Color.Black,
                navigationIconContentColor = Color.Black
            )
        )
        Column(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Shipping Address", fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans)),
                        color = Color("#909090".toColorInt()),
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_sua),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                ShippingAddressCard()
            }
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Payment", fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans)),
                        color = Color("#909090".toColorInt()),
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_sua),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.card),
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(90.dp)
                        )
                        Text(text = "**** **** **** 6789")
                    }
                }
            }
//phuong thuc thanh toan
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Delivery method", fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans)),
                        color = Color("#909090".toColorInt()),
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_sua),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.dhl),
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(90.dp)
                                .padding(start = 15.dp, end = 15.dp)
                        )
                        Text(text = "Fast (2-3days)")
                    }
                }
            }


            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .height(120.dp)
                        .padding(start = 15.dp, end = 15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Order: ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            color = Color("#808080".toColorInt()),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$ 95.00",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Delivery: ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            color = Color("#808080".toColorInt()),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$ 5.00",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total: ",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            color = Color("#808080".toColorInt()),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$ 100.00",
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans)),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(color = Color.Black)
                    .clickable { navController.navigate("sucssces")},
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,


                ) {
                Text("SUBMIT ORDER", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun ShippingAddressCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(127.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "Bruno Fernandes", fontWeight = FontWeight.Bold, fontSize = 18.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
            Divider()
            Text(
                "25 rue Robert Latouche, Nice, 06200, Côte D'azur, France",
                modifier = Modifier.padding(start = 15.dp),
                fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.nn))
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_6_pro")
@Composable
fun PreviewCheckOut() {
    val navController = rememberNavController()
    CheckOutSceen(navController)
}