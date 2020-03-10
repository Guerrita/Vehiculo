import javafx.css.converter.LadderConverter;

import javax.swing.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                    String placaRevision = JOptionPane.showInputDialog("Ingrese la placa del vehículo revisado:");
                    Optional<Vehiculo> vehiculoRevision= Optional.empty();
                    for(Vehiculo vehiculo:vehiculos){
                        if(placaRevision.equals(vehiculo.getPlaca())){
                            vehiculoRevision = Optional.of(vehiculo);
                            break;
                        }
                    }
                    if(!vehiculoRevision.isPresent()){
                        JOptionPane.showMessageDialog(null, "El vehículo con la placa ingresada no existe");
                    }else{
                        String diagnostico = JOptionPane.showInputDialog("Ingrese el diagnóstico: ");
                        Revision revision = new Revision(LocalDateTime.now(), diagnostico);
                        Vehiculo vehiculo = vehiculoRevision.get();
                        vehiculo.getRevisiones().add(revision);
                        JOptionPane.showMessageDialog(null, "Revisión registrada correctamente");
                    }
                    break;
                case "3": //consultar vehículo
                    String placaConsulta = JOptionPane.showInputDialog("Ingrese la placa del vehículo a consultar:");
                    for(Vehiculo vehiculo:vehiculos){
                        if(placaConsulta.equals(vehiculo.getPlaca())){
                            System.out.println(vehiculo);
                            break;
                        }
                    }
                    break;
                default://Error
                    JOptionPane.showMessageDialog(null,"Opcion incorrecta.");
            }
        }while(!"3".equals(opcion));
    }
}
