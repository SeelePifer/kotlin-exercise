package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResourcesTest {
    @Test
    fun `resources should have correct values`() {
        // Given
        val limits = Limits(memory = "512Mi")
        val requests = Requests(cpu = "0.5", memory = "256Mi")

        val resources = Resources(limits = limits, requests = requests)

        // When
        val resultLimits = resources.limits
        val resultRequests = resources.requests

        // Then
        assertEquals(limits, resultLimits)
        assertEquals(requests, resultRequests)
    }
}