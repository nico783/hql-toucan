package jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies = new ArrayList<Movie>();

	@Column(nullable = false, length = 50)
	private String name;

	@Version
	private int version;

	public Actor() {
	}

	public Actor(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return this.version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", version=" + version + "]";
	}

}
