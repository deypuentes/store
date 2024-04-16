package com.staging.store.controller;

import java.time.LocalDate;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staging.store.dto.SalesBySellerDTO;
import com.staging.store.service.ReportService;

@RestController
@RequestMapping("/store")
public class ReporSellerVsSaleController {
	private final Logger logger = LogManager.getLogger(ReporSellerVsSaleController.class);

	
	@Autowired
	ReportService reportService;

	
	@GetMapping("/report/saleseller")
    public List<SalesBySellerDTO> obtenerRegistrosPorRangoFechas(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {
		try {
			
        return reportService.salesReportBySeller(startDate, endDate);
		}finally {
            logger.info("Finalizando consumo del API Visitor consulta por dia");
        }
    }
}
