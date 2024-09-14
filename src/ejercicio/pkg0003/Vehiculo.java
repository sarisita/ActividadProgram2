/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.pkg0003;

import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author SARIC
 */
public class Vehiculo {

    String numeroPlaca;
    int tipoVehiculo;
    LocalDateTime fechaHoraIngreso;
    LocalDateTime fechaHoraSalida;

    public Vehiculo(String numeroPlaca, int tipoVehiculo, LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {
        this.numeroPlaca = numeroPlaca;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.fechaHoraSalida = fechaHoraSalida;

    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public int getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(int tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void getMostrarVehiculo() {
       String tV="";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String hrIng = fechaHoraIngreso.format(formatter);
        
        String hrSld = fechaHoraSalida.format(formatter);
         switch (tipoVehiculo) {
            case 0:
                tV = "Automovil";
                break;
            case 1:
                tV = "Motocicleta";
                break;
            case 2:
                tV = "Camioneta";
                break;
            default:
                break;
        }
       

        String info = "Los datos del vehiculo son: \n";
        info += "Numero de placa: " + numeroPlaca + "\n";
        info += "Tipo de vehiculo: " + tV + "\n";
        info += "Fecha y hora de ingreso: " + hrIng + "\n";
        info += "Fecha y hora de salida : " + hrSld + "\n";
        JOptionPane.showMessageDialog(null, info);
    }

    public int calcHoras() {

        long minutosDiferencia = ChronoUnit.MINUTES.between(fechaHoraIngreso, fechaHoraSalida);

        long horasCobradas = (minutosDiferencia + 59) / 60;

        int horas = (int) horasCobradas;

        return horas;

    }

    public double calcValorHora() {
        double valorH;
        if (tipoVehiculo == 1) {
            valorH = 1000;
        } else {
            valorH = 2000;
        }

        return valorH;
    }

    public double getValorPagar() {
        double valorpagar = calcValorHora() * calcHoras();
        return valorpagar;
    }

    public void mostrarDetalleCobro() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String hrIng = fechaHoraIngreso.format(formatter);
        
        String hrSld = fechaHoraSalida.format(formatter);
        

        String msg = "FECHA Y HORA DE INGRESO    " + hrIng + "\n"
                + "FECHA Y HORA DE SALIDA " + hrSld + "\n"
                + "TIEMPO DE ESTACIONAMIENTO " + calcHoras() + "\n"
                + "VALOR A PAGAR $ " + getValorPagar();

        JOptionPane.showMessageDialog(null, msg);

    }

}
