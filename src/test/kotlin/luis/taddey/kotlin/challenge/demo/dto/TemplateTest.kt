package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TemplateTest {
    @Test
    fun `template should have correct metadata`() {
        // Given
        val metadata = TemplateMetadata(creationTimestamp = "2022-01-01T12:00:00Z")
        val template = Template(metadata = metadata)

        // When
        val resultMetadata = template.metadata

        // Then
        assertEquals(metadata, resultMetadata)
    }

    @Test
    fun `template should have correct spec`() {
        // Given
        val spec = TemplateSpec()
        val template = Template(spec = spec)

        // When
        val resultSpec = template.spec

        // Then
        assertEquals(spec, resultSpec)
    }
}
