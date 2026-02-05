package com.anasouamira.androidsystemmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.anasouamira.androidsystemmaster.navigation.AppNavGraph
import com.anasouamira.androidsystemmaster.ui.theme.AndroidSystemMasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavGraph()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSystemMasterTheme {
        AppNavGraph()
    }
}