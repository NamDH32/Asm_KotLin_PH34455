package com.dhnph34455.fpt.edu.asm_kotlin_ph34455

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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

class Product(var image: Int, var name: String, var price: Double, var quantity: Int) {

}

val listProduct = listOf(
    Product(R.drawable.product2, "Coffee Table", 25.00, 1),
    Product(R.drawable.product2, "Coffee Table", 25.00, 1),
    Product(R.drawable.product2, "Coffee Table", 25.00, 1)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCart(navController : NavHostController) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text("My cart", fontFamily = FontFamily(Font(R.font.merriweather_regular)))
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

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(570.dp)
                .padding(15.dp)
        ) {
            items(listProduct) { pro ->
                ItemCard(
                    image = pro.image,
                    itemName = pro.name,
                    itemPrice = pro.price,
                    quantity = pro.quantity
                )
                Spacer(modifier = Modifier.height(10.dp))

                Divider(color = Color("#D1D1D1".toColorInt()))
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
        ) {
            TextField(
                placeholder = {
                    Text(
                        text = "Enter your promo code",
                        fontFamily = FontFamily(Font(R.font.nn)),
                        fontWeight = FontWeight.W600
                    )
                },
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color("#E0E0E0".toColorInt()),
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                ),

                )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    modifier = Modifier
                        .size(50.dp)
                        .background(color = Color.Black, RoundedCornerShape(14.dp))
                        .shadow(
                            elevation = 1.dp,
                            shape = RoundedCornerShape(14.dp),
                            clip = true
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

        }
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total: ", fontFamily = FontFamily(Font(R.font.nunitosans)),
                fontWeight = FontWeight(700), fontSize = 20.sp,
                color = Color("#808080".toColorInt())
            )
            Text(
                text = "$ 95.00", fontFamily = FontFamily(Font(R.font.nunitosans)),
                fontWeight = FontWeight.Bold, fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color.Black)
                .clickable { navController.navigate("order")},
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,


            ) {
            Text("Check out", fontSize = 20.sp, color = Color.White)
        }
    }
}

@Composable
fun ItemCard(image: Int, itemName: String, itemPrice: Double, quantity: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image), contentDescription = null, modifier = Modifier
                .width(110.dp)
                .height(120.dp)
                .clip(shape = RoundedCornerShape(15.dp)),
            contentScale = ContentScale.FillBounds

        )

        Column(
            modifier = Modifier
                .width(200.dp)
                .padding(start = 10.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = itemName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray, fontFamily = FontFamily(
                        Font(R.font.nn)
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "\$ " + itemPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(
                        Font(R.font.nunitosans)
                    )
                )
            }
            Row(
                modifier = Modifier.width(110.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }
                Text(
                    text = "01",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(
                        Font(R.font.nunitosans)
                    )
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tru),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }


        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_del),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Row {

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_6_pro")
@Composable
fun PreviewItemListScreen() {
    val navController = rememberNavController()
    MyCart(navController)
}