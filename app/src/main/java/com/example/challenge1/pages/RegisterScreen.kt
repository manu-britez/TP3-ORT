package com.example.challenge1.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge1.R
import com.example.challenge1.ui.theme.Challenge1Theme
import com.example.challenge1.ui.theme.PrimaryBlue

@Composable
fun RegisterScreen(onBackClick: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Geometric Elements
            Canvas(modifier = Modifier.fillMaxSize()) {
                val lightBlue = Color(0xFFF1F4FF)
                drawCircle(
                    color = lightBlue,
                    radius = 400f,
                    center = Offset(size.width * 0.9f, size.height * 0.1f)
                )
                
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))

                Text(
                    text = stringResource(R.string.register_title),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = stringResource(R.string.register_subtitle),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(50.dp))

                // Email TextField
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = stringResource(R.string.email_placeholder)) },
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF1F4FF),
                        unfocusedContainerColor = Color(0xFFF1F4FF),
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Password TextField
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = stringResource(R.string.password_placeholder)) },
                    shape = RoundedCornerShape(10.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF1F4FF),
                        unfocusedContainerColor = Color(0xFFF1F4FF),
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Confirm Password TextField
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = stringResource(R.string.confirm_password_placeholder)) },
                    shape = RoundedCornerShape(10.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF1F4FF),
                        unfocusedContainerColor = Color(0xFFF1F4FF),
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Sign Up Button
                Button(
                    onClick = { /* Handle Sign Up */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.sign_up_button),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Already have account
                TextButton(onClick = onBackClick) {
                    Text(
                        text = stringResource(R.string.already_have_account),
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Or continue with
                Text(
                    text = stringResource(R.string.or_continue_with),
                    color = PrimaryBlue,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Social Icons Row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    SocialIconButton(text = "G")
                    SocialIconButton(text = "f")
                    SocialIconButton(text = "A")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Challenge1Theme {
        RegisterScreen()
    }
}
