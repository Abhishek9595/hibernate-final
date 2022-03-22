package com.te.hibernate.onetoone;

import java.io.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Passport implements Serializable {
	@Id
	private int passId;
	private String passNum;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pId")
	private Person person;
}
