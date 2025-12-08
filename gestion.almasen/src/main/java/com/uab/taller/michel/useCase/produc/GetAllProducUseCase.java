package com.uab.taller.michel.useCase.produc;

import java.util.List;

import com.uab.taller.michel.service.IProducService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uab.taller.michel.dominian.Produc;

@Service
public class GetAllProducUseCase {
    @Autowired
    IProducService producService;
    public List<Produc> execute(){
        return producService.getAll();
    }

}
