import java.util.ArrayList;

/**
 * Write a description of class Liga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{
    // Equipos que juegan la liga
    private ArrayList<Equipo> equipos;
    // Jornadas que componen la liga
    private ArrayList<Jornada> jornadas;
    // El nombre de los equipos sera "equipo" + un numero
    public static final String NOMBRE ="Equipo";

    /**
     * Crea la liga con el numero de equipos indicados.
     */
    public Liga(int numEquipos)
    {
        // Inicializa los arraylist
        equipos = new ArrayList();
        jornadas = new ArrayList();
        // Si el numero de equipos es impar, suma uno
        if(numEquipos%2 != 0)
        {
            numEquipos++;
        }
        // Crea tantos equipos como se hayan introducido
        for(int i = 0; i < numEquipos; i++)
        {
            equipos.add(new Equipo(NOMBRE + " " + i, 22));
        }
        // Genera las jornadas de la liga
        generaJornadas();
    }

    /**
     * Genera las jornadas para la liga, que seran el numero de equipos - 1. No puede haber emparejamientos iguales en la liga
     */
    private void generaJornadas()
    {
        int indice = 0;
        int index = 0;
        boolean aniadir = true;
        Jornada jornada = null;
        while(indice < (equipos.size() - 1))
        {
            // Genera una jornada
            jornada = new Jornada(equipos);
            // Comprueba que no exista en el arraylist una incompatible. Si no hay incompatibles la añade
            aniadir = true;
            index = 0;
            while(index < jornadas.size() && aniadir)
            {
                // Si devuelve true, son compatibles y sigue comprobando. En cuanto encuentre uno no compatible termina el bucle
                aniadir = jornadas.get(index).compatibles(jornada);
                index++;
            }
            // Si la nueva jornada es compatible con todas, se añade
            if(aniadir)
            {
                jornadas.add(jornada);
                indice++;
            }
        }
    }
}
