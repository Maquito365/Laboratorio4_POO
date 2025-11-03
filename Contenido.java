import java.util.ArrayList;
import java.util.List;

public abstract class Contenido implements Publicable{
    protected int id;
    protected String titulo;
    protected String autor;
    protected List<String> categorias;

    public Contenido(int id, String titulo, String autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categorias = new ArrayList<>();
    }

    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }

    public void setTitulo(String nuevoTitulo){
        this.titulo = nuevoTitulo;
    }
    public void agregarCategoria(String categoria){
        categorias.add(categoria);
    }
    public List<String> getCategorias(){
        return categorias;
    }

    @Override
    public abstract void publicar();

    @Override
    public abstract void visualizar();
}