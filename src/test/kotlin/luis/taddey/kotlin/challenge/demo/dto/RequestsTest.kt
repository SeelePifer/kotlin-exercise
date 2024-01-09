package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestsTest {
    @Test
    fun `requests should have correct values`() {
        // Given
        val cpuValue = "0.5"
        val memoryValue = "256Mi"

        val requests = Requests(cpu = cpuValue, memory = memoryValue)

        // When
        val resultCpu = requests.cpu
        val resultMemory = requests.memory

        // Then
        assertEquals(cpuValue, resultCpu)
        assertEquals(memoryValue, resultMemory)
    }
}