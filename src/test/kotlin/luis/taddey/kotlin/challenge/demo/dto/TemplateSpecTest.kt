package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TemplateSpecTest {
    @Test
    fun `template spec should have correct containers`() {
        // Given
        val containers = listOf(
            Container(image = "image1"),
            Container(image = "image2")
        )
        val templateSpec = TemplateSpec(containers = containers)

        // When
        val resultContainers = templateSpec.containers

        // Then
        assertEquals(containers, resultContainers)
    }

    @Test
    fun `template spec should have correct DNS policy`() {
        // Given
        val dnsPolicy = "ClusterFirst"
        val templateSpec = TemplateSpec(dnsPolicy = dnsPolicy)

        // When
        val resultDnsPolicy = templateSpec.dnsPolicy

        // Then
        assertEquals(dnsPolicy, resultDnsPolicy)
    }

    @Test
    fun `template spec should have correct restart policy`() {
        // Given
        val restartPolicy = "Always"
        val templateSpec = TemplateSpec(restartPolicy = restartPolicy)

        // When
        val resultRestartPolicy = templateSpec.restartPolicy

        // Then
        assertEquals(restartPolicy, resultRestartPolicy)
    }
}