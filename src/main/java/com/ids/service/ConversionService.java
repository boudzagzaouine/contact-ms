package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Conversion;

@TransactionalService
public class ConversionService extends AbstractService<Conversion, UUID> {
	public List<Conversion> init() throws Exception {
		List<Conversion> conversions = new ArrayList<>();
		File f = new File("src/main/resources/names.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			UUID NumFacture = null;
			UUID Client = null;
			Long Montant = sc.nextLong();
			Long Taux = sc.nextLong();
			Long Valeur = sc.nextLong();
			Conversion conversion = new Conversion();
			conversion.setMontant(Montant);
			conversion.setClient(Client);
			conversion.setNumeroFacture(NumFacture);
			conversion.setTaux(Taux);
			conversion.setValeur(Valeur);
			conversions.add(conversion);
		}
		return conversions;
	}
}
