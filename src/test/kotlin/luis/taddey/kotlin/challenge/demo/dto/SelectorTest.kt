package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SelectorTest {
    @Test
    fun `selector should have correct matchLabels`() {
        // Given
        val matchLabels = mapOf("key1" to "value1", "key2" to "value2")
        val selector = Selector(matchLabels = matchLabels)

        // When
        val resultMatchLabels = selector.matchLabels

        // Then
        assertEquals(matchLabels, resultMatchLabels)
    }

}