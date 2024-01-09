package luis.taddey.kotlin.challenge.demo.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import luis.taddey.kotlin.challenge.demo.model.KubernetesEntity
import luis.taddey.kotlin.challenge.demo.service.KubernetesService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaListener(
    private val kubernetesService: KubernetesService,
    private val objectMapper: ObjectMapper
) {
    @KafkaListener(topics = ["k8s-resources"], groupId = "group_id")
    fun consume(message: String) {
        val kubernetesEntity = objectMapper.readValue(message, KubernetesEntity::class.java)
        kubernetesService.saveKubernetes(kubernetesEntity)
    }
}