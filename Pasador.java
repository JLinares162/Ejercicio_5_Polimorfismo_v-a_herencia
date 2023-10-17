/**
 * Clase que representa a un jugador de tipo Pasador en el torneo de voleibol.
 */
public class Pasador extends Jugador {
    private int pases;              // Número de pases realizados por el Pasador.
    private int fintasEfectivas;    // Número de fintas efectivas realizadas por el Pasador.

    /**
     * Constructor de la clase Pasador.
     *
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces (puntos directos por servicios) del jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     * @param pases Número de pases realizados por el Pasador.
     * @param fintasEfectivas Número de fintas efectivas realizadas por el Pasador.
     */
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Obtiene el número de pases realizados por el Pasador.
     *
     * @return El número de pases del Pasador.
     */
    public int getPases() {
        return pases;
    }

    /**
     * Establece el número de pases del Pasador.
     *
     * @param pases El número de pases del Pasador.
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * Obtiene el número de fintas efectivas realizadas por el Pasador.
     *
     * @return El número de fintas efectivas del Pasador.
     */
    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    /**
     * Establece el número de fintas efectivas del Pasador.
     *
     * @param fintasEfectivas El número de fintas efectivas del Pasador.
     */
    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Calcula la efectividad del Pasador.
     * La efectividad de un Pasador se calcula de manera específica.
     *
     * @return La efectividad del Pasador.
     */
    @Override
    public double calcularEfectividad() {
        return ((pases + fintasEfectivas - getErrores()) * 100.0 / (pases + fintasEfectivas + getErrores())) + (getAces() * 100.0 / getTotalServicios());
    }

    /**
     * Convierte los datos del Pasador en una cadena CSV.
     *
     * @return Una cadena en formato CSV que representa al Pasador.
     */
    @Override
    public String toCSV() {
        return "Pasador," + getNombre() + "," + getPais() + "," + getErrores() + "," + getAces() + "," + getTotalServicios() + "," + pases + "," + fintasEfectivas;
    }
}
