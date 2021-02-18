package com.xworkz.flight.service;

import java.util.ArrayList;

import com.xworkz.flight.dao.impl.FlightDAOImpl;
import com.xworkz.flight.dto.FlightDTO;

public class InsertListOfRecords {

	public static void main(String[] args) {
		
		
		FlightDAOImpl dao=new FlightDAOImpl();
		
		FlightDTO dto=new FlightDTO(11, "indigo", 3000, 4.50, "kerala", "srilanka");
		
		FlightDTO dto1=new FlightDTO(12, "GOAIR", 1000, 6.00, "srilanka", "delhi");
		
		ArrayList<FlightDTO> dtos=new ArrayList<FlightDTO>();
		
		dtos.add(dto);
		dtos.add(dto1);
		
		dao.insertListOfRecords(dtos);

	}

}
