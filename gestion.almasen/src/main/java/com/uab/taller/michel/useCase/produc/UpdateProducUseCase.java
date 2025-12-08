package com.uab.taller.michel.useCase.produc;

import com.uab.taller.michel.service.IProducService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uab.taller.michel.dominian.Produc;
import com.uab.taller.michel.dominian.dtorecust.ProducRequest;

import java.util.Optional;

@Service
public class UpdateProducUseCase {
    @Autowired
    IProducService poducService;
    public Produc execute(Long id, ProducRequest request) {
        Optional<Produc> producUpdate = poducService.getById(id);
        return poducService.save(producUpdate.orElse(null));
    }
}
