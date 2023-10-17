/**
 * Clase que representa a un jugador de tipo Auxiliar/Opuesto en el torneo de voleibol.
 */
public class AuxiliarOpuesto extends Jugador {
    private int ataques;            // Número de ataques realizados por el Auxiliar/Opuesto.
    private int bloqueosEfectivos;  // Número de bloqueos efectivos realizados por el Auxiliar/Opuesto.
    private int bloqueosFallidos;   // Número de bloqueos fallidos realizados por el Auxiliar/Opuesto.

    /**
     * Constructor de la clase Auxiliar/Opuesto.
     *
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces (puntos directos por servicios) del jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     * @param ataques Número de ataques realizados por el Auxiliar/Opuesto.
     * @param bloqueosEfectivos Número de bloqueos efectivos realizados por el Auxiliar/Opuesto.
     * @param bloqueosFallidos Número de bloqueos fallidos realizados por el Auxiliar/Opuesto.
     */
    public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Obtiene el número de ataques realizados por el Auxiliar/Opuesto.
     *
     * @return El número de ataques del Auxiliar/Opuesto.
     */
    public int getAtaques() {
        return ataques;
    }

    /**
     * Establece el número de ataques del Auxiliar/Opuesto.
     *
     * @param ataques El número de ataques del Auxiliar/Opuesto.
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    /**
     * Obtiene el número de bloqueos efectivos realizados por el Auxiliar/Opuesto.
     *
     * @return El número de bloqueos efectivos del Auxiliar/Opuesto.
     */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    /**
     * Establece el número de bloqueos efectivos del Auxiliar/Opuesto.
     *
     * @param bloqueosEfectivos El número de bloqueos efectivos del Auxiliar/Opuesto.
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * Obtiene el número de bloqueos fallidos realizados por el Auxiliar/Opuesto.
     *
     * @return El número de bloqueos fallidos del Auxiliar/Opuesto.
     */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    /**
     * Establece el número de bloqueos fallidos del Auxiliar/Opuesto.
     *
     * @param bloqueosFallidos El número de bloqueos fallidos del Auxiliar/Opuesto.
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Calcula la efectividad del Auxiliar/Opuesto.
     * La efectividad de un Auxiliar/Opuesto se calcula de manera específica.
     *
     * @return La efectividad del Auxiliar/Opuesto.
     */
    @Override
    public double calcularEfectividad() {
        return ((ataques + bloqueosEfectivos - bloqueosFallidos - getErrores()) * 100.0 / (ataques + bloqueosEfectivos + bloqueosFallidos + getErrores())) + (getAces() * 100.0 / getTotalServicios());
    }

    /**
     * Convierte los datos del Auxiliar/Opuesto en una cadena CSV.
     *
     * @return Una cadena en formato CSV que representa al Auxiliar/Opuesto.
     */
    @Override
    public String toCSV() {
        return "AuxiliarOpuesto," + getNombre() + "," + getPais() + "," + getErrores() + "," + getAces() + "," + getTotalServicios() + "," + ataques + "," + bloqueosEfectivos + "," + bloqueosFallidos;
    }
}
