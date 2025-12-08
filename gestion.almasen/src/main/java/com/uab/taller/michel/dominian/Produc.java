package com.uab.taller.michel.dominian;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Produc {
    @Id
    long Id_pruducto;
    String articulo;
    String descripcion;
    Number unidad;
    String foto;
    Number precio;
    String categoria;

    public static boolean isDeleted() {
        return false;
    }

    public void setChangeDate(LocalDateTime now) {

    }
}
