package com.koreait.practice.domain;

import java.util.List;
import java.util.Map;

public class User {

	private String name;
	private String birthday;
	private String id;
	private List<String> hobby;
	private double weight;
	private double height;
	private int age;
	private Map<String, String> contactDetail;
	private BMICalculator bmiCalculator;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String birthday, String id, List<String> hobby, double weight, double height, int age,
			Map<String, String> contactDetail, BMICalculator bmiCalculator) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.id = id;
		this.hobby = hobby;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.contactDetail = contactDetail;
		this.bmiCalculator = bmiCalculator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<String, String> getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(Map<String, String> contactDetail) {
		this.contactDetail = contactDetail;
	}

	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}

	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	
}
