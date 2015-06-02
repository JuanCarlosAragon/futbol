
/**
 * Representa las estadisticas del equipo
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClasificacionEquipo
{
    // Puntos que tiene el equipo
    private int puntos;
    // Partidos jugados por el equipo
    private int pj;
    // Partidos ganados por el equipo
    private int pg;
    // Partidos empatados por el equipo
    private int pe;
    // Partidos perdidos por el equipo
    private int pp;
    // Goles a favor del equipo
    private int gf;
    // Goles en contra del equipo
    private int gc;

    /**
     * Constructor para objetos de clasificacion de equipo. Este objeto recoje las estadisticas de la clasificacion de la liga para un equipo.
     * Este constructor inicializa todas las variables a 0.
     */
    public ClasificacionEquipo()
    {
        // initialise instance variables
        this.puntos = puntos;
        this.pj = 0;
        this.pg = 0;
        this.pe = 0;
        this.pp = 0;
        this.gf = 0;
        this.gc = 0;
    }

    /**
     * Constructor para objetos de clasificacion de equipo. Este objeto recoje las estadisticas de la clasificacion de la liga para un equipo.
     * @param puntos Los puntos del equipo
     * @param pj Partidos jugados por el equipo
     * @param pg Partidos ganados por el equipo
     * @param pe Partidos empatados por el equipo
     * @param pp Partidos perdidos por el equipo
     * @param gf Goles a favor del equipo
     * @param gc Goles en contra del equipo
     */
    public ClasificacionEquipo(int puntos, int pj, int pg, int pe, int pp, int gf, int gc)
    {
        // initialise instance variables
        this.puntos = puntos;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
    }

    /**
     * Suma las estadisticas pasadas como parametro a este objeto clasificacion.
     * @param sumaEstadisticas Estadisticas a sumar a este objeto.
     */
    public void sumaEstadisticas(ClasificacionEquipo sumaEstadisticas)
    {
        puntos += sumaEstadisticas.getPuntos();
        pj += sumaEstadisticas.getPartidosJugados();
        pg += sumaEstadisticas.getPartidosGanados();
        pe += sumaEstadisticas.getPartidosEmpatados();
        pp += sumaEstadisticas.getPartidosPerdidos();
        gf += sumaEstadisticas.getGolesAFavor();
        gc += sumaEstadisticas.getGolesEnContra();
    }

    /**
     * Devuelve los puntos del equipo
     * @return los puntos del equipo
     */
    public int getPuntos()
    {
        return puntos;
    }

    /**
     * Devuelve los partidos jugados del equipo
     * @return los partidos jugados del equipo
     */
    public int getPartidosJugados()
    {
        return pj;
    }

    /**
     * Devuelve los partidos ganados del equipo
     * @return los partidos ganados del equipo
     */
    public int getPartidosGanados()
    {
        return pg;
    }

    /**
     * Devuelve los partidos empatados del equipo
     * @return los partidos empatados del equipo
     */
    public int getPartidosEmpatados()
    {
        return pe;
    }

    /**
     * Devuelve los partidos perdidos del equipo
     * @return los partidos perdidos del equipo
     */
    public int getPartidosPerdidos()
    {
        return pp;
    }

    /**
     * Devuelve los goles a favor del equipo
     * @return los goles a favor del equipo
     */
    public int getGolesAFavor()
    {
        return gf;
    }

    /**
     * Devuelve los goles en contra del equipo
     * @return los goles en contra del equipo
     */
    public int getGolesEnContra()
    {
        return gc;
    }

    /**
     * Devuelve la diferencia de goles a favor y en contra del equipo
     * @return la diferencia de goles a favor y en contra del equipo
     */
    public int getDiferenciaDeGoles()
    {
        return (gf - gc);
    }
    
    /**
     * Devuelve la informacion de la clasificacion del equipo
     * @return un String con la informacion de la clasificacion del equipo
     */
    public String toString()
    {
        return (puntos + "\t" + pj + "\t" + + pg + "\t" + pe + "\t" + pp + "\t" + gf + "\t" + gc + "\t" + getDiferenciaDeGoles());
    }
}
