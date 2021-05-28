package com.project.bootcamp.mapper;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setDate(dto.getDate());
        stock.setName(dto.getName());
        stock.setVariation(dto.getVariation());
        stock.setPrice(dto.getPrice());
        return stock;
    }

    public StockDTO toDto(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setDate(stock.getDate());
        return dto;
    }

    public List<StockDTO> toDto(List<Stock> list) {
        return list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
