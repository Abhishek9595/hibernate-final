package com.te.hibernate.onetoone;

import java.io.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Person implements Serializable {
	@Id
	private int pId;
	private String pName;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
	private Passport passport;
}
