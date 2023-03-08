package com.ObrasApp.ObraApp.service;

import com.ObrasApp.ObraApp.model.Imovel;
import com.ObrasApp.ObraApp.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public Imovel criar(Imovel imovel) {
        if (imovel.getId() != null) {
            throw new IllegalArgumentException();
        }
        imovel.setId(UUID.randomUUID().toString());
        return imovelRepository.save(imovel);
    }

    public Imovel obter(String id) {
        return imovelRepository.findById(id).orElse(null);
    }
     
    public List<Imovel> obterTodos() {
        List<Imovel> lista = new ArrayList<>();
        imovelRepository.findAll().forEach(imovel -> lista.add(imovel));
        return lista;
    }

    public Imovel atualizar(Imovel imovel) {
        
        return imovelRepository.save(imovel);
    }

    public Imovel delete(String id) {
        Imovel imovel = imovelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        imovelRepository.delete(imovel);
        return imovel;
    }

}
