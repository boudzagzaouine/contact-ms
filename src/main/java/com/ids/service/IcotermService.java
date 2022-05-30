package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Incoterm;

@TransactionalService
public class IcotermService extends AbstractService<Incoterm, UUID> {

	public List<Incoterm> init() throws Exception {
		List<Incoterm> incoterms = new ArrayList<>();
		File f = new File("src/main/resources/init/incoterm.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String line = sc.nextLine().trim();
			String[] blocks = line.split("##");
			Incoterm incoterm = new Incoterm();
			incoterm.setDesign(blocks[1]);
			incoterm.setCode(blocks[0]);
			incoterms.add(incoterm);
		}
		sc.close();
		return incoterms;

	}
}
