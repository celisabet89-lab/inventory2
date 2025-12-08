package com.uab.taller.michel.dominian.dtorecust;
import com.uab.taller.michel.dominian.Produc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducRequest {
    String articulo;
    String descripcion;
    Number unidad;
    String foto;
    Number precio;
    String categoria;
}
