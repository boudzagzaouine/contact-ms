package com.ids.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ids.data.annotation.TransactionalService;
import com.ids.data.service.AbstractService;
import com.ids.entity.Journal;

@TransactionalService
public class JournalService extends AbstractService<Journal, UUID> {
	public List<Journal> init() throws Exception {
		List<Journal> journals = new ArrayList<>();
		File f = new File("src/main/resources/names.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			UUID NumFacture = null;
			UUID Client = null;
			String Type = sc.nextLine().trim();
			Long Entree = sc.nextLong();
			Long Sortie = sc.nextLong();

			Journal journal = new Journal();
			journal.setClient(Client);
			journal.setNumeroFacture(NumFacture);
			journal.setEntree(Entree);
			journal.setSortie(Sortie);
			journal.setType(Type);
			journals.add(journal);
		}
		return journals;
	}
}