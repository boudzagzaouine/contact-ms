package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Devise;

@TransactionalService
public class DeviseService extends AbstractService<Devise, UUID> {

	public List<Devise> init() throws Exception {
		List<Devise> devises = new ArrayList<>();
		File f = new File("src/main/resources/devise.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String line = sc.nextLine().trim();
			String[] blocks = line.split("##");
			Devise devise = new Devise();
			devise.setDesignation(blocks[1]);
			devise.setSymbole(blocks[2]);
			devise.setCode_iso(blocks[3]);
			devises.add(devise);
		}
		sc.close();
		return devises;

	}
}
