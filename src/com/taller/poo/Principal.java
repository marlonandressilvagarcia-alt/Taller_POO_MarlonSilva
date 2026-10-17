package com.taller.poo;

public class Principal {
    public static void main(String[] args){

        Vehiculo chickHicks = new Vehiculo();
        Vehiculo elRey = new Vehiculo("Playmouth", "Superbird", 9000.0, 120, true);
        Vehiculo rayoMcquen = new Vehiculo("Pixar", "Combinado", 9000.0, 120, true);

        Estudiante e1 = new Estudiante("00001", "MarlonSilva", 4.5,true);
        Estudiante e2 = new Estudiante("00002", "LionelMessi", 4.0, true);
        Estudiante e3 = new Estudiante("00003", "CristianoRonaldo", 4.0, true);

        CuentaBancaria cB1 = new CuentaBancaria();
        CuentaBancaria cB2 = new CuentaBancaria("00003", "CristianoRonaldo");
        CuentaBancaria cB3 = new CuentaBancaria("00001", "MarlonSilva", 10.0, 100.0);

        //Operaciones de modificacion de estado
        //cuentas bancarias (depositar)
        boolean depositocB1 = cB1.depositar(100.0);
        boolean depositocB2 = cB2.depositar(80.0);
        boolean depositocB3 = cB3.depositar(95.0);

        //cuentas bancarias (retirar)
        boolean retirocB1 = cB1.retirar(50.0);
        boolean retirocB2 = cB2.retirar(30.5);
        boolean retirocB3 = cB3.retirar(40.0);

        //metodo estatico (conversor de moneda)
        double euros = ConversorMoneda.convertirDolaresAEuros(100.0, 0.92);
        String formateo = ConversorMoneda.formatearMoneda(20.4);

        //Reportes
        //vehiculos
        System.out.printf(" === REPORTE DE VEHICULOS === \n");
        System.out.printf("[1] Marca: %s | Modelo: %s | KM: %.2f | VelMax; %d | Encendido: %b \n",
                chickHicks.getMarca(), chickHicks.getModelo(), chickHicks.getKilometraje(), chickHicks.getVelocidadMaxima(),
                chickHicks.isEstadoEncendido());
        System.out.printf("[2] Marca: %s | Modelo: %s | KM: %.2f | VelMax; %d | Encendido: %b \n",
                elRey.getMarca(), elRey.getModelo(), elRey.getKilometraje(), elRey.getVelocidadMaxima(),
                elRey.isEstadoEncendido());
        System.out.printf("[3] Marca: %s | Modelo: %s | KM: %.2f | VelMax; %d | Encendido: %b \n",
                rayoMcquen.getMarca(), rayoMcquen.getModelo(), rayoMcquen.getKilometraje(), rayoMcquen.getVelocidadMaxima(),
                rayoMcquen.isEstadoEncendido());

        //Cuentas bancarias
        System.out.printf(" === REPORTE DE CUENTAS BANCARIAS === \n");
        System.out.printf("Cuenta: %s | Titular: %s | Saldo Final %.2f | Credito: %.2f \n",
                cB1.getNumeroCuenta(), cB1.getTitular(), cB1.getSaldo(), cB1.getLimiteCredito());
        System.out.printf("Cuenta: %s | Titular: %s | Saldo Final %.2f | Credito: %.2f \n",
                cB2.getNumeroCuenta(), cB2.getTitular(), cB2.getSaldo(), cB2.getLimiteCredito());
        System.out.printf("Cuenta: %s | Titular: %s | Saldo Final %.2f | Credito: %.2f \n",
                cB3.getNumeroCuenta(), cB3.getTitular(), cB3.getSaldo(), cB3.getLimiteCredito());

        //Estudiantes
        System.out.printf(" === REPORTE DE ESTUDIANTES === \n");
        System.out.printf("Nombre Completo: %s | Identificacion: %s | Promedio %.2f | Matriculado: %b \n",
                e1.getNombreCompleto(), e1.getIdentificacion(), e1.getPromedioCalificaciones(), e1.isEstaMatriculado());
        System.out.printf("Nombre Completo: %s | Identificacion: %s | Promedio %.2f | Matriculado: %b \n",
                e2.getNombreCompleto(), e2.getIdentificacion(), e2.getPromedioCalificaciones(), e2.isEstaMatriculado());
        System.out.printf("Nombre Completo: %s | Identificacion: %s | Promedio %.2f | Matriculado: %b \n",
                e3.getNombreCompleto(), e3.getIdentificacion(), e3.getPromedioCalificaciones(), e3.isEstaMatriculado());
    }
}
