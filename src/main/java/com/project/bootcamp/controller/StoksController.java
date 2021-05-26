package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StoksController {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> save(@RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<StockDTO>> getAll() {
        List<StockDTO> list = new ArrayList<>();

        StockDTO stock = new StockDTO();
        stock.setId(1l);
        stock.setName("Magazine Luiza");
        stock.setPrice(10000d);
        stock.setVariation(180d);
        stock.setDate(LocalDate.now());

        list.add(stock);

        return ResponseEntity.ok(list);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
        List<StockDTO> list = new ArrayList<>();

        StockDTO stock = new StockDTO();
        stock.setId(1l);
        stock.setName("Magazine Luiza");
        stock.setPrice(10000d);
        stock.setVariation(180d);
        stock.setDate(LocalDate.now());

        list.add(stock);

        stock = new StockDTO();
        stock.setId(2l);
        stock.setName("Petróbras");
        stock.setPrice(10000d);
        stock.setVariation(180d);
        stock.setDate(LocalDate.now());

        list.add(stock);

        stock = new StockDTO();
        stock.setId(3l);
        stock.setName("CEMIG");
        stock.setPrice(10000d);
        stock.setVariation(180d);
        stock.setDate(LocalDate.now());

        list.add(stock);

        stock = list
                .stream()
                .filter(x -> x.getId().compareTo(id) == 0)
                .findFirst().get();

        return ResponseEntity.ok(stock);
    }
}
