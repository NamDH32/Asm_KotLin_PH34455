package com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.BottomNavigationBar
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenHome(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Make home",
                        fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp,
                        color = Color("#909090".toColorInt()),
                    )
                    Text(
                        text = "BEAUTIFUL",
                        fontFamily = FontFamily(Font(R.font.gelasio_variablefont_wght)),
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.cart), contentDescription = "",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
            ListItemCategory(
                imageList = listOf(
                    R.drawable.item1,
                    R.drawable.ic_chair,
                    R.drawable.ic_table,
                    R.drawable.ic_tablechair,
                    R.drawable.ic_bed,
                    R.drawable.ic_bed,
                    R.drawable.ic_bed,
                ),
                textList = listOf("Popular", "Chair", "Table", "Armchair", "Bed", "Lamp", "Stand")
            )
            ListProductItem(
                listImageProduct = listOf(
                    R.drawable.product1,
                    R.drawable.product2,
                    R.drawable.product3,
                    R.drawable.product4,
                    R.drawable.product1,
                    R.drawable.product2
                ),
                listNameProduct = listOf(
                    "Black Simple Lamp",
                    "Minimal Stand",
                    "Coffee Chair",
                    "Simple Desk",
                    "Product 5",
                    "Product 6"
                ),
                listPriceProduct = listOf(
                    10.0,
                    20.0,
                    30.0,
                    40.0,
                    50.0,
                    60.0
                )
            )


        }
    }

}

@Composable
fun ListItemCategory(imageList: List<Int>, textList: List<String>) {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
    ) {
        imageList.forEachIndexed { index, i ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = i), contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Text(
                    text = textList.getOrNull(index) ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans)),
                    fontWeight = FontWeight.W700
                )
            }
        }

    }
}

@Composable
fun ListProductItem(
    listImageProduct: List<Int>,
    listNameProduct: List<String>,
    listPriceProduct: List<Double>
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(listImageProduct.size) { index ->
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = listImageProduct[index]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(170.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = listNameProduct.getOrNull(index) ?: "",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp,
                    color = Color("#606060".toColorInt()),
                    fontWeight = FontWeight.W800,
                    fontFamily = FontFamily(Font(R.font.nunitosans))

                )
                Text(
                    text = "$ ${listPriceProduct.getOrNull(index) ?: ""}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp,
                    color = Color("#606060".toColorInt()),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHomePreview() {
    val navController = rememberNavController()
    ScreenHome(navController = navController)
}