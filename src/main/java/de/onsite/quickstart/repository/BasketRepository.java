package de.onsite.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.onsite.quickstart.model.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
	
}