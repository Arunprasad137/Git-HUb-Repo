package com.tutorials.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tutorials.jdbc.bo.Person;

public class PersonDAO
{
	static Connection conn = null;
	static String connURL1 = "jdbc:mysql://localhost:3306/matrimony?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
	static String connURL = "jdbc:mysql://localhost:3306/matrimony";
    static String userName = "root";
	static String password = "Milvik@137";
 	static String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	//TODO Revisit this later to make a proper instance method
	//after the CRUD functionalities are completed.
	/*public static PersonDAO _instance = null;
	
	public PersonDAO()
	{
		if(null==_instance) {
			_instance = new PersonDAO();
		}
	}*/
	
	public static void main(String... args)
	{
		try {
			connectToDB();
			System.out.println("Connection to the MySQL DB is successful!");
			System.out.println("conn : " + conn);
		}catch(Exception exception) {
			System.err.println("Exception occurred while making a connection..");
			System.err.println("Error Message :  " + exception.getMessage());
			exception.printStackTrace();//NOT recommended in PROD codebase, as it reveals the code structure
		}

		List<Person> personList = listAll();
		System.out.println("personList size :  " + personList.size());

		if(personList.size()>0) {
			for(Person person : personList) {
				System.out.println(person);
			}
		}
		List<Person> personSearchList = searchPerson(JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS);
		System.out.println("personSearchList size :  " + personSearchList.size());

		if(personSearchList.size()>0) {
			for(Person person : personSearchList) {
				System.out.println(person);
			}
		}
		List<Person> userPersonList = userPerosnList(JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS);
		System.out.println("userPersonList size :  " + userPersonList.size());

		if(userPersonList.size()>0) {
			for(Person person : userPersonList) {
				System.out.println(person);
			}
		}
	}

	public static void connectToDB() throws Exception
	{	
		Class.forName(JDBC_DRIVER_CLASS);
		conn = DriverManager.getConnection(connURL, userName, password);
	}

	public static void unUsedCreateTable() throws SQLException
	{
		String sql = "INSERT INTO PERSON (FirstName, MiddleName, LastName,Age,Gender,Email, Password,State, City, PostalCode, Address, Occupation,Income,Religion, Caste, SubCaste,Hobbies"
				+ "  MaritalStatus,ZodiacSign,Star,Height,Weight,Color,BloodType,FatherName,MotherName,Smoking,Drinking,Diet,PhysicalStatus)" + 
				" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? "
						+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
						+ "?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
	}
	
