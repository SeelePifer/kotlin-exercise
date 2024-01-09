package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*

@Embeddable
data class TemplateMetadata(
    @Column(name = "creation_timestamp")
    val creationTimestamp: String? = null,

    @ElementCollection
    @CollectionTable(name = "template_metadata_labels_table", joinColumns = [JoinColumn(name = "template_metadata_id")])
    @MapKeyColumn(name = "label_key")
    @Column(name = "label_value")
    val labels: Map<String, String>? = null
)
