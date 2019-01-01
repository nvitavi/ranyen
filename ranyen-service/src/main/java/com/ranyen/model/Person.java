package com.ranyen.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data @Builder
@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;

	@Column(name="user_name")
	private String username;

	@Column(name="pwd")
	private String password;

	@Column(name="email_address")
	private String emailAddress;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleInitial;

	@OneToMany(mappedBy="person")
	private Set<Location> locations;

	@OneToMany(mappedBy="person")
	private Set<Picture> pictures;

	@OneToMany(mappedBy="person")	
	private Set<Trip> trips;

}
