import java.util.ArrayList;

/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private ArrayList<Jugador> titularesLocal;
    private ArrayList<Jugador> titularesVisitante;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1, Equipo equipo2)
    {
        this.equipoLocal = equipo1;
        this.equipoVisitante = equipo2;
        titularesLocal = new ArrayList<>();
        titularesVisitante = new ArrayList<>();
        titularesLocal = equipo1.alinear();
        titularesVisitante = equipo2.alinear();
    }

    public void mostrarAlineaciones(){
        showInfoLocal();
        showInfoVisitante();
    }

    /**
     * Muestra la informacion del equipo local
     */
    private void showInfoLocal()
    {
        // Crea una lista temporal de suplentes
        ArrayList<Jugador> suplentes = new ArrayList<>(equipoLocal.getPlantilla());
        for(int i = 0; i < titularesLocal.size(); i++)
        {
            suplentes.remove(titularesLocal.get(i));
        }
        double valoracionTotal = 0;
        System.out.println(equipoLocal.getNombre().toUpperCase());
        System.out.println("titulares:");
        for(int i = 0; i < titularesLocal.size(); i++)
        {
            Jugador titular = titularesLocal.get(i);
            System.out.println(titular.toString());
            valoracionTotal += titular.valoracion();
        }
        System.out.printf("***************************** MEDIA DE VALORACION DEL EQUIPO TITULAR: %1.2f ******************************************", valoracionTotal/11);
        System.out.println("\nReservas:");
        for(int i = 0; i < suplentes.size(); i++){
            System.out.println(suplentes.get(i).toString());
        }
        System.out.println("\n\n");
    }

    /**
     * Muestra la informacion del equipo visitante
     */
    private void showInfoVisitante()
    {
        // Crea una lista temporal de suplentes
        ArrayList<Jugador> suplentes = new ArrayList<>(equipoVisitante.getPlantilla());
        for(int i = 0; i < titularesVisitante.size(); i++)
        {
            suplentes.remove(titularesVisitante.get(i));
        }
        double valoracionTotal = 0;
        System.out.println(equipoVisitante.getNombre().toUpperCase());
        System.out.println("titulares:");
        for(int i = 0; i < titularesVisitante.size(); i++)
        {
            Jugador titular = titularesVisitante.get(i);
            System.out.println(titular.toString());
            valoracionTotal += titular.valoracion();
        }
        System.out.printf("***************************** MEDIA DE VALORACION DEL EQUIPO TITULAR: %1.2f ******************************************", valoracionTotal/11);
        System.out.println("\nReservas:");
        for(int i = 0; i < suplentes.size(); i++){
            System.out.println(suplentes.get(i).toString());
        }
        System.out.println("\n\n");
    }

    /**
     * Simula el resultado de un partido. El partido se resolvera por un sistema de puntos, que
     * depende de las caracteristicas de los jugadores.
     */
    public void simular()
    {
        int visitante = 0;
        int local = 0;
        // Compara el sumatorio de pases de ambas alineaciones, da un punto al mejor
        if(sumaPases(titularesVisitante) > sumaPases(titularesLocal))
        {
            visitante++;
        }
        else if (sumaPases(titularesVisitante) < sumaPases(titularesLocal))
        {
            local++;
        }
        // Compara la forma de ambas alineaciones, da un punto al mejor
        if(sumaForma(titularesVisitante) > sumaForma(titularesLocal))
        {
            visitante++;
        }
        else if (sumaForma(titularesVisitante) < sumaForma(titularesLocal))
        {
            local++;
        }
        // Compara la el regate medio de un equipo con la fortalieza mental del portero rival. Si es mayor, da un punto
        if(sumaRegate(titularesVisitante)/10 > getMentalidad(titularesLocal))
        {
            visitante++;
        }
        if (sumaRegate(titularesLocal)/10 > getMentalidad(titularesVisitante))
        {
            local++;
        }
        // Compara el remate medio de cada equipo con la agilidad del protero rival, Si es mayor, da un punto
        if(sumaRemate(titularesVisitante)/10 > getAgilidad(titularesLocal))
        {
            visitante++;
        }
        if (sumaRemate(titularesLocal)/10 > getAgilidad(titularesVisitante))
        {
            local++;
        }
        // Compara el liderazgo, da un punto extra al equipo con mas liderazgo
         if(getLiderazgo(titularesVisitante) > getLiderazgo(titularesLocal))
        {
            visitante++;
        }
        else if (getLiderazgo(titularesVisitante) < getLiderazgo(titularesLocal))
        {
            local++;
        }
        
        // Los goles marcados por cada equipo seran los puntos que hayan obtenido
        String resultado = equipoLocal.getNombre().toUpperCase() + ": " + local + " - " + equipoVisitante.getNombre().toUpperCase() + ": " + visitante;
        System.out.println(resultado);
    }

    /**
     * Calcula la suma de los pases de la alineacion que se pasa como parametro
     */
    private int sumaPases(ArrayList<Jugador> alineacion)
    {
        int sumatorio = 0;
        for(Jugador jugador : alineacion)
        {
            if(jugador instanceof JugadorCampo)
            {
                sumatorio = ((JugadorCampo)jugador).getPases();
            }
        }
        return sumatorio;
    }

    /**
     * Calcula la suma de la forma de la alineacion que se pasa como parametro
     */
    private int sumaForma(ArrayList<Jugador> alineacion)
    {
        int sumatorio = 0;
        for(Jugador jugador : alineacion)
        {
            sumatorio = jugador.getForma();
        }
        return sumatorio;
    }

    /**
     * Calcula la suma del regate de la alineacion que se pasa como parametro
     */
    private int sumaRegate(ArrayList<Jugador> alineacion)
    {
        int sumatorio = 0;
        for(Jugador jugador : alineacion)
        {
            if(jugador instanceof JugadorCampo)
            {
                sumatorio = ((JugadorCampo)jugador).getRegate();
            }
        }
        return sumatorio;
    }

    /**
     * Calcula la suma del remate de la alineacion que se pasa como parametro
     */
    private int sumaRemate(ArrayList<Jugador> alineacion)
    {
        int sumatorio = 0;
        for(Jugador jugador : alineacion)
        {
            if(jugador instanceof JugadorCampo)
            {
                sumatorio = ((JugadorCampo)jugador).getRemate();
            }
        }
        return sumatorio;
    }

    /**
     * Devuelve la agilidad del portero de la alineacion que se pasa como parametro
     */
    private int getAgilidad(ArrayList<Jugador> alineacion)
    {
        Portero portero = null;
        for(Jugador jugador : alineacion)
        {
            if(jugador instanceof Portero)
            {
                portero = (Portero)jugador;
            }
        }
        return portero.getAgilidad();
    }

    /**
     * Devuelve la mentalidad del portero de la alineacion que se pasa como parametro
     */
    private int getMentalidad(ArrayList<Jugador> alineacion)
    {
        Portero portero = null;
        for(Jugador jugador : alineacion)
        {
            if(jugador instanceof Portero)
            {
                portero = (Portero)jugador;
            }
        }
        return portero.getMentalidad();
    }
    
     /**
     * Devuelve la liderazgo del portero de la alineacion que se pasa como parametro
     */
    private int getLiderazgo(ArrayList<Jugador> alineacion)
    {
        Lider lider = null;
        for(Jugador jugador : alineacion)
        {
            if(jugador instanceof Lider)
            {
                lider = (Lider)jugador;
            }
        }
        return lider.getLiderazgo();
    }
}
