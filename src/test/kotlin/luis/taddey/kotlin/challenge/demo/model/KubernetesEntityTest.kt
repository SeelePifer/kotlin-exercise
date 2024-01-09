package luis.taddey.kotlin.challenge.demo.model

import luis.taddey.kotlin.challenge.demo.dto.Spec
import luis.taddey.kotlin.challenge.demo.dto.Status
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KubernetesEntityTest {
    @Test
    fun `create KubernetesEntity`() {
        // Given
        val metadata = Metadata()
        val spec = Spec()
        val status = Status()

        // When
        val kubernetesEntity = KubernetesEntity(
            id = 1L,
            apiVersion = "v1",
            kind = "Pod",
            metadata = metadata,
            spec = spec,
            status = status
        )

        // Then
        assertThat(kubernetesEntity.id).isEqualTo(1L)
        assertThat(kubernetesEntity.apiVersion).isEqualTo("v1")
        assertThat(kubernetesEntity.kind).isEqualTo("Pod")
        assertThat(kubernetesEntity.metadata).isEqualTo(metadata)
        assertThat(kubernetesEntity.spec).isEqualTo(spec)
        assertThat(kubernetesEntity.status).isEqualTo(status)
    }
}