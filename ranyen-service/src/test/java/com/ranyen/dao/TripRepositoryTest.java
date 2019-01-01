package com.ranyen.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranyen.model.Trip;

@RunWith(SpringRunner.class)
public class TripRepositoryTest extends BaseTestSetup {

	@Test
	public void testGetTripSuccess() {
		// assert the same trip retrieved is the one added
		assertThat(trip.getPerson().getFirstName()).isEqualTo(retrievedTrip.getPerson().getFirstName());
	}
	
	@Test
	public void testJoinTripWithUserSuccess() {
		// test join with location
		assertThat(retrievedTrip.getPerson().getFirstName()).isEqualTo(mary.getFirstName());
	}
	
	@Test
	public void testJoinTripWithLocationSuccess() {
		// test join with location
		assertThat(retrievedTrip.getLocation().getCity()).isEqualTo(bamenda.getCity());
	}
	
	@Test
	public void testUpdateTripSuccess() {
		// update trip
		retrievedPerson.setFirstName("May");
		retrievedTrip.setPerson(retrievedPerson);
		Trip updatedTrip = tripRepository.save(retrievedTrip);

		// assert the same picture was updated
		assertThat(updatedTrip.getPerson().getFirstName()).isEqualTo(retrievedPerson.getFirstName());
	}
	
	@Test
	public void testDeleteTripSuccess() {
		// delete trip
		tripRepository.delete(retrievedTrip);

		// assert trip was deleted
		Optional<Trip> deletedTrip = tripRepository.findById(tripId);
		assertThat(deletedTrip.isPresent()).isFalse();
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	public void testAddTripFailure() {
		// save trip with same ID trip should fail
		tripRepository.save(Trip.builder().id(retrievedTrip.getId()).build());
	}
	
	@Test(expected = JpaSystemException.class)
	public void testAddTripJoinFailure() {
		//test should fail since the foreign keys for person and location should not be null
		//and there isn't a No Args constructor
		tripRepository.save(Trip.builder().id(2).build());
	}

}
