package com.atenea.service;
import java.util.List;

import com.atenea.model.Person;
public interface PersonService {
	/**
	 * Gets the all Persons.
	 *
	 * @return the all Persons
	 */
	List<Person> getAllPersons();
}
