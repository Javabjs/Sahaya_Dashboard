package com.sahayadashboard.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Product")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false,unique=true)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private AlcoholType type;
	
	@Column(nullable = false,unique=true)
	private String brand;
	
	@Column(nullable = false)
	private double quantity;
	
	@Column(nullable = false)
	private double alcohol_percentage;
	
	@Column(nullable = false)
	private Date manufactureDate;
	
	@Column(nullable =false)
	private Date expiryDate;
	
	@CreationTimestamp
	@Column(nullable=false,updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp 
	@Column(nullable=false,updatable=false)
	private Date updatedAt;

	
	
	

}
