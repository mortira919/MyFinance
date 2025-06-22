package com.example.myfinance.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfinance.R

@Composable
fun RegisterScreen() {
    val selectedTab = remember { mutableStateOf("Регистрация") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Используем Column, учитывающую клавиатуру
    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding() // корректно поднимает всё при появлении клавиатуры
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Логотип с точным размером
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFFFF3B30), fontWeight = FontWeight.Black)) {
                    append("My")
                }
                withStyle(style = SpanStyle(color = Color(0xFF28A745), fontWeight = FontWeight.Black)) {
                    append("Finance")
                }
            },
            fontSize = 36.sp, // как в макете
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Вкладки
        AuthTabSwitcher(
            selectedTab = selectedTab.value,
            onTabSelected = { selectedTab.value = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Поля
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Введите ваш адрес эл. почты",
            icon = Icons.Default.Email
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Придумайте пароль",
            icon = Icons.Default.Lock,
            password = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = "Подтвердите пароль",
            icon = Icons.Default.Lock,
            password = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF28A745)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Зарегистрироваться", color = Color.White, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Войти через Google", color = Color(0xFF5F5F5F))
        }

        Spacer(modifier = Modifier.height(24.dp)) // нижний отступ
    }
}
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: ImageVector,
    password: Boolean = false
) {
    val visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(placeholder, fontSize = 14.sp) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        modifier = Modifier.fillMaxWidth(), // ❌ без .height(56.dp)!
        shape = RoundedCornerShape(6.dp),
        visualTransformation = visualTransformation,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray,
            focusedLabelColor = Color.DarkGray,
            unfocusedLabelColor = Color.Gray,
            cursorColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}