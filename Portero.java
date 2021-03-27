import java.util.Random;
public class Portero extends Jugador
{
    private int agilidad;
    private int mentalidad;
    public static final int MAX_CARACTERISTICA = 10;

    /**
     * Constructor for objects of class Portero
     */
    public Portero(int dorsal, boolean crack)
    {
        super(dorsal, crack);
        Random rnd = new Random();
        if(crack)
        {
            agilidad = MAX_CARACTERISTICA;
            mentalidad = MAX_CARACTERISTICA;
        }
        else
        {
            agilidad = rnd.nextInt(11);
            mentalidad = rnd.nextInt(11);
        }
    }
    
    public int getAgilidad()
    {
        return agilidad;
    }
    
    public int getMentalidad()
    {
        return mentalidad;
    }

    public int valoracion(){
        return ((super.getForma() + agilidad + mentalidad)/3);
    }

    public String toString(){
        return super.toString() + "\tAgil.: " + agilidad + "\tFortM.: " + mentalidad + "\t\t\tValoracion: " + valoracion();
    }
	
	public String toString2(){
        return super.toString() + "\tAgil.: " + agilidad + "\tFortM.: " + mentalidad + "\t\t\tValoracion: " + valoracion();
    }
	
}
