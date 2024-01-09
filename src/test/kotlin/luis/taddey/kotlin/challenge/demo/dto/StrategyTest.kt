package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrategyTest {
    @Test
    fun `strategy should have correct type`() {
        // Given
        val type = "Type1"
        val strategy = Strategy(type = type)

        // When
        val resultType = strategy.type

        // Then
        assertEquals(type, resultType)
    }

    @Test
    fun `strategy should have correct rollingUpdate`() {
        // Given
        val rollingUpdate = RollingUpdate(maxSurge = "2", maxUnavailable = "1")
        val strategy = Strategy(rollingUpdate = rollingUpdate)

        // When
        val resultRollingUpdate = strategy.rollingUpdate

        // Then
        assertEquals(rollingUpdate, resultRollingUpdate)
    }
}