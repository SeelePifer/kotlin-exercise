package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*

@Entity
data class Condition(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "last_transition_time")
    val lastTransitionTime: String? = null,

    @Column(name = "last_update_time")
    val lastUpdateTime: String? = null,

    val message: String? = null,

    val reason: String? = null,

    val status: String? = null,

    val type: String? = null
)