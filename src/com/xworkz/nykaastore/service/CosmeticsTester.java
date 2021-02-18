package com.xworkz.nykaastore.service;

import java.util.ArrayList;

import com.xworkz.nykaastore.dao.CosmeticsDAO;
import com.xworkz.nykaastore.dao.impl.CosmeticsDAOImpl;
import com.xworkz.nykaastore.dto.CosmeticsDTO;

public class CosmeticsTester {
	public static void main(String[] args) {

		CosmeticsDAO cosmeticsDAOImpl = new CosmeticsDAOImpl();
		ArrayList<CosmeticsDTO> cosmeticsList = new ArrayList<CosmeticsDTO>();

		CosmeticsDTO cosmetics = new CosmeticsDTO(5, "Eyeshadow", 600.00, 1, "Bobbi Brown");

		System.out.println("Saving record database:" + cosmetics);

		boolean result = cosmeticsDAOImpl.save(cosmetics);

		if (result) {
			System.out.println("inserted into record,sucessfully");
		} else {
			System.out.println("problem while recording");
		}
	}

}
