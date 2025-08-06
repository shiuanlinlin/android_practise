package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                //modifier = Modifier.fillMaxSize() 它的作用是告訴你的 UI 元素去填滿所有可用的空間
                // innerPadding 的作用就是告訴你：「這裡有一些空間是留給 Scaffold 的其他元件的，你應該避開這些空間。」
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding( paddingValues = innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        TextColumn()
//                        Counter()
//                        ButtonEx()
//                        ButtonEnabled()
//                        ButtonStyleEx()
//                        RowEx()
//                        FullExample()
//                        ButtonChange ()
//                        DyamicListEx()
                          RowStatusEx()

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "哈囉! $name!",
        modifier = modifier
    )
}

@Composable
fun ButtonEx() {
    Button(
        onClick = { println("Button clicked") },
    )
    {
       Text("Click Me")
    }
}

@Composable
fun ButtonEnabled() {
    Button(
        onClick = { println("Button clicked") },
        enabled = false
    )
    {
        Text("Click Me enabled")
    }
}

@Composable
fun ButtonStyleEx()
{
    Button(
        onClick = { println("Save")  },
        modifier = Modifier
            .fillMaxWidth()
            .padding( 8.dp),
        enabled = true
    ){
        Text("save", fontSize = 18.sp)
    }
}

@Composable
fun RowEx()
{
    Row() {
        Text(
            text = "Hello" ,
            modifier = Modifier
                .background(Color.Yellow)
            )
        Text(
            text = "Hello two" ,
            modifier = Modifier
                .background(Color.Yellow)
        )
    }
}



@Composable
//Column 將項目排序在頁面上
fun TextColumn() {
    Column {
        Text(
            text = "Alfred Sisley",
            fontSize = 20.sp
        )
        Text(text = "3 minutes ago")
    }
}

@Composable
//按鈕
fun Counter() {
    var count by remember { mutableStateOf(value = 0) }
    Column {
        Text(
            text = "Count: $count",
            //添加樣式
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier.padding( all = 16.dp)
        )
        Button(onClick = { count++ }) { Text( text = "Incremont" ) }
    }
}

@Composable
fun FullExample() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Hello Jetpack Compose" , fontSize = 22.sp , fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {println("Left clicked")},
            ){
                Text("Left")
            }
            Button(
                onClick = {println("Right clicked")}
            ){
                Text("Right")
            }
        }
        Text(
            text = "Click Me",
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { println("Text clicked") }
        )
    }
}

@Composable
//文字按鈕更換效果
fun ButtonChange ()
{
    var message by remember { mutableStateOf("Hello") }
    Column () {
        Text (text = message , fontSize = 20.sp)
        Button(
            //按下後更換文字
            onClick = { message = "今天天氣很好" }
        ) {
            //按鈕本身文字
            Text("按下試試")
        }
    }
}

@Composable
//迴圈
fun DyamicListEx() {
    var lists by remember { mutableStateOf(listOf("Item 1","Item 3")) } //起始值
    var counter by remember { mutableStateOf(3) } //紀錄數值(感覺很像起始數字)
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        lists.forEach { item ->
            Text(text = item , fontSize = 18.sp)
        }

        Button( onClick = {
            counter += 2
            lists = lists + "Item $counter"
        }) {
            Text("Add Item")
        }
    }
}


@Composable
fun RowStatusEx()
{
    var value by remember { mutableStateOf(0) }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Button(onClick = { value-- }) { Text("-") }
        Text("Value: $value" , fontSize = 20.sp)
        Button(onClick = { value++ }) { Text("+") }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}