package de.onsite.quickstart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student Bean class
 *
 */
@Entity
@Table(name="ITEM")
public class Item
{	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	public Item() {
		//empty for hibernate
	}
	
	public Item(Long id, String itemName) {
		this.id = id;
		this.itemName = itemName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + "]";
	}
}