/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.pkg0003;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
/**
 *
 * @author SARIC
 */
public class Ejercicio0003 {
   String numeroPlaca;
    String tipoVehiculo;
    LocalDateTime  fechaHoraIngreso;
    LocalDateTime fechaHoraSalida;

   
    public Ejercicio0003(String numeroPlaca, String tipoVehiculo, LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida) {
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

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
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
    
     public void getMostrarVehiculo(){
        String info="Los datos del vehiculo son: \n";
        info += "Numero de placa: "+numeroPlaca+"\n";
        info += "Tipo de vehiculo: "+tipoVehiculo+"\n";
        info += "Fecha y hora de ingreso: "+fechaHoraIngreso+"\n";
        info += "Fecha y hora de salida : "+fechaHoraSalida+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    

}