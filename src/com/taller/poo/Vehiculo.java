package com.taller.poo;

public class Vehiculo {
    /*
     * Justificación de tipos: Se utilizaron tipos primitivos
     * para los atributos de rendimiento y estado del vehículo.
     * Son más eficientes en el consumo de memoria   y en velocidad de procesamiento
     *  ya que no requieren un proceso de "boxing/unboxing".
     * Además, aseguran que los valores numéricos comiencen en 0 en lugar de un valor nulo (null),
     * lo cual es ideal para este contexto físico.
     */
    private String marca;
    private String modelo;
    private double kilometraje;
    private int velocidadMaxima;
    private boolean estadoEncendido;

    public Vehiculo() {
        this.marca = "Genérico";
        this.modelo = "Sin modelo";
        this.kilometraje = 0.0;
        this.velocidadMaxima = 120;
        this.estadoEncendido = false;
    }
    public Vehiculo(String marca, String modelo, double kilometraje, int velocidadMaxima, boolean estadoEncendido){
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.velocidadMaxima = velocidadMaxima;
        this.estadoEncendido = estadoEncendido;
    }
     public String getMarca(){
        return this.marca;
     }
     public String getModelo(){
        return this.modelo;
     }
    public double getKilometraje(){
        return this.kilometraje;
    }

    public int getVelocidadMaxima() {
        return this.velocidadMaxima;
    }
    public boolean isEstadoEncendido(){
        return this.estadoEncendido;
    }


}


