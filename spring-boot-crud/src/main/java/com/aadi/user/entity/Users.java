package com.aadi.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq_gen")
	@SequenceGenerator(name = "users_seq_gen", sequenceName = "users_seq", allocationSize = 1)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	public Long getId() {
		return id;
	}

}