/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg0003;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SARIC
 */
public class VectorVehiculo {

    Vehiculo vehi[];
    int tamaño;

    VectorVehiculo(JTextField jtam) {
        int i;
        try {

            tamaño = Integer.parseInt(jtam.getText());

            vehi = new Vehiculo[tamaño];

            for (i = 0; i < vehi.length; i++) {
                vehi[i] = new Vehiculo("", -1, LocalDateTime.now(), LocalDateTime.now());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error: " + e + ".  El vector no fue creado! Intente nuevamente.");
            jtam.setText("");
            jtam.requestFocus();
            vehi = null;
        }
    }

    public Vehiculo[] getVehi() {
        return vehi;
    }

    public void setVehi(Vehiculo[] vehi) {
        this.vehi = vehi;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getBuscarPlaca(String plac) {
        int i;
        for (i = 0; i < vehi.length; i++) {
            if (plac.equals(vehi[i].getNumeroPlaca())) {
                return i;
            }
        }
        return -1;
    }

    public boolean llenarVector(JTextField numPlaca, JComboBox tipoVeh, LocalDateTime hrI, LocalDateTime hrS, int pos) {
        int b;
        try {
            if ((pos < 0) || (pos >= tamaño)) {
                JOptionPane.showMessageDialog(null, "Posición invalida!");
                return false;
            } else {
                do {
                    b = getBuscarPlaca(numPlaca.getText());
                    if (b != -1) {
                        JOptionPane.showMessageDialog(null, "La placa ya existe.  Intente " + "nuevamente!");
                        numPlaca.setText("");
                        numPlaca.requestFocus();
                        return false;
                    }
                } while (b != -1);

                vehi[pos].setNumeroPlaca(numPlaca.getText());
                vehi[pos].setTipoVehiculo(tipoVeh.getSelectedIndex());
                vehi[pos].setFechaHoraIngreso(hrI);
                vehi[pos].setFechaHoraSalida(hrS);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e + ". No fue registrado.");
            return false;
        }

    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int pFila, int pVec) {
        String tV = " ";

        switch (vehi[pVec].getTipoVehiculo()) {
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
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String hrIng = vehi[pVec].getFechaHoraIngreso().format(formatter);
        
        String hrSld = vehi[pVec].getFechaHoraSalida().format(formatter);

        miModelo.setValueAt(vehi[pVec].getNumeroPlaca(), pFila, 0);
        miModelo.setValueAt(tV, pFila, 1);
        miModelo.setValueAt(hrIng, pFila, 2);
        miModelo.setValueAt(hrSld, pFila, 3);
        miModelo.setValueAt(vehi[pVec].calcHoras() + "h", pFila, 4);
        miModelo.setValueAt(vehi[pVec].getValorPagar(), pFila, 5);

    }

    public void llenarJTable(JTable tab) {
        int posTabla = 0; //Este índice recorre los elementos de la fila Tabla
        int posVec = 0;  //Este índice para ubicar posición del vector
        DefaultTableModel miModelo = new DefaultTableModel();

        //Creamos los nombres de las columnas de la tabla
        miModelo.addColumn("Numero de Placa");
        miModelo.addColumn("Tipo de Vehiculo");
        miModelo.addColumn("Fecha de Ingreso");
        miModelo.addColumn("Fecha de Salida");
        miModelo.addColumn("Tiempo Estacionado");
        miModelo.addColumn("Valor a Pagar");

        //Recorremos el vector para tomar sus datos
        //y pasarlos al JTable
        while (posVec < vehi.length) {
            miModelo.addRow(new Object[]{"", "", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, posTabla, posVec);
            posVec++;
            posTabla++;
        }
        tab.setModel(miModelo);
    }

    public void ordenarPorTipoYPlaca() {
        for (int i = 0; i < vehi.length - 1; i++) {
            for (int j = i + 1; j < vehi.length; j++) {
                if (vehi[i].tipoVehiculo == vehi[j].tipoVehiculo
                        || (vehi[i].tipoVehiculo == vehi[j].tipoVehiculo && vehi[i].numeroPlaca.compareToIgnoreCase(vehi[j].numeroPlaca) > 0)) {
                    Vehiculo temp = vehi[i];
                    vehi[i] = vehi[j];
                    vehi[j] = temp;
                }
            }
        }
    }

    public void ordenarPorInsercion() {

        for (int i = 1; i < vehi.length; i++) {
            Vehiculo a = vehi[i];
            int j = i - 1;

            while (j >= 0 && vehi[j].calcHoras() < a.calcHoras()) {
                vehi[j + 1] = vehi[j];
                j = j - 1;
            }
            vehi[j + 1] = a;
        }
    }

    public void ordenarPorBurbuja() {
        int n = vehi.length;
        boolean cambiado;
        for (int i = 0; i < n - 1; i++) {
            cambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Comparar los valores a pagar para ordenamiento descendente
                if (vehi[j].getValorPagar() < vehi[j + 1].getValorPagar()) {
                    // Intercambiar los vehículos
                    Vehiculo temp = vehi[j];
                    vehi[j] = vehi[j + 1];
                    vehi[j + 1] = temp;
                    cambiado = true;
                }
            }

            if (!cambiado) {
                break;
            }
        }
    }

}
