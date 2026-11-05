package br.com.nomedaempresa.iniciandojava.controller;

import br.com.nomedaempresa.iniciandojava.dto.ErrorDTO;
import br.com.nomedaempresa.iniciandojava.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(404).body(new ErrorDTO(exception.getMessage()));
    }

}
