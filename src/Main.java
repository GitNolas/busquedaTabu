import java.util.*;
public class Main {
    public static void main(String[] args) {
        Operadores o= new Operadores("coordenadas_100.txt", "aleatorios100.txt");
        for(int i=0;i< o.getSolucion().size();i++){
            System.out.println(i+":"+" Latitude-->" +o.getSolucion().get(i).getLatitude() + " Lonxitude-->" + o.getSolucion().get(i).getLonxitude()+ " ID-->" + o.getSolucion().get(i).getID());
        }
        System.out.println("Distancia: " + o.calculoDistancia());

    }
}