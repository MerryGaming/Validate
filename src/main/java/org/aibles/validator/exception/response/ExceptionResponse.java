package org.aibles.validator.exception.response;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

public class ExceptionResponse {

  @Value("${classpath:i18n/message}")
  private MessageSource messageSource;
  private Instant timestamp;

  private String error;

  private Object message;

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Object getMessage() {
    return messageSource;
  }

  public void setMessage(Object message) {
    this.message = message;
  }
}
