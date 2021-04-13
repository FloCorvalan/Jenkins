package com.example.demo.model;

import com.google.gson.annotations.SerializedName;

public class Suma {
    @SerializedName("operando1")
    private int operando1;
    @SerializedName("operando2")
    private int operando2;
    @SerializedName("resultado")
    private int resultado;

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int sumarValores(int operando1, int operando2){
        this.resultado = this.operando1 + this.operando2;
        return resultado;
    }
}
