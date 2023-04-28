package com.eddymy1304.composeinstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .fillMaxWidth()
                .height(1.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        SignUp()
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account?",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Sign up.",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3)
        )
    }
}

@Composable
fun Body(modifier: Modifier) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var clickLoginButton by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) { email = it }
        Spacer(modifier = Modifier.size(8.dp))
        Password(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(8.dp))
        LoginButton(clickLoginButton)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        FacebookLogin()
    }
}

@Composable
fun FacebookLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Facebook icon",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Eddy",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )

    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
    }
}

@Composable
fun LoginButton(click: Boolean) {
    Button(onClick = { }, enabled = click, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Log in")
    }

}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF2196F3)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChange: (String) -> Unit) {
    TextField(value = password, onValueChange = { onTextChange(it) }, Modifier.fillMaxWidth())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChange: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChange(it) }, Modifier.fillMaxWidth())
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ins),
        contentDescription = "Logo instagram",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    //llamar a la activity desde el contexto
    //val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Icon close",
        modifier = modifier
            .clickable { }//activity.finish() }
    )
}