package com.projectManagment.projectManagment.Repository;

import com.projectManagment.projectManagment.Models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
