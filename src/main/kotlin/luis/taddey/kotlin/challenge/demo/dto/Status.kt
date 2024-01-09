package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*

@Embeddable
data class Status(
    @Column(name = "available_replicas")
    val availableReplicas: Int? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "status_id")
    val conditions: List<Condition>? = null,

    @Column(name = "observed_generation")
    val observedGeneration: Int? = null,

    @Column(name = "ready_replicas")
    val readyReplicas: Int? = null,

    val replicas: Int? = null,

    @Column(name = "updated_replicas")
    val updatedReplicas: Int? = null
)
