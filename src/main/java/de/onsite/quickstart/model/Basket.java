package de.onsite.quickstart.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ItemList class
 *
 */
@Entity
@Table(name="BASKET")
public class Basket
{	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="BASKET_NAME")
	private String basketName;
	
	@OneToMany(mappedBy="basket")
	private List<Item> items;
	
	public Basket() {
		//empty for hibernate
	}
	
	public Basket(Long id, String basketName) {
		this.id = id;
		this.basketName = basketName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBasketName() {
		return basketName;
	}

	public void setBasketName(String basketName) {
		this.basketName = basketName;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		items.stream().forEach(i -> sBuilder.append(i.toString()));
		return "ItemList [id=" + id + ", basketName=" + basketName + "items=" + sBuilder.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((basketName == null) ? 0 : basketName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (basketName == null) {
			if (other.basketName != null)
				return false;
		} else if (!basketName.equals(other.basketName))
			return false;
		return true;
	}
	
	
}