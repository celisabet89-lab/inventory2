package com.uab.taller.michel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uab.taller.michel.dominian.Produc;
import com.uab.taller.michel.dominian.dtorecust.ProducRequest;
import com.uab.taller.michel.useCase.produc.CreateProducUseCase;
import com.uab.taller.michel.useCase.produc.DeleteProducUseCase;
import com.uab.taller.michel.useCase.produc.GetAllProducUseCase;
import com.uab.taller.michel.useCase.produc.GetProducUseCase;
import com.uab.taller.michel.useCase.produc.UpdateProducUseCase;

@RestController
@RequestMapping("/produc")
public class ProducController {
    @Autowired
    CreateProducUseCase createProducUseCase;
    @Autowired
    DeleteProducUseCase deleteProducUseCase;
    @Autowired
    GetAllProducUseCase getAllProducUseCase;
    @Autowired
    GetProducUseCase getProducUseCase;
    @Autowired
    UpdateProducUseCase updateProducUseCase;

    public List<Produc> getAll(){
        return getAllProducUseCase.execute();
    }
    @GetMapping("/{id}")
    public Optional<Produc> getById(@PathVariable Long id) {
        return getProducUseCase.execute(id);
    }
    @DeleteMapping("/{producID")
    public void deleteById(@PathVariable Long userId) {deleteProducUseCase.execute(userId);}
    @PostMapping
    public Produc save(@RequestBody ProducRequest request) {
        return createProducUseCase.execute(request);
    }
    @PutMapping("/{id}")
    public Produc update(@PathVariable Long id, @RequestBody ProducRequest request) {
        return updateProducUseCase.execute(id, request);
    }
}
