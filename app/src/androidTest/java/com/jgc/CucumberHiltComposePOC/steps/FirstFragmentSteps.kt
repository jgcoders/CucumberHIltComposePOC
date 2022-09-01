package com.jgc.CucumberHiltComposePOC.steps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.Navigation.findNavController
import com.jgc.CucumberHiltComposePOC.MainActivity
import com.jgc.CucumberHiltComposePOC.R
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
class FirstFragmentSteps {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @When("^launch first fragment screen$")
    fun launchFirstFragmentScreen() {
        composeRule.activityRule.scenario.onActivity {
            findNavController(it, R.id.nav_host_fragment)
                .navigate(R.id.firstFragment)
        }
    }

    @Then("^first fragment text is displayed$")
    fun firstFragmentTextIsDisplayed() {
        with(composeRule) {
            waitForIdle()
            onNodeWithTag("firstFragmentText").assertIsDisplayed()
        }
    }

    @Then("^click navigate to second fragment button$")
    fun clickNavigateToSecondFragmentButton() {
        with(composeRule) {
            waitForIdle()
            onNodeWithTag("navigateToSecondFragmentButton").performClick()
        }
    }

    @Then("^second fragment text should be visible$")
    fun thenSecondFragmentTextShouldBeVisible() {
        with(composeRule) {
            waitForIdle()
            onNodeWithTag("secondFragmentText").assertIsDisplayed()
        }
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