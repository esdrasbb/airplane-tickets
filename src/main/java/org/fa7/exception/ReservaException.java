package org.fa7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ReservaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

}