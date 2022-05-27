package com.ids.mymaquete.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.mymaquete.entity.Exemple;

@TransactionalService
public class ExempleService extends AbstractService<Exemple, UUID> {

	public List<Exemple> init() throws Exception {
		List<Exemple> Exemples = new ArrayList<>();
		File f = new File("src/main/resources/init/exemple.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String line = sc.nextLine().trim();
			String[] block = line.split("##");
			Exemple exemple = new Exemple();
			exemple.setDesign(block[0]);
			exemple.setQte(Integer.valueOf(block[1]));
			Exemples.add(exemple);
		}
		return Exemples;

	}
}
