package com.jgc.CucumberHiltComposePOC.ui.generator

import kotlin.random.Random

class NumberGeneratorImpl : NumberGenerator {
    override fun generateNumber(): Float {
        return Random.nextFloat()
    }
}