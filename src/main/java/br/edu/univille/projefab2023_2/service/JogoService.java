package br.edu.univille.projefab2023_2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.univille.projefab2023_2.entity.Jogo;

public interface JogoService {
    Jogo getOneRandom();

    void save(Jogo cliente);

    void delete(Jogo cliente);

    Page<Jogo> findAll(Pageable pageable);
}
