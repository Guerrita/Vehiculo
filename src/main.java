import javafx.css.converter.LadderConverter;

import javax.swing.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class main {
    private static List<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        String menu = "Bienvenido. Seleccione una opcion;\n"+
                "1. Registrar Vehiculo. \n"+
                "2. Registrar Revision. \n"+
                "3. Salir.\n";
        String opcion = "";
        do {
            opcion = JOptionPane.showInputDialog(menu);
            switch (opcion) {
                case "1"://Registrar vehiculo
                    String placa = JOptionPane.showInputDialog("ingrese la placa");
                    String marca = JOptionPane.showInputDialog("ingrese la marca");
                    String modelo = JOptionPane.showInputDialog("ingrese el modelo");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("ingrese el anio"));
                    String color = JOptionPane.showInputDialog("ingrese el color");
                    int numeroPuertas = Integer.parseInt(JOptionPane.showInputDialog("ingrese el anio"));
                    Vehiculo v = new Vehiculo(placa, marca, modelo, color, anio, numeroPuertas);
                    vehiculos.add(v);
                    JOptionPane.showMessageDialog(null, "Vehiculo registrado");
                    break;
                case "2"://Registrar revision
                    Vehiculo vehiculoRevision = null;
                    String placaRevision = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
                    for (Vehiculo vehiculo : vehiculos){
                        if (placaRevision.equals(vehiculo.getPlaca())) {
                            vehiculoRevision = vehiculo;
                            break;
                        }
                    }
                    if(vehiculoRevision==null){
                        JOptionPane.showMessageDialog(null,"El vehiculo para la placa ingresada no existe");
                    }else{
                        String diagnostico = JOptionPane.showInputDialog("Ingrese el diagnostico");
                        Revision revision = new Revision(LocalDateTime.now(),diagnostico);
                        vehiculoRevision.getRevisiones().add(revision);
                    }
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null,"Hasta luego.");
                    break;
                default://Error
                    JOptionPane.showMessageDialog(null,"Opcion incorrecta.");
            }
        }while(!"3".equals(opcion));
    }
}
