public class Imagen extends Contenido{
    
    public Imagen(int id, String titulo, String autor){
        super(id,titulo,autor);
    }

    @Override
    public void publicar(){
        System.out.println("Imagen subida: "+ titulo);
    }

    @Override
    public void visualizar(){
        System.out.println("--IMAGEN--");
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Categorias: "+ categorias);
        System.out.println("[ESTO ES UNA IMAGEN 100%]");
    }
}