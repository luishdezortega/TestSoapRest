package com.test.rest.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.api.service.interfaces.BasicCalculator;
import com.test.rest.api.service.interfaces.BasicMathOperation;
import com.test.rest.api.util.Operations;

@Service
public class BasicCalculatorService implements BasicCalculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculatorService.class);

	@Autowired
	List<BasicMathOperation> operations;

	@Override
	public String doMath(String x, String y, Operations operation) {
		validateInput(x, y);
		return operations.stream().filter(bm -> bm.operation() == operation).map(operator -> operator.operation(x, y))
				.collect(Collectors.toList()).get(0);
	}

	private void validateInput(String x, String y) {
		try {
			Integer.parseInt(x);
			Integer.parseInt(y);
		} catch (NumberFormatException nfe) {
			LOGGER.error("NumberFormatException");
		}
	}

}
