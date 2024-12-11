package com.cato.core.billing.common.security.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Table(name = "userdetail")
public class UserDetail {

	@Id
	@GenericGenerator(strategy = "increment",name = "user_autoincrement")
	@GeneratedValue(generator = "user_autoincrement")
	private Long id;
    private String username;
    private String password;
    private boolean enabled;
}
