package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Avoir;

@TransactionalService
public class AvoirService extends AbstractService<Avoir, UUID> {
	public List<Avoir> init() throws Exception {
		List<Avoir> avoirs = new ArrayList<>();
		File f = new File("src/main/resources/names.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			UUID NumFacture = null;
			UUID Client = null;
			double Montant = sc.nextDouble();
			Avoir avoir = new Avoir();

			avoir.setMontant(Montant);
			avoir.setClient(Client);
			avoir.setNumeroFacture(NumFacture);
			avoirs.add(avoir);
		}
		return avoirs;
	}
}