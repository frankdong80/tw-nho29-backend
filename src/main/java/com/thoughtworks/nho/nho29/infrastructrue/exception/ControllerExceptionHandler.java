package com.thoughtworks.nho.nho29.infrastructrue.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransactionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String unsupported = "Unsupported content type: " + ex.getContentType();
        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
        ExceptionBody errorMessage = new ExceptionBody(unsupported + "." + supported);
        return new ResponseEntity(errorMessage, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ExceptionBody errorMessage;
        if (mostSpecificCause != null) {
            String exceptionName = mostSpecificCause.getClass().getName();
            String message = mostSpecificCause.getMessage();
            errorMessage = new ExceptionBody(exceptionName + "." + message);
        } else {
            errorMessage = new ExceptionBody(ex.getMessage());
        }
        return new ResponseEntity(errorMessage, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        log.error("Input parameters validation error for access [{}]", request.toString(), ex);
        ExceptionBody body = new ExceptionBody(ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
    }

    @ExceptionHandler({TransactionTimedOutException.class})
    public ResponseEntity<Object> handle(TransactionTimedOutException ex, WebRequest request) {
        log.error("Transaction timeout [{}]", request.toString(), ex);
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new ExceptionBody(ex));
    }

    @ExceptionHandler({TransactionException.class})
    public ResponseEntity<Object> handle(TransactionException ex, WebRequest request) {
        log.error("Transaction exception [{}]", request.toString(), ex);
        if (ex.getMessage().contains("timeout")) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new ExceptionBody("TRANSACTION_TIMEOUT"));
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, new HttpHeaders(), status, request);
        }
    }
}
