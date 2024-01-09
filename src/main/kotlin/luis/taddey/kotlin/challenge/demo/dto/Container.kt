package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded


@Embeddable
data class Container(
    val image: String? = null,

    @Column(name = "image_pull_policy")
    val imagePullPolicy: String? = null,

    val name: String? = null,

    @Embedded
    val resources: Resources? = null,

    @Column(name = "termination_message_path")
    val terminationMessagePath: String? = null,

    @Column(name = "termination_message_policy")
    val terminationMessagePolicy: String? = null
)
