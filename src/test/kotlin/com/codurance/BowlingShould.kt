package com.codurance

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class BowlingShould {
    @Test
    fun calculate_score_for_pins() {
        assertThat(scoreFor(""), `is`(0))
        assertThat(scoreFor("1"), `is`(1))
        assertThat(scoreFor("2"), `is`(2))
        assertThat(scoreFor("23"), `is`(5))
    }
}