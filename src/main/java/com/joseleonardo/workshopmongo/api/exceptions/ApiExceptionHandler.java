package com.joseleonardo.workshopmongo.api.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joseleonardo.workshopmongo.domain.services.exceptions.EntidadeNaoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(EntidadeNaoEncontradaException e, 
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		String error = "Recurso não encontrado";
		
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), error, 
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(erroPadrao);
	}
	
}
