package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class RollingUpdate(
    @Column(name = "max_surge")
    val maxSurge: String? = null,

    @Column(name = "max_unavailable")
    val maxUnavailable: String? = null
)