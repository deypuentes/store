package com.staging.store.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SaleEntity {  
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="invoice_id")
	private Integer invoiceId;
	
    @Column(name= "product")
    private String product;

    @Column(name="seller")
    private Integer seller;

    @Column(name="date_seller")
    private LocalDate dateSeller;
    
    @Column(name="amount")
    private Integer amount;

	
}
