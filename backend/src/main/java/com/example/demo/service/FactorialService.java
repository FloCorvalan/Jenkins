package com.example.demo.service;

import com.example.demo.model.Factorial;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factorial")
@CrossOrigin(origins = "*")
public class FactorialService {
    private final Gson gson;

    FactorialService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @PostMapping({"","/"})
    ResponseEntity<String> calcularFactorial(@RequestBody String request){
        Factorial factorial = gson.fromJson(request,Factorial.class);
        int resultado = factorial.calcularFactorial(factorial.getOperando());
        factorial.setResultado(resultado);
        return new ResponseEntity<>(gson.toJson(factorial), HttpStatus.OK);

    }
}
