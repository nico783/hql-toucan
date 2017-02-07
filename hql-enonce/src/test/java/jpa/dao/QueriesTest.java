package jpa.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.dao.Dao;
import jpa.dto.MovieActorNames;
import jpa.model.Actor;
import jpa.model.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class QueriesTest {

	@Autowired
	private Dao dao;

	/**
	 * Récupérer la liste de tous les acteurs
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>sans charger les films</li>
	 * </ul>
	 */
	@Test
	public void test01() {
		List<Actor> actors = dao.test01();

		// 10 acteurs dans la base
		Assert.assertEquals(10, actors.size());
	}

	/**
	 * Liste de tous les acteurs 
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>avec chargement des films</li>
	 * </ul>
	 */
	@Test
	public void test02() {
		List<Actor> actors = dao.test02();

		// 10 acteurs dans la base
		Assert.assertEquals(10, actors.size());
		// Al Pacino : 1 movie
		Assert.assertEquals(1, actors.get(0).getMovies().size());
		// Tom Hanks : 3 movies
		Assert.assertEquals(3, actors.get(actors.size() - 1).getMovies().size());
	}

	/**
	 * Liste de tous les acteurs
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>dont le nom contient 'C' (case insensitive)</li>
	 * <li>avec les films chargés</li>
	 * </ul>
	 */
	@Test
	public void test03() {
		List<Actor> actors = dao.test03();

		// 5 actors
		Assert.assertEquals(5, actors.size());
		// Al Pacino : 1 movie
		Assert.assertEquals(1, actors.get(0).getMovies().size());
		// Leonardo DiCaprio : 3 movies
		Assert.assertEquals(3, actors.get(actors.size() - 1).getMovies().size());
	}

	/**
	 * Récupérer le premier acteur de la liste des acteurs
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>avec les films chargés</li>
	 * <li>dont le nom contient 'C' (case insensitive)</li>
	 * </ul>
	 */
	@Test
	public void test04() {
		Actor actor = dao.test04();

		// Al Pacino : 1 movie
		Assert.assertNotNull(actor);
		Assert.assertEquals("Al Pacino", actor.getName());
		Assert.assertEquals(1, actor.getMovies().size());
	}

	/**
	 * Liste des acteurs
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>avec les films chargés</li>
	 * <li>qui possède un film de nom contenant la lettre 'f' (case insensitive)</li>
	 * </ul>
	 */
	@Test
	public void test05() {
		List<Actor> actors = dao.test05();

		// 4 acteurs
		Assert.assertEquals(4, actors.size());
		// Jack Nicholson : 1 movie dont le nom contient 'f'
		Assert.assertEquals(1, actors.get(0).getMovies().size());
		// Tom Hanks : 2 movies dont le nom contient 'f'
		Assert.assertEquals(2, actors.get(actors.size() - 1).getMovies().size());
	}

	/**
	 * Liste des acteurs
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>avec les films chargés (pas seulement les films contenant la lettre 'f')</li>
	 * <li>qui possède un film de nom contenant la lettre 'f' (case insensitive)</li>
	 * </ul>
	 */
	@Test
	public void test06() {
		List<Actor> actors = dao.test06();

		// 4 acteurs
		Assert.assertEquals(4, actors.size());
		// Jack Nicholson : 1 movie
		Assert.assertEquals(1, actors.get(0).getMovies().size());
		// Tom Hanks : 3 movies
		Assert.assertEquals(3, actors.get(actors.size() - 1).getMovies().size());
	}

	/**
	 * Liste des acteurs
	 * <ul>
	 * <li>qui ont joué avec Leonardo DiCaprio</li>
	 * <li>ordonnée par nom</li>
	 * </ul>
	 */
	@Test
	public void test07() {
		List<Actor> actors = dao.test07();

		// 5 acteurs
		Assert.assertEquals(5, actors.size());
		// Christopher Walken
		Assert.assertEquals("Christopher Walken", actors.get(0).getName());
		// Tom Hanks
		Assert.assertEquals("Tom Hanks", actors.get(actors.size() - 1).getName());
	}

	/**
	 * Liste des films
	 * <ul>
	 * <li>ordonnée par nom</li>
	 * <li>avec plus d'un acteur</li>
	 * </ul>
	 */
	@Test
	public void test08() {
		List<Movie> movies = dao.test08();

		// 5 acteurs
		Assert.assertEquals(5, movies.size());
		// Christopher Walken
		Assert.assertEquals("Arrete-moi si tu peux", movies.get(0).getName());
		// Tom Hanks
		Assert.assertEquals("Les infiltres", movies.get(movies.size() - 1).getName());
	}

	/**
	 * Une liste de {movieName, actorName}
	 * <ul>
	 * <li>ordonnée par nom de film, nom d'acteur</li>
	 * <li>en utilisant HQL et retournant un tableau</li>
	 * </ul>
	 */
	@Test
	public void test09() {
		List<Object[]> names = dao.test09();

		// 16 elements
		Assert.assertEquals(16, names.size());
		// First element
		Assert.assertEquals("Arrete-moi si tu peux", names.get(0)[0]);
		Assert.assertEquals("Christopher Walken", names.get(0)[1]);
		// Last element
		Assert.assertEquals("Les infiltres", names.get(names.size() - 1)[0]);
		Assert.assertEquals("Matt Damon", names.get(names.size() - 1)[1]);
	}

	/**
	 * Une liste de {movieName, actorName}
	 * <ul>
	 * <li>ordonnée par nom de film, nom d'acteur</li>
	 * <li>en utilisant un DTO</li>
	 * </ul>
	 */
	@Test
	public void test10() {
		List<MovieActorNames> names = dao.test10();

		// 16 elements
		Assert.assertEquals(16, names.size());
		// First element
		Assert.assertEquals("Arrete-moi si tu peux", names.get(0).getMovieName());
		Assert.assertEquals("Christopher Walken", names.get(0).getActorName());
		// Last element
		Assert.assertEquals("Les infiltres", names.get(names.size() - 1).getMovieName());
		Assert.assertEquals("Matt Damon", names.get(names.size() - 1).getActorName());
	}

}
