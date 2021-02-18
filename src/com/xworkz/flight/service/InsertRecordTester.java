package com.xworkz.flight.service;

import com.xworkz.flight.dao.FlightDAO;
import com.xworkz.flight.dao.impl.FlightDAOImpl;
import com.xworkz.flight.dto.FlightDTO;

public class InsertRecordTester {

	public static void main(String[] args) {

		FlightDTO dto = new FlightDTO(2, "AIRINDIA", 2000, 3.00, "gulbarga", "kerala");
		FlightDAO dao = new FlightDAOImpl();

		boolean res = dao.insertRecord(dto);

		if (res) {
			System.out.println("succesfull insertion of data:");
		} else {
			System.out.println("problem while insertion:");
		}
	}

}
