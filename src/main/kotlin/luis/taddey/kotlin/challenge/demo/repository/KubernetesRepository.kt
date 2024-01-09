package luis.taddey.kotlin.challenge.demo.repository

import luis.taddey.kotlin.challenge.demo.model.KubernetesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KubernetesRepository: JpaRepository<KubernetesEntity, Long>