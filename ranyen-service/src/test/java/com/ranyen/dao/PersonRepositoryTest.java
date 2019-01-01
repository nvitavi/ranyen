package com.ranyen.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranyen.model.Person;

@RunWith(SpringRunner.class)
public class PersonRepositoryTest extends BaseTestSetup {

	@Test
	public void testGetPerson() {
		//assert the same person retrieved is the one added
		assertThat(mary.getFirstName()).isEqualTo(retrievedPerson.getFirstName());
	}
	
	@Test
	public void testUpdatePerson() {
		//update Mary
		retrievedPerson.setFirstName("Mae");
		Person updatedPerson = personRepository.save(retrievedPerson);

		//assert the same person was updated
		assertThat(retrievedPerson.getFirstName()).isEqualTo(updatedPerson.getFirstName());
	}
	
	@Test
	public void testDeletePerson() {
		//delete person
		personRepository.delete(retrievedPerson);
		
		//assert person was deleted
		Optional<Person> deletedPerson = personRepository.findById(maryId);
		assertThat(deletedPerson.isPresent()).isFalse();
	}
}
