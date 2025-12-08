package com.uab.taller.michel.useCase.produc;

import com.uab.taller.michel.service.IProducService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class DeleteProducUseCase {
    @Autowired
    IProducService  producService;
    @Transactional
    public void execute(long id){
        Long Id;
        producService.deleteById(id);
    }
}
