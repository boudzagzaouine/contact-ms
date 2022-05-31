package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.MatierePremiere;

@TransactionalService
public class MatierePremiereService extends AbstractService<MatierePremiere, UUID> {

	public List<MatierePremiere> init() throws Exception {
		List<MatierePremiere> matierePremieres = new ArrayList<>();
		File f = new File("src/main/resources/init/matiere_premiere.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String line = sc.nextLine().trim();
			MatierePremiere matierePremiere = new MatierePremiere();
			//metal coco##metal##400##oo1##594f8488-cac0-4dd6-bd05-720bef34014d
			String[] word = line.split("##");
			matierePremiere.setDesignation(word[0]);
			matierePremiere.setFamilleMatierePremiere(word[1]);
			matierePremiere.setPrix(Double.valueOf(word[2]));
			matierePremiere.setOrigine(word[3]);
			matierePremiere.setIdFournisseur(UUID.fromString(word[4]));

			matierePremieres.add(matierePremiere);
		}
		sc.close();
		return matierePremieres;

	}
}
