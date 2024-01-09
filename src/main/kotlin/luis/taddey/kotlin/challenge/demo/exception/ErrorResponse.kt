package luis.taddey.kotlin.challenge.demo.exception

data class ErrorResponse(
    val message: String,
    val details : List<String>
)
