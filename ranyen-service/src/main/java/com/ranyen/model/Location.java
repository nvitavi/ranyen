package com.ranyen.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data @Builder 
@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="location_id")
	private int id;
	
	@Column(name="longitude")
	double longitude;
	
	@Column(name="latitude")
	double latitude;
	
	@Column(name="city")
	String city;
	
	@Column(name="country")
	String country;
	
	@Column(name="start_date")
	Date startDate;
	
	@Column(name="end_date")
	Date endDate;
	
	@Column(name="comments")
	String comments;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id", nullable = false)
	private Person person;

	@OneToMany(mappedBy="location")
	private Set<Picture> pictures;

	@OneToMany(mappedBy="location")
	private Set<Trip> trips;
	
}
