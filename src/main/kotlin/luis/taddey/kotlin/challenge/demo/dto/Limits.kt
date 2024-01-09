package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Limits(
    @Column(name = "memory", insertable = false, updatable = false)
    val memory: String? = null
)
