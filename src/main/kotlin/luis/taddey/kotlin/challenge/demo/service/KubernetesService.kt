package luis.taddey.kotlin.challenge.demo.service

import luis.taddey.kotlin.challenge.demo.model.KubernetesEntity
import luis.taddey.kotlin.challenge.demo.repository.KubernetesRepository
import org.springframework.stereotype.Service

@Service
class KubernetesService(private val repository: KubernetesRepository) {

    fun saveKubernetes(entity: KubernetesEntity) : KubernetesEntity{
        return repository.save(entity);
    }
}