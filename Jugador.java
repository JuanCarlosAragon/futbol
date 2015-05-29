import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jugador
{
    private String nombre;
    private int edad;
    private int forma;
    private int dorsal;
    private static final String[] nombres = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos",
            "J.Ramon", "Fede", "Alberto", "Roberto", "Ruben", "Hector",
            "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "J.Manu", "J.Jesus",
            "Pepe", "Ricardo", "Fer", "Antonio", "Jose", "J.Luis", "David",
            "Emilio", "Cesar", "German", "Raul", "Pablo"};
    private static final int EDAD_MINIMA = 18;
    public static final int MAX_FORMA = 10;
    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(int dorsal, boolean crack)
    {
        Random rnd = new Random();
        nombre = nombres[rnd.nextInt(nombres.length)];
        edad = rnd.nextInt(22) + EDAD_MINIMA;
        this.dorsal = dorsal;
        if(crack)
        {
            forma = MAX_FORMA;
            this.nombre +="*";
        }
        else
        {
            forma = rnd.nextInt(10);
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public int getForma(){
        return forma;
    }

    public int getDorsal(){
        return dorsal;
    }
    
    public void setForma(int nuevaForma){
        if(nuevaForma > 10)
        {
            forma = 10;
        }
        else
        {
            forma = nuevaForma;
        }
    }

    public String toString(){
        return "Dorsal " + dorsal + ".\t" + nombre + "\t(" + edad + " anos)" + "\tForma: " + forma;
    }

    public abstract int valoracion();
}
