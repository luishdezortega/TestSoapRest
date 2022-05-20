package com.test.rest.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import com.test.rest.api.domain.MathOperation;
import com.test.rest.api.service.impl.BasicCalculatorService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
@Api("Application to perform mathematical operations")
public class BasicCalculatorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculatorController.class);

	@Autowired
	BasicCalculatorService basicCalculatorService;

	@PostMapping(value = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> basicCalculator(@RequestBody MathOperation mathOperation) {

		try {
			return new ResponseEntity<>(Double.valueOf(basicCalculatorService.doMath(mathOperation.getFirtTerm(),
					mathOperation.getSecondTerm(), mathOperation.getOperator())), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", e);
		}

	}

}
