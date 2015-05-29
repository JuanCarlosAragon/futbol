public class Test
{
    public Test() 
    {
        Equipo equipo1 = new Equipo("SOLTEROS", 15);
        Equipo equipo2 = new Equipo("CASADOS", 15);
        Partido miPartido = new Partido(equipo1, equipo2);
        miPartido.mostrarAlineaciones();
    }
}
