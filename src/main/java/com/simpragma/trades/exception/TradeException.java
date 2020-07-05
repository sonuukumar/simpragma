package com.simpragma.trades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TradeException {

	@ExceptionHandler(StockException.class)
	public ResponseEntity<String> stockException(){
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
