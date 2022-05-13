package com.samourai.javaserver.rest;

import com.samourai.javaserver.exceptions.JavaServerErrorCode;
import com.samourai.javaserver.exceptions.NotifiableException;
import com.samourai.javaserver.exceptions.RestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public abstract class AbstractRestExceptionHandler extends ResponseEntityExceptionHandler {
  protected abstract void onException(Exception e);

  protected abstract ResponseEntity<Object> mapException(Exception e);

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<Object> exceptionHandler(Exception e) {
    ResponseEntity responseEntity;
    if (e instanceof RestException) {
      RestException restException = (RestException) e;
      responseEntity =
          new ResponseEntity<>(restException.getResponse(), restException.getHttpStatus());
    } else {
      responseEntity = mapException(e);
    }
    onException(e);
    return responseEntity;
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException e,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    return exceptionHandler(
        new NotifiableException(
            JavaServerErrorCode.SERVER_ERROR,
            "Invalid parameter: " + e.getParameter().getParameterName()));
  }
}
