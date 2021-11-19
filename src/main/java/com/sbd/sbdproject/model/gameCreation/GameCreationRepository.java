package com.sbd.sbdproject.model.gameCreation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameCreationRepository extends JpaRepository<GameCreation, Integer> {

}
