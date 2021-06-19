package com.employeeservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;

import com.employeeservice.constants.EmployeeApiConstants;
import com.employeeservice.responses.EmployeeApiResponse;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiErrorVO handleValidationError(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		FieldError fieldError = bindingResult.getFieldError();
		String defaultMessage = fieldError.getDefaultMessage();
		return ApiErrorVO.builder().statusCode(EmployeeApiConstants.BAD_REQUEST).message(defaultMessage).build();
	}
	
	@ExceptionHandler(GenericCustomException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String,Object> handleGenericExceptionHandler(GenericCustomException ex) {
		Map<String,Object> response=new HashMap();
		response.put("statusCode",ex.getResponseHttpStatus());
		response.put("message",ex.getMessage()!=null?ex.getMessage():"Internal server error");
		
		log.error("Error Name :: ",ex.getMessage(),ex.getResponseHttpStatus());
		log.error("Error Trace :: ",ex);
		return response;
	}

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Object> handleCityNotFoundException(
			RecordNotFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "No Data Found");
		body.put("statusCode", "404");

		log.error("Error Name :: ",ex.getMessage(),ex.getStackTrace());
		log.error("Error Trace :: ",ex);
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(
			NoDataFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		log.error("Error Name :: ",ex.getMessage(),ex.getStackTrace());
		log.error("Error Trace :: ",ex);
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { Unauthorized.class })
	public ResponseEntity<Object> handleUnauthorizedException(Unauthorized ex) {
		log.error("Error Name :: ",ex.getMessage(),ex.getStackTrace());
		log.error("Error Trace :: ",ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		log.error("Error Name :: ",ex.getMessage(),ex.getStackTrace());
		log.error("Error Trace :: ",ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
