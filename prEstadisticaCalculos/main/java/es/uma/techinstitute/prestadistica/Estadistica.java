package es.uma.techinstitute.prestadistica;

/**
 * Created by SamsungAndroid on 08/07/2016.
 */
public class Estadistica {
    private double numElementos;
    private double sumaX;
    private double sumaX2;

    //Constructor
    public Estadistica(){

    }
    //Métodos
    public void agrega(double d){
        numElementos++;
        sumaX =  sumaX +  d;
        sumaX2 =  sumaX2 + (d*d);
    }
    public void agrega(double d, int n){
        numElementos = numElementos + n;
        sumaX = sumaX + (n * d);
        sumaX2 = sumaX2 + n * (d * d);
    }
    public double media(){
        return (sumaX/numElementos);
    }
    public double varianza(){
        return ((sumaX2/numElementos) - (media()*media()));
    }
    public double desviacionTipica(){
        return Math.sqrt(varianza());
    }

}
