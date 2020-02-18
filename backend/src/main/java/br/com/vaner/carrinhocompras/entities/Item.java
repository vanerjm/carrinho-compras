package br.com.vaner.carrinhocompras.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
public class Item {

	@Id String id;
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

	public String getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
}
