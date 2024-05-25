package com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun ProductDetailScreen(navController: NavHostController) {
    var selectedColor by remember { mutableStateOf(Color.Gray) }
    var quantity by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        header(navController)
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White)
        ) {
            Text(
                text = "Minimal Stand",
                fontFamily = FontFamily(Font(R.font.nunitosans)),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$50",
                    fontFamily = FontFamily(Font(R.font.nunitosans)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Row(
                    modifier = Modifier.width(100.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .shadow(0.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                Color("#DEDEDE".toColorInt()),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .size(30.dp)
                    ) {
                        IconButton(onClick = { if (quantity > 1) quantity-- }) {
                            Icon(
                                painter = painterResource(id = R.drawable.tru),
                                contentDescription = "Decrease Quantity",
                                modifier = Modifier.size(10.dp)
                            )
                        }
                    }
                    Text(text = quantity.toString(), style = MaterialTheme.typography.bodyLarge)
                    Box(
                        modifier = Modifier
                            .shadow(0.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                Color("#DEDEDE".toColorInt()),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .size(30.dp)
                    ) {
                        IconButton(onClick = { quantity++ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_add_24),
                                contentDescription = "Increase Quantity",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.width(150.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(Icons.Filled.Star, contentDescription = "Rating", tint = Color(0xFFFFC107))
                Text(text = "4.5", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "(50 reviews)",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    fontSize = 15.sp,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Minimal Stand is made of natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                textAlign = TextAlign.Justify,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(60.dp)
                        .background(color = Color("#DEDEDE".toColorInt()))
                        .clickable { },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Image(painter = painterResource(id = R.drawable.ic_marker2), contentDescription = "",
                        modifier = Modifier.size(20.dp))
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .width(300.dp)
                        .height(60.dp)
                        .background(color = Color.Black)
                        .clickable { navController.navigate("cart")},
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Text("Add to cart", fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun header(navController: NavHostController) {
    var selectedColor by remember { mutableStateOf(Color.Gray) }

    Box(
        modifier = Modifier
            .height(500.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Row {

                }
                Image(
                    painter = painterResource(id = R.drawable.product2),
                    contentDescription = "",
                    modifier = Modifier
                        .width(350.dp)
                        .fillMaxHeight()
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(bottomStart = 52.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(125.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .size(45.dp)
                            .background(color = Color.White, RoundedCornerShape(14.dp))
                            .shadow(
                                elevation = 0.dp,
                                shape = RoundedCornerShape(14.dp),
                                clip = true
                            )
                            .clickable { navController.navigateUp() },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrowback),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(70.dp)
                            .shadow(5.dp, shape = RoundedCornerShape(35.dp))
                            .background(Color.White, shape = RoundedCornerShape(35.dp))
                            .border(1.dp, Color.White, RoundedCornerShape(35.dp))
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {


                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ColorOption(
                                color = Color.White,
                                isSelected = selectedColor == Color.Gray
                            ) { selectedColor = it }
                            ColorOption(
                                color = Color("#B4916C".toColorInt()),
                                isSelected = selectedColor == Color(0xFFFFEB3B)
                            ) { selectedColor = it }
                            ColorOption(
                                color = Color("#E4CBAD".toColorInt()),
                                isSelected = selectedColor == Color(0xFF795548)
                            ) { selectedColor = it }
                        }
                    }
                    Row {

                    }
                }
            }
        }
    }
}

@Composable
fun ColorOption(color: Color, isSelected: Boolean, onClick: (Color) -> Unit) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(color)
            .clickable { onClick(color) }
            .border(
                width = 7.dp,
                color = if (isSelected) Color("#909090".toColorInt()) else Color("#F0F0F0".toColorInt()),
                shape = CircleShape
            )
    )
}

@Preview(showBackground = true, device = "id:pixel_6_pro")
@Composable
fun PreviewProductDetailScreen() {
    val navController = rememberNavController()
    ProductDetailScreen(navController)
}
