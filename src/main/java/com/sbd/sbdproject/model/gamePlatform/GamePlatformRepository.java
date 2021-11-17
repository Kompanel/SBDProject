package com.sbd.sbdproject.model.gamePlatform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePlatformRepository extends JpaRepository<GamePlatform, Integer> {
}
