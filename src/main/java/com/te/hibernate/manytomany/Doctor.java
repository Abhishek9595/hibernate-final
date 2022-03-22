package com.te.hibernate.manytomany;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Doctor implements Serializable {
	@Id
	private int dId;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "listDoctors")
	private List<Patient> listPatients;
}
