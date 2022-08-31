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
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.jgc.CucumberHiltComposePOC.R
import com.jgc.CucumberHiltComposePOC.ui.first.FirstFragmentContent
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
class FirstFragmentSteps {

    @get:Rule
    val composeRule = createComposeRule()

    @When("^launch first fragment screen$")
    fun launchFirstFragmentScreen() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        // Create a graphical FragmentScenario for the TitleScreen
        /*launchFragmentInHiltContainer<FirstFragment>() {
            // Set the graph on the TestNavHostController
            Navigation.setViewNavController(this.requireView(), navController)

        }*/
        composeRule.setContentWithinTheme {
            navController.setGraph(R.navigation.nav_graph)
            FirstFragmentContent(navController = navController)
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