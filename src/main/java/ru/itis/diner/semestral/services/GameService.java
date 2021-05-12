package ru.itis.diner.semestral.services;

import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface GameService {
    void click(Long userId, Long count_click);

    Long getUserScoreById(Long id);

    Long getClickPowerById(Long id);
}
