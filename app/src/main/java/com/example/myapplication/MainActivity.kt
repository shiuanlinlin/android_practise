package com.example.myapplication

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
                    Column(modifier = Modifier.padding( paddingValues = innerPadding)) {
                        textColumn()
                        Counter()
                        ButtonEx()
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
    Button( onClick = { println("Button clicked") } ) {
       Text("Click Me")
    }
}



@Composable
//Column 將項目排序在頁面上
fun textColumn() {
    Column {
        Text(
            text = "Alfred Sisley",
            fontSize = 20.sp
        )
        Text("3 minutes ago")
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}