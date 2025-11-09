import java.util.List;

public class Administrador extends Usuario {

    public Administrador(String nombre) {
        super(nombre);
    }

    @Override
    public void crearContenido(Contenido contenido) {
        System.out.println("Se creó el contenido: " + contenido.getTitulo() + " por " + contenido.getAutor());
    }

    public void eliminarContenido(List<Contenido> lista, int id) {
        Contenido eliminado = null;
        for (Contenido c : lista) {
            if (c.getId() == id) {
                eliminado = c;
                break;
            }
        }
        if (eliminado != null) {
            lista.remove(eliminado);
            System.out.println("El contenido [ID " + id + "] '" + eliminado.getTitulo() +
                               "' publicado por " + eliminado.getAutor() + " fue eliminado correctamente.");
        } else {
            System.out.println("No se encontró contenido con ID " + id);
        }
    }
}
