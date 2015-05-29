import java.util.Random;
public class Portero extends Jugador
{
    private int agilidad;
    private int mentalidad;

    /**
     * Constructor for objects of class Portero
     */
    public Portero(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        agilidad = rnd.nextInt(10);
        mentalidad = rnd.nextInt(10);
    }

    public int valoracion(){
        return ((super.getForma() + agilidad + mentalidad)/3);
    }
    
    public String toString(){
        return super.toString() + "\tAgil.: " + agilidad + "\tFortM.: " + mentalidad + "\t\t\tValoracion: " + valoracion();
    }
}
