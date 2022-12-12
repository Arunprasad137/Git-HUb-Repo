/**
 * 
 */
package test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.tutorials.jdbc.bo.Person;
import com.tutorials.jdbc.dao.PersonDAO;

/**
 * <p>
 * A Test class to test the functionalities of the PersonDAO class.
 * </p>
 * @author raghavan.muthu
 *
 */
public class PersonDAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testCreatePerson();
		testUpdatePerson();
		//testDeletePerson();
	}

	private static void testUpdatePerson() {
		Person person = new Person();
		
		person.setId(2);
		person.setFirstName("Anil");
		person.setMiddleName("Kumar");
		person.setLastName("Reddy");
		person.setAge(24);
		person.setGender("Male");
		person.setEmail("anil23@gmail.com");
		person.setPassword("anil1234");
		person.setState("Andhra");
		person.setCity("Nellore");
		person.setPostalCode(123376);
		person.setAddress("Gandhi Street");
		person.setOccupation("Police");
		person.setIncome(500000);
		person.setReligion("Hindu");
		person.setCaste("kappu");
		person.setSubCaste("oc");
		person.setHobbies("Travelling");
		
		try {
			PersonDAO.updatePerson(person);
		} catch (Exception e) {
			System.err.println("Exception occurred while updating the data into the Database Table");
			System.err.println("Message : " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	private static void testCreatePerson() 
	{
		Person person = new Person();
		
		person.setFirstName("Anil32");
		person.setMiddleName("Kumar");
		person.setLastName("Reddy");
		person.setAge(26);
		person.setEmail("anil23@gmail.com");
		person.setPassword("anil1234");
		person.setGender("Male");
		person.setState("Andhra");
		person.setCity("Nellore");
		person.setPostalCode(1233436);
		person.setAddress("Gandhi Street");
		person.setOccupation("Police");
		person.setIncome(500000);
		person.setReligion("Hindu");
		person.setCaste("kappu");
		person.setSubCaste("oc");
		person.setHobbies("Travelling");
		
		
		/*int recordsInserted = PersonDAO.createPerson(person);
		System.out.println("recordsInserted : " + recordsInserted);*/
		
		int lastInsertedId = PersonDAO.createPerson(person);
		System.out.println("lastInsertedId : " + lastInsertedId);
		
	}

	/*public static void testDeletePerson()
	{
		int id = 8;
		
		int rowsDeleted = PersonDAO.deleteEmployeeById(id);
		
		System.out.println("rowsDeleted : " + rowsDeleted);
		
		System.out.println(PersonDAO.listAll());
	}*/
	
}

