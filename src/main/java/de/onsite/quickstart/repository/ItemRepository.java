package de.onsite.quickstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.onsite.quickstart.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	public List<Item> findAllByItemListId(Long id);
}