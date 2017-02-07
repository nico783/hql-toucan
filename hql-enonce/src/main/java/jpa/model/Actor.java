package jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Actor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@GenericGenerator(strategy = "org.hibernate.id.enhanced.TableGenerator", name = "actorGen", parameters = {
			@Parameter(name = "table_name", value = "ID_GENERATOR"),
			@Parameter(name = "value_column_name", value = "GEN_VALUE"),
			@Parameter(name = "segment_column_name", value = "GEN_ID"),
			@Parameter(name = "segment_value", value = "ACTOR_ID"),
			@Parameter(name = "increment_size", value = "50"),
			@Parameter(name = "optimizer", value = "pooled") })
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "actorGen")
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
