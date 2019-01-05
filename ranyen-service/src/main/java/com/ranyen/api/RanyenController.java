package com.ranyen.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ranyen.dao.LocationRepository;
import com.ranyen.dao.PersonRepository;
import com.ranyen.dao.TripRepository;
import com.ranyen.model.Location;
import com.ranyen.model.Person;
import com.ranyen.model.Trip;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RanyenController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private TripRepository tripRepository;

	@CrossOrigin
	@PostMapping("/add-user")
	public void addUser(@RequestBody Person person) {
		log.debug("Inside add user method");
		personRepository.save(person);
		log.debug("Person has been added");
	}

	@PostMapping("/get-user")
	public Person getUser(@RequestBody Person person) {
		// TODO: first authenticate user
		try {
			return personRepository.findById(person.getId()).get();
		} catch (NoSuchElementException e) {
			log.error("Error in getUser", e.getMessage());
			return null;
		}
	}

	@PostMapping("/update-user")
	public Person updateUser(@RequestBody Person person) {
		// TODO: first authenticate user before updating
		return personRepository.save(person);
	}

	@PostMapping("/delete-user")
	public void deleteUser(@RequestBody Person person) {
		// TODO: first authenticate user before deleting
		personRepository.delete(person);
	}

	@PostMapping("/add-location")
	public void addLocation(@RequestBody List<Location> locations) {
		// TODO: first authenticate user
		locationRepository.saveAll(locations);
	}

	@PostMapping("/update-location")
	public void updateLocation(@RequestBody List<Location> locations) {
		// TODO: first authenticate user
		locationRepository.saveAll(locations);
	}

	@PostMapping("/delete-location")
	public void deleteLocations(@RequestBody List<Location> locations) {
		// TODO: first authenticate user
		locationRepository.deleteAll(locations);
	}

	@PostMapping("/get-trips")
	public List<Trip> getTrips(@RequestBody Person person) {
		// TODO: first authenticate user
		List<Integer> tripIds = person.getTrips().stream().map(Trip::getId).collect(Collectors.toList());
		return (List<Trip>) tripRepository.findAllById(tripIds);
	}
}
