package com.atenea.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.atenea.model.Person;
import com.atenea.service.PersonService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	/**
	 * Gets the all person.
	 *
	 * @return the all person
	 */
	@GetMapping
	public ResponseEntity<List<Person>> getAllPersonas(){
		return ResponseEntity.ok(personService.getAllPersons());
	}
}
