package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LimitsTest {
    @Test
    fun `limits should have correct values`() {
        // Given
        val memoryValue = "512Mi"
        val limits = Limits(memory = memoryValue)

        // When
        val result = limits.memory

        // Then
        assertEquals(memoryValue, result)
    }

}