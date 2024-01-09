package luis.taddey.kotlin.challenge.demo.exception

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class CustomExceptionHandler {
    @ExceptionHandler(MissingKotlinParameterException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMissingKotlinParameterException(ex: MissingKotlinParameterException): ResponseEntity<ErrorResponse> {
        val errorDetails = mutableListOf<String>()

        ex.path.forEach { reference ->
            errorDetails.add("Field '${reference.fieldName}' is missing")
        }

        val errorResponse = ErrorResponse(
            message = "Validation failed",
            details = errorDetails
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}