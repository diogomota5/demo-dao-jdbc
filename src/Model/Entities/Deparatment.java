package Model.Entities;

import java.io.Serializable;
import java.util.Objects;

public class Deparatment implements Serializable { // Serializable para os objetos serem transformados em sequencias de bytes, objeto ser gravado em arquivo, trafegado em rede
													
	private static final long serialVersionUID = 1L;

	private Integer Id;
	private String name;

	public Deparatment() {
	}

	public Deparatment(Integer id, String name) {
		Id = id;
		this.name = name;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deparatment other = (Deparatment) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Deparatment [Id=" + Id + ", name=" + name + "]";
	}

}
