package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class Metadata(
    @Embedded
    val annotations: Annotations? = null,

    @Column(name = "creation_timestamp", insertable = false, updatable = false)
    val creationTimestamp: String? = null,

    val generation: Int? = null,

    @Embedded
    val labels: Labels? = null,

    val name: String? = null,

    val namespace: String? = null,

    @Column(name = "resource_version")
    val resourceVersion: String? = null,

    val uid: String? = null
)
