package com.taller.poo;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private Double limiteCredito;

        /*
    * PREGUNTAS DE ANÁLISIS:
    * 1. ¿Qué diferencia ocurre a nivel de memoria y asignación por defecto al
    declarar 'saldo' como double primitivo frente a 'limiteCredito' como Wrapper
    Double?
    * R= el Wrapper 'limiteCredito' ocuppa mas espacio en la memoria y la asignacion por defecto
    * sera null mientras que en el dato primitivo 'saldo' ocupa menos espacio y su asignacion
    * por defecto sera 0.0
    * 2. ¿Por qué una operación aritmética sobre un atributo no inicializado de
    tipo Double provoca una NullPointerException, mientras que sobre un double
    primitivo opera con 0.0?
    * R= porque si a un wrapper no le asignamos o no le declaramos un valor por inicial, java le
    * asignara null por defecto y no podremos hacer calculos con valores nulos en cambio con double
    * (tipo primitivo) es diferente ya que java le asignará cero (en este caso 0.0 por ser decimal)
    */

    public boolean depositar(double monto){
        if (monto > 0){
            saldo += monto;
            return true;
        }else {
            return false;
        }
    }
    public boolean retirar(double monto) {
        double creditoDisponible = (limiteCredito != null) ? limiteCredito : 0.0;
        double saldoTotalDispo = saldo + creditoDisponible;

        if (monto > 0 && monto <= saldoTotalDispo) {
            saldo -= monto;
            return true;
        } else {
            return false;
        }
    }

    public CuentaBancaria(){
        this.numeroCuenta = "000000";
        this.titular = "Sin nombre";
        this.saldo = 0.0;
        this.limiteCredito = 0.0;
    }
    public CuentaBancaria(String numeroCuenta, String titular){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
        this.limiteCredito = 100.0;
    }
    public CuentaBancaria(String numeroCuenta, String titular, double saldo, Double limiteCredito){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Double getLimiteCredito() {
        return this.limiteCredito;
    }
}
