import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Controlador controlador = new Controlador();
        Vista vista = new Vista();
        Scanner sc = new Scanner(System.in);

        Administrador admin = new Administrador("Carlos");
        Editor editor = new Editor("María");

        int opcion;
        do {
            vista.mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("=== Crear contenido ===");
                    System.out.println("1. Artículo\n2. Video\n3. Imagen\n4. Podcast");
                    System.out.print("Selecciona tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();

                    switch (tipo) {
                        case 1:
                            System.out.print("Texto del artículo: ");
                            String texto = sc.nextLine();
                            Articulo art = new Articulo(controlador.generarId(), titulo, autor, texto);
                            art.agregarCategoria(categoria);
                            admin.crearContenido(art);
                            controlador.agregarContenido(art);
                            break;
                        case 2:
                            System.out.print("URL del video: ");
                            String url = sc.nextLine();
                            Video vid = new Video(controlador.generarId(), titulo, autor, url);
                            vid.agregarCategoria(categoria);
                            editor.crearContenido(vid);
                            controlador.agregarContenido(vid);
                            break;
                        case 3:
                            Imagen img = new Imagen(controlador.generarId(), titulo, autor);
                            img.agregarCategoria(categoria);
                            admin.crearContenido(img);
                            controlador.agregarContenido(img);
                            break;
                        case 4:
                            System.out.print("Duración del podcast: ");
                            String duracion = sc.nextLine();
                            Podcast pod = new Podcast(controlador.generarId(), titulo, autor, duracion);
                            pod.agregarCategoria(categoria);
                            editor.crearContenido(pod);
                            controlador.agregarContenido(pod);
                            break;
                        default:
                            System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Contenidos publicados ===");
                    controlador.mostrarContenidos();
                    break;

                case 3:
                    System.out.print("\nCategoría a filtrar: ");
                    String cat = sc.nextLine();
                    controlador.filtrarPorCategoria(cat);
                    break;

                case 4:
                    System.out.print("\nID de contenido a editar: ");
                    int idEdit = sc.nextInt();
                    sc.nextLine();
                    Contenido cEdit = controlador.buscarPorId(idEdit);
                    if (cEdit != null) {
                        System.out.print("Nuevo título: ");
                        String nuevoTitulo = sc.nextLine();
                        editor.editarContenido(cEdit, nuevoTitulo);
                    } else {
                        System.out.println("No se encontró contenido con ese ID.");
                    }
                    break;

                case 5:
                    System.out.print("\nID de contenido a eliminar: ");
                    int idDel = sc.nextInt();
                    controlador.eliminarContenido(idDel);
                    break;

                case 6:
                    controlador.generarReporte();
                    break;

                case 0:
                    System.out.println("Saliendo del CMS...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
