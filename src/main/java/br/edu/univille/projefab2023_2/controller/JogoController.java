package br.edu.univille.projefab2023_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projefab2023_2.service.JogoService;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService service;
    
    @GetMapping
    public ModelAndView index (){

        var jogo = service.getOneRandom();

        return new ModelAndView("jogos/index","jogo", jogo);
    }
}