package net.mothupi.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mothupi.springbootbackend.model.ChessKid;

public interface ChessKidRepository extends JpaRepository<ChessKid, Long>{

}