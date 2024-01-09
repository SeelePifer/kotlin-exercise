package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LabelsTest {
    @Test
    fun `labels should have correct values`() {
        // Given
        val labelMap = mapOf("key1" to "value1", "key2" to "value2")
        val labels = Labels(labelMap)

        // When
        val result = labels.labels

        // Then
        assertEquals(labelMap, result)
    }
}