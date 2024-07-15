package luis.taddey.kotlin.challenge.demo.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
abstract class GenericKafkaListener<T>(
    private val objectMapper: ObjectMapper
) {
    @KafkaListener(topics = ["k8s-resources"], groupId = "group_id")
    fun consume(message: String){
        val entity = objectMapper.readValue(message, getEntityType())
        saveEntity(entity)
    }

    abstract fun getEntityType(): Class<T>
    abstract fun saveEntity(entity: T)
}