package com.uab.taller.michel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uab.taller.michel.dominian.Produc;
import com.uab.taller.michel.repository.ProducRepository;

@Service
public abstract class ProducServiceImp implements IProducService{
    private final ProducRepository producRepository;
    @Autowired
    public ProducServiceImp (ProducRepository producRepository){
        this.producRepository=producRepository;
    }
    @Override
    public List<Produc> getAll(){
        return producRepository.findByDeletedFalse();
    }
    @Override 
    public Optional<Produc> getById(Long Id_produc) {
        return producRepository.findById(Id_produc)
        .filter(produc -> !Produc.isDeleted());
    }

    @Override
    public Produc save(Produc produc) {
        produc.setChangeDate(LocalDateTime.now());
        return producRepository.save(produc);
    }
    @Override
    public Produc update(Long Id, Produc produc) {
        return producRepository.findById(Id)
        .map(existingProduc -> {
                existingProduc.setArticulo(produc.getArticulo());
                existingProduc.setDescripcion(produc.getDescripcion());
                existingProduc.setFoto(produc.getFoto());
                existingProduc.setPrecio(produc.getPrecio());
                existingProduc.setCategoria(produc.getCategoria());
                existingProduc.setUnidad(produc.getUnidad());
                return producRepository.save(existingProduc);
            })
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        }

        @Override
        public void deleteById(Long id) {
            producRepository.findById(id).ifPresent(produc -> {
                producRepository.save(produc);
            });
        }
    }