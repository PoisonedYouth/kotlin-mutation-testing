package com.poisonedyouth

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationServiceTest {

    @Test
    fun `filterList returns empty list for empty input`(){
        // given
        val list = emptyList<String>()
        val filter = "test"

        // when
        val actual = ApplicationService.filterList(list, filter)

        // then
        assertThat(actual).isEmpty()
    }

    @Test
    fun `filterList returns empty list for empty filter`(){
        // given
        val list = listOf("a", "b", "c")
        val filter = ""

        // when
        val actual = ApplicationService.filterList(list, filter)

        // then
        assertThat(actual).isEqualTo(list)
    }

    @Test
    fun `filterList returns empty list for no matching input`(){
        // given
        val list = listOf("a", "b", "c")
        val filter = "test"

        // when
        val actual = ApplicationService.filterList(list, filter)

        // then
        assertThat(actual).isEmpty()
    }

    @Test
    fun `filterList returns matching list`(){
        // given
        val list = listOf("a", "b", "c", "d", "e", "ab")
        val filter = "a"

        // when
        val actual = ApplicationService.filterList(list, filter)

        // then
        assertThat(actual).containsExactlyInAnyOrder("a", "ab")
    }
}

