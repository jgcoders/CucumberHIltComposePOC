package com.jgc.CucumberHiltComposePOC.steps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.Navigation.findNavController
import androidx.test.espresso.Espresso
import com.jgc.CucumberHiltComposePOC.MainActivity
import com.jgc.CucumberHiltComposePOC.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
@HiltAndroidTest
class FirstFragmentSteps {

//    @get: Rule(order = 0)
//    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
//        hiltRule.inject()
    }

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

    @Then("^navigating back$")
    fun thenNavigatingBack() {
        Espresso.pressBack()
    }
}