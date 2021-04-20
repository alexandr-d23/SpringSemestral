package ru.itis.diner.semestral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.diner.semestral.dto.UserAchievementDto;
import ru.itis.diner.semestral.model.Achievement;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Query(nativeQuery = true,
            value = "SELECT a.id, a.type, a.required_value, a.description, " +
                    "ua.value FROM achievements as a LEFT JOIN user_actions" +
                    " as ua on a.type = ua.type AND ua.user_id = ?;")
    public List<UserAchievementDto> getAchievementsWithProgress();
    
}
