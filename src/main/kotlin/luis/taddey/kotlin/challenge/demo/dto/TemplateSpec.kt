package luis.taddey.kotlin.challenge.demo.dto

import jakarta.persistence.*
@Embeddable
data class TemplateSpec(
    @ElementCollection
    @CollectionTable(name = "containers_table", joinColumns = [JoinColumn(name = "template_spec_id")])
    val containers: List<Container>? = null,

    @Column(name = "dns_policy")
    val dnsPolicy: String? = null,

    @Column(name = "restart_policy")
    val restartPolicy: String? = null,

    @Column(name = "scheduler_name")
    val schedulerName: String? = null,

    @Column(name = "termination_grace_period_seconds")
    val terminationGracePeriodSeconds: Int? = null
)
