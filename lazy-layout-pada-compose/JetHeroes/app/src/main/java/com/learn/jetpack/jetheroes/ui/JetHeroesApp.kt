package com.learn.jetpack.jetheroes.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.learn.jetpack.jetheroes.ui.theme.JetHeroesTheme

@Composable
fun JetHeroesApp(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun JetHeroesPreview() {
    JetHeroesTheme {
        JetHeroesApp()
    }
}