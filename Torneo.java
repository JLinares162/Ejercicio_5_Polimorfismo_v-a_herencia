import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el torneo internacional de voleibol y gestiona la información de los jugadores.
 */
public class Torneo {
    private List<Jugador> jugadores = new ArrayList<>();

    /**
     * Registra un jugador en el torneo.
     *
     * @param jugador El jugador a registrar.
     */
    public void registrarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * Muestra los datos de todos los jugadores inscritos en el torneo.
     */
    public void mostrarJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    /**
     * Obtiene los 3 mejores líberos basados en su efectividad.
     *
     * @return Una lista con los 3 mejores líberos.
     */
    public List<Libero> losMejoresLiberos() {
        List<Libero> liberos = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                liberos.add((Libero) jugador);
            }
        }

        liberos.sort((l1, l2) -> Double.compare(l2.calcularEfectividad(), l1.calcularEfectividad()));

        return liberos.subList(0, Math.min(liberos.size(), 3));
    }

    /**
     * Calcula la cantidad de pasadores con más de un 80% de efectividad.
     *
     * @return La cantidad de pasadores efectivos.
     */
    public int cantidadPasadoresEfectivos() {
        int count = 0;
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                Pasador pasador = (Pasador) jugador;
                double efectividad = pasador.calcularEfectividad();
                if (efectividad > 80.0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Guarda la lista de jugadores en un archivo CSV.
     *
     * @param archivo El nombre del archivo CSV donde se almacenarán los datos.
     * @throws IOException Si ocurre un error durante la escritura del archivo.
     */
    public void guardarCatalogo(String archivo) throws IOException {
        if (!archivo.endsWith(".csv")) {
            archivo += ".csv"; // Añadir la extensión .csv si no está presente
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Jugador jugador : jugadores) {
                writer.write(jugador.toCSV() + "\n");
            }
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Carga la lista de jugadores desde un archivo CSV.
     *
     * @param archivo El nombre del archivo CSV desde donde se cargarán los datos.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    public void cargarCatalogo(String archivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            jugadores.clear(); // Limpiar la lista actual antes de cargar desde el archivo
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    String tipoJugador = parts[0];
                    Jugador jugador = null;

                    switch (tipoJugador) {
                        case "Libero":
                            jugador = new Libero(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
                            break;
                        case "Pasador":
                            jugador = new Pasador(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                            break;
                        case "AuxiliarOpuesto":
                            jugador = new AuxiliarOpuesto(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]));
                            break;
                    }

                    if (jugador != null) {
                        registrarJugador(jugador);
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
