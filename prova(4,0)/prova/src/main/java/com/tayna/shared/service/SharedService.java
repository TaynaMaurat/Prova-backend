package com.tayna.shared.service;

import java.util.List;
import java.util.Optional;

import com.tayna.shared.model.Shared;
import com.tayna.shared.shared.SharedDTO;

import org.springframework.stereotype.Service;

@Service
public interface SharedService {
    
    List<SharedDTO> obterTodos();

    Optional<SharedDTO> obterPorId(String idShared);

    SharedDTO adicionar(SharedDTO sharedDto);

    Shared atualizar(String idShared, SharedDTO sharedDto);

    void delete(String idShared);
}
