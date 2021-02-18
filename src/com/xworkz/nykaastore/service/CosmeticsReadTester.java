package com.xworkz.nykaastore.service;

import java.util.ArrayList;

import com.xworkz.nykaastore.dao.impl.CosmeticsDAOImpl;
import com.xworkz.nykaastore.dto.CosmeticsDTO;

public class CosmeticsReadTester {

	public static void main(String[] args) {

		CosmeticsDAOImpl cosmeticDAOImpl = new CosmeticsDAOImpl();

		ArrayList<CosmeticsDTO> cosmeticsList = cosmeticDAOImpl.readAllRecords();

		for (CosmeticsDTO cosmeticsDTO : cosmeticsList) {

			System.out.println("cosmeticsId is:" + cosmeticsDTO.getCosmeticsId());
			System.out.println("cosmetics name:" + cosmeticsDTO.getName());
			System.out.println("cosmetics price:" + cosmeticsDTO.getPrice());
			System.out.println("cosmetic quantity:" + cosmeticsDTO.getQuantity());
			System.out.println("cosmetics brand:" + cosmeticsDTO.getBrand());
			System.out.println("* * * * * * * * * * * * * *  * * * * * * * * *");

		}
	}

}
