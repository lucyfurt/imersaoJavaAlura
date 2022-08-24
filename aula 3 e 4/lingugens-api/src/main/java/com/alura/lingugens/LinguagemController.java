package com.alura.lingugens;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {
    @Autowired
    private LinguaguemRepository repository;

    @GetMapping("/linguagens")
    public List<Linguagens> obterLinguagens(){

        List<Linguagens> linguagens = repository.findAll();
        return linguagens;

    }

    @PostMapping("/linguagens")
    public Linguagens cadastrarLinguagem(@RequestBody  Linguagens linguagens){
        Linguagens linguagemSalva = repository.save(linguagens);
        return linguagemSalva;

    }
}
