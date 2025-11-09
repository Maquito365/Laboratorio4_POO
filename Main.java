import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controlador controlador = new Controlador();
        Vista vista = new Vista();

        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: // Crear contenido
                    vista.mostrarTiposContenido();
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    Contenido nuevo = null;

                    switch (tipo) {
                        case 1: // Artículo
                            System.out.print("Texto del artículo: ");
                            String texto = sc.nextLine();
                            nuevo = new Articulo(controlador.generarId(), titulo, autor, texto);
                            break;
                        case 2: // Video
                            System.out.print("URL del video: ");
                            String url = sc.nextLine();
                            nuevo = new Video(controlador.generarId(), titulo, autor, url);
                            break;
                        case 3: // Imagen
                            nuevo = new Imagen(controlador.generarId(), titulo, autor);
                            break;
                        case 4: // Podcast
                            System.out.print("Duración: ");
                            String duracion = sc.nextLine();
                            nuevo = new Podcast(controlador.generarId(), titulo, autor, duracion);
                            break;
                        default:
                            System.out.println("Tipo no válido.");
                            continue;
                    }

                    System.out.print("Ingrese las categorías separadas por coma: ");
                    String categoriasStr = sc.nextLine();
                    String[] categorias = categoriasStr.split(",");
                    for (String cat : categorias) {
                        nuevo.agregarCategoria(cat.trim());
                    }

                    controlador.agregarContenido(nuevo);
                    break;

                case 2: // Mostrar contenidos
                    controlador.mostrarContenidos();
                    break;

                case 3: // Editar contenido
                    System.out.print("ID del contenido a editar: ");
                    int idEdit = sc.nextInt();
                    sc.nextLine();

                    Contenido edit = controlador.buscarPorId(idEdit);
                    if (edit != null) {
                        System.out.print("Nuevo título: ");
                        String nuevoTitulo = sc.nextLine();

                        // Si es un artículo, también permite editar el texto
                        if (edit instanceof Articulo) {
                            System.out.print("Nuevo texto del artículo: ");
                            String nuevoTexto = sc.nextLine();
                            ((Articulo) edit).setTexto(nuevoTexto);
                        }

                        // Si es un video, permite cambiar la URL
                        else if (edit instanceof Video) {
                            System.out.print("Nueva URL del video: ");
                            String nuevaUrl = sc.nextLine();
                            ((Video) edit).setUrl(nuevaUrl);
                        }

                        // Si es un podcast, permite cambiar la duración
                        else if (edit instanceof Podcast) {
                            System.out.print("Nueva duración del podcast: ");
                            String nuevaDuracion = sc.nextLine();
                            ((Podcast) edit).setDuracion(nuevaDuracion);
                        }

                        Editor editor = new Editor("Editor del sistema");
                        editor.editarContenido(edit, nuevoTitulo);
                    } else {
                        System.out.println("No se encontró contenido con ese ID.");
                    }
                    break;

                case 4: // Eliminar contenido
                    System.out.print("ID del contenido a eliminar: ");
                    int idDel = sc.nextInt();
                    controlador.eliminarContenido(idDel);
                    break;

                case 5: // Reporte
                    controlador.generarReporte();
                    break;

                case 6: // Salir
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                case 7: //filtrar por categoría
                    System.out.print("Ingrese el nombre de la categoría: ");
                    String categoria = sc.nextLine();
                    controlador.filtrarPorCategoria(categoria);
                break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
