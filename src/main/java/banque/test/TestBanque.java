package banque.test;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entites.Adresse;
import banque.entites.AssuranceVie;
import banque.entites.Banque;
import banque.entites.Client;
import banque.entites.Compte;
import banque.entites.LivretA;
import banque.entites.Operation;
import banque.entites.Virement;


public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banqueJpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tr= em.getTransaction();
		tr.begin();
		/*
		 * Création d'une adresse
		 */
		Adresse adr = new Adresse();
		adr.setNumero(1);
		adr.setRue("Place du Capitole");
		adr.setCodePostal(31000);
		adr.setVille("Toulouse");
		/*
		 * Création de nouveaux client
		 */
		Client client1 = new Client();
		client1.setNom("Dupont");
		client1.setPrenom("Tess");
		client1.setDateNaissance(LocalDate.of(1998, 4, 14));
		client1.setAdresse(adr);
		
		Client client2 = new Client();
		client2.setNom("Plaa");
		client2.setPrenom("Corentin");
		client2.setDateNaissance(LocalDate.of(1997, 2, 21));
		client2.setAdresse(adr);
		/*
		 *  Ajout de client dans la base de donnée
		 */
				em.persist(client1);
				em.persist(client2);
				
				/*
				 * Création d'une banque
				 */
				Banque banque = new Banque();
				banque.setNom("Banque Populaire");
				
				/*
				 * Ajout d'une banque associer a un client 
				 */
				em.persist(banque);
				client1.setBanque(banque);
				client2.setBanque(banque);
				
				/*
				 * Création de trois comptes
				 */
				Compte compte1 = new Compte();
				compte1.setNumero("FR 1845 7035 5639");
				compte1.setSolde(2689);
				
				LivretA compte2 = new LivretA();
				compte2.setNumero("FR 3406 6932 4518");
				compte2.setSolde(18658);
				compte2.setTaux(0.02);
				
				AssuranceVie compte3 = new AssuranceVie();
				compte3.setNumero("FR 6408 1278 3951");
				compte3.setSolde(15487);
				compte3.setDateFin(LocalDate.of(2050, 12, 10));
				compte3.setTaux(0.05);
				
				/*
				 * Ajout d'un compte et association à un client
				 */
				em.persist(compte1);
				em.persist(compte2);
				em.persist(compte3);
				System.out.println(compte1);
				client1.getCompte().add(compte1);
				client2.getCompte().add(compte1);
				client2.getCompte().add(compte2);
				client2.getCompte().add(compte3);
				
				/*
				 * Création d'opérations et ajout à la base de donnée
				 */
				Operation op = new Operation();
				op.setDate(LocalDate.now());
				op.setMontant(-50.99);
				op.setMotif("DEBIT");
				op.setCompte(compte1);
				em.persist(op);
				
				op = new Operation();
				op.setDate(LocalDate.now());
				op.setMontant(108.52);
				op.setMotif("CREDIT");
				op.setCompte(compte1);
				em.persist(op);
			
				Virement v = new Virement();
				v.setDate(LocalDate.now());
				v.setMontant(250.00);
				v.setMotif("VIREMENT");
				v.setBeneficiaire("Marcel Michelin");
				v.setCompte(compte1);
				em.persist(v);
				
				/*
				 * Commit
				 */
				tr.commit();
	}

}
