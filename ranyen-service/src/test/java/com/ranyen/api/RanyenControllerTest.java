package com.ranyen.api;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranyen.dao.LocationRepository;
import com.ranyen.dao.PersonRepository;
import com.ranyen.dao.TripRepository;
import com.ranyen.model.Location;
import com.ranyen.model.Person;
import com.ranyen.model.Trip;

@RunWith(SpringRunner.class)
@WebMvcTest(RanyenController.class)
public class RanyenControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonRepository personRepository;

	@MockBean
	private LocationRepository locationRepository;

	@MockBean
	private TripRepository tripRepository;

	@Test
	public void testAddPerson() throws Exception {
		Person person = Person.builder().build();

		mvc.perform(post("/add-user").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(person))).andExpect(status().isOk());
		
		verify(personRepository, times(1)).save(person);
	}

	@Test
	public void testGetPerson() throws Exception {
		Person person = Person.builder().id(0).build();
	    
		mvc.perform(post("/get-user").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(person))).andExpect(status().isOk());
		
		verify(personRepository, times(1)).findById(person.getId());
	}

	@Test
	public void testUpdatePerson() throws Exception {
		Person person = Person.builder().build();

		mvc.perform(post("/update-user").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(person))).andExpect(status().isOk());
		
		verify(personRepository, times(1)).save(person);
	}

	@Test
	public void testDeletePerson() throws Exception {
		Person person = Person.builder().build();

		mvc.perform(post("/delete-user").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(person))).andExpect(status().isOk());
		
		verify(personRepository, times(1)).delete(person);
	}

	@Test
	public void testAddLocation() throws Exception {
		Location location = Location.builder().build();
		List<Location> locations = Arrays.asList(location);

		mvc.perform(post("/add-location").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(locations))).andExpect(status().isOk());
		
		verify(locationRepository, times(1)).saveAll(locations);
	}

	@Test
	public void testUpdateLocation() throws Exception {
		Location location = Location.builder().build();
		List<Location> locations = Arrays.asList(location);

		mvc.perform(post("/update-location").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(locations))).andExpect(status().isOk());
		
		verify(locationRepository, times(1)).saveAll(locations);
	}

	@Test
	public void testDeleteLocation() throws Exception {
		Location location = Location.builder().build();
		List<Location> locations = Arrays.asList(location);

		mvc.perform(post("/delete-location").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(locations))).andExpect(status().isOk());
		
		verify(locationRepository, times(1)).deleteAll(locations);
	}

	@Test
	public void testGetTrips() throws Exception {
		Trip trip = Trip.builder().id(0).build();
		Set<Trip> trips = new HashSet<>();
		trips.add(trip);
		Person person = Person.builder().id(0).trips(trips).build();

		mvc.perform(post("/get-trips").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(person))).andExpect(status().isOk());
		
		verify(tripRepository, times(1)).findAllById(Arrays.asList(person.getId()));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
