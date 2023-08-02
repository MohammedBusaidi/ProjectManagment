package com.projectManagment.projectManagment.Repository;

import com.projectManagment.projectManagment.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
