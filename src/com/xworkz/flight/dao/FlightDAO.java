package com.xworkz.flight.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xworkz.flight.dto.FlightDTO;


public interface FlightDAO {
	
	
	Connection getDBConnection() throws SQLException;
	
	public boolean insertRecord(FlightDTO flight);
	
	public void insertListOfRecords(ArrayList<FlightDTO> flightDTO);
	
	//CRUD
	
	public void insertMultipleRecords(ArrayList<FlightDTO> flightDTOs );
	
	public boolean updateDestinationByFlightId(String destination,int flightId);
	
	public boolean deleteByFlightId(int flightId);
	
	
	
	
	
	

}
