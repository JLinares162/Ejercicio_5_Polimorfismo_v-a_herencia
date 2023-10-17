/**
 * Clase base que representa a un jugador en el torneo de voleibol.
 */
public class Jugador {
    private String nombre;          // Nombre del jugador.
    private String pais;            // País del jugador.
    private int errores;            // Número de errores cometidos por el jugador.
    private int aces;               // Número de aces (puntos directos por servicios) del jugador.
    private int totalServicios;     // Total de servicios realizados por el jugador.

    /**
     * Constructor de la clase Jugador.
     *
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces (puntos directos por servicios) del jugador.
     * @param totalServicios Total de servicios realizados por el jugador.
     */
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre El nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país del jugador.
     *
     * @return El país del jugador.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del jugador.
     *
     * @param pais El país del jugador.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene el número de errores cometidos por el jugador.
     *
     * @return El número de errores del jugador.
     */
    public int getErrores() {
        return errores;
    }

    /**
     * Establece el número de errores del jugador.
     *
     * @param errores El número de errores del jugador.
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }

    /**
     * Obtiene el número de aces del jugador.
     *
     * @return El número de aces del jugador.
     */
    public int getAces() {
        return aces;
    }

    /**
     * Establece el número de aces del jugador.
     *
     * @param aces El número de aces del jugador.
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * Obtiene el total de servicios realizados por el jugador.
     *
     * @return El total de servicios del jugador.
     */
    public int getTotalServicios() {
        return totalServicios;
    }

    /**
     * Establece el total de servicios realizados por el jugador.
     *
     * @param totalServicios El total de servicios del jugador.
     */
    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    /**
     * Calcula la efectividad del jugador.
     * Este método es abstracto y debe ser implementado en las subclases.
     *
     * @return La efectividad del jugador.
     */
    public double calcularEfectividad() {
        return 0.0; // Método abstracto a implementar en las subclases
    }

    /**
     * Convierte los datos del jugador en una cadena CSV.
     *
     * @return Una cadena en formato CSV que representa al jugador.
     */
    public String toCSV() {
        return "Jugador," + nombre + "," + pais + "," + errores + "," + aces + "," + totalServicios;
    }

    /**
     * Devuelve una representación en cadena de la información del jugador.
     *
     * @return Una cadena que muestra los datos del jugador.
     */
    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", pais=" + pais + ", errores=" + errores + ", aces=" + aces
                + ", totalServicios=" + totalServicios + "]";
    }
}
