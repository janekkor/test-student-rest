package de.onsite.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.onsite.quickstart.model.ItemList;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
	
}