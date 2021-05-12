package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsPage {
    private int pagesCount;
    private List<ProductDto> papers;
}
