package ru.itis.diner.semestral.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Answer {
    private boolean isSuccessful;
    private String description;
}
