Prueba master 2

Agrego linea a revertir

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

Linea que no se va a revertir 

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
    // Recoje las puntuaciones de cada equipo para hacer la clasificacion
    private HashMap<Equipo,ClasificacionEquipo> clasificacion;
    // Marca la jornada actual en la que se encuentra la liga
    private int jornadaActual;

    /**
     * Crea la liga con el numero de equipos indicados.
     */
    public Liga(int numEquipos)
    {
        // Inicializa los atributos
        equipos = new ArrayList();
        jornadas = new ArrayList();
        jornadaActual = 0;
        clasificacion = new HashMap();
        // Si el numero de equipos es impar, suma uno
        if(numEquipos%2 != 0)
        {
            numEquipos++;
        }
        // Crea tantos equipos como se hayan introducido
        for(int i = 0; i < numEquipos; i++)
        {
            Equipo equipo = new Equipo(NOMBRE + " " + (i + 1), 22);
            equipos.add(equipo);
            // Los añade a la vez al diccionario de clasificaciones
            clasificacion.put(equipo, new ClasificacionEquipo());
        }
        // Genera las jornadas de la liga
        generaJornadas();
    }

    /**
     * Muestra los emparejamientos de cada jornada.
     */
    public void muestraJornadas()
    {
        for(int i = 0; i < jornadas.size(); i++)
        {
            System.out.println("Jornada " + (i + 1));
            jornadas.get(i).showInfo();
        }
    }

    /**
     * Simula las jornadas de la liga indicadas y actualiza la clasificacion.
     * Si se introduce un numero mayor al numero de jornadas, se simularan solo las jornadas que existan
     */
    public void simularJornadas(int numero)
    {
        // Si el numero introducido es mayor que el numero de jornadas que queden, se setea al numero de jornadas
        if((numero + jornadaActual) > (jornadas.size()))
        {
            numero = (jornadas.size() - jornadaActual);
        }
        for (int i = 0; i < numero; i ++)
        {
            // Simula la jornada y actualiza la clasificacion
            System.out.println("JORNADA " + (jornadaActual + 1));
            actualizaClasificacion(jornadas.get(i).simularJornada());
            jornadaActual++;
            entrenamientos();
        }
    }

    /**
     * Muestra la clasificacion de los equipos, ordenada de mayor a menor puntuacion
     */
    public void mostrarClasificaciones()
    {
        // Toma un set de las claves para iterar y una copia de la clasificacion
        HashMap<Equipo,Integer> copia = new HashMap(clasificacion);
        Set<Equipo> setEquipos = clasificacion.keySet();
        int puntosMax = 0;
        Equipo equipoMax = null;
        String clasi = "\nCLASIFICACION DE LA LIGA, JORNADA " + (jornadaActual + 1);
        clasi += "\nNOMBRE\t\tpuntos\tPJ\tPG\tPE\tPP\tGF\tGC\tGAVG";
        for(int i = 0; i < clasificacion.size(); i++)
        {
            puntosMax = 0;
            equipoMax = null;
            for (Equipo equipo: setEquipos)
            {
                // Toma los puntos de ese equipo para compararlos, si el equipo aun no se ha mostrado en la clasificacion
                if(copia.containsKey(equipo))
                {
                    int puntosEquipo = clasificacion.get(equipo).getPuntos();
                    // Si los puntos son mayores o no hay ningun equipo guardado como maximo, lo guarda
                    if(puntosEquipo > puntosMax || equipoMax == null)
                    {
                        puntosMax = puntosEquipo;
                        equipoMax = equipo;
                    }
                    // Si empatan a puntos, el primer factor de desempate es la diferencia de goles (gol average)
                    else if (puntosEquipo == puntosMax)
                    {
                        if(clasificacion.get(equipo).getDiferenciaDeGoles() > clasificacion.get(equipoMax).getDiferenciaDeGoles())
                        {
                            puntosMax = puntosEquipo;
                            equipoMax = equipo;
                        }
                        // El segundo factor de desempate son los goles marcados
                        else if(clasificacion.get(equipo).getDiferenciaDeGoles() == clasificacion.get(equipoMax).getDiferenciaDeGoles())
                        {
                            if(clasificacion.get(equipo).getGolesAFavor() > clasificacion.get(equipoMax).getGolesAFavor())
                            {
                                puntosMax = puntosEquipo;
                                equipoMax = equipo;
                            }
                        }
                    }
                }
            }
            clasi += "\n" + equipoMax.getNombre() + " ->\t" + clasificacion.get(equipoMax).toString();
            copia.remove(equipoMax);
        }
        System.out.println(clasi);
    }

    /**
     * Los equipos entrenan
     */
    private void entrenamientos()
    {
        for(int i = 0; i < equipos.size(); i++)
        {
            equipos.get(i).entrenar();
        }
    }

    /**
     * Actualiza la clasificacion con los puntos recibidos como parametro
     */
    private void actualizaClasificacion(HashMap<Equipo,ClasificacionEquipo> puntos)
    {
        // Genera un set con las keys para iterar por el hashmap
        Set<Equipo> setEquipos = puntos.keySet();
        for(Equipo equipo: setEquipos)
        {
            // A cada clasificacion del equipo le pasa el resultado en formato ClasificacionEquipo para que la actualize
            ClasificacionEquipo temporal = clasificacion.get(equipo);
            temporal.sumaEstadisticas(puntos.get(equipo));
        }
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
	
	/**
     * Actualiza la clasificacion con los puntos recibidos como parametro
     */
    private void actualizaClasificacion_SOPORTE(HashMap<Equipo,ClasificacionEquipo> puntos_sop)
    {
        // Genera un set con las keys para iterar por el hashmap
        Set<Equipo> setEquipos = puntos_sop.keySet();
        for(Equipo equipo: setEquipos)
        {
            // A cada clasificacion del equipo le pasa el resultado en formato ClasificacionEquipo para que la actualize
            ClasificacionEquipo temporal = clasificacion.get(equipo);
            temporal.sumaEstadisticas(puntos_sop.get(equipo));
        }
    }
	
	/**
     * Genera las jornadas para la liga, que seran el numero de equipos - 1. No puede haber emparejamientos iguales en la liga
     */
    private void generaJornadas_DESA()
    {
        int indice = 1;
        int index = 1;
        boolean aniadir = true;
        Jornada jornada = null;
        while(indice < (equipos.size() - 1))
        {
            // Genera una jornada
            jornada = new Jornada(equipos);
            // Comprueba que no exista en el arraylist una incompatible. Si no hay incompatibles la añade
            aniadir = true;
            index = 0;
            while(index >= jornadas.size() && aniadir)
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
