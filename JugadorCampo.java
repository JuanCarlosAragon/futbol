import java.util.Random;
/**
 * Write a description of class JugadorCampo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorCampo extends Jugador
{
    private int pases;
    private int regate;
    private int remate;
    public static final int MAX_CARACTERISTICA = 10;

    /**
     * Constructor for objects of class JugadorCampo
     */
    public JugadorCampo(int dorsal, boolean crack)
    {
        super(dorsal, crack);
        Random rnd = new Random();
        if(crack)
        {
            pases = MAX_CARACTERISTICA;
            regate = MAX_CARACTERISTICA;
            remate = MAX_CARACTERISTICA;
        }
        else
        {
            pases = rnd.nextInt(11);
            regate = rnd.nextInt(11);
            remate = rnd.nextInt(11);
        }
    }

    public int getPases()
    {
        return pases;
    }

    public int getRegate()
    {
        return regate;
    }

    public int getRemate()
    {
        return remate;
    }

    public int valoracion(){
        return ((super.getForma() + pases + regate + remate)/4);
    }

    public String toString(){
        return super.toString() + "\tPases: " + pases + "\tRegate: " + regate + "\tRemate: " + remate + "\tValoracion: " + valoracion() + "\t";
    }
}
