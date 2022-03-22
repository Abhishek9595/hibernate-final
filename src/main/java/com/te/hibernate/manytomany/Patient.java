package com.te.hibernate.manytomany;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Patient implements Serializable {
	@Id
	private int pId;
	private String pName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "patients_info", 
	joinColumns = @JoinColumn(name = "pId"), 
	inverseJoinColumns = @JoinColumn(name = "dId"))
	private List<Doctor> listDoctors;
}
