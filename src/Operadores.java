import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Operadores {
    private ArrayList<Concello> datos;
    private ArrayList<Concello> solucion;
    private ArrayList<ArrayList<Integer>> matrizDistancias;
    private static String fDatos;
    private static String fAleatorio;

    public ArrayList<Concello> getDatos() {
        return datos;
    }

    public ArrayList<Concello> getSolucion() {
        return solucion;
    }

    public ArrayList<ArrayList<Integer>> getMatrizDistancias() {
        return matrizDistancias;
    }

    public Operadores(String ficheroDatos, String ficheroAleatorios) {
        fDatos=ficheroDatos;
        fAleatorio=ficheroAleatorios;
        datos=new ArrayList<>();
        double Latitude=0.0;
        double Lonxitude=0.0;
        Integer i=0;
        try{
            File file=new File(ficheroDatos);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                Latitude=sc.nextDouble();
                Lonxitude=sc.nextDouble();
                datos.add(new Concello(Latitude,Lonxitude, i));
                i++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ArrayList<Integer>aleatorios=new ArrayList();
        solucion=new ArrayList();
        File file2=new File(fAleatorio);
        Double x=0.0;
        Integer y=0;
        try {
            Scanner sc=new Scanner(file2);
            while(sc.hasNextLine()){
                x=1+ Math.floor(sc.nextFloat() * 99);
                y=x.intValue();
                while(aleatorios.contains(y)){//comprobamos que non insertamos repetidos
                    y=(y%99)+1;
                }
                aleatorios.add(y);
            }
            for(int j=0;j<aleatorios.size();j++){
                solucion.add(j,datos.get(aleatorios.get(j)));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        matrizDistancias=new ArrayList<>();
        ArrayList<Integer> aux;
        Integer intermedio=0;
        for(int c=0;c<datos.size();c++){
            aux=new ArrayList<>();
            for(int d=0;d<datos.size();d++){
                intermedio= datos.get(c).calculoDistancia(datos.get(d));
                aux.add(d, intermedio);
            }
            matrizDistancias.add(c,aux);
        }
    }
    private void inicializarDatos(){
        datos=new ArrayList<>();
        double Latitude=0.0;
        double Lonxitude=0.0;
        Integer i=0;
        try{
            File file=new File(fDatos);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                Latitude=sc.nextDouble();
                Lonxitude=sc.nextDouble();
                datos.add(new Concello(Latitude,Lonxitude, i));
                i++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private void  primeiraSolución(){
        ArrayList<Integer>aleatorios=new ArrayList();
        ArrayList <Concello> primera=new ArrayList();
        File file=new File(fAleatorio);
        Double x=0.0;
        Integer y=0;
        try {
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                x=1+ Math.floor(sc.nextFloat() * 99);
                y=x.intValue();
                while(aleatorios.contains(y)){//comprobamos que non insertamos repetidos
                    y=(y%99)+1;
                }
                aleatorios.add(y);
            }
            for(int j=0;j<aleatorios.size();j++){
                primera.add(j,datos.get(j));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void inicializarMatriz(){
        matrizDistancias=new ArrayList<>();
        ArrayList<Integer> aux;
        Integer intermedio=0;
        for(int i=0;i<datos.size();i++){
            aux=new ArrayList<>();
            for(int j=0;j<datos.size();j++){
                intermedio= datos.get(i).calculoDistancia(datos.get(j));
                aux.add(j, intermedio);
            }
            matrizDistancias.add(i,aux);
        }
    }
    public Integer calculoDistancia(){
        int  resultado=0;
        resultado=matrizDistancias.get(0).get(solucion.get(0).getID());
        resultado=resultado + matrizDistancias.get(solucion.get(98).getID()).get(0);
        for(int j=0; j<solucion.size()-1;j++){
            resultado=resultado+matrizDistancias.get(solucion.get(j).getID()).get(solucion.get(j+1).getID());
        }
        return resultado;
    }
}
