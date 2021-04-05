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
@Table(name="ITEM_LIST")
public class ItemList
{	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="LIST_NAME")
	private String listName;
	
	@OneToMany(mappedBy="itemList")
	private List<Item> items;
	
	public ItemList() {
		//empty for hibernate
	}
	
	public ItemList(Long id, String listName) {
		this.id = id;
		this.listName = listName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		items.stream().forEach(i -> sBuilder.append(i.toString()));
		return "ItemList [id=" + id + ", listName=" + listName + "items=" + sBuilder.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((listName == null) ? 0 : listName.hashCode());
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
		ItemList other = (ItemList) obj;
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
		if (listName == null) {
			if (other.listName != null)
				return false;
		} else if (!listName.equals(other.listName))
			return false;
		return true;
	}
	
	
}