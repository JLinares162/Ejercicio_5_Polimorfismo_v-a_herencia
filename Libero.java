/**
 * Clase que representa a un jugador de tipo Líbero en el torneo de voleibol.
 */
public class Libero extends Jugador {
    private int recibosEfectivos; // Número de recibos efectivos realizados por el Líbero.

    /**
     * Constructor de la clase Líbero.
     *
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces (puntos directos por servicios) del jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     * @param recibosEfectivos Número de recibos efectivos realizados por el Líbero.
     */
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * Obtiene el número de recibos efectivos del Líbero.
     *
     * @return El número de recibos efectivos.
     */
    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    /**
     * Establece el número de recibos efectivos del Líbero.
     *
     * @param recibosEfectivos El número de recibos efectivos.
     */
    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * Calcula la efectividad del Líbero.
     * La efectividad de un Líbero se calcula de manera específica.
     *
     * @return La efectividad del Líbero.
     */
    @Override
    public double calcularEfectividad() {
        return ((recibosEfectivos - getErrores()) * 100.0 / (recibosEfectivos + getErrores())) + (getAces() * 100.0 / getTotalServicios());
    }

    /**
     * Convierte los datos del Líbero en una cadena CSV.
     *
     * @return Una cadena en formato CSV que representa al Líbero.
     */
    @Override
    public String toCSV() {
        return "Libero," + getNombre() + "," + getPais() + "," + getErrores() + "," + getAces() + "," + getTotalServicios() + "," + recibosEfectivos;
    }
}
