package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class Strategy(
    val type: String? = null,

    @Embedded
    val rollingUpdate: RollingUpdate? = null
)
