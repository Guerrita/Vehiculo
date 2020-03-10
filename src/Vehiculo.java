import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private String marca,
            modelo,
            color,
            placa;
    private int anio,
            numeroPuertas;
    private List<Revision> revisiones = new ArrayList<>();

    //private: solo se  puede acceder desde dentro de la clase.
    //Protected:la clase y los que hereden la clase.


    //Metodos constructores
    public Vehiculo(String marca) {
        this.marca = marca;

    }

    public Vehiculo(String placa, String marca, String modelo, String color, int anio, int numeroPuertas) {
        this.placa = placa;
        if (marca==null | "".equals(marca)){
            this.marca = "NA";
        }
        else{this.marca=marca;}

        if (color==null | "".equals(color)){
            this.color = "NA";
        }
        else{this.color=color;}

        if (modelo==null | "".equals(modelo)){
            this.modelo = "NA";
        }
        else{this.modelo=modelo;}

        if (anio>1980 && anio<2021){
            this.anio=anio;
        }
        else{this.anio = 0;}
        if (numeroPuertas>0 &&  numeroPuertas<5){
            this.numeroPuertas = numeroPuertas;
        }else this.numeroPuertas = 1;

    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getAnio() {
        return anio;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    //sobrecarga
    //sobreescritura
    @Override
    public String  toString() {//Metodo especial
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", anio=" + anio +
                ", numeroPuertas=" + numeroPuertas +
                '}';
    }
}
