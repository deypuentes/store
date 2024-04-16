package com.staging.store.repository;

import org.springframework.stereotype.Repository;

import com.staging.store.dto.SalesBySellerDTO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class SalesBySellerJDBC{
	
	@Autowired
    public JdbcTemplate jdbcTemplate;
	
	public List<SalesBySellerDTO> getTotalSalesBySeller(LocalDate startDate, LocalDate endDate){


		String cmdSQL="select"
				+ "	s.seller_name as seller_name,"
				+ "	p.name as product_name,"
				+ "	SUM(sa.amount) as total"
				+ " from"
				+ "	seller s"
				+ " join product p on"
				+ "	s.id = p.seller"
				+ " join sales sa on"
				+ "	p.id = sa.product_id"
				+ " where "
				+ "sa.date_sale  >= '" + startDate
				+ "' AND sa.date_sale <= '" +endDate
				+ "'"
				+ " group by"
				+ "	s.seller_name,"
				+ "	p.name";

		return jdbcTemplate.query(cmdSQL, (rs, rowNum) -> {
			SalesBySellerDTO bySellerDTO = new SalesBySellerDTO();
			bySellerDTO.setSellerName(rs.getString("seller_name"));
			bySellerDTO.setProductName(rs.getString("product_name"));
			bySellerDTO.setTotalSale(rs.getInt("total"));

            return bySellerDTO;
        });	}
	

}


