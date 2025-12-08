package com.uab.taller.michel.service;

import com.uab.taller.michel.dominian.Produc;

import java.util.List;
import java.util.Optional;

public interface IProducService {
    List<Produc> getAll();
    Optional<Produc> getById(Long Id_pruducto);
    Produc save (Produc produc);
    Produc update(Long Id, Produc produc);
    void deleteById (Long Id);
}

