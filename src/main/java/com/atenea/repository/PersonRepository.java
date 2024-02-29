package com.atenea.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.atenea.model.Person;
public interface PersonRepository extends JpaRepository<Person, Long>{

}
