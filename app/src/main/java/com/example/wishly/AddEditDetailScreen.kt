package com.example.wishly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddEditWishView(
    updateId: Long,
    viewModel: WishViewModel,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(R.color.lightPink),
                        Color(0xFFFFF5F7    )
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f) // Increased values for better gradient spread
                )
            )
    ) {
        Scaffold(
            topBar = {
                ActionBar(
                    title = if (updateId == -1L) "Add Wish" else "Edit Wish",
                    showBackArrow = true,
                    onBackArrowPressed = { navController.popBackStack() }
                )
            },
            containerColor = Color.Transparent // Important to ensure the gradient is visible
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.Transparent), // Transparent for gradient visibility
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WishTextView(
                        label = "Enter your wish",
                        value = viewModel.wishTitle,
                        onValueChange = { viewModel.onWishTitleChange(it) }
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    WishTextView(
                        label = "Enter your wish description",
                        value = viewModel.wishDescription,
                        onValueChange = { viewModel.onWishDescriptionChange(it) }
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        modifier = Modifier.padding(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.pink),
                            contentColor = Color.White
                        ),
                        onClick = {
                            if (viewModel.wishTitle.isNotEmpty() && viewModel.wishDescription.isNotEmpty()) {
                                // Update
                            } else {
                                // Add
                            }
                        }
                    ) {
                        Text(
                            text = if (updateId == -1L) "Save" else "Update",
                            modifier = Modifier.padding(8.dp),
                            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun WishTextView(
    label:String,
    value:String,
    onValueChange:(String)->Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label , color = colorResource(R.color.pink))  },
        modifier = Modifier.fillMaxWidth().padding(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.colors(
            focusedTextColor = colorResource(R.color.darkPink),
            unfocusedTextColor =colorResource(R.color.darkPink) ,
            focusedContainerColor = Color.Transparent,   // Background color when focused
            unfocusedContainerColor = Color.Transparent, // Background color when unfocused
            focusedIndicatorColor = colorResource(R.color.pink),          // Border color when focused
            unfocusedIndicatorColor = colorResource(R.color.lightPink),        // Border color when unfocused
            cursorColor = colorResource(R.color.pink)                 // Cursor color
        )
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddEditWishViewPreview() {
    val navController = rememberNavController()
    val viewModel = remember { WishViewModel() }  // Mock ViewModel instance
    AddEditWishView(
        updateId = -1L,
        viewModel = viewModel,
        navController = navController
    )
}


@Preview(showBackground = true)
@Composable
fun WishTextViewPreview() {
    var text by remember { mutableStateOf("") }

    WishTextView(
        label = "Enter your wish",
        value = text,
        onValueChange = { text = it }
    )
}



