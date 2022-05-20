package com.test.rest.api.service.impl;

import org.springframework.stereotype.Service;

import com.test.rest.api.service.interfaces.BasicMathOperation;
import com.test.rest.api.util.Operations;

@Service
public class SubtractOperation implements BasicMathOperation {

	@Override
	public String operation(String x, String y) {
		return String.valueOf(Integer.parseInt(x) - Integer.parseInt(y));
	}

	@Override
	public Operations operation() {
		return Operations.SUB;
	}
}
