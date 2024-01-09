package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TemplateMetadataTest {
    @Test
    fun `template metadata should have correct creation timestamp`() {
        // Given
        val creationTimestamp = "2022-01-01T12:00:00Z"
        val templateMetadata = TemplateMetadata(creationTimestamp = creationTimestamp)

        // When
        val resultCreationTimestamp = templateMetadata.creationTimestamp

        // Then
        assertEquals(creationTimestamp, resultCreationTimestamp)
    }

    @Test
    fun `template metadata should have correct labels`() {
        // Given
        val labels = mapOf("key1" to "value1", "key2" to "value2")
        val templateMetadata = TemplateMetadata(labels = labels)

        // When
        val resultLabels = templateMetadata.labels

        // Then
        assertEquals(labels, resultLabels)
    }
}