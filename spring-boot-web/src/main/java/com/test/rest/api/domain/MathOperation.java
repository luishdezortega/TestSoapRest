package com.test.rest.api.domain;

import com.test.rest.api.util.Operations;

public class MathOperation {

	private String firtTerm;

	private String secondTerm;

	private Operations operator;

	public MathOperation() {
	}

	public MathOperation(String firtTerm, String secondTerm, Operations operator) {
		super();
		this.firtTerm = firtTerm;
		this.secondTerm = secondTerm;
		this.operator = operator;
	}

	public String getFirtTerm() {
		return firtTerm;
	}

	public void setFirtTerm(String firtTerm) {
		this.firtTerm = firtTerm;
	}

	public String getSecondTerm() {
		return secondTerm;
	}

	public void setSecondTerm(String secondTerm) {
		this.secondTerm = secondTerm;
	}

	public Operations getOperator() {
		return operator;
	}

	public void setOperator(Operations operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "TestBody [firtTerm=" + firtTerm + ", secondTerm=" + secondTerm + ", operator=" + operator + "]";
	}

}
