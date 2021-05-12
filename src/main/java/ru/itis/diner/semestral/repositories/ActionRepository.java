package ru.itis.diner.semestral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.diner.semestral.model.Action;

import java.util.Optional;

public interface ActionRepository extends JpaRepository<Action, Long> {



}
