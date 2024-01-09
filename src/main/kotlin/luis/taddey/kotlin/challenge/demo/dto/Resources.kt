package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class Resources(
    @Embedded
    val limits: Limits? = null,

    @Embedded
    val requests: Requests? = null
)
