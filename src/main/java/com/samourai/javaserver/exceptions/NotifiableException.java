package com.samourai.javaserver.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class NotifiableException extends Exception {
  private static final Logger log = LoggerFactory.getLogger(NotifiableException.class);
  public static final HttpStatus STATUS_DEFAULT = HttpStatus.INTERNAL_SERVER_ERROR;

  private int errorCode;
  private HttpStatus httpStatus;

  public NotifiableException(int errorCode, String message) {
    this(errorCode, message, STATUS_DEFAULT);
  }

  public NotifiableException(int errorCode, HttpStatus status) {
    this(errorCode, status.getReasonPhrase(), status);
  }

  public NotifiableException(int errorCode, String message, HttpStatus httpStatus) {
    super(message);
    this.errorCode = errorCode;
    this.httpStatus = httpStatus;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public static NotifiableException computeNotifiableException(Exception e) {
    if (NotifiableException.class.isAssignableFrom(e.getClass())) {
      return (NotifiableException) e;
    }
    log.warn("Exception obfuscated to user", e);
    return new NotifiableException(500, "Error");
  }
}
