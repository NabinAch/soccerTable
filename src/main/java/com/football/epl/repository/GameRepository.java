package com.football.epl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.football.epl.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer>{

}
