package com.atenea.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cities")
@Getter
@Setter
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "city_name", nullable = false)
	private String cityName;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "department_id", nullable = false)
	private Integer departmentId;

}
