/**
 * Clase principal cuenta con el metodo main del programa y es la encargada de solo imprimir y recibir datos del usuario.
 *
 * @author Javier Alexander Linares Chang - carnet 231135
 * @version 1.0
 * @since 2023-10-16
 */

import java.util.Scanner;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar un jugador");
            System.out.println("2. Mostrar todos los jugadores inscritos en el torneo");
            System.out.println("3. Mostrar los 3 mejores líberos");
            System.out.println("4. Mostrar la cantidad de pasadores con más del 80% de efectividad");
            System.out.println("5. Guardar catálogo en un archivo CSV");
            System.out.println("6. Cargar catálogo desde un archivo CSV");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el país del jugador: ");
                    String pais = scanner.nextLine();
                    System.out.println("Ingresa el número de errores del jugador: ");
                    int errores = scanner.nextInt();
                    System.out.println("Ingresa el número de aces del jugador: ");
                    int aces = scanner.nextInt();
                    System.out.println("Ingresa el número total de servicios del jugador: ");
                    int totalServicios = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.println("Selecciona el tipo de jugador:");
                    System.out.println("1. Libero");
                    System.out.println("2. Pasador");
                    System.out.println("3. Auxiliar/Opuesto");
                    int tipoJugador = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    Jugador jugador = null;

                    switch (tipoJugador) {
                        case 1:
                            System.out.println("Ingresa el número de recibos efectivos del líbero: ");
                            int recibosEfectivos = scanner.nextInt();
                            jugador = new Libero(nombre, pais, errores, aces, totalServicios, recibosEfectivos);
                            break;
                        case 2:
                            System.out.println("Ingresa el número de pases del pasador: ");
                            int pases = scanner.nextInt();
                            System.out.println("Ingresa el número de fintas efectivas del pasador: ");
                            int fintasEfectivas = scanner.nextInt();
                            jugador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas);
                            break;
                        case 3:
                            System.out.println("Ingresa el número de ataques del auxiliar/opuesto: ");
                            int ataques = scanner.nextInt();
                            System.out.println("Ingresa el número de bloqueos efectivos del auxiliar/opuesto: ");
                            int bloqueosEfectivos = scanner.nextInt();
                            System.out.println("Ingresa el número de bloqueos fallidos del auxiliar/opuesto: ");
                            int bloqueosFallidos = scanner.nextInt();
                            jugador = new AuxiliarOpuesto(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }

                    if (jugador != null) {
                        torneo.registrarJugador(jugador);
                        System.out.println("Jugador registrado exitosamente.");
                    }
                    break;
                case 2:
                    System.out.println("\nTodos los jugadores inscritos en el torneo:");
                    torneo.mostrarJugadores();
                    break;
                case 3:
                    System.out.println("\nLos 3 mejores líberos:");
                    torneo.losMejoresLiberos().forEach(libero -> System.out.println(libero.toString()));
                    break;
                case 4:
                    int pasadoresEfectivos = torneo.cantidadPasadoresEfectivos();
                    System.out.println("\nCantidad de pasadores con más del 80% de efectividad: " + pasadoresEfectivos);
                    break;
                case 5:
                    System.out.println("Ingresa el nombre del archivo CSV para guardar el catálogo: ");
                    String archivoGuardar = scanner.nextLine();
                    try {
                        torneo.guardarCatalogo(archivoGuardar);
                        System.out.println("Catálogo guardado exitosamente en " + archivoGuardar);
                    } catch (IOException e) {
                        System.err.println("Error al guardar el catálogo: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Ingresa el nombre del archivo CSV para cargar el catálogo: ");
                    String archivoCargar = scanner.nextLine();
                    try {
                        torneo.cargarCatalogo(archivoCargar);
                        System.out.println("Catálogo cargado exitosamente desde " + archivoCargar);
                    } catch (IOException e) {
                        System.err.println("Error al cargar el catálogo: " + e.getMessage());
                    }
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
