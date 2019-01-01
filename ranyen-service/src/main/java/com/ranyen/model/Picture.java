package com.ranyen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data @Builder
@Entity
@Table(name = "picture")
public class Picture {

	@Id
	@Column(name = "picture_id")
	private int id;

	@Column(name = "uri")
	private String uri;

	@ManyToOne
	@JoinColumn(name = "fk_user_id", nullable = false)
	private Person person;

	@ManyToOne
	@JoinColumn(name = "fk_location_id", nullable = false)
	private Location location;

}
