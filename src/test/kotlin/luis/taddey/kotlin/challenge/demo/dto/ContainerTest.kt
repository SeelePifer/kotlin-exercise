package luis.taddey.kotlin.challenge.demo.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ContainerTest {
    @Test
    fun `create Container with null values`() {
        // Given

        // When
        val container = Container()

        // Then
        assertThat(container.image).isNull()
        assertThat(container.imagePullPolicy).isNull()
        assertThat(container.name).isNull()
        assertThat(container.resources).isNull()
        assertThat(container.terminationMessagePath).isNull()
        assertThat(container.terminationMessagePolicy).isNull()
    }

    @Test
    fun `create Container with non-null values`() {
        // Given
        val image = "docker.io/example/image:latest"
        val imagePullPolicy = "Always"
        val name = "container-1"
        val resources = Resources()
        val terminationMessagePath = "/dev/termination-log"
        val terminationMessagePolicy = "File"

        // When
        val container = Container(
            image = image,
            imagePullPolicy = imagePullPolicy,
            name = name,
            resources = resources,
            terminationMessagePath = terminationMessagePath,
            terminationMessagePolicy = terminationMessagePolicy
        )

        // Then
        assertThat(container.image).isEqualTo(image)
        assertThat(container.imagePullPolicy).isEqualTo(imagePullPolicy)
        assertThat(container.name).isEqualTo(name)
        assertThat(container.resources).isEqualTo(resources)
        assertThat(container.terminationMessagePath).isEqualTo(terminationMessagePath)
        assertThat(container.terminationMessagePolicy).isEqualTo(terminationMessagePolicy)
    }
}