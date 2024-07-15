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
) : GenericKafkaListener<KubernetesEntity>(objectMapper){
    private val service = kubernetesService;
    override fun getEntityType(): Class<KubernetesEntity> =
         KubernetesEntity::class.java


    override fun saveEntity(entity: KubernetesEntity) {
        service.saveKubernetes(entity)
    }

}