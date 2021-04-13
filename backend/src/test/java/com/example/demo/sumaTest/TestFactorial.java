package com.example.demo.sumaTest;

import com.example.demo.model.Factorial;
import com.example.demo.model.Suma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class TestFactorial extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    private final Gson gson;

    TestFactorial(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Test
    public void calcularFactorialUno() throws Exception {
        String uri = "/factorial";
        Factorial factorial = new Factorial();
        factorial.setOperando(4);

        String inputJson = gson.toJson(factorial);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String factRes = mvcResult.getResponse().getContentAsString();
        Suma factFinal = gson.fromJson(factRes, Suma.class);

        assertEquals(24, factFinal.getResultado());
    }

    @Test
    public void calcularFactorialDos() throws Exception {
        String uri = "/factorial";
        Factorial factorial = new Factorial();
        factorial.setOperando(3);

        String inputJson = gson.toJson(factorial);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String factRes = mvcResult.getResponse().getContentAsString();
        Suma factFinal = gson.fromJson(factRes, Suma.class);

        assertEquals(6, factFinal.getResultado());
    }

    @Test
    public void calcularFactorialTres() throws Exception {
        String uri = "/factorial";
        Factorial factorial = new Factorial();
        factorial.setOperando(7);

        String inputJson = gson.toJson(factorial);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String factRes = mvcResult.getResponse().getContentAsString();
        Suma factFinal = gson.fromJson(factRes, Suma.class);

        assertEquals(5040, factFinal.getResultado());
    }

    @Test
    public void calcularFactorialCuatro() throws Exception {
        String uri = "/factorial";
        Factorial factorial = new Factorial();
        factorial.setOperando(0);

        String inputJson = gson.toJson(factorial);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String factRes = mvcResult.getResponse().getContentAsString();
        Suma factFinal = gson.fromJson(factRes, Suma.class);

        assertEquals(1, factFinal.getResultado());
    }
}
