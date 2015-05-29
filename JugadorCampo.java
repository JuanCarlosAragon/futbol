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

    /**
     * Constructor for objects of class JugadorCampo
     */
    public JugadorCampo(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        pases = rnd.nextInt(10);
        regate = rnd.nextInt(10);
        remate = rnd.nextInt(10);
    }
    public int valoracion(){
        return ((super.getForma() + pases + regate + remate)/4);
    }
    public String toString(){
        return super.toString() + "\tPases: " + pases + "\tRegate: " + regate + "\tRemate: " + remate + "\tValoracion: " + valoracion() + "\t";
    }
}
