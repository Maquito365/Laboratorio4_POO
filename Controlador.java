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
}