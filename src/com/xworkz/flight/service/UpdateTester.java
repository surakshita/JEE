package com.xworkz.flight.service;

import com.xworkz.flight.dao.impl.FlightDAOImpl;
import com.xworkz.flight.dto.FlightDTO;

public class UpdateTester {

	public static void main(String[] args) {
		
		
		FlightDTO dto=new FlightDTO();
		FlightDAOImpl flightDAO=new FlightDAOImpl();
		
		boolean result=flightDAO.updateDestinationByFlightId("delhi", 2);
		if(result)
		{
			System.out.println("update in record is succesfull");
			
		}
		else {
			System.out.println("there was an error while updating record");
		}

	}

}
