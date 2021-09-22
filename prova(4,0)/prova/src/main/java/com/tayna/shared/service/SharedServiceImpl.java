package com.tayna.shared.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tayna.shared.model.Shared;
import com.tayna.shared.repository.SharedRepository;
import com.tayna.shared.shared.SharedDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SharedServiceImpl implements SharedService {
    
    @Autowired
    SharedRepository repositorioShared;

    @Override
    public List<SharedDTO> obterTodos() {
        List<Shared> Shareds = repositorioShared.findAll();
        ModelMapper mapper = new ModelMapper();

        return Shareds.stream()
        .map(shared -> mapper.map(shared, SharedDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<SharedDTO> obterPorId(String idShared) {
        Optional<Shared> optionalShared = repositorioShared.findById(idShared);
        if(optionalShared.isEmpty()){
            throw new InputMismatchException("Música não encontrada." + idShared);
        }
        SharedDTO SharedDto = new ModelMapper().map(optionalShared.get(), SharedDTO.class);

        return Optional.of(SharedDto);
    }

    @Override
    public SharedDTO adicionar(SharedDTO sharedDto) {
        ModelMapper mapper = new ModelMapper();
        Shared shared = mapper.map(sharedDto, Shared.class);
        shared.setId(null);
        shared = repositorioShared.save(shared);

        return mapper.map(shared, SharedDTO.class);
    }

    @Override
    public Shared atualizar(String idShared, SharedDTO sharedDto){
        if(repositorioShared.findById(idShared).isPresent()){
            Shared sharedAtt = repositorioShared.findById(idShared).get(); 

            sharedAtt.setTitulo(sharedDto.getTitulo());
            sharedAtt.setArtista(sharedDto.getArtista());
            sharedAtt.setAlbum(sharedDto.getAlbum());
            sharedAtt.setGenero(sharedDto.getGenero());
            sharedAtt.setAnoDoLancamento(sharedDto.getAnoDoLancamento());
            sharedAtt.setCompositor(sharedDto.getCompositor());

            return repositorioShared.save(sharedAtt);
        }else{
            throw new InputMismatchException("Impossível de Atualizar");
        }
    }

    @Override
    public void delete(String idShared) {
        repositorioShared.deleteById(idShared);
        
    }
}