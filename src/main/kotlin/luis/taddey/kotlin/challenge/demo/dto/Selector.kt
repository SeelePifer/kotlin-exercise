package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*

@Embeddable
data class Selector(
    @ElementCollection
    @CollectionTable(name = "selector_match_labels_table", joinColumns = [JoinColumn(name = "selector_id")])
    @MapKeyColumn(name = "label_key")
    @Column(name = "label_value")
    val matchLabels: Map<String, String>? = null
)