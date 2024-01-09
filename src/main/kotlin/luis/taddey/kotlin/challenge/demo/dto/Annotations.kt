package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*

@Embeddable
data class Annotations(
    @ElementCollection
    @CollectionTable(name = "annotations_table", joinColumns = [JoinColumn(name = "annotations_id")])
    @MapKeyColumn(name = "annotation_key")
    @Column(name = "annotation_value")
    val annotations: Map<String, String>? = null
)
