public class Articulo extendens Contenido{
    private String texto;

    public Articulo(int id, String titulo, String autor, String texto){
        super(id,titulo,autor);
        this.texto = texto;
    }

    public void setTexto(String texto){
        return texto;
    }

    @Override
    public void publicar(){
        System.out.println("Articulo publicado: "+ titulo);
    }

    @Override
    public void visualizar(){
        System.out.println("--ARTICULO--");
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Texto: "+ texto);
        System.out.println("Categorias: "+ categorias);

    }

}