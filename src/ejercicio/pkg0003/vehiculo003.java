/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg0003;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SARIC
 */
public class vehiculo003 {
    Ejercicio0003 vehi[];
      int tamaño;
      
        vehiculo003(JTextField jtam){
        int i;
        try{
           
            tamaño = Integer.parseInt(jtam.getText());
          
            vehi= new  Ejercicio0003[tamaño];
           
            for( i=0; i< vehi.length; i++ ){
                vehi[i] = new  Ejercicio0003("","",LocalDateTime.now(),LocalDateTime.now());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                "Error: "+e+".  El vector no fue creado! Intente nuevamente.");
            jtam.setText("");
            jtam.requestFocus();
            vehi = null;
        }
        }
        
         public void registrarVehiculo(int i, String marca, String numeroPlaca, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        if (i>= 0 && i< vehi.length) {
            vehi[i] = new Ejercicio0003(marca, numeroPlaca, fechaIngreso, fechaSalida);
        }
         }
    
          public int getBuscarpornump(String Placa){
        int i;
        for( i=0; i<vehi.length; i++ ){
            if( Placa.equals(vehi[i].numeroPlaca) )
                return i;
        }
        return -1;
    }
              public void ordenarPorTipoYPlaca() {
        for (int i = 0; i < vehi.length - 1; i++) {
            for (int j = i + 1; j < vehi.length; j++) {
                if (vehi[i].tipoVehiculo.compareTo(vehi[j].tipoVehiculo) > 0 ||
                    (vehi[i].tipoVehiculo.equals(vehi[j].tipoVehiculo) && vehi[i].numeroPlaca.compareTo(vehi[j].numeroPlaca) > 0)) {
                    Ejercicio0003 temp = vehi[i];
                    vehi[i] = vehi[j];
                    vehi[j] = temp;
                }
            }
        }
              }
              
              
                 
    }

         
    
        

