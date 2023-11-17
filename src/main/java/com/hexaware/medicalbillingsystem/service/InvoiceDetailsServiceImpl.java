package com.hexaware.medicalbillingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystem.dto.InvoiceDetailsDTO;
import com.hexaware.medicalbillingsystem.entities.InvoiceDetails;
import com.hexaware.medicalbillingsystem.exceptions.NoSuchInvoiceGeneratedException;
import com.hexaware.medicalbillingsystem.repository.InvoiceDetailsRepository;

@Service
public class InvoiceDetailsServiceImpl implements IInvoiceDetailsService {

	@Autowired
	private InvoiceDetailsRepository repository;
	
	@Override
	public InvoiceDetails generateInvoice(InvoiceDetailsDTO detailsDTO) {
		InvoiceDetails details=new InvoiceDetails();
		details.setInvoiceDate(detailsDTO.getInvoiceDate());
		details.setInvoiceDueDate(detailsDTO.getInvoicedueDate());
		details.setInvoiceTax(detailsDTO.getInvoiceTax());
		details.setInvoiceTotalAmount(detailsDTO.getInvoiceTotalAmount());
		details.setPatient(detailsDTO.getPatient());
		return repository.save(details);
	}

	@Override
	public List<InvoiceDetails> getAllGeneratedInvoice() {

		return repository.findAll();
	}

	@Override
	public InvoiceDetailsDTO getInvoiceById(int invoiceId) {
		InvoiceDetails details= repository.findById(invoiceId).orElseThrow(() -> new NoSuchInvoiceGeneratedException(
		         HttpStatus.NO_CONTENT,"No such Invoice with Id :"+invoiceId+" Found"));
		InvoiceDetailsDTO detailsDTO=new InvoiceDetailsDTO();
		detailsDTO.setInvoiceId(details.getInvoiceId());
		detailsDTO.setInvoiceDate(details.getInvoiceDate());
		detailsDTO.setInvoicedueDate(details.getInvoiceDueDate());
		detailsDTO.setInvoiceTax(details.getInvoiceTax());
		detailsDTO.setInvoiceTotalAmount(details.getInvoiceTotalAmount());
		detailsDTO.setPatient(details.getPatient());
		return detailsDTO;
	}

}
