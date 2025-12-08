package com.uab.taller.michel.useCase.produc;

import java.util.Optional;

import com.uab.taller.michel.service.IProducService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uab.taller.michel.dominian.Produc;

@Service
public class GetProducUseCase {
    @Autowired
    IProducService poducService;
    public Optional<Produc> execute(Long id){
        return poducService.getById(id);
    }
}
