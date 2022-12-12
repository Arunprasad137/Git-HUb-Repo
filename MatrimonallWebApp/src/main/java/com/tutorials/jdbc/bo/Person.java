package com.tutorials.jdbc.bo;

import java.util.List;

public class Person
{
	private int id;

	private String firstName;
	
	private String middleName;
	
	private String lastName;

	private int age;
	
	private String gender;
	
	private String email;
	
	private String password;
	
	private String state;

	private String city;
	
	private int postalCode;

	private String address;	
	
	private String occupation;
	
	private int income;
	
    private String religion;
	
	private String caste;
	
	private String subCaste;
	
	private String hobbies;
	
    private String maritalStatus;	
	
	private String zodiacSign;
	
	private String star;
	
    private int height;
	
	private int weight;
	
	private String color;
	
	private String bloodType;
	
    private String fatherName;
	
	private String motherName ;
	
    private String smoking ;
    
    private String drinking;
	
	private String diet;
	
	private String physicalStatus;

	/* ============================= */
	/*     Getters and Setters       */
	/* ============================= */

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getDrinking() {
		return drinking;
	}

	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getPhysicalStatus() {
		return physicalStatus;
	}

	public void setPhysicalStatus(String physicalStatus) {
		this.physicalStatus = physicalStatus;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public int getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode=postalCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public int getIncome() {
		return this.income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	public String getCaste() {
		return this.caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}
	
	public String getSubCaste() {
		return this.subCaste;
	}

	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}
	
	public String getHobbies() {
		return this.hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public String getZodiacSign() {
		return this.zodiacSign;
	}

	public void setZodiacSign(String zodiacSign ) {
		this.zodiacSign = zodiacSign;
	}
	
	public String getStar() {
		return this.star;
	}

	public void setStar(String star ) {
		this.star = star;
	}
	
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getColor() {
		return this.color;
	}

	public void setColor(String color ) {
		this.color = color;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType ) {
		this.bloodType = bloodType;
	}
	
	/* ===================================== */
	/* 		Constructors		 */
	/* ===================================== */
	public Person() {
		System.out.println("Person() - instantiated..");
	}

	public Person(int id, String firstName, String middleName, String lastName, int age, String gender,
			String email, String password, String state,String city, int postalCode, 
			String address, String occupation, int income, String religion, String caste, 
			String subCaste,String hobbies,String fatherName,String motherName,String smoking,String drinking,String diet,String physicalStatus, String maritalStatus, String zodiacSign, String star, int height, int weight, String color, String bloodType) {
		System.out.println("Person(id, firstName, middleName, lastName, age,gender, email,password, state, city, postalCode, address,occupation, income, religion, caste, subCaste,hobbies ) - instantiated..");
		this.id = id; 
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
		this.address = address;
		this.occupation = occupation;
		this.income = income;
		this.religion = religion;
		this.caste = caste;
		this.subCaste = subCaste;
		this.hobbies = hobbies;
		this.maritalStatus = maritalStatus;
		this.zodiacSign = zodiacSign;
		this.star = star;
		this.height = height;
		this.weight = weight;
		this.color = color;
		this.bloodType = bloodType;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.smoking = smoking;
		this.drinking = drinking;
		this.diet = diet;
		this.physicalStatus = physicalStatus;
		
	}

	/* ==================================== */
	/*		toString()		*/
	/* ==================================== */

	@Override
	public String toString() {
		return "Person [id=" + id 
				+ ", firstName=" + firstName 
				+ ", middleName=" + middleName 
				+ ", lastName=" + lastName
				+ ", age=" + age 
				+ ", gender=" + gender 
				+ ", email=" + email 
				+ ", password=" + password 
				+ ", state="+ state 
				+ ", city=" + city 
				+ ", postalCode=" + postalCode 
				+ ", address=" + address 
				+ ", occupation="+ occupation 
				+ ", income=" + income 
				+ ", religion=" + religion 
				+ ", caste=" + caste 
				+ ", subCaste="+ subCaste 
				+ ", hobbies=" + hobbies 
				+ ", maritalStatus=" + maritalStatus 
				+ ", zodiacSign=" + zodiacSign
				+ ", star=" + star 
				+ ", height=" + height 
				+ ", weight=" + weight 
				+ ", color=" + color 
				+ ", bloodType="+ bloodType 
				+ ", fatherName=" + fatherName 
				+ ", motherName=" + motherName 
				+ ", smoking=" + smoking
				+ ", drinking=" + drinking 
				+ ", diet=" + diet 
				+ ", physicalStatus=" + physicalStatus + "]";
	}

	

}
