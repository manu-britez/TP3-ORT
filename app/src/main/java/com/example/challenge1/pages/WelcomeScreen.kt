package com.example.challenge1.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge1.R
import com.example.challenge1.ui.theme.Challenge1Theme
import com.example.challenge1.ui.theme.PrimaryBlue

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Geometric Elements
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Drawing some subtle light blue shapes/lines as seen in the background
                val lightBlue = Color(0xFFF1F4FF)
                drawCircle(
                    color = lightBlue,
                    radius = 400f,
                    center = Offset(size.width * 0.9f, size.height * 0.1f)
                )
                
                // Bottom lines/shapes
                drawLine(
                    color = lightBlue,
                    start = Offset(0f, size.height * 0.8f),
                    end = Offset(size.width, size.height * 0.95f),
                    strokeWidth = 2f
                )
                drawLine(
                    color = lightBlue,
                    start = Offset(size.width * 0.2f, size.height),
                    end = Offset(size.width * 0.8f, size.height * 0.7f),
                    strokeWidth = 2f
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Illustration
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.welcome_image__1_),
                        contentDescription = stringResource(R.string.illustration_placeholder),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.welcome_title),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue,
                    textAlign = TextAlign.Center,
                    lineHeight = 45.sp
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = stringResource(R.string.welcome_description),
                    fontSize = 14.sp,
                    color = Color.Black.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(80.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.login_button),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }

                    TextButton(
                        onClick = onRegisterClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.register_button),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    Challenge1Theme {
        WelcomeScreen()
    }
}
