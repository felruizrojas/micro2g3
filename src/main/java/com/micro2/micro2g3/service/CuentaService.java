package com.micro2.micro2g3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro2.micro2g3.model.Cuenta;
import com.micro2.micro2g3.repository.CuentaRepository;

import jakarta.transaction.Transactional;

@Service

public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta findByIdCuenta(int idCuenta) {
        return cuentaRepository.findByIdCuenta(idCuenta);
    }

    @Transactional
    public void deleteByIdCuenta(Integer idCuenta) {
        cuentaRepository.deleteByIdCuenta(idCuenta);
    }
}
