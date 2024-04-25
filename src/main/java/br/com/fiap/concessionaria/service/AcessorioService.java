package br.com.fiap.concessionaria.service;

import br.com.fiap.concessionaria.dto.request.AcessorioRequest;
import br.com.fiap.concessionaria.dto.response.AcessorioResponse;
import br.com.fiap.concessionaria.entity.Acessorio;
import br.com.fiap.concessionaria.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class AcessorioService implements ServiceDTO<Acessorio, AcessorioRequest, AcessorioResponse>{


    @Autowired
    private AcessorioRepository repo;

    @Override
    public Collection<Acessorio> findAll(Example<Acessorio> example) {
        return repo.findAll(example);
    }

    @Override
    public Acessorio findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Acessorio save(Acessorio e) {
        return repo.save( e );
    }

    @Override
    public Acessorio toEntity(AcessorioRequest dto) {
        if (Objects.isNull( dto )) return null;

        return Acessorio.builder()
                .nome(dto.nome())
                .preco(dto.preco())
                .build();
    }
    @Override
    public AcessorioResponse toResponse(Acessorio e) {
        if (Objects.isNull( e )) return null;

        return AcessorioResponse.builder()
                .nome(e.getNome())
                .preco(e.getPreco())
                .build();
    }
}
