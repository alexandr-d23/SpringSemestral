package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diner.semestral.model.BoostTypes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
public class ProductRest {
    private Long id;
    private Long cost;
    private BoostTypes type;
    private Long value;
    private String description;
}
