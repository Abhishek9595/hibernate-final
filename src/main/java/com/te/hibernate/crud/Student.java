package com.te.hibernate.crud;

import java.io.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Student implements Serializable {
	@Id
	private int id;
	private String name;
	private String location;
}
