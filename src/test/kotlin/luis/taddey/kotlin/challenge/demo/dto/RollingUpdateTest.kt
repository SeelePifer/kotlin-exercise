package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RollingUpdateTest {
    @Test
    fun `rolling update should have correct values`() {
        // Given
        val rollingUpdate = RollingUpdate(maxSurge = "2", maxUnavailable = "1")

        // When
        val resultMaxSurge = rollingUpdate.maxSurge
        val resultMaxUnavailable = rollingUpdate.maxUnavailable

        // Then
        assertEquals("2", resultMaxSurge)
        assertEquals("1", resultMaxUnavailable)
    }
}