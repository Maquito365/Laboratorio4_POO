import modelo.*;
import controlador.*;
import vista.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ControladorCMS controlador = new ControladorCMS();
        VistaCMS vista = new VistaCMS();

        Administrador admin = new Administrador("Carlos");
        Editor editor = new Editor("María");

        // Crear contenidos
        Articulo art = new Articulo(controlador.generarId(), "Polimorfismo en Java", "María", "El polimorfismo permite...");
        Video vid = new Video(controlador.generarId(), "Tutorial MVC", "Carlos", "https://video.com/mvc");
        Imagen img = new Imagen(controlador.generarId(), "Logo universidad", "Carlos");
        Podcast pod = new Podcast(controlador.generarId(), "Entrevista sobre programación", "María", "25 min");

        art.agregarCategoria("Programación");
        vid.agregarCategoria("Educativo");
        img.agregarCategoria("Institucional");
        pod.agregarCategoria("Tecnología");

        admin.crearContenido(art);
        editor.crearContenido(vid);
        admin.crearContenido(img);
        editor.crearContenido(pod);

        controlador.agregarContenido(art);
        controlador.agregarContenido(vid);
        controlador.agregarContenido(img);
        controlador.agregarContenido(pod);

        System.out.println();
        controlador.mostrarContenidos();

        System.out.println("\n--- Editando contenido ---");
        editor.editarContenido(art, "Polimorfismo en Java (Actualizado)");

        System.out.println("\n--- Eliminando contenido ---");
        admin.eliminarContenido(Arrays.asList(art, vid, img, pod), 3); // simulado
        controlador.eliminarContenido(3);

        System.out.println("\n--- Reporte ---");
        controlador.generarReporte();
    }
}
