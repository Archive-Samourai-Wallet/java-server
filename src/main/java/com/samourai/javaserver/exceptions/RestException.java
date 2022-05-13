package com.samourai.javaserver.exceptions;

import org.springframework.http.HttpStatus;

public class RestException extends Exception {
  private Object response;
  private HttpStatus httpStatus;

  public RestException(Object response, HttpStatus httpStatus) {
    this.response = response;
    this.httpStatus = httpStatus;
  }

  public RestException(Object response) {
    this(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public Object getResponse() {
    return response;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  @Override
  public String toString() {
    return "RestException{"
        + "response="
        + response.toString()
        + ", httpStatus="
        + httpStatus
        + '}';
  }
}
