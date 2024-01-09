package luis.taddey.kotlin.challenge.demo.service

import luis.taddey.kotlin.challenge.demo.model.KubernetesEntity
import luis.taddey.kotlin.challenge.demo.repository.KubernetesRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class KubernetesServiceTest {
    @Test
    fun `saveKubernetes should return the saved entity`() {
        // Given
        val repositoryMock = mock(KubernetesRepository::class.java)
        val service = KubernetesService(repositoryMock)
        val entity = KubernetesEntity(apiVersion = "v1", kind = "Pod")
        `when`(repositoryMock.save(entity)).thenReturn(entity)

        // When
        val savedEntity = service.saveKubernetes(entity)

        // Then
        assertThat(savedEntity).isEqualTo(entity)
    }
}