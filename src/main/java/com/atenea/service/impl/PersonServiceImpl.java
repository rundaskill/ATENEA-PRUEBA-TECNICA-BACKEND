package com.atenea.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atenea.model.Person;
import com.atenea.repository.PersonRepository;
import com.atenea.service.PersonService;


@Service
public class PersonServiceImpl implements  PersonService {

	@Autowired
	private PersonRepository peroRepository;
	
	
	/**
	 * Gets the all Persons.
	 *
	 * @return the all Persons
	 */
	@Override
	public List<Person> getAllPersons() {
		
		return peroRepository.findAll();
	}
}
