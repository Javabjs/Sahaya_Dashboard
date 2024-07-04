package com.sahayadashboard.model;

import java.util.Date;
import java.util.UUID;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="role")


public class Role {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable=false,unique=true)
	private String name;
	
	@CreationTimestamp
	@Column(nullable=false,updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(nullable=false)
	private Date updatedAt;
	
	

}
