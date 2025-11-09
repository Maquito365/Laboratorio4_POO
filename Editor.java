public class Editor extends Usuario {

    public Editor(String nombre) {
        super(nombre);
    }

    @Override
    public void crearContenido(Contenido contenido) {
        System.out.println("Se creó el contenido: " + contenido.getTitulo() + " por " + contenido.getAutor());
    }

    public void editarContenido(Contenido contenido, String nuevoTitulo) {
        int id = contenido.getId();
        String autor = contenido.getAutor();
        contenido.setTitulo(nuevoTitulo);
        System.out.println("El autor " + autor + " editó su contenido [ID " + id + "] y cambió el título a: " + nuevoTitulo);
    }
}
