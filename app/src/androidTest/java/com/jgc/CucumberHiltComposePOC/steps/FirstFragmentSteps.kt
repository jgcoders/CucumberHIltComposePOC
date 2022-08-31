package com.jgc.CucumberHiltComposePOC.steps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.jgc.CucumberHiltComposePOC.ui.first.FirstFragmentContent
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule


@WithJunitRule
class FirstFragmentSteps() {

    @get:Rule
    val composeRule = createComposeRule()

    @When("^launch first fragment screen$")
    fun launchFirstFragmentScreen() {
        composeRule.setContentWithinTheme {
            FirstFragmentContent(navController = navController)
        }
    }

    @Then("^first fragment text is displayed$")
    fun firstFragmentTextIsDisplayed() {
        composeRule.onNodeWithTag("firstFragmentText").assertIsDisplayed()
    }

    @Then("^click navigate to second fragment button$")
    fun clickNavigateToSecondFragmentButton() {
        composeRule.onNodeWithTag("navigateToSecondFragmentButton").performClick()
    }
}

fun ComposeContentTestRule.setContentWithinTheme(content: @Composable () -> Unit) {
    setContent {
        MaterialTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                content()
            }
        }
    }
}