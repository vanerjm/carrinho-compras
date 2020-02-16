package br.com.vaner.carrinhocompras.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Float value;

	public Item() {
		super();
	}

	public Item(String name, Float value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
}
