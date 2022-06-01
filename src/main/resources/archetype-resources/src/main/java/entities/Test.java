package ${package}.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "test")
public class Test extends PanacheEntityBase {

	@Id
	@NotNull(message = "Nombre may not be null")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "value")
	private Integer value;

	public String getName() {
		return this.name;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(Integer value) {
		this.value = value;
	}
	//getter and setter gen
	
}
