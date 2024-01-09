package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpecTest {
    @Test
    fun `spec should have correct progressDeadlineSeconds`() {
        // Given
        val progressDeadlineSeconds = 60
        val spec = Spec(progressDeadlineSeconds = progressDeadlineSeconds)

        // When
        val resultProgressDeadlineSeconds = spec.progressDeadlineSeconds

        // Then
        assertEquals(progressDeadlineSeconds, resultProgressDeadlineSeconds)
    }

    @Test
    fun `spec should have correct replicas`() {
        // Given
        val replicas = 2
        val spec = Spec(replicas = replicas)

        // When
        val resultReplicas = spec.replicas

        // Then
        assertEquals(replicas, resultReplicas)
    }

    @Test
    fun `spec should have correct selector`() {
        // Given
        val selector = Selector(matchLabels = mapOf("key" to "value"))
        val spec = Spec(selector = selector)

        // When
        val resultSelector = spec.selector

        // Then
        assertEquals(selector, resultSelector)
    }

    @Test
    fun `spec should have correct strategy`() {
        // Given
        val strategy = Strategy(type = "RollingUpdate", rollingUpdate = RollingUpdate(maxSurge = "25%", maxUnavailable = "0%"))
        val spec = Spec(strategy = strategy)

        // When
        val resultStrategy = spec.strategy

        // Then
        assertEquals(strategy, resultStrategy)
    }

}