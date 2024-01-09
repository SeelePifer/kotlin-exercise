package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*

@Embeddable
data class Labels(
    @ElementCollection
    @CollectionTable(name = "labels_table", joinColumns = [JoinColumn(name = "labels_id")])
    @MapKeyColumn(name = "label_key")
    @Column(name = "label_value")
    val labels: Map<String, String>? = null
)
