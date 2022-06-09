package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Facture;

@TransactionalService
public class FactureService extends AbstractService<Facture, UUID> {
	public List<Facture> init() throws Exception {
		List<Facture> factures = new ArrayList<>();
		File f = new File("src/main/resources/names.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String Payement = sc.nextLine().trim();
			UUID Client = null;
			double Montant = sc.nextDouble();
			double Reduction = sc.nextDouble();
			double Tva = sc.nextDouble();
			double Total = sc.nextDouble();
			Facture facture = new Facture();
			facture.setMontant(Montant);
			facture.setPayement(Payement);
			facture.setClient(Client);
			facture.setReduction(Reduction);
			facture.setTva(Tva);
			facture.setTotal(Total);
			factures.add(facture);
		}
		return factures;
	}
}
