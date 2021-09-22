package com.tayna.shared.controller;

import java.util.List;
import java.util.Optional;

import com.tayna.shared.model.Shared;
import com.tayna.shared.service.SharedService;
import com.tayna.shared.shared.SharedDTO;

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

@RestController
@RequestMapping("/api/musicas")
public class SharedController {
    
    @Autowired
    SharedaService servicoShared;

    @GetMapping
    public ResponseEntity<List<SharedDTO>> obterTodos(){
        List<SharedDTO> shared = servicoShared.obterTodos();

        return new ResponseEntity<>(shared, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SharedDTO>> obterPorId(@PathVariable String id){
        Optional<SharedDTO> Shared = servicoShared.obterPorId(id);
        
        return new ResponseEntity<>(Shared, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SharedDTO> adicionar(@RequestBody SharedDTO sharedDto){
    sharedDto = servicoShared.adicionar(sharedDto);

        return new ResponseEntity<>(sharedDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shared> atualizar (@PathVariable String id, 
    @RequestBody SharedDTO sharedDto){

        return new ResponseEntity<>(servicoShared.atualizar(id, sharedDto), HttpStatus.OK);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        servicoShared.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
