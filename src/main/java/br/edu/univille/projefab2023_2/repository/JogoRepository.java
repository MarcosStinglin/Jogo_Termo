package br.edu.univille.projefab2023_2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import br.edu.univille.projefab2023_2.entity.Jogo;

@Repository
public interface JogoRepository
    extends JpaRepository<Jogo,Long> {
        Page<Jogo> findAll(Pageable pageable);
        
    }

