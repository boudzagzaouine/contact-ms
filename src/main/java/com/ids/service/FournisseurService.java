package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Fournisseur;

@TransactionalService
public class FournisseurService extends AbstractService<Fournisseur, UUID> {

	public List<Fournisseur> init() throws Exception {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		File f = new File("src/main/resources/init/fournisseurs.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String word = sc.nextLine().trim();
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setDesign(word);
			fournisseur.setContact(word);
			fournisseur.setEmail(word.replace(" ", "_") + "@gmail.com");
			fournisseurs.add(fournisseur);
		}
		return fournisseurs;

	}
}
