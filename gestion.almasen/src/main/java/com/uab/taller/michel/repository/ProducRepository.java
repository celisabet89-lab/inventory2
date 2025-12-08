package com.uab.taller.michel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uab.taller.michel.dominian.Produc;

import java.util.List;

public interface ProducRepository extends JpaRepository<Produc, Long> {
    List<Produc> findByDeletedFalse();
}
