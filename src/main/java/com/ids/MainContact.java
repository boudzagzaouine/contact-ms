package com.ids;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ids.data.utils.ApplicationStarter;
import com.ids.entity.AdressLiv;
import com.ids.repository.AdressLivRepository;
import com.ids.repository.ArticleClientRepository;
import com.ids.repository.ArticleCommandeRepository;
import com.ids.repository.ArticleRepository;
import com.ids.repository.ClientRepository;
import com.ids.repository.CommandeRepository;
import com.ids.repository.DeviseRepository;
import com.ids.repository.FournisseurRepository;
import com.ids.repository.IncotermRepository;
import com.ids.repository.MatierePremiereRepository;
import com.ids.repository.PayementModeRepository;
import com.ids.service.ArticleClientService;
import com.ids.service.ArticleService;
import com.ids.service.ClientService;
import com.ids.service.DeviseService;
import com.ids.service.FournisseurService;
import com.ids.service.IcotermService;
import com.ids.service.MatierePremiereService;
import com.ids.service.PayementModeService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MainContact {
	private boolean g = true;

	public static void main(String[] args) {
		ApplicationStarter.Main(args, MainContact.class);
	}

	// http://localhost:2000/v2/api-docs
	// http://localhost:2000/swagger-ui.html
	// IDS DATA
	/**
	 * drop table commande_article_commandes;drop table client_adress_livs;drop
	 * table client_commandes;drop table article_commande; drop table
	 * adress_liv;drop table commande;drop table client;
	 */

	@Bean
	CommandLineRunner go(ClientRepository clientRepository, ClientService service,
			CommandeRepository commandeRepository, AdressLivRepository adressLivRepository,
			ArticleCommandeRepository articleCommandeRepository, DeviseRepository deviseDao, DeviseService deviseServ,
			IncotermRepository incotermDao, IcotermService incotermServ, PayementModeRepository payementModeDao,
			PayementModeService payementModeServ) {
		return a -> {
			if (clientRepository.findAll().size() == 0)
				clientRepository.saveAll(service.init());
			/************************************************************************
			 * new java.util.Timer().schedule(new java.util.TimerTask() {
			 * 
			 * @Override public void run() { try { if (commandeRepository.findAll().size()
			 *           == 0) { clientRepository.findAll().forEach(l -> { for (int i = 0; i
			 *           < 3; i++) { int k = rn(7, 8000); Commande cm = new Commande();
			 *           cm.setDate(new Date()); cm.setSeason("saison " + k); cm.setAmount(k
			 *           * 2); cm.setIdClient(l.getId()); commandeRepository.save(cm); } });
			 *           }
			 ********************************************************************************************************/
			if (adressLivRepository.findAll().size() == 0 && g) {
				String[] countr = new String[] { "maroc#rabat", "maroc#casa", "maroc#fes", "maroc#oujda",
						"maroc#tanger", "maroc#titouane", "maroc#araiche", "maroc#marakesh", "maroc#alyoune",
						"maroc#dakhla", "maroc#rachidia", "france#paris", "france#marseil", "france#nime",
						"france#lille", "france#toulouse", "tunisie#assima", "tunisie#jerba", "tunisie#ssfakess",
						"espagne#madrid", "espagne#barcelone", "espagne#malaga", "espagne#alicante", "espagne#cortova",
						"espagne#sivilla", "espagne#lione", "arabie saudi#makka", "arabie saudi#madina",
						"arabie saudi#riad", "arabie saudi#tabouk", };
				clientRepository.findAll().forEach(cl -> {
					List<AdressLiv> lav = new ArrayList<>();
					for (int i = 1; i < 3; i++) {
						int n = rn(0, countr.length);
						String[] tab = countr[n].split("#");
						AdressLiv al = new AdressLiv();
						al.setCountry(tab[0]);
						al.setCity(tab[1]);
						al.setAdress(i + " rue de la liberté " + tab[1] + " " + tab[0]);
						al.setIdClient(cl.getId());
						adressLivRepository.save(al);
						lav.add(al);
					}
					cl.setAdressLivs(lav);
					clientRepository.save(cl);
				});
			}
			/****************************************************************************************
			 * if (articleCommandeRepository.findAll().size() == 0) { String[] countr = new
			 * String[] { "pc", "tablette", "ecran", "machine a laver", "smarte phone",
			 * "tv", "frigirateur" }; commandeRepository.findAll().forEach(cl -> { for (int
			 * i = 0; i < 3; i++) { ArticleCommande al = new ArticleCommande();
			 * al.setDesign(countr[rn(0, countr.length)]); al.setQte(rn(1, 500));
			 * al.setPu(rn(200, 50000)); al.setPortion("***"); al.setIdCommande(cl.getId());
			 * articleCommandeRepository.save(al); } }); } } catch (Exception e) {
			 * e.printStackTrace(); } } }, 1000); System.out.println("done ..... !");
			 ************************************************************************/
			if (deviseDao.findAll().size() == 0)
				deviseDao.saveAll(deviseServ.init());
			/************************************************************************/
			if (incotermDao.findAll().size() == 0)
				incotermDao.saveAll(incotermServ.init());
			/***********
			 * payementModeDao
			 *************************************************************/
			if (payementModeDao.findAll().size() == 0)
				payementModeDao.saveAll(payementModeServ.init());

		};
	}

	@Bean
	CommandLineRunner goF(FournisseurRepository frounDao, FournisseurService service) {
		return a -> {
			if (frounDao.findAll().size() == 0)
				frounDao.saveAll(service.init());
		};
	}

	@Bean
	CommandLineRunner goArt(ArticleRepository artDao, ArticleService service) {
		return a -> {
			if (artDao.findAll().size() == 0)
				artDao.saveAll(service.init());
		};
	}

	@Bean
	CommandLineRunner goArtClient(ArticleClientRepository artDao, ArticleClientService service) {
		return a -> {
			if (artDao.findAll().size() == 0)
				artDao.saveAll(service.init());
		};
	}

	@Bean
	CommandLineRunner goMatierePremiere(MatierePremiereRepository matDao, MatierePremiereService service) {
		return a -> {
			if (matDao.findAll().size() == 0)
				matDao.saveAll(service.init());
		};
	}

	public int rn(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
}
