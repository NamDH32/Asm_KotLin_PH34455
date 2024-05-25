package com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chinhdev.assignment_kot104.BottomNavigationBar
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.R

data class FavoriteProduct(
    val imageRes: Int,
    val name: String,
    val price: Double
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenFavor(navController: NavHostController) {
    val favoriteProducts = listOf(
        FavoriteProduct(R.drawable.product1, "Coffee Table", 50.0),
        FavoriteProduct(R.drawable.product2, "Coffee Chair", 20.0),
        FavoriteProduct(R.drawable.product3, "Minimal Stand", 25.0),
        FavoriteProduct(R.drawable.product4, "Minimal Desk", 50.0),
        FavoriteProduct(R.drawable.product1, "Minimal Lamp", 12.0)
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search), contentDescription = "",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
                Text(
                    text = "Favorites",
                    fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Image(
                    painter = painterResource(id = R.drawable.cart), contentDescription = "",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(favoriteProducts) { product ->
                    FavoriteItem(product)
                }
            }

            Button(
                onClick = { /* Add all items to cart */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "Add all to my cart",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun FavoriteItem(product: FavoriteProduct) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = product.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "$ ${product.price}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.align(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_delete), contentDescription = "",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_cart), contentDescription = "",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenFavorPreview() {
    val navController = rememberNavController()
    ScreenFavor(navController = navController)
}
