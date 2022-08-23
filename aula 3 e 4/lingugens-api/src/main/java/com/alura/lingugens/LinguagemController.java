package com.alura.lingugens;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {

    private List<Linguagens> linguagens =
            List.of(
              new Linguagens("Java","https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1 ),
                    new Linguagens("PHP","https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2 )

                    );
    @GetMapping(value = "/linguagens")
    public List<Linguagens> obterLinguagens(){
        return linguagens;
    }
}
