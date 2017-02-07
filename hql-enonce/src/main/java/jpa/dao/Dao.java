package jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return new ArrayList<Actor>();
	}

	public List<Actor> test02() {
		return new ArrayList<Actor>();
	}

	public List<Actor> test03() {
		return new ArrayList<Actor>();
	}

	public Actor test04() {
		return new Actor();
	}

	public List<Actor> test05() {
		return new ArrayList<Actor>();
	}

	public List<Actor> test06() {
		return new ArrayList<Actor>();
	}

	public List<Actor> test07() {
		return new ArrayList<Actor>();
	}

	public List<Movie> test08() {
		return new ArrayList<Movie>();
	}

	public List<Object[]> test09() {
		return new ArrayList<Object[]>();
	}

	public List<MovieActorNames> test10() {
		return new ArrayList<MovieActorNames>();
	}

}
