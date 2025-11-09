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

                    switch (tipo) {
                        case 1: // Artículo
                            System.out.print("Texto del artículo: ");
                            String texto = sc.nextLine();
                            Articulo art = new Articulo(controlador.generarId(), titulo, autor, texto);
                            controlador.agregarContenido(art);
                            break;
                        case 2: // Video
                            System.out.print("URL del video: ");
                            String url = sc.nextLine();
                            Video vid = new Video(controlador.generarId(), titulo, autor, url);
                            controlador.agregarContenido(vid);
                            break;
                        case 3: // Imagen
                            Imagen img = new Imagen(controlador.generarId(), titulo, autor);
                            controlador.agregarContenido(img);
                            break;
                        case 4: // Podcast
                            System.out.print("Duración: ");
                            String duracion = sc.nextLine();
                            Podcast pod = new Podcast(controlador.generarId(), titulo, autor, duracion);
                            controlador.agregarContenido(pod);
                            break;
                        default:
                            System.out.println("Tipo no válido.");
                    }
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

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
