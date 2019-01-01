package com.ranyen.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranyen.model.Location;

@RunWith(SpringRunner.class)
public class LocationRepositoryTest extends BaseTestSetup {

	@Test
	public void testGetLocation() {
		// assert the same location retrieved is the one added
		assertThat(bamenda.getCity()).isEqualTo(retrievedLocation.getCity());
	}
	
	@Test
	public void testJoinLocationWithUser() {
		// test join with Person
		assertThat(retrievedLocation.getPerson().getFirstName()).isEqualTo(mary.getFirstName());
	}
	
	@Test
	public void testUpdateLocation() {
		// update Location
		retrievedLocation.setCity("Nso");
		Location updatedLocation = locationRepository.save(retrievedLocation);

		// assert the same location was updated
		assertThat(retrievedLocation.getCity()).isEqualTo(updatedLocation.getCity());
	}
	
	@Test
	public void testDeleteLocation() {
		// delete location
		locationRepository.delete(retrievedLocation);

		// assert location was deleted
		Optional<Location> deletedLocation = locationRepository.findById(locationId);
		assertThat(deletedLocation.isPresent()).isFalse();
	}
	
	@Test(expected = JpaSystemException.class)
	public void testAddLocationJoinFailure() {
		//test should fail since the foreign keys for person should not be null
		//and there isn't a No Args constructor
		locationRepository.save(Location.builder().id(2).build());
	}
}
