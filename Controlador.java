import java.util.*;

public class Controlador {
    private List<Contenido> contenidos = new ArrayList<>();
    private int contadorId = 1;

    public int generarId() {
        return contadorId++;
    }

    public void agregarContenido(Contenido c) {
        contenidos.add(c);
        System.out.println("[ID " + c.getId() + "] " + c.getClass().getSimpleName() +
                           " publicado: " + c.getTitulo() + " por " + c.getAutor());
    }

    public void mostrarContenidos() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos publicados.");
            return;
        }
        for (Contenido c : contenidos) {
            System.out.println("ID: " + c.getId());
            c.visualizar();
            System.out.println("-----------------------");
        }
    }

    public void filtrarPorCategoria(String categoria) {
        System.out.println("Filtrando por categoría: " + categoria);
        for (Contenido c : contenidos) {
            if (c.getCategorias().contains(categoria)) {
                c.visualizar();
            }
        }
    }

    public Contenido buscarPorId(int id) {
        for (Contenido c : contenidos) {
            if (c.getId() == id) return c;
        }
        return null;
    }
    public void eliminarContenido(int id) {
    Contenido eliminado = buscarPorId(id);
    if (eliminado != null) {
        contenidos.remove(eliminado);
        System.out.println("El contenido [ID " + id + "] '" + eliminado.getTitulo() +
                           "' publicado por " + eliminado.getAutor() + " fue eliminado correctamente.");
    } else {
        System.out.println("No se encontró contenido con ID " + id);
    }
}

    public void generarReporte() {
        System.out.println("=== REPORTE DE CONTENIDOS ===");
        System.out.println("Total contenidos: " + contenidos.size());
        long articulos = contenidos.stream().filter(c -> c instanceof Articulo).count();
        long videos = contenidos.stream().filter(c -> c instanceof Video).count();
        long imagenes = contenidos.stream().filter(c -> c instanceof Imagen).count();
        long podcasts = contenidos.stream().filter(c -> c instanceof Podcast).count();

        System.out.println("Artículos: " + articulos);
        System.out.println("Videos: " + videos);
        System.out.println("Imágenes: " + imagenes);
        System.out.println("Podcasts: " + podcasts);
    }

}