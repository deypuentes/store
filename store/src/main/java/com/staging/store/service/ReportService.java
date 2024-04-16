package com.staging.store.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.staging.store.dto.SalesBySellerDTO;
import com.staging.store.repository.SalesBySellerJDBC;

@Service
public class ReportService {
	 
	private final Logger logger = LogManager.getLogger(ReportService.class);
	

	
	@Autowired
	SalesBySellerJDBC salesBySellerJDBC;

	
	@Transactional(readOnly = true)
	public List<SalesBySellerDTO> salesReportBySeller(LocalDate startDate,LocalDate endDate) throws Exception {
		logger.debug("Starting operation sales report by seller");
		try {
		return salesBySellerJDBC.getTotalSalesBySeller(startDate, endDate);
			
		}
		catch (Exception e) {
			throw new Exception("detalle: " + e.getMessage());
		}

	}
}
