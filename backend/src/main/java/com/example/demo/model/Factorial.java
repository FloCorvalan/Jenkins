package com.example.demo.model;

import com.google.gson.annotations.SerializedName;

public class Factorial {
    @SerializedName("operando")
    private int operando;
    @SerializedName("resultado")
    private int resultado;

    public int getOperando() {
        return operando;
    }

    public void setOperando(int operando) {
        this.operando = operando;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int calcularFactorial(int op){
        int i = 1;
        if(op == 0){
            return 1;
        }
        while( op > 1){
            i = op * i;
            op--;
        }
        return i;
    }
}
