package com.jgc.CucumberHiltComposePOC.steps

import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = [
        "features"
    ],
    plugin = ["pretty"],
    glue = ["com.jgc.CucumberHiltComposePOC.steps"],
)
@Suppress("unused")
class CucumberConfiguration