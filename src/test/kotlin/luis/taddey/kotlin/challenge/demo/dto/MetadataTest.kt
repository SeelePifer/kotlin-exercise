package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MetadataTest {
    @Test
    fun `metadata should have correct values`() {
        // Given
        val creationTimestampValue = "2024-01-09T12:34:56Z"
        val generationValue = 1
        val nameValue = "example-name"
        val namespaceValue = "example-namespace"
        val resourceVersionValue = "12345"
        val uidValue = "abcd-1234-efgh-5678"
        val annotations = Annotations(mapOf("key1" to "value1", "key2" to "value2"))
        val labels = Labels(mapOf("label1" to "value1", "label2" to "value2"))

        val metadata = Metadata(
            annotations = annotations,
            creationTimestamp = creationTimestampValue,
            generation = generationValue,
            labels = labels,
            name = nameValue,
            namespace = namespaceValue,
            resourceVersion = resourceVersionValue,
            uid = uidValue
        )

        // When
        val resultCreationTimestamp = metadata.creationTimestamp
        val resultGeneration = metadata.generation
        val resultName = metadata.name
        val resultNamespace = metadata.namespace
        val resultResourceVersion = metadata.resourceVersion
        val resultUid = metadata.uid

        // Then
        assertEquals(creationTimestampValue, resultCreationTimestamp)
        assertEquals(generationValue, resultGeneration)
        assertEquals(nameValue, resultName)
        assertEquals(namespaceValue, resultNamespace)
        assertEquals(resourceVersionValue, resultResourceVersion)
        assertEquals(uidValue, resultUid)
    }
}