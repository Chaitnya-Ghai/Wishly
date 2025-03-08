package com.example.wishly

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wishly.ui.theme.WishlyTheme


@Composable
fun ActionBar(
    title: String = "Wishly",
    showBackArrow: Boolean = false,
    onBackArrowPressed: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(8.dp)
            .shadow(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.pink))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackArrow) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { onBackArrowPressed() }
                        .weight(1f) // Ensures equal spacing on the left
                )
            } else {
                Spacer(modifier = Modifier.weight(1f)) // Adds empty space if no back arrow
            }
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(2f), // Centers the text in the available space
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f)) // Balances space on the right
        }
    }
}





@Preview(showBackground = true)
@Composable
fun ActionBarPreview() {
    WishlyTheme {
        Column {
            ActionBar("Android", showBackArrow = true) {
                // Simulate back press action
            }
            Spacer(modifier = Modifier.height(8.dp))
            ActionBar("Wishly")
        }
    }
}
