package com.example.artspaceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppGallery()
                }
            }
        }
    }
}

@Composable
fun AppGallery(){
    AppGalleryImageAndPicture(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun AppGalleryImageAndPicture(modifier: Modifier= Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource = when(result){
        1 -> R.drawable.artspace1
        2 -> R.drawable.artspace2
        3 -> R.drawable.artspace3
        4 -> R.drawable.artspace4
        else -> R.drawable.artspace1
    }
    val textResource = when(result){
        1 -> R.string.art1
        2 -> R.string.art2
        3 -> R.string.art3
        4 -> R.string.art4
        else -> R.string.art1
    }
    val descResource = when(result){
        1 -> R.string.art1desc
        2 -> R.string.art2desc
        3 -> R.string.art3desc
        4 -> R.string.art4desc
        else -> R.string.art1desc
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Picture Painter",
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResource),
            fontSize = 28.sp,modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(descResource),
            fontSize = 16.sp, modifier = Modifier.padding(36.dp)
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(bottom = 24.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Button(onClick = { result-=1 }) {
            Text(text = stringResource(id = R.string.prev))
        }
        Spacer(modifier = Modifier.width(64.dp))
        Button(onClick = { result+=1 }) {
            Text(text = stringResource(id = R.string.nex))
        }
        Spacer(modifier = Modifier.height(16.dp))
        if(result<1)
            result=4
        if(result>4)
            result=1
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevCheck(){
    ArtSpaceAppTheme {
        AppGallery()
    }
}
