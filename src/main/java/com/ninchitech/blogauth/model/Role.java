package com.ninchitech.blogauth.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
	public final static Role USER = new Role("USER");
    public final static Role SERVICE = new Role("SERVICE");

    private String name;
}
