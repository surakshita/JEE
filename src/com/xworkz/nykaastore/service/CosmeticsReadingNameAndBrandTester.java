package com.xworkz.nykaastore.service;

import java.util.ArrayList;

import com.xworkz.nykaastore.dao.impl.CosmeticsDAOImpl;
import com.xworkz.nykaastore.dto.CosmeticsDTO;

public class CosmeticsReadingNameAndBrandTester {

	public static void main(String[] args) {
		
		
		CosmeticsDAOImpl cosmeticsDAOImpl=new CosmeticsDAOImpl();
		
		ArrayList<CosmeticsDTO> cosList=cosmeticsDAOImpl.readingNameAndBrandFromTable();
		
		for (CosmeticsDTO cosmeticsDTO : cosList) {
			
			System.out.println("name:"+cosmeticsDTO.getName());
			System.out.println("brand:"+cosmeticsDTO.getBrand());
			System.out.println("* * * * * * * * * * * * * * * * * * * * ");
			
		}
		
		
		

	}

}
