package luis.taddey.kotlin.challenge.demo.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AnnotationsTest {
    @Test
    fun `create Annotations with null value`() {
        // Given

        // When
        val annotations = Annotations()

        // Then
        assertThat(annotations.annotations).isNull()
    }

    @Test
    fun `create Annotations with non-null value`() {
        // Given
        val values = mapOf("key1" to "value1", "key2" to "value2")

        // When
        val annotations = Annotations(annotations = values)

        // Then
        assertThat(annotations.annotations).isEqualTo(values)
    }
}