package fr.adaming.forum.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import fr.adaming.forum.entity.Formation;

@Component
public class FormationDaoImpl implements IFormation{

	@PersistenceContext
	private EntityManager em;

	Logger log = Logger.getLogger("FormationDaoImpl");

	@Override
	public Formation addFormation(Formation formation) {
		em.persist(formation);
		log.info("La formation "+ formation + " a �t� ajout�e.");
		return null;
	}

	@Override
	public Formation getFormationById(int idFormation) {
		Formation formation = em.find(Formation.class, idFormation);
		log.info("La formation "+ formation +" est dans la base de donn�e" );
		return formation;
	}

	@Override
	public Formation updateFormation(Formation formation) {
		em.merge(formation);
		log.info("L'adresse "+ formation +" a �t� modifi�e");
		return formation;
		
	}

	@Override
	public Formation deleteFormation(int idFormation) {
		Formation formation = em.find(Formation.class, idFormation);
		em.remove(formation);
		log.info("L'adresse "+ formation +" a �t� supprim�e de la base de donn�e" );
		return formation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formation> getAllFormations() {
		Query query = em.createQuery("FROM Formation");
		log.info("Il y a " + query.getResultList().size() + " Formation(s) !");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formation> getFormationByKeyWord(String keyWord) {
		Query query = em.createQuery("From Formation f like :x");
		query.setParameter("x", "%" + keyWord + "%");
		
		log.info(query.getResultList().size() + "utilisateur(s) ont �t� trouv� !");
		return query.getResultList();
	}

}
