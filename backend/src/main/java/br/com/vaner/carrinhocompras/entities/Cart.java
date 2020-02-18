package br.com.vaner.carrinhocompras.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany
	@JoinColumn(name = "item_list")
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

	public long getId() {
		return id;
	}

	public float getTotal() {
		return total;
	}	
}
