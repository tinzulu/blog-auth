package com.ninchitech.blogauth.model;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
	 private String displayName;
	 private String profilePictureUrl;
	 private Date birthday;
}
