package com.jgc.CucumberHiltComposePOC.ui.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jgc.CucumberHiltComposePOC.R


@Composable
fun FirstFragmentContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First fragment",
            modifier = Modifier.testTag("firstFragmentText")
        )
        Spacer(modifier = Modifier)
        Button(
            modifier = Modifier.testTag("navigateToSecondFragmentButton"),
            onClick = {
                navController.navigate(R.id.secondFragment)
            },
            content = {
                Text("Navigate to second fragment")
            }
        )
    }
}