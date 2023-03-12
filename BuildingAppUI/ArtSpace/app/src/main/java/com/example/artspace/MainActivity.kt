package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtspaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtworkWall(
    artworkImage: Int,
    artworkArtist: String,
    artworkTitle: String,
    artworkYear: String,
    modifier: Modifier = Modifier
) {

        Surface(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(8.dp),
            tonalElevation = 16.dp,
            shadowElevation = 4.dp,
            modifier = Modifier
//                .padding(16.dp)
                .border(BorderStroke(2.dp, color = MaterialTheme.colorScheme.outline))
                .size(height = 500.dp, width = 500.dp)
        ) {
            Image(
                painter = painterResource(id = artworkImage),
                contentDescription = "",
                modifier
                    .wrapContentSize()
                    .padding(16.dp)
            )
        }


    Spacer(modifier.height(24.dp))

    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 16.dp,
        shadowElevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = artworkTitle,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
            )
            Spacer(modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = artworkArtist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier.width(8.dp))

                Text(
                    text = artworkYear,
                    fontSize = 16.sp,
                )
            }
        }

    }

}


@Composable
fun ArtspaceApp() {
var currentArt by remember{ mutableStateOf(1) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
    ) {
        when (currentArt) {
            1 -> {
                ArtworkWall(
                    artworkImage = R.drawable.aerial_rebuild_7,
                    "Dragoon Spear",
                    "Aerial Rebuild",
                    "2022"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { currentArt=2 }) {
                        Text("Next")
                    }
                }

            }

            2 -> {
                ArtworkWall(
                    artworkImage = R.drawable.astray_red_frame,
                    "Dragoon Spear",
                    "Astray Red Frame",
                    "2021"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Button(
                        onClick = { currentArt = 1}
                    ) {
                        Text("Previous")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { currentArt = 3 }) {
                        Text("Next")
                    }
                }
            }
            3 -> {
                ArtworkWall(
                    artworkImage = R.drawable.gundam_astraea_type_f2,
                    "Dragoon Spear",
                    "Astraea Type F2",
                    "2020"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Button(
                        onClick = { currentArt=2 }
                    ) {
                        Text("Previous")
                    }
                }
            }
        }
        

        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtspaceApp()
    }
}