package com.koreait.practice.domain;

public class BMICalculator {

	private double normalBase;
	private double overBase;
	private double obesityBase;
	private Calculator calculator;
	
	public BMICalculator() {
		// TODO Auto-generated constructor stub
	}

	public BMICalculator(double normalBase, double overBase, double obesityBase, Calculator calculator) {
		super();
		this.normalBase = normalBase;
		this.overBase = overBase;
		this.obesityBase = obesityBase;
		this.calculator = calculator;
	}

	public double getNormalBase() {
		return normalBase;
	}

	public void setNormalBase(double normalBase) {
		this.normalBase = normalBase;
	}

	public double getOverBase() {
		return overBase;
	}

	public void setOverBase(double overBase) {
		this.overBase = overBase;
	}

	public double getObesityBase() {
		return obesityBase;
	}

	public void setObesityBase(double obesityBase) {
		this.obesityBase = obesityBase;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void bmiInfo(double weight, double height) {
		height = calculator.div(height, 100);
		double bmi = calculator.div(weight, calculator.mul(height, height));
		String health = null;
		if (bmi >= obesityBase) health = "비만";
		else if (bmi >= overBase) health = "과체중";
		else if (bmi >= normalBase) health = "정상";
		else health = "저체중";
		System.out.println("bmi : " + bmi + " (" + health + ")");
	}
	
}
