public class Video extends Contenido{
    private String url;

    public Video(int id, String titulo, String autor, String url){
        super(id,titulo,autor);
        this.url = url;
    }

    @Override
    public void publicar(){
        System.out.println("Video Publicado: "+ titulo);
    }

    @Override
    public void visualizar(){
        System.out.println("--VIDEO--");
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("URL: "+ url);
        System.out.println("Categorias: "+ categorias)
    }
}