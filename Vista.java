public class Vista {

    public void mostrarMenu() {
        System.out.println("\n=== MENÚ DEL SISTEMA CMS ===");
        System.out.println("1. Crear contenido");
        System.out.println("2. Mostrar contenidos");
        System.out.println("3. Editar contenido");
        System.out.println("4. Eliminar contenido");
        System.out.println("5. Generar reporte");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarTiposContenido() {
        System.out.println("\nSeleccione el tipo de contenido:");
        System.out.println("1. Artículo");
        System.out.println("2. Video");
        System.out.println("3. Imagen");
        System.out.println("4. Podcast");
        System.out.print("Opción: ");
    }
}
