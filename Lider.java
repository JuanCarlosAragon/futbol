import java.util.Random;
/**
 * Write a description of class Lider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lider extends JugadorCampo
{
    private int liderazgo;

    /**
     * Constructor for objects of class Lider
     */
    public Lider(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        liderazgo = rnd.nextInt(5);
    }
    
    public int valoracion(){
       return super.valoracion() + liderazgo;
    }
    
    public String toString(){
        return super.toString() + "Liderazgo: " + liderazgo + "(Cap)";
    }
}
