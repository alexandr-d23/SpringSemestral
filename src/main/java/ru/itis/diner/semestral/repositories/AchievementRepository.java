package ru.itis.diner.semestral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.diner.semestral.dto.UserAchievementDto;
import ru.itis.diner.semestral.model.Achievement;
import ru.itis.diner.semestral.model.User;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

}
