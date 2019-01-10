
package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;


/**
 * This Controller performs  Operation.
 * 
 * @author ampandey
 * 
 */
@RestController
public class Controller {

	/**
	 * This API is used to add the details of a particular person for the first time.
	 * @param personDTO
	 * @return list of update person data.
	 */
	@GetMapping("/")
	public Map<String, Object> add() {
		 return Collections.singletonMap("message", "Hello World");
	}

}
