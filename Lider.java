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
    public static final int MAX_LIDERAZGO = 5;

    /**
     * Constructor for objects of class Lider
     */
    public Lider(int dorsal, boolean crack)
    {
        super(dorsal, crack);
        Random rnd = new Random();
        if(crack)
        {
            liderazgo = MAX_LIDERAZGO;
        }
        else
        {
        liderazgo = rnd.nextInt(6);
    }
    }
    
    public int valoracion(){
       return super.valoracion() + liderazgo;
    }
    
    public String toString(){
        return super.toString() + "Liderazgo: " + liderazgo + "(Cap)";
    }
}
