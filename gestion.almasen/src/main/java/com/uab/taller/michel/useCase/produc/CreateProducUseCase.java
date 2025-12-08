package com.uab.taller.michel.useCase.produc;

import com.uab.taller.michel.dominian.Produc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uab.taller.michel.service.IProducService;
import com.uab.taller.michel.dominian.dtorecust.ProducRequest;

@Service
public class CreateProducUseCase {

    IProducService producService;


    public Produc execute(ProducRequest request) {
        Produc produc = new Produc();
        produc.setArticulo(request.getArticulo());
        produc.setDescripcion(request.getDescripcion());
        produc.setFoto(request.getFoto());
        produc.setPrecio(request.getPrecio());
        produc.setCategoria(request.getCategoria());
        produc.setUnidad(request.getUnidad());

        return producService.save(produc);
    }
}
