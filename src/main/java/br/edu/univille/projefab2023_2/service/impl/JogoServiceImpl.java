package br.edu.univille.projefab2023_2.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.univille.projefab2023_2.entity.Jogo;
import br.edu.univille.projefab2023_2.repository.JogoRepository;
import br.edu.univille.projefab2023_2.service.JogoService;

@Service
public class JogoServiceImpl  implements JogoService {

    @Autowired
    private JogoRepository repository;
    @Override
    public Jogo getOneRandom() {
        var listaPalavras = repository.findAll();

        if(listaPalavras.size() == 0){
            popularBanco();

            listaPalavras = repository.findAll();
        }

        Random random = new Random();
        int indiceAleatorio = random.nextInt(listaPalavras.size());

        return listaPalavras.get(indiceAleatorio);
    }
    @Override
    public void save(Jogo jogo) {
        repository.save(jogo);
    }
    @Override
    public void delete(Jogo jogo) {
        repository.delete(jogo);
    }
    
    @Override
    public Page<Jogo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    private void popularBanco(){
        

        var palavras = getPalavras();

        for (String palavra : palavras) {
            var jogo = new Jogo();
            
            jogo.setPalavra(palavra.toUpperCase());

            repository.save(jogo);
        }
    }

    private String[] getPalavras(){
        String[] palavras = {
            "mexer", "fazer", "vigor", "sanar", "poder", "haver", "expor", "pesar", "saber", "dizer",
            "coser", "dever", "temor", "ceder", "estar", "cozer", "pudor", "criar", "impor", "pedir",
            "falar", "devir", "valor", "fluir", "visar", "puder", "lugar", "temer", "abrir", "obter",
            "gerar", "tomar", "olhar", "levar", "favor", "reter", "tecer", "ouvir", "viver", "achar",
            "fator", "selar", "rogar", "rever", "citar", "adiar", "humor", "deter", "atuar", "labor",
            "líder", "ficar", "remir", "coçar", "velar", "caçar", "anuir", "botar", "rigor", "ímpar",
            "lazer", "maior", "pegar", "morar", "furor", "vetor", "setor", "comer", "ardor", "rezar",
            "reger", "mudar", "andar", "fugir", "parar", "fruir", "fitar", "puxar", "gerir", "tirar",
            "arcar", "fixar", "sumir", "ligar", "tocar", "lidar", "bater", "alçar", "autor", "caber",
            "supor", "zelar", "advir", "super", "pisar", "pilar", "rumor", "optar", "medir", "ecoar",
            "vetar",""};

            return palavras;
    }
}