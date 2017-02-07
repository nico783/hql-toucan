package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jpa.dto.MovieActorNames;
import jpa.model.Actor;
import jpa.model.Movie;

@Repository
@Transactional
public class Dao {

	@PersistenceContext
	private EntityManager em;

	public List<Actor> test01() {
		final StringBuilder hql = new StringBuilder();
		hql.append(" select distinct a ");
		hql.append(" from Actor a ");
		hql.append(" order by a.name ");
		return em.createQuery(hql.toString(), Actor.class).getResultList();
	}

	public List<Actor> test02() {
		final StringBuilder hql = new StringBuilder();
		hql.append(" select distinct a ");
		hql.append(" from Actor a ");
		hql.append(" join fetch a.movies ");
		hql.append(" order by a.name");

		return em.createQuery(hql.toString(), Actor.class).getResultList();
	}

	public List<Actor> test03() {
		final StringBuilder hql = new StringBuilder();
		hql.append(" select distinct a ");
		hql.append(" from Actor a ");
		hql.append(" join fetch a.movies ");
		hql.append(" where upper(a.name) like '%C%' ");
		hql.append(" order by a.name");
		return em.createQuery(hql.toString(), Actor.class).getResultList();
	}

	public Actor test04() {
		final StringBuilder hql = new StringBuilder();
		hql.append(" select distinct a ");
		hql.append(" from Actor a ");
		hql.append(" join fetch a.movies ");
		hql.append(" where upper(a.name) like '%C%' ");
		hql.append(" order by a.name");
		
		Query q = em.createQuery(hql.toString(), Actor.class);
		q.setMaxResults(1);
		return (Actor) q.getSingleResult();
	}

	public List<Actor> test05() {
		final StringBuilder hql = new StringBuilder();
		hql.append(" select distinct a ");
		hql.append(" from Actor a ");
		hql.append(" join fetch a.movies m ");
		hql.append(" where upper(m.name) like '%F%' ");
		hql.append(" order by a.name");
		
		return em.createQuery(hql.toString(), Actor.class).getResultList();
	}

	public List<Actor> test06() {
		
		// Solution 1: avec une sous requete.
		final StringBuilder hql = new StringBuilder();
		hql.append(" select distinct actor ");
		hql.append(" from Actor actor ");
		hql.append(" join fetch actor.movies ");
		hql.append(" where actor.id in ");
		hql.append(" 	(select distinct a.id ");
		hql.append(" 	from Actor a ");
		hql.append(" 	join a.movies m ");
		hql.append(" 	where upper(m.name) like '%F%') ");
		hql.append(" order by actor.name");

		// Solution 2: avec une clause WITH
		final StringBuilder hql2 = new StringBuilder();
		hql2.append(" select distinct actor ");
		hql2.append(" from Actor actor ");
		hql2.append(" join actor.movies m ");
		hql2.append(" with upper(m.name) like '%F%' ");
		hql2.append(" left join fetch actor.movies ");
		
		return em.createQuery(hql.toString(), Actor.class).getResultList();
	}

	public List<Actor> test07() {
		final StringBuilder hql = new StringBuilder();
		hql.append(" select actor  ");
		hql.append(" from Actor actor ");
		hql.append(" join actor.movies m ");
		hql.append(" where actor.name!=:actorName ");
		hql.append(" and m.id in ");
		hql.append(" 	(select m.id ");
		hql.append(" 	from Movie m ");
		hql.append(" 	join m.actors a ");
		hql.append(" 	where a.name=:actorName) ");
		hql.append(" order by actor.name");
		
		return em.createQuery(hql.toString(), Actor.class).setParameter("actorName", "Leonardo DiCaprio").getResultList();
	}

	public List<Movie> test08() {
		final String hql = "from Movie where size(actors) > 1 order by name";
		return em.createQuery(hql, Movie.class).getResultList();
	}

	public List<Object[]> test09() {
		final String hql = "select m.name, a.name from Actor a join a.movies m order by m.name, a.name";
		return em.createQuery(hql, Object[].class).getResultList();
	}

	public List<MovieActorNames> test10() {
		final String hql = "select new jpa.dto.MovieActorNames (m.name, a.name) from Actor a join a.movies m order by m.name, a.name";
		return em.createQuery(hql, MovieActorNames.class).getResultList();
	}

}
