package org.aibles.validator.controller.advice;


import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aibles.validator.exception.BaseExceptionRequest;
import org.aibles.validator.exception.response.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ExceptionHandleAdvice {

  private HttpServletRequest request;

  @ExceptionHandler(value = {BaseExceptionRequest.class})
  public ResponseEntity<ExceptionResponse> exceptionHandle(
      BaseExceptionRequest error) {
    log.info("(Exception)exception: {}", error);
    ExceptionResponse response = new ExceptionResponse();
    response.setError("Exception");
    response.setMessage(error.getMessage());
    response.setTimestamp(Instant.now());
    return ResponseEntity.status(HttpStatus.valueOf(error.getStatusException())).body(response);
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse validationExceptionHandle() {
    log.info("(Validation)");
    ExceptionResponse response = new ExceptionResponse();
    response.setError("Exception");
    response.setMessage("Error input");
    response.setTimestamp(Instant.now());
    return response;
  }


}

