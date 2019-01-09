package com.ranyen.dao;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.ranyen.model.Location;
import com.ranyen.model.Person;
import com.ranyen.model.Picture;
import com.ranyen.model.Trip;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("local")
public class BaseTestSetup {

	@Autowired
	private TestEntityManager entityManager;

	//Setup for person
	@Autowired
	protected PersonRepository personRepository;
	
	protected Person mary = Person.builder().firstName("Mary").lastName("Jane").emailAddress("mary_jane@email.com").username("mj").password("mary123")
			.build();
	
	protected int maryId;

	//find person added in BaseTestSetup by ID
	Person retrievedPerson;
	
	//Setup for location
	@Autowired
	protected LocationRepository locationRepository;
	
	protected Location bamenda = Location.builder().latitude(123.4).longitude(567.8).city("Bamenda").country("Cameroon")
			.person(mary).build();
	
	protected int locationId;
	
	protected Location retrievedLocation;
	
	//setup for picture
	@Autowired
	protected PictureRepository pictureRepository;
	
	protected Picture picture = Picture.builder().location(bamenda).person(mary).uri("/picure/1").build();
	
	protected int pictureId;
	
	protected Picture retrievedPicture;

	//setup for trip
	@Autowired
	protected TripRepository tripRepository;
	
	protected Trip trip = Trip.builder().location(bamenda).person(mary).build();
	
	protected int tripId;
	
	protected Trip retrievedTrip;
	
	@Before
	public void setUp() {
		
		//persist Person to DB
		maryId = (int) entityManager.persistAndGetId(mary);
		
		// persist location to DB
		locationId = (int) entityManager.persistAndGetId(bamenda);
		
		//persist picture to DB
		pictureId = (int) entityManager.persistAndGetId(picture);
		
		//persist trip to DB
		tripId = (int) entityManager.persistAndGetId(trip);
		
		entityManager.flush();

		//find person added in by ID
		retrievedPerson = personRepository.findById(maryId).get();
		
		//find location added by ID
		retrievedLocation = locationRepository.findById(locationId).get();
		
		//find picture added by ID
		retrievedPicture = pictureRepository.findById(pictureId).get();
		
		//find trip added by ID
		retrievedTrip= tripRepository.findById(tripId).get();
	}

}
