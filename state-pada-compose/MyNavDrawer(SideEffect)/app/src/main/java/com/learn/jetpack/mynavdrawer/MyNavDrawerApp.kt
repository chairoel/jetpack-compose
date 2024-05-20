package com.learn.jetpack.mynavdrawer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.learn.jetpack.mynavdrawer.ui.theme.MyNavDrawerTheme

@Composable
fun MyNavDrawerApp() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNavDrawerTheme {
        MyNavDrawerApp()
    }
}