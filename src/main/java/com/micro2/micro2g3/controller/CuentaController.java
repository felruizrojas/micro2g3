package com.micro2.micro2g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro2.micro2g3.model.Cuenta;
import com.micro2.micro2g3.service.CuentaService;

@RestController
@RequestMapping("/api/cuentas")

public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getCuentas() {
        List<Cuenta> cuentas = cuentaService.findAll();
        if (!cuentas.isEmpty()) {
            return new ResponseEntity<>(cuentas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Cuenta> postUsuario(@RequestBody Cuenta cuenta) {
        Cuenta buscado = cuentaService.findByIdCuenta(cuenta.getIdCuenta());
        if (buscado == null) {
            return new ResponseEntity<>(cuentaService.save(cuenta), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/id/{idCuenta}")
    public ResponseEntity<Cuenta> getCuentaByIdCuenta(@PathVariable int idCuenta) {
        Cuenta cuenta = cuentaService.findByIdCuenta(idCuenta);
        if (cuenta != null) {
            return new ResponseEntity<>(cuenta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/id/{idCuenta}")
    public ResponseEntity<Cuenta> updateCuentaByIdCuenta(@PathVariable int idCuenta, @RequestBody Cuenta cuenta) {
        Cuenta existente = cuentaService.findByIdCuenta(idCuenta);
        if (existente != null) {
            existente.setUsername(cuenta.getUsername());
            existente.setPassword(cuenta.getPassword());
            return new ResponseEntity<>(cuentaService.save(existente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{idCuenta}")
    public ResponseEntity<Void> deleteCuentaByIdCuenta(@PathVariable int idCuenta) {
        Cuenta existente = cuentaService.findByIdCuenta(idCuenta);
        if (existente != null) {
            cuentaService.deleteByIdCuenta(idCuenta);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
