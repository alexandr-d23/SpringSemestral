package ru.itis.diner.semestral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import ru.itis.diner.semestral.model.User;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM Account ORDER BY score DESC LIMIT 10")
    List<User> getTopUsers();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Account SET score = score + :value where id = :id")
    void addScoreByUserId(Long id, Long value);

    @Query(nativeQuery = true, value = "SElECT score FROM Account WHERE id = :id")
    Long getUserScoreById(Long id);

}
