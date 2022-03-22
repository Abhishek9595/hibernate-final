package com.te.hibernate.onetomany;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Company implements Serializable {
	@Id
	private int cId;
	private String cName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Employees> listEmployees;
}
