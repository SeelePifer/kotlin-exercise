package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class Template(
    @Embedded
    val metadata: TemplateMetadata? = null,

    @Embedded
    val spec: TemplateSpec? = null
)
