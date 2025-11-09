public class Podcast extends Contenido {
    private String duracion;

    public Podcast(int id, String titulo, String autor, String duracion) {
        super(id, titulo, autor);
        this.duracion = duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public void publicar() {
        System.out.println("Podcast publicado: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println("=== PODCAST ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Duración: " + duracion);
        System.out.println("Categorías: " + categorias);
    }
}
