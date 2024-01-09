package luis.taddey.kotlin.challenge.demo.model

import jakarta.persistence.*
import luis.taddey.kotlin.challenge.demo.dto.Spec
import luis.taddey.kotlin.challenge.demo.dto.Status

@Entity
@Table(name = "kubernetes_spec")
data class KubernetesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "api_version")
    val apiVersion: String? = null,

    val kind: String? = null,

    @Embedded
    val metadata: Metadata? = null,

    @Embedded
    val spec: Spec? = null,

    @Embedded
    val status: Status? = null
)



