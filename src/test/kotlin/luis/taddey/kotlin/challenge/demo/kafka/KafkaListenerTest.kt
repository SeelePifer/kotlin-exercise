package luis.taddey.kotlin.challenge.demo.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import luis.taddey.kotlin.challenge.demo.model.KubernetesEntity
import luis.taddey.kotlin.challenge.demo.service.KubernetesService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class KafkaListenerTest {
    @Mock
    private lateinit var kubernetesService: KubernetesService

    @Mock
    private lateinit var objectMapper: ObjectMapper

    @InjectMocks
    private lateinit var kafkaListener: KafkaListener

    @Test
    fun `consume should save KubernetesEntity`() {
        // Given
        val message = "{\"apiVersion\":\"apps/v1\",\"kind\":\"Deployment\",\"metadata\":{\"annotations\":{\"deployment.kubernetes.io/revision\":\"3\",\"kubectl.kubernetes.io/last-applied-configuration\":\"{\\\"apiVersion\\\":\\\"apps/v1\\\",\\\"kind\\\":\\\"Deployment\\\",\\\"metadata\\\":{\\\"annotations\\\":{},\\\"labels\\\":{\\\"app\\\":\\\"chaos-controller\\\",\\\"part-of\\\":\\\"chaos-services\\\"},\\\"name\\\":\\\"chaos-controller\\\",\\\"namespace\\\":\\\"chaos-paths\\\"},\\\"spec\\\":{\\\"replicas\\\":1,\\\"selector\\\":{\\\"matchLabels\\\":{\\\"app\\\":\\\"chaos-controller\\\"}},\\\"template\\\":{\\\"metadata\\\":{\\\"labels\\\":{\\\"app\\\":\\\"chaos-controller\\\",\\\"part-of\\\":\\\"chaos-services\\\"}},\\\"spec\\\":{\\\"containers\\\":[{\\\"image\\\":\\\"public.ecr.aws/g9k7c6g2/chaos-path-controller:main\\\",\\\"imagePullPolicy\\\":\\\"Always\\\",\\\"name\\\":\\\"chaos-controller\\\",\\\"resources\\\":{\\\"limits\\\":{\\\"memory\\\":\\\"256Mi\\\"},\\\"requests\\\":{\\\"cpu\\\":\\\"250m\\\",\\\"memory\\\":\\\"256Mi\\\"}}}]}}}}\\n\"},\"creationTimestamp\":\"2023-05-25T05:37:17Z\",\"generation\":3,\"labels\":{\"app\":\"chaos-controller\",\"part-of\":\"chaos-services\"},\"name\":\"chaos-controller\",\"namespace\":\"chaos-paths\",\"resourceVersion\":\"64274569\",\"uid\":\"4e59b527-da3e-48ed-aff0-4c136773e03a\"},\"spec\":{\"progressDeadlineSeconds\":600,\"replicas\":1,\"revisionHistoryLimit\":10,\"selector\":{\"matchLabels\":{\"app\":\"chaos-controller\"}},\"strategy\":{\"rollingUpdate\":{\"maxSurge\":\"25%\",\"maxUnavailable\":\"25%\"},\"type\":\"RollingUpdate\"},\"template\":{\"metadata\":{\"creationTimestamp\":null,\"labels\":{\"app\":\"chaos-controller\",\"part-of\":\"chaos-services\"}},\"spec\":{\"containers\":[{\"image\":\"public.ecr.aws/g9k7c6g2/chaos-path-controller:main\",\"imagePullPolicy\":\"Always\",\"name\":\"chaos-controller\",\"resources\":{\"limits\":{\"memory\":\"256Mi\"},\"requests\":{\"cpu\":\"250m\",\"memory\":\"256Mi\"}},\"terminationMessagePath\":\"/dev/termination-log\",\"terminationMessagePolicy\":\"File\"}],\"dnsPolicy\":\"ClusterFirst\",\"restartPolicy\":\"Always\",\"schedulerName\":\"default-scheduler\",\"securityContext\":{},\"terminationGracePeriodSeconds\":30}}},\"status\":{\"availableReplicas\":1,\"conditions\":[{\"lastTransitionTime\":\"2023-05-31T03:50:00Z\",\"lastUpdateTime\":\"2023-05-31T05:03:19Z\",\"message\":\"ReplicaSet\\\"chaos-controller-c74454c5b\\\"hassuccessfullyprogressed.\",\"reason\":\"NewReplicaSetAvailable\",\"status\":\"True\",\"type\":\"Progressing\"},{\"lastTransitionTime\":\"2023-05-31T05:33:42Z\",\"lastUpdateTime\":\"2023-05-31T05:33:42Z\",\"message\":\"Deploymenthasminimumavailability.\",\"reason\":\"MinimumReplicasAvailable\",\"status\":\"True\",\"type\":\"Available\"}],\"observedGeneration\":3,\"readyReplicas\":1,\"replicas\":1,\"updatedReplicas\":1}}\n"
        val kubernetesEntity = KubernetesEntity(/* initialize with required values */)

        // Mocking
        Mockito.`when`(objectMapper.readValue(message, KubernetesEntity::class.java)).thenReturn(kubernetesEntity)

        // When
        kafkaListener.consume(message)

        // Then
        Mockito.verify(kubernetesService).saveKubernetes(kubernetesEntity)
    }
}