package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //繪製區域
        setContent {
            MyApplicationTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    CreatBizCards ()
                }
            }
        }
    }
}


@Composable
fun CreatBizCards (){
    //畫布就像div
    Surface(modifier = Modifier.fillMaxSize()){
        Card(
            //鍊式呼叫
            modifier = Modifier.fillMaxSize().padding(12.dp),
            colors = CardDefaults.cardColors( containerColor = Color.White),
            //陰影
            elevation = CardDefaults.cardElevation( defaultElevation = 4.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImagesDiv()
                //水平線
                HorizontalDivider(
                    color = Color.LightGray,
                    thickness = 1.dp
                )
                //資料區域
                Extracted()
                //按鈕
                Button(
                    onClick = {
                        Log.i("MainActivity","Button click")
                    }
                ){
                    Text(
                        text = "專案列表"
                    )
                }

                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = Color.LightGray,
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RoundedCornerShape( corner = CornerSize(5.dp)) //圓角
                ) {

                }

            }
        }
    }
}

@Composable
private fun Extracted() {
    Column(modifier = Modifier.padding(5.dp))
    {
        Text(
            text = "王大明 ABC",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Android 練習")
        Text(text = "@abcde")
    }
}

@Composable
//需要添加預設(modifier:Modifier = Modifier)
//private fun ImagesDiv(modifier: Modifier = Modifier)
private fun ImagesDiv()
{
    Surface(
        modifier = Modifier.padding(5.dp),
        shape = CircleShape, //圓形
        border = BorderStroke(0.5.dp,Color.LightGray),
        shadowElevation = 4.dp //陰影
    ) {
        Image (
            painter = painterResource(R.drawable.profile_image),
            contentDescription = "人像圖",
            modifier = Modifier.size(150.dp)
        )
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        CreatBizCards()
    }
}