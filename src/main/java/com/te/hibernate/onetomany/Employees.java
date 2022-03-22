package com.te.hibernate.onetomany;

import java.io.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Employees implements Serializable {
	@Id
	private int employeeId;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cId")
	private Company company;
}
