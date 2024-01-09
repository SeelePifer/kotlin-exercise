package luis.taddey.kotlin.challenge.demo.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StatusTest {
    @Test
    fun `status should have correct availableReplicas`() {
        // Given
        val availableReplicas = 3
        val status = Status(availableReplicas = availableReplicas)

        // When
        val resultAvailableReplicas = status.availableReplicas

        // Then
        assertEquals(availableReplicas, resultAvailableReplicas)
    }

    @Test
    fun `status should have correct conditions`() {
        // Given
        val conditions = listOf(
            Condition(id = 1, type = "Type1"),
            Condition(id = 2, type = "Type2")
        )
        val status = Status(conditions = conditions)

        // When
        val resultConditions = status.conditions

        // Then
        assertEquals(conditions, resultConditions)
    }

    @Test
    fun `status should have correct observedGeneration`() {
        // Given
        val observedGeneration = 5
        val status = Status(observedGeneration = observedGeneration)

        // When
        val resultObservedGeneration = status.observedGeneration

        // Then
        assertEquals(observedGeneration, resultObservedGeneration)
    }

    @Test
    fun `status should have correct readyReplicas`() {
        // Given
        val readyReplicas = 2
        val status = Status(readyReplicas = readyReplicas)

        // When
        val resultReadyReplicas = status.readyReplicas

        // Then
        assertEquals(readyReplicas, resultReadyReplicas)
    }

    @Test
    fun `status should have correct replicas`() {
        // Given
        val replicas = 4
        val status = Status(replicas = replicas)

        // When
        val resultReplicas = status.replicas

        // Then
        assertEquals(replicas, resultReplicas)
    }

    @Test
    fun `status should have correct updatedReplicas`() {
        // Given
        val updatedReplicas = 1
        val status = Status(updatedReplicas = updatedReplicas)

        // When
        val resultUpdatedReplicas = status.updatedReplicas

        // Then
        assertEquals(updatedReplicas, resultUpdatedReplicas)
    }
}