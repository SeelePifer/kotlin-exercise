package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class Spec(
    @Column(name = "progress_deadline_seconds")
    val progressDeadlineSeconds: Int? = null,

    @Column(name = "replicas", insertable = false, updatable = false)
    val replicas: Int? = null,

    @Embedded
    val selector: Selector? = null,

    @Embedded
    val strategy: Strategy? = null,

    @Embedded
    val template: Template? = null
)
