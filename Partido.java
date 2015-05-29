
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    private Equipo equipo1;
    private Equipo equipo2;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1, Equipo equipo2)
    {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void mostrarAlineaciones(){
        equipo1.showInfo();
        
        equipo2.showInfo();
    }
}
