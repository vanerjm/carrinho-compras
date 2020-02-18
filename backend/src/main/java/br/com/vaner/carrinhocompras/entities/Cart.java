package br.com.vaner.carrinhocompras.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class Cart {

	@Id String id;

	@DBRef
	private User user;
	
	@DBRef
	private List<Item> items;
	
	private float total;

	public Cart() {
		super();
	}
	
	public Cart(User user, List<Item> items) {
		super();
		this.user = user;
		this.items = items;
		this.total = 0;
		
		if(this.items != null) {
			for (Item item : items) {
				total += item.getValue();
			}
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		if(this.items != null) {
			for (Item item : items) {
				total += item.getValue();
			}
		}
	}

	public String getId() {
		return id;
	}

	public float getTotal() {
		return total;
	}	
}