	public static List<Person> listAll()
	{
		System.out.println("--- listAll invoked --- ");
		
		String sql = "SELECT * FROM PERSON";
	
		/*if(null==conn) {
			throw new RuntimeException("DB Connection has not yet been established!");	
		}*/

		Statement stmt = null; 
		ResultSet rs = null;
		List<Person> personList = new ArrayList<>();
		Person person = null;
		
		System.out.println("Connection Object : " + conn);

		try {
			
			if(null==conn || conn.isClosed())
			{
				System.out.println("Connection is null, creating a new one");
				connectToDB();
				System.out.println("Connection Object : " + conn);
			}
			
			stmt = conn.createStatement();	
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				//create a new instance of Person whenever there is a data from the ResultSet
                person = new Person();
				
				person.setId(rs.getInt("Id"));
				person.setFirstName(rs.getString("FirstName"));
				person.setMiddleName(rs.getString("MiddleName"));
				person.setLastName(rs.getString("LastName"));
				person.setAge(rs.getInt("Age"));
				person.setGender(rs.getString("Gender"));
				person.setEmail(rs.getString("Email"));
				person.setPassword(rs.getString("Password"));
				person.setState(rs.getString("State"));
				person.setCity(rs.getString("City"));
				person.setPostalCode(rs.getInt("PostalCode"));
				person.setAddress(rs.getString("Address"));
				person.setOccupation(rs.getString("Occupation"));
				person.setIncome(rs.getInt("Income"));
				person.setReligion(rs.getString("Religion"));
				person.setCaste(rs.getString("Caste"));
				person.setSubCaste(rs.getString("SubCaste"));
				person.setHobbies(rs.getString("Hobbies"));
				person.setMaritalStatus(rs.getString("MaritalStatus"));
				person.setZodiacSign(rs.getString("ZodiacSign"));
				person.setStar(rs.getString("Star"));
				person.setHeight(rs.getInt("Height"));
				person.setWeight(rs.getInt("Weight"));
				person.setColor(rs.getString("Color"));
				person.setBloodType(rs.getString("BloodType"));
				person.setFatherName(rs.getString("FatherName"));
				person.setMotherName(rs.getString("MotherName"));
				person.setSmoking(rs.getString("Smoking"));
				person.setDrinking(rs.getString("Drinking"));
				person.setDiet(rs.getString("Diet"));
				person.setPhysicalStatus(rs.getString("PhysicalStatus"));

				//Add the person object into the Collection
				personList.add(person);
			}
		}catch(SQLException sqlEx) {
			System.err.println("SQLException occurred while fetching the rows from the table");
			System.err.println("Message : " + sqlEx.getMessage());
			sqlEx.printStackTrace();
		}catch(Exception ex) {
			System.err.println("Exception occurred while fetching the rows from the table");
			System.err.println("Message : " + ex.getMessage());
			ex.printStackTrace();
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while closing the JDBC Resources");
				System.err.println("Message : " + sqlException.getMessage());
			}
		}

		//System.out.println("Person List size : " + personList.size());

		return personList;
	}	
	
	
	public static Person getPersonByName(String firstNameParam)
	{
		System.out.println("--- getPersonById - idParam :: " + firstNameParam);
		
		String sql = "SELECT * FROM PERSON WHERE FIRSTNAME=?";

		System.out.println("SQL Query :: " + sql);

		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int count = 0;

		Person person = null;
		
		try {
			
			if(null==conn || conn.isClosed())
			{
				connectToDB();
			}
			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, firstNameParam);

			rs = stmt.executeQuery();
		
			int id, age ,postalCode,income,weight,height;
			String firstName, middleName,lastName,gender,email,password,state, 
				   city, address,occupation,religion,caste,subCaste,hobbies,
				   maritalStatus,zodiacSign,star,color,bloodType,fatherName,motherName,
				   smoking,drinking,diet,physicalStatus;
			 
			
			
		
			while(rs.next()) { //read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted to an Object.
				person = new Person();

				id = rs.getInt(1);
				firstName = rs.getString(2);
				middleName = rs.getString(3);
				lastName = rs.getString(4);
				age = rs.getInt(5);
				gender = rs.getString(6);
				email = rs.getString(7);
				password = rs.getString(8);
				state = rs.getString(9);
				city = rs.getString(10);
				postalCode= rs.getInt(11);
				address = rs.getString(12);
				occupation = rs.getString(13);
				income = rs.getInt(14);
				religion = rs.getString(15);
				caste = rs.getString(16);
				subCaste = rs.getString(17);
				hobbies = rs.getString(18);
				maritalStatus = rs.getString(19);
				zodiacSign = rs.getString(20);
				star = rs.getString(21);
				height = rs.getInt(22);
				weight = rs.getInt(23);
				color = rs.getString(24);
				bloodType = rs.getString(25);
				fatherName = rs.getString(26);
				motherName = rs.getString(27);
				smoking = rs.getString(28);
				drinking = rs.getString(29);
				diet= rs.getString(30);
				physicalStatus = rs.getString(31);
				
				
				person.setId(rs.getInt("Id"));
				person.setFirstName(rs.getString("FirstName"));
				person.setMiddleName(rs.getString("MiddleName"));
				person.setLastName(rs.getString("LastName"));
				person.setAge(rs.getInt("Age"));
				person.setGender(rs.getString("Gender"));
				person.setEmail(rs.getString("Email"));
				person.setPassword(rs.getString("Password"));
				person.setState(rs.getString("State"));
				person.setCity(rs.getString("City"));
				person.setPostalCode(rs.getInt("PostalCode"));
				person.setAddress(rs.getString("Address"));
				person.setOccupation(rs.getString("Occupation"));
				person.setIncome(rs.getInt("Income"));
				person.setReligion(rs.getString("Religion"));
				person.setCaste(rs.getString("Caste"));
				person.setSubCaste(rs.getString("SubCaste"));
				person.setHobbies(rs.getString("Hobbies"));
				person.setMaritalStatus(rs.getString("MaritalStatus"));
				person.setZodiacSign(rs.getString("ZodiacSign"));
				person.setStar(rs.getString("Star"));
				person.setHeight(rs.getInt("Height"));
				person.setWeight(rs.getInt("Weight"));
				person.setColor(rs.getString("Color"));
				person.setBloodType(rs.getString("BloodType"));
				person.setFatherName(rs.getString("FatherName"));
				person.setMotherName(rs.getString("MotherName"));
				person.setSmoking(rs.getString("Smoking"));
				person.setDrinking(rs.getString("Drinking"));
				person.setDiet(rs.getString("Diet"));
				person.setPhysicalStatus(rs.getString("PhysicalStatus"));


				count++;
			}
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=rs) rs.close();
					if(null!=stmt) stmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}
		if(count==0) {
			System.out.println("There are no matching records for the criteria specified!");
		}else {
			System.out.println("Data read from the table successfully!");
		}

		return person;
	}
	
	public static Person getPersonById(int idParam)
	{
		System.out.println("--- getPersonById - idParam :: " + idParam);
		
		String sql = "SELECT * FROM PERSON WHERE ID=?";

		System.out.println("SQL Query :: " + sql);

		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int count = 0;

		Person person = null;
		
		try {
			
			if(null==conn || conn.isClosed())
			{
				connectToDB();
			}
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, idParam);

			rs = stmt.executeQuery();
		
			int id, age ,postalCode,income,weight,height;
			String firstName, middleName,lastName,gender,email,password,state, 
				   city, address,occupation,religion,caste,subCaste,hobbies,
				   maritalStatus,zodiacSign,star,color,bloodType,fatherName,motherName,
				   smoking,drinking,diet,physicalStatus;
			 
			 
			
			
		
			while(rs.next()) { //read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted to an Object.
				person = new Person();

				id = rs.getInt(1);
				firstName = rs.getString(2);
				middleName = rs.getString(3);
				lastName = rs.getString(4);
				age = rs.getInt(5);
				gender = rs.getString(6);
				email = rs.getString(7);
				password = rs.getString(8);
				state = rs.getString(9);
				city = rs.getString(10);
				postalCode= rs.getInt(11);
				address = rs.getString(12);
				occupation = rs.getString(13);
				income = rs.getInt(14);
				religion = rs.getString(15);
				caste = rs.getString(16);
				subCaste = rs.getString(17);
				hobbies = rs.getString(18);
				maritalStatus = rs.getString(19);
				zodiacSign = rs.getString(20);
				star = rs.getString(21);
				height = rs.getInt(22);
				weight = rs.getInt(23);
				color = rs.getString(24);
				bloodType = rs.getString(25);
				fatherName = rs.getString(26);
				motherName = rs.getString(27);
				smoking = rs.getString(28);
				drinking = rs.getString(29);
				diet= rs.getString(30);
				physicalStatus = rs.getString(31);
				
				
				person.setId(rs.getInt("Id"));
				person.setFirstName(rs.getString("FirstName"));
				person.setMiddleName(rs.getString("MiddleName"));
				person.setLastName(rs.getString("LastName"));
				person.setAge(rs.getInt("Age"));
				person.setGender(rs.getString("Gender"));
				person.setEmail(rs.getString("Email"));
				person.setPassword(rs.getString("Password"));
				person.setState(rs.getString("State"));
				person.setCity(rs.getString("City"));
				person.setPostalCode(rs.getInt("PostalCode"));
				person.setAddress(rs.getString("Address"));
				person.setOccupation(rs.getString("Occupation"));
				person.setIncome(rs.getInt("Income"));
				person.setReligion(rs.getString("Religion"));
				person.setCaste(rs.getString("Caste"));
				person.setSubCaste(rs.getString("SubCaste"));
				person.setHobbies(rs.getString("Hobbies"));
				person.setMaritalStatus(rs.getString("MaritalStatus"));
				person.setZodiacSign(rs.getString("ZodiacSign"));
				person.setStar(rs.getString("Star"));
				person.setHeight(rs.getInt("Height"));
				person.setWeight(rs.getInt("Weight"));
				person.setColor(rs.getString("Color"));
				person.setBloodType(rs.getString("BloodType"));
				person.setFatherName(rs.getString("FatherName"));
				person.setMotherName(rs.getString("MotherName"));
				person.setSmoking(rs.getString("Smoking"));
				person.setDrinking(rs.getString("Drinking"));
				person.setDiet(rs.getString("Diet"));
				person.setPhysicalStatus(rs.getString("PhysicalStatus"));


				count++;
			}
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=rs) rs.close();
					if(null!=stmt) stmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}
		if(count==0) {
			System.out.println("There are no matching records for the criteria specified!");
		}else {
			System.out.println("Data read from the table successfully!");
		}

		return person;
	}
	
	public static int createPerson(Person person)
	{
		System.out.println("--- createPerson - person :: " + person);
		
		String sql = "INSERT INTO PERSON (FirstName, MiddleName, LastName, Age, Gender, Email,"
				+ "Password, State, City, PostalCode, Address,"
				+ " Occupation, Income, Religion, Caste, SubCaste, Hobbies,"
				+ "MaritalStatus,ZodiacSign,Star,Height,Weight,Color,BloodType,"
				+ "FatherName,MotherName,Smoking,Drinking,Diet,PhysicalStatus)" + 
				" VALUES (?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?,"
				+ "?, ?, ?, ?, ?, ?,"
				+ "?, ?, ?, ?, ?, ?, ?"
				+ "?, ?, ?, ?, ?, ?)";
		System.out.println("SQL Query :: " + sql);
		
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int lastInsertedId=0, recordsInserted = 0;
		
		try {
			
			if(null==conn)
			{
				connectToDB();
			}
			
			System.out.println("AutoCommit ? : " + conn.getAutoCommit());
			/*conn.setAutoCommit(true);
			System.out.println("(2) AutoCommit ? : " + conn.getAutoCommit());*/
			
			pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, person.getFirstName());
			pStmt.setString(2, person.getMiddleName());
			pStmt.setString(3, person.getLastName());
			pStmt.setInt(4, person.getAge());
			pStmt.setString(5, person.getGender());
			pStmt.setString(6, person.getEmail());
			pStmt.setString(7, person.getPassword());
			pStmt.setString(8, person.getState());
			pStmt.setString(9, person.getCity());
			pStmt.setInt(10, person.getPostalCode());
			pStmt.setString(11, person.getAddress());
			pStmt.setString(12, person.getOccupation());
			pStmt.setInt(13, person.getIncome());
			pStmt.setString(14, person.getReligion());
			pStmt.setString(15, person.getCaste());
			pStmt.setString(16, person.getSubCaste());
			pStmt.setString(17, person.getHobbies());
			pStmt.setString(18, person.getMaritalStatus());
			pStmt.setString(19, person.getZodiacSign());
			pStmt.setString(20, person.getStar());
			pStmt.setInt(21, person.getHeight());
			pStmt.setInt(22, person.getWeight());
			pStmt.setString(23, person.getColor());
			pStmt.setString(24, person.getBloodType());
			pStmt.setString(25, person.getFatherName());
			pStmt.setString(26, person.getMotherName());
			pStmt.setString(27, person.getSmoking());
			pStmt.setString(28, person.getDrinking());
			pStmt.setString(29, person.getDiet());
			pStmt.setString(30, person.getPhysicalStatus());
			
			
			
			recordsInserted = pStmt.executeUpdate();
			//lastInsertedId = pStmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.println("recordsInserted : " + recordsInserted);
			
		    rs = pStmt.executeQuery("SELECT LAST_INSERT_ID()");

		    if (rs.next()) {
		    	lastInsertedId = rs.getInt(1);
		    } else {
		        System.err.println("There was no record inserted in this session!");
		    }

		    System.out.println("Key returned from " +
		                       "'SELECT LAST_INSERT_ID()': " +
		                       lastInsertedId);
			
		}catch(SQLException sqlException) {
			System.err.println("SQL Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		} finally {
			try {
				if(null!=pStmt) pStmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while inserting the data into the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=pStmt) pStmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}
		
		System.out.println("Records Inserted with the Id : " + lastInsertedId);
		//System.out.println("Records Inserted  : " + recordsInserted);
		
		return lastInsertedId;
	}
	
	public static int createPersonFlavor1ThrowsException(Person person) throws Exception
	{
		System.out.println("--- createPersonFlavor1ThrowsException - person :: " + person);
		
		String sql = "INSERT INTO PERSON (FirstName, MiddleName, LastName, Age, Gender, Email,"
				+ "Password, State, City, PostalCode, Address,"
				+ " Occupation, Income, Religion, Caste, SubCaste, Hobbies,"
				+ "MaritalStatus,ZodiacSign,Star,Height,Weight,Color,BloodType,"
				+ "FatherName,MotherName,Smoking,Drinking,Diet,PhysicalStatus)" + 
				" VALUES (?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?,"
				+ "?, ?, ?, ?, ?, ?,"
				+ "?, ?, ?, ?, ?, ?, ?"
				+ "?, ?, ?, ?, ?, ?)";


		System.out.println("SQL Query :: " + sql);
		
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int lastInsertedId=0, recordsInserted = 0;
			
		if(null==conn)
		{
			connectToDB();
		}
		
		System.out.println("AutoCommit ? : " + conn.getAutoCommit());
		/*conn.setAutoCommit(true);
		System.out.println("(2) AutoCommit ? : " + conn.getAutoCommit());*/
		
		pStmt = conn.prepareStatement(sql);
		
		pStmt.setString(1, person.getFirstName());
		pStmt.setString(2, person.getMiddleName());
		pStmt.setString(3, person.getLastName());
		pStmt.setInt(4, person.getAge());
		pStmt.setString(5, person.getGender());
		pStmt.setString(6, person.getEmail());
		pStmt.setString(7, person.getPassword());
		pStmt.setString(8, person.getState());
		pStmt.setString(9, person.getCity());
		pStmt.setInt(10, person.getPostalCode());
		pStmt.setString(11, person.getAddress());
		pStmt.setString(12, person.getOccupation());
		pStmt.setInt(13, person.getIncome());
		pStmt.setString(14, person.getReligion());
		pStmt.setString(15, person.getCaste());
		pStmt.setString(16, person.getSubCaste());
		pStmt.setString(17, person.getHobbies());
		pStmt.setString(18, person.getMaritalStatus());
		pStmt.setString(19, person.getZodiacSign());
		pStmt.setString(20, person.getStar());
		pStmt.setInt(21, person.getHeight());
		pStmt.setInt(22, person.getWeight());
		pStmt.setString(23, person.getColor());
		pStmt.setString(24, person.getBloodType());
		pStmt.setString(25, person.getFatherName());
		pStmt.setString(26, person.getMotherName());
		pStmt.setString(27, person.getSmoking());
		pStmt.setString(28, person.getDrinking());
		pStmt.setString(29, person.getDiet());
		pStmt.setString(30, person.getPhysicalStatus());
		
		recordsInserted = pStmt.executeUpdate();
		//lastInsertedId = pStmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		System.out.println("recordsInserted : " + recordsInserted);
		
	    rs = pStmt.executeQuery("SELECT LAST_INSERT_ID()");

	    if (rs.next()) {
	    	lastInsertedId = rs.getInt(1);
	    } else {
	        System.err.println("There was no record inserted in this session!");
	    }

	    System.out.println("Key returned from " +
	                       "'SELECT LAST_INSERT_ID()': " +
	                       lastInsertedId);
	    
	    if(null!=pStmt) pStmt.close();
		if(null!=conn) conn.close();
			
		
		
		System.out.println("Records Inserted with the Id : " + lastInsertedId);
		//System.out.println("Records Inserted  : " + recordsInserted);
		
		return lastInsertedId;
	}
	
	public static void updatePerson(Person person) throws Exception
	{
		System.out.println("--- updatePerson - person :: " + person);
		
		String sql = "UPDATE PERSON SET "
				+ "FirstName=?, MiddleName=?, LastName=?, Age=?, Gender=?,"
				+ "Email=?, Password=?, State=?, City=?, PostalCode=?,"
				+ "Address=?, Occupation=?, Income=?, Religion=?,"
				+ "Caste=?, SubCaste=?, Hobbies=?,"
				+ "MaritalStatus=?, ZodiacSign=?, Star=?, Height=?, Weight=?, Color=?, BloodType=?,"
				+ "FatherName=?, MotherName=?, Smoking=?, Drinking=?, Diet=?, PhysicalStatus=?"
				+ "WHERE ID = ?";

		System.out.println("SQL Query :: " + sql);
		
		PreparedStatement pStmt = null;
		int recordsUpdated = 0;
			
		if(null==conn || conn.isClosed())
		{
			connectToDB();
		}
		
		pStmt = conn.prepareStatement(sql);
		
		pStmt.setString(1, person.getFirstName());
		pStmt.setString(2, person.getMiddleName());
		pStmt.setString(3, person.getLastName());
		pStmt.setInt(4, person.getAge());
		pStmt.setString(5, person.getGender());
		pStmt.setString(6, person.getEmail());
		pStmt.setString(7, person.getPassword());
		pStmt.setString(8, person.getState());
		pStmt.setString(9, person.getCity());
		pStmt.setInt(10, person.getPostalCode());
		pStmt.setString(11, person.getAddress());
		pStmt.setString(12, person.getOccupation());
		pStmt.setInt(13, person.getIncome());
		pStmt.setString(14, person.getReligion());
		pStmt.setString(15, person.getCaste());
		pStmt.setString(16, person.getSubCaste());
		pStmt.setString(17, person.getHobbies());
		pStmt.setString(18, person.getMaritalStatus());
		pStmt.setString(19, person.getZodiacSign());
		pStmt.setString(20, person.getStar());
		pStmt.setInt(21, person.getHeight());
		pStmt.setInt(22, person.getWeight());
		pStmt.setString(23, person.getColor());
		pStmt.setString(24, person.getBloodType());
		pStmt.setString(25, person.getFatherName());
		pStmt.setString(26, person.getMotherName());
		pStmt.setString(27, person.getSmoking());
		pStmt.setString(28, person.getDrinking());
		pStmt.setString(29, person.getDiet());
		pStmt.setString(30, person.getPhysicalStatus());
		
		
		//Add a condition to the Where clause
		pStmt.setInt(31, person.getId());
		
		recordsUpdated = pStmt.executeUpdate();
		//lastInsertedId = pStmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		System.out.println("recordsUpdated : " + recordsUpdated);
	
	    if(null!=pStmt) pStmt.close();
		if(null!=conn) conn.close();
			
		System.out.println("recordsUpdated  : " + recordsUpdated);
	}
	
	public static int deletePersonById(int idParam)
	{
		System.out.println("--- deletePersonById - idParam :: " + idParam);
		
		String sql = "DELETE FROM PERSON WHERE ID=?";

		System.out.println("SQL Query :: " + sql);

		PreparedStatement pStmt = null;
		int rowsDeleted = 0;
		
		try {
			
			if(null==conn || conn.isClosed())
			{
				connectToDB();
			}
			
			pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, idParam);
		
			rowsDeleted = pStmt.executeUpdate();
			
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while deleting the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while deleting the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=pStmt) pStmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while closing the JDBC Resources");
				System.err.println("Message : " + sqlException.getMessage());
			}
		}
		if(rowsDeleted==0) {
			System.out.println("There are no recors deleted");
		}else {
			System.out.println("Record deleted from the table successfully!");
		}

		return rowsDeleted;
	}
	//SEARCH PERSON BY GENDER AND STATE. NEED TO ADD MORE FIELDS.
	public static List<Person> searchPerson(String genderParam, String stateParam, String religionParam, String casteParam, String maritalstatusParam, 
			String smoking1,String drinking1,String diet1,String physicalStatus1 )
	{
		System.out.println("--- searchPerson - genderParam,stateParam :: " + genderParam + stateParam);
		
		String sql = "SELECT * FROM PERSON WHERE GENDER=? AND STATE=? AND MARITALSTATUS =? AND (RELIGION LIKE ? "
				+ "OR CASTE LIKE ? OR  DRINKING LIKE ? OR SMOKING LIKE ? "
				+ "OR DIET LIKE ? OR PHYSICALSTATUS LIKE ?)";
		
		//String sql = "select * from members where gender=? and(marital_status like ? or city like ? or state like ? or religion like ? or mother_tongue like ?)";

		System.out.println("SQL Query :: " + sql);
		System.out.println(sql);

		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> searchPersonList = new ArrayList<>();
		
		Person person = null;
		
		try {
			
			if(null==conn || conn.isClosed())
			{
				connectToDB();
			}
			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, genderParam);
			System.out.println(genderParam);
			stmt.setString(2, stateParam);
			System.out.println(stateParam);
			stmt.setString(3, maritalstatusParam);
			System.out.println(maritalstatusParam);
			stmt.setString(4, religionParam);
			System.out.println(religionParam);
			stmt.setString(5, casteParam);
			System.out.println(casteParam);
			stmt.setString(6,drinking1);
			System.out.println(drinking1);
			stmt.setString(7, smoking1);
			System.out.println(smoking1);
			stmt.setString(8, diet1);
			System.out.println(diet1);
			stmt.setString(9,physicalStatus1);
			System.out.println(physicalStatus1);

			rs = stmt.executeQuery();
		
			int id, age ,postalCode,income,weight,height;
			String firstName, middleName,lastName,gender,email,password,state, 
				   city, address,occupation,religion,caste,subCaste,hobbies,
				   maritalStatus,zodiacSign,star,color,bloodType,fatherName,motherName,
				   smoking,drinking,diet,physicalStatus;
			 
			
		
			while(rs.next()) { //read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted to an Object.
				person = new Person();

				id = rs.getInt(1);
				firstName = rs.getString(2);
				middleName = rs.getString(3);
				lastName = rs.getString(4);
				age = rs.getInt(5);
				gender = rs.getString(6);
				email = rs.getString(7);
				password = rs.getString(8);
				state = rs.getString(9);
				city = rs.getString(10);
				postalCode= rs.getInt(11);
				address = rs.getString(12);
				occupation = rs.getString(13);
				income = rs.getInt(14);
				religion = rs.getString(15);
				caste = rs.getString(16);
				subCaste = rs.getString(17);
				hobbies = rs.getString(18);
				maritalStatus = rs.getString(19);
				zodiacSign = rs.getString(20);
				star = rs.getString(21);
				height = rs.getInt(22);
				weight = rs.getInt(23);
				color = rs.getString(24);
				bloodType = rs.getString(25);
				fatherName = rs.getString(26);
				motherName = rs.getString(27);
				smoking = rs.getString(28);
				drinking = rs.getString(29);
				diet= rs.getString(30);
				physicalStatus = rs.getString(31);
				
				
				person.setId(rs.getInt("Id"));
				person.setFirstName(rs.getString("FirstName"));
				person.setMiddleName(rs.getString("MiddleName"));
				person.setLastName(rs.getString("LastName"));
				person.setAge(rs.getInt("Age"));
				person.setGender(rs.getString("Gender"));
				person.setEmail(rs.getString("Email"));
				person.setPassword(rs.getString("Password"));
				person.setState(rs.getString("State"));
				person.setCity(rs.getString("City"));
				person.setPostalCode(rs.getInt("PostalCode"));
				person.setAddress(rs.getString("Address"));
				person.setOccupation(rs.getString("Occupation"));
				person.setIncome(rs.getInt("Income"));
				person.setReligion(rs.getString("Religion"));
				person.setCaste(rs.getString("Caste"));
				person.setSubCaste(rs.getString("SubCaste"));
				person.setHobbies(rs.getString("Hobbies"));
				person.setMaritalStatus(rs.getString("MaritalStatus"));
				person.setZodiacSign(rs.getString("ZodiacSign"));
				person.setStar(rs.getString("Star"));
				person.setHeight(rs.getInt("Height"));
				person.setWeight(rs.getInt("Weight"));
				person.setColor(rs.getString("Color"));
				person.setBloodType(rs.getString("BloodType"));
				person.setFatherName(rs.getString("FatherName"));
				person.setMotherName(rs.getString("MotherName"));
				person.setSmoking(rs.getString("Smoking"));
				person.setDrinking(rs.getString("Drinking"));
				person.setDiet(rs.getString("Diet"));
				person.setPhysicalStatus(rs.getString("PhysicalStatus"));


				searchPersonList.add(person);
			}
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=rs) rs.close();
					if(null!=stmt) stmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}
		return searchPersonList;
	}
	
	public static Person loginPerson(String emailParam,String passwordParam)
	{
		System.out.println("--- getPersonByemail - emailParam :: " + emailParam);
		
		String sql = "SELECT * FROM PERSON WHERE EMAIL = ? AND PASSWORD = ?";

		System.out.println("SQL Query :: " + sql);

		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int count = 0;

		Person person = null;
		
		try {
			
			if(null==conn || conn.isClosed())
			{
				connectToDB();
			}
			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, emailParam);
			stmt.setString(2, passwordParam);

			rs = stmt.executeQuery();
		
			int id, age ,postalCode,income,weight,height;
			String firstName, middleName,lastName,gender,email,password,state, 
				   city, address,occupation,religion,caste,subCaste,hobbies,
				   maritalStatus,zodiacSign,star,color,bloodType,fatherName,motherName,
				   smoking,drinking,diet,physicalStatus;
			 
			
			
		
			while(rs.next()) { //read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted to an Object.
				person = new Person();

				id = rs.getInt(1);
				firstName = rs.getString(2);
				middleName = rs.getString(3);
				lastName = rs.getString(4);
				age = rs.getInt(5);
				gender = rs.getString(6);
				email = rs.getString(7);
				password = rs.getString(8);
				state = rs.getString(9);
				city = rs.getString(10);
				postalCode= rs.getInt(11);
				address = rs.getString(12);
				occupation = rs.getString(13);
				income = rs.getInt(14);
				religion = rs.getString(15);
				caste = rs.getString(16);
				subCaste = rs.getString(17);
				hobbies = rs.getString(18);
				maritalStatus = rs.getString(19);
				zodiacSign = rs.getString(20);
				star = rs.getString(21);
				height = rs.getInt(22);
				weight = rs.getInt(23);
				color = rs.getString(24);
				bloodType = rs.getString(25);
				fatherName = rs.getString(26);
				motherName = rs.getString(27);
				smoking = rs.getString(28);
				drinking = rs.getString(29);
				diet= rs.getString(30);
				physicalStatus = rs.getString(31);
				
				
				person.setId(rs.getInt("Id"));
				person.setFirstName(rs.getString("FirstName"));
				person.setMiddleName(rs.getString("MiddleName"));
				person.setLastName(rs.getString("LastName"));
				person.setAge(rs.getInt("Age"));
				person.setGender(rs.getString("Gender"));
				person.setEmail(rs.getString("Email"));
				person.setPassword(rs.getString("Password"));
				person.setState(rs.getString("State"));
				person.setCity(rs.getString("City"));
				person.setPostalCode(rs.getInt("PostalCode"));
				person.setAddress(rs.getString("Address"));
				person.setOccupation(rs.getString("Occupation"));
				person.setIncome(rs.getInt("Income"));
				person.setReligion(rs.getString("Religion"));
				person.setCaste(rs.getString("Caste"));
				person.setSubCaste(rs.getString("SubCaste"));
				person.setHobbies(rs.getString("Hobbies"));
				person.setMaritalStatus(rs.getString("MaritalStatus"));
				person.setZodiacSign(rs.getString("ZodiacSign"));
				person.setStar(rs.getString("Star"));
				person.setHeight(rs.getInt("Height"));
				person.setWeight(rs.getInt("Weight"));
				person.setColor(rs.getString("Color"));
				person.setBloodType(rs.getString("BloodType"));
				person.setFatherName(rs.getString("FatherName"));
				person.setMotherName(rs.getString("MotherName"));
				person.setSmoking(rs.getString("Smoking"));
				person.setDrinking(rs.getString("Drinking"));
				person.setDiet(rs.getString("Diet"));
				person.setPhysicalStatus(rs.getString("PhysicalStatus"));


				count++;
			}
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=rs) rs.close();
					if(null!=stmt) stmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}
		if(count==0) {
			System.out.println("Invalid Credentials.");
		}else {
			System.out.println("Data read from the table successfully!");
		}

		return person;
	}
	
	public static List<Person> userPerosnList(String emailParam, String passwordParam)
	{
		System.out.println("--- userPersonList - genderParam,stateParam :: " + emailParam);
		
		String sql = "SELECT * FROM PERSON WHERE EMAIL != ? AND PASSWORD != ?";

		System.out.println("SQL Query :: " + sql);
		System.out.println(sql);

		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> userPersonList = new ArrayList<>();
		
		Person person = null;
		
		try {
			
			if(null==conn || conn.isClosed())
			{
				connectToDB();
			}
			
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, emailParam);
			System.out.println(emailParam);
			stmt.setString(2, passwordParam);
			
			rs = stmt.executeQuery();
		
			int id, age ,postalCode,income,weight,height;
			String firstName, middleName,lastName,gender,email,password,state, 
				   city, address,occupation,religion,caste,subCaste,hobbies,
				   maritalStatus,zodiacSign,star,color,bloodType,fatherName,motherName,
				   smoking,drinking,diet,physicalStatus;
			 
			
			
		
			while(rs.next()) { //read one full row's data - one column at a time

				// makes sense to create an object, so that we don't waste the memory allotted to an Object.
				person = new Person();

				id = rs.getInt(1);
				firstName = rs.getString(2);
				middleName = rs.getString(3);
				lastName = rs.getString(4);
				age = rs.getInt(5);
				gender = rs.getString(6);
				email = rs.getString(7);
				password = rs.getString(8);
				state = rs.getString(9);
				city = rs.getString(10);
				postalCode= rs.getInt(11);
				address = rs.getString(12);
				occupation = rs.getString(13);
				income = rs.getInt(14);
				religion = rs.getString(15);
				caste = rs.getString(16);
				subCaste = rs.getString(17);
				hobbies = rs.getString(18);
				maritalStatus = rs.getString(19);
				zodiacSign = rs.getString(20);
				star = rs.getString(21);
				height = rs.getInt(22);
				weight = rs.getInt(23);
				color = rs.getString(24);
				bloodType = rs.getString(25);
				fatherName = rs.getString(26);
				motherName = rs.getString(27);
				smoking = rs.getString(28);
				drinking = rs.getString(29);
				diet= rs.getString(30);
				physicalStatus = rs.getString(31);
				
				
				
				person.setId(rs.getInt("Id"));
				person.setFirstName(rs.getString("FirstName"));
				person.setMiddleName(rs.getString("MiddleName"));
				person.setLastName(rs.getString("LastName"));
				person.setAge(rs.getInt("Age"));
				person.setGender(rs.getString("Gender"));
				person.setEmail(rs.getString("Email"));
				person.setPassword(rs.getString("Password"));
				person.setState(rs.getString("State"));
				person.setCity(rs.getString("City"));
				person.setPostalCode(rs.getInt("PostalCode"));
				person.setAddress(rs.getString("Address"));
				person.setOccupation(rs.getString("Occupation"));
				person.setIncome(rs.getInt("Income"));
				person.setReligion(rs.getString("Religion"));
				person.setCaste(rs.getString("Caste"));
				person.setSubCaste(rs.getString("SubCaste"));
				person.setHobbies(rs.getString("Hobbies"));
				person.setMaritalStatus(rs.getString("MaritalStatus"));
				person.setZodiacSign(rs.getString("ZodiacSign"));
				person.setStar(rs.getString("Star"));
				person.setHeight(rs.getInt("Height"));
				person.setWeight(rs.getInt("Weight"));
				person.setColor(rs.getString("Color"));
				person.setBloodType(rs.getString("BloodType"));
				person.setFatherName(rs.getString("FatherName"));
				person.setMotherName(rs.getString("MotherName"));
				person.setSmoking(rs.getString("Smoking"));
				person.setDrinking(rs.getString("Drinking"));
				person.setDiet(rs.getString("Diet"));
				person.setPhysicalStatus(rs.getString("PhysicalStatus"));


				userPersonList.add(person);
			}
		}catch(SQLException sqlException) {
			System.err.println("SQLException occurred while reading the data from the Database Table");
			System.err.println("Message : " + sqlException.getMessage());
		}catch(Exception exception) {
			System.err.println("Exception occurred while reading the data from the Database Table");
			System.err.println("Message : " + exception.getMessage());
		}finally {
			try {
				if(null!=rs) rs.close();
				if(null!=stmt) stmt.close();
				if(null!=conn) conn.close();
			}catch(SQLException sqlException) {
				System.err.println("Exception occurred while reading the data from the Database Table");
				System.err.println("Message : " + sqlException.getMessage());
			}finally {
				try {
					if(null!=rs) rs.close();
					if(null!=stmt) stmt.close();
					if(null!=conn) conn.close();
				}catch(SQLException sqlException) {
					System.err.println("Exception occurred while closing the JDBC Resources");
					System.err.println("Message : " + sqlException.getMessage());
				}
			}
		}
		return userPersonList;
	}
}


