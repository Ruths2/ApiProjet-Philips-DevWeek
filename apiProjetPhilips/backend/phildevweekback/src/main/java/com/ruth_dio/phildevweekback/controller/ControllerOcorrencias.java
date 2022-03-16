package com.ruth_dio.phildevweekback.controller;

import com.ruth_dio.phildevweekback.repository.OcorrenciaRepo;
import com.ruth_dio.phildevweekback.entity.IncidenciaExame;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerOcorrencias {
    private final OcorrenciaRepo ocRepository;

    public ControllerOcorrencias(OcorrenciaRepo ocRepository) {
        this.ocRepository = ocRepository;
    }

    @GetMapping("/ocorrencias")
    public ResponseEntity<List<IncidenciaExame>> findOcorrencias(){
        List<IncidenciaExame> listaOcorrencia = ocRepository.findAll();
        if (listaOcorrencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
    }

    @GetMapping("/ocorrencia/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> ocorrenciaOptional = ocRepository.findById(id);
        if (ocorrenciaOptional.isPresent()){
            IncidenciaExame ocorrenciaUnid = ocorrenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
