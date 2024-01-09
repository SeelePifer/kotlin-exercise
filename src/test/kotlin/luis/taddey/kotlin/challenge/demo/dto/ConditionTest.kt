package luis.taddey.kotlin.challenge.demo.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConditionTest {
    @Test
    fun `create Condition with null values`() {
        // Given

        // When
        val condition = Condition()

        // Then
        assertThat(condition.id).isNull()
        assertThat(condition.lastTransitionTime).isNull()
        assertThat(condition.lastUpdateTime).isNull()
        assertThat(condition.message).isNull()
        assertThat(condition.reason).isNull()
        assertThat(condition.status).isNull()
        assertThat(condition.type).isNull()
    }

    @Test
    fun `create Condition with non-null values`() {
        // Given
        val lastTransitionTime = "2024-01-09T12:00:00"
        val lastUpdateTime = "2024-01-09T12:05:00"
        val message = "Condition message"
        val reason = "Condition reason"
        val status = "Condition status"
        val type = "Condition type"

        // When
        val condition = Condition(
            lastTransitionTime = lastTransitionTime,
            lastUpdateTime = lastUpdateTime,
            message = message,
            reason = reason,
            status = status,
            type = type
        )

        // Then
        assertThat(condition.lastTransitionTime).isEqualTo(lastTransitionTime)
        assertThat(condition.lastUpdateTime).isEqualTo(lastUpdateTime)
        assertThat(condition.message).isEqualTo(message)
        assertThat(condition.reason).isEqualTo(reason)
        assertThat(condition.status).isEqualTo(status)
        assertThat(condition.type).isEqualTo(type)
    }
}