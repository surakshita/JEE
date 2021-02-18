package com.xworkz.flight.service;

import com.xworkz.flight.dao.impl.FlightDAOImpl;
import com.xworkz.flight.dto.FlightDTO;

public class DeleteTester {

	public static void main(String[] args) {
		
		FlightDTO dto=new FlightDTO();
		FlightDAOImpl dao=new FlightDAOImpl();
		
		boolean res=dao.deleteByFlightId(11);
	if(res) {
		System.out.println("record deleted");
	}
		
	else {
		System.out.println("error");
	}

	}

}
