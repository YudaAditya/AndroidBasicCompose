package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BussinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BussinessCardApp() {
    Column(
        Modifier
            .background(Color(0xFF073042))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        ComposableImageCard(
            name = "Yuda Aditya",
            title = "UX Designer",
            image = painterResource(id = R.drawable.android_logo)
        )
        ComposableContactCard(phoneNumber = "3249879812", socialMedia = "90380289", email = "yudauad")
    }
}

@Composable
private fun ComposableImageCard(
    name: String,
    title: String,
    image: Painter,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 4.dp)
                .height(100.dp)
                .width(100.dp)
        )
        Text(
            text = name,
            fontSize = 48.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Light
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
private fun ComposableContactCard(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val MyAppIcons = Icons.Rounded
    Column(
        modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Localized description",
                tint = Color(0xFF3ddc84)
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Localized description",
                tint = Color(0xFF3ddc84)
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Localized description",
                tint = Color(0xFF3ddc84)
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BussinessCardTheme {
        BussinessCardApp()
    }
}