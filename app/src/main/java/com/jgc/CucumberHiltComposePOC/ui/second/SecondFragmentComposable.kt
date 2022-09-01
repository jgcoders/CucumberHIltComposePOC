package com.jgc.CucumberHiltComposePOC.ui.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

@Composable
fun SecondFragmentComposable() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {
        Text(text = "Second fragment", modifier = Modifier.testTag("secondFragmentText"))
    }
}