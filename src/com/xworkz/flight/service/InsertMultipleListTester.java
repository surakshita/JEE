package com.xworkz.flight.service;

import java.util.ArrayList;

import com.xworkz.flight.dao.impl.FlightDAOImpl;
import com.xworkz.flight.dto.FlightDTO;

public class InsertMultipleListTester {

	public static void main(String[] args) {

		
		FlightDAOImpl dao=new FlightDAOImpl();
		
		FlightDTO dto=new FlightDTO(13, "SpiceJet", 200, 4.00, "banglore", "pune");
		FlightDTO dto1=new FlightDTO(14, "AIR INDIA", 200, 8.45, "pune", "banglore");
		
		ArrayList<FlightDTO> dtos=new ArrayList<FlightDTO>();
		
		dtos.add(dto);
		dtos.add(dto1);
		
		dao.insertMultipleRecords(dtos);
		

	}

}
