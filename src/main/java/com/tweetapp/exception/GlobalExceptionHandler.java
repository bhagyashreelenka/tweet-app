package com.tweetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<ExceptionDetails> handleUserAlreadyExistsException(UserAlreadyPresentException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.CONFLICT,ex.getMessage());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.CONFLICT);
	}
	

	@ExceptionHandler(InvalidTweetIdException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidTweetIdException(InvalidTweetIdException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.CONFLICT,ex.getMessage());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleUserNotFoundException(UserNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.CONFLICT,ex.getMessage());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NoUserException.class)
	public ResponseEntity<ExceptionDetails> handleNoUserPresentException(NoUserException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUsernameOrPasswordException.class)
	public ResponseEntity<ExceptionDetails> handleInvalidUsernameOrPasswordException(InvalidUsernameOrPasswordException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(TweetNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleTweetNotFoundException(TweetNotFoundException ex) {
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ExceptionDetails>(exceptionDetail, HttpStatus.NOT_FOUND);
	}
	

}
