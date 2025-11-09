import java.util.List;
public class Administrador extends Usuario {

    public Administrador(String nombre) {
        super(nombre);
    }

    @Override
    public void crearContenido(Contenido contenido) {
        System.out.println("Administrador " + nombre + " creó contenido: " + contenido.getTitulo());
    }

    public void eliminarContenido(List<Contenido> lista, int id) {
        lista.removeIf(c -> c.getId() == id);
        System.out.println("Administrador " + nombre + " eliminó el contenido con ID " + id);
    }
}
