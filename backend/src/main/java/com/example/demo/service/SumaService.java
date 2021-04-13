package com.example.demo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.demo.model.Suma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suma")
@CrossOrigin(origins = "*")
public class SumaService {

    private final Gson gson;

    SumaService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @PostMapping({"","/"})
    ResponseEntity<String> sumarOperandos(@RequestBody String request){
        Suma suma = gson.fromJson(request,Suma.class);
        int resultado = suma.sumarValores(suma.getOperando1(), suma.getOperando2());
        suma.setResultado(resultado);
        System.out.println("prueba1");
        return new ResponseEntity<>(gson.toJson(suma), HttpStatus.OK);

    }

}
