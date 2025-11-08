package modelo;

public class Editor extends Usuario {

    public Editor(String nombre) {
        super(nombre);
    }

    @Override
    public void crearContenido(Contenido contenido) {
        System.out.println("Editor " + nombre + " creó contenido: " + contenido.getTitulo());
    }

    public void editarContenido(Contenido contenido, String nuevoTitulo) {
        contenido.setTitulo(nuevoTitulo);
        System.out.println("Editor " + nombre + " editó el título a: " + nuevoTitulo);
    }
}
