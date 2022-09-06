package org.aibles.validator.validation;


import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.aibles.validator.exception.InternalServerBaseException;


@Slf4j
public class BaseValidator<T> {

  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory()
      .getValidator();
  private String getField(ConstraintViolation<BaseValidator<T>> violation) {
    return violation.getPropertyPath().toString();
  }

  public void validate() {
    var errorMap = new HashMap<String, Object>();

    var violations = VALIDATOR.validate(this);
    if (!violations.isEmpty()) {
      log.info("(isValid){} --> INVALID", this.getClass().getTypeName());
      for (var violation: violations) {
        errorMap.put(getField(violation), violation.getMessage());
      }
    }

    if (!errorMap.isEmpty()) {
      System.out.println(errorMap);
      throw new RuntimeException("invalid entity");
    }
  }

}
