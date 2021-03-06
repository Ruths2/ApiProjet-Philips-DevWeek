package com.ruth_dio.phildevweekback.controller;

import com.ruth_dio.phildevweekback.entity.FaixaEtaria;
import com.ruth_dio.phildevweekback.repository.FaixaEtariaRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepo fRepository;

    public ControllerFaixaEtaria(FaixaEtariaRepo fRepository) {
        this.fRepository = fRepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
           List<FaixaEtaria> lista = fRepository.findAll();
           return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> unidOptional = fRepository.findById(id);
            if (unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/add")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return fRepository.save(newFaixa);
    }

    @DeleteMapping("/faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        fRepository.deleteById(id);
    }
}
