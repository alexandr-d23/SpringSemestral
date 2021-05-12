package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.diner.semestral.model.BoostTypes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long cost;
    private String type;
    private Long value;
    private String description;
}
