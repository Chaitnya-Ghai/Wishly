package com.example.wishly

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishly.dataClasses.DummyList
import com.example.wishly.dataClasses.Wish
import com.example.wishly.ui.theme.WishlyTheme

@Composable
fun HomeView(
    navController: NavController ,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(R.color.lightPink),
                        Color(0xFFFFF5F7),
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f) // Smoother diagonal gradient
                )
            )
    )
    {
        Scaffold(
            topBar = {
                ActionBar(
                    title = "Wishly", false,
                    onBackArrowPressed = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                    }
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.AddScreen.route)

                    },
                    icon = { Icon(Icons.Default.Add, contentDescription = "Go") },
                    contentColor = Color.White,
                    containerColor = colorResource(R.color.pink),
                    text = { Text(text = "Add") },
                    modifier = Modifier.padding(16.dp)
                )
            },
            containerColor = Color.Transparent // Important to keep Scaffold transparent
        ) { paddingValues ->
            LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                if (DummyList.Wishlist.isEmpty()) {
                    item { Text("No items found", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center) }
                } else {
                    items(DummyList.Wishlist) { item ->
                        WishView(item,{
                            navController.navigate(Screen.AddScreen.route)
                        })
                    }
                }
            }

        }
    }
}

@Composable
fun WishView(
    wish: Wish,
    onWishClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(R.color.p)
        ),
        modifier = Modifier
            .fillMaxWidth().padding(top= 8.dp, start = 10.dp, end = 10.dp )
            .clickable { onWishClicked() },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.elevatedCardElevation(10.dp) // Adds elevation
    ){
        Box(
            modifier = Modifier.clickable { onWishClicked() }
        ){
            Column(
                modifier = Modifier.wrapContentSize().padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally // Centers text horizontally
            ){
                Text(
                    text = wish.title?:"No Title",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top= 8.dp ).align(Alignment.Start)
                )
                Text(
                    text = wish.description?:"No Description",
                    fontWeight = FontWeight.W300,
                    modifier = Modifier.padding(top = 2.dp , start = 2.dp).fillMaxWidth()
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeViewPreview() {
    WishlyTheme {
        Column() {
            HomeView(navController= NavController(LocalContext.current),viewModel = WishViewModel())
        }
    }
}
@Preview()
@Composable
fun WishViewPreview() {
    WishlyTheme {
        WishView(
            wish = Wish(),
            {})
    }
}
