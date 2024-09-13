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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="stock")

public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	private int quantity;
	
	
	@CreationTimestamp
	@Column(nullable=false,updatable=false)
	private Date createdAt;
	
	
	@UpdateTimestamp 
	@Column(nullable=false,updatable=false)
	private Date updatedAt;
	
	
	public Stock(String uuid) {
	 this.id=UUID.fromString(uuid);
	}
	
	public Stock(int quantity) {
        this.quantity = quantity;
    }
	
	

}
