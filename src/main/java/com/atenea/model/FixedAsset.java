package com.atenea.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fixed_assets")
@Getter
@Setter
public class FixedAsset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@Size(max = 255)
	private String description;

	@Enumerated(EnumType.STRING)
	private TypeAsset type;

	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String serial;

	@NotNull
	private String inventory_number;

	private Double weight;

	private Double height;

	private Double width;

	private Double length;

	@NotNull
	@Column(name = "purchase_value")
	private Double purchaseValue;

	@NotNull
	@Column(name = "purchase_date")
	private Date purchaseDate;


	@NotNull
	@Column(name = "disposal_date")
	private Date disposalDate;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "current_state")
	private CurrentState currentState;

	private String color;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	
	public enum CurrentState {
		ACTIVO, DADO_DE_BAJA, EN_REPARACION, DISPONIBLE, ASIGNADO
	}
	public enum TypeAsset {
		INMUEBLE, MAQUINARIA, MATERIAL_OFICINA
	}
	
	public Date getDisposalDate() {
		return disposalDate;
	}
	public void setDisposalDate(Date disposalDate) {
		this.disposalDate = disposalDate;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	

}
