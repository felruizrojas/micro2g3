package com.micro2.micro2g3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro2.micro2g3.model.Cuenta;

@Repository

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    List<Cuenta> findAll();

    @SuppressWarnings("unchecked")
    
    Cuenta save(Cuenta cuenta);

    Cuenta findByIdCuenta(int idCuenta);

    void deleteByIdCuenta(int idCuenta);
}
