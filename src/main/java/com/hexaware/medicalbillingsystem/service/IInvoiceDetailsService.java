package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import com.hexaware.medicalbillingsystem.dto.InvoiceDetailsDTO;
import com.hexaware.medicalbillingsystem.entities.InvoiceDetails;
/*
@Author :   Rajat Darvhekar 
Modified Date : 04-11-2023
Description : Interface of  InvoiceDetailsService performing the following operations
*/
public interface IInvoiceDetailsService {
	
	public InvoiceDetails generateInvoice(InvoiceDetailsDTO detailsDTO);
	
	public List<InvoiceDetails> getAllGeneratedInvoice();
	
	public InvoiceDetailsDTO getInvoiceById(int invoiceId);
	
	

}
