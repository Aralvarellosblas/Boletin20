package ejercicio20;

import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class Ejercicio20{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Libreria li=new Libreria();
        li.crearLibreria();
        int x;
        do{
            x=Integer.parseInt(JOptionPane.showInputDialog("Selecciona:\n"
                    +"1-- Añadir libro\n"
                    +"2-- Consultar Fichero\n"
                    +"3-- Buscar Libro\n"
                    +"4-- Borrar libros con 0 unidades\n"
                    +"5-- Cambiar precio\n"
                    +"0-- Para salir"));
            switch(x){
                case 1:
                    li.añadirLibro();
                    li.guardarLibros();
                    break;
                case 2:
                    li.visualizarLibros();
                    break;
                case 3:
                    li.buscarLibro();
                    break;
                case 4:
                    li.borrarLibros();
                    break;
                case 5:
                    li.cambiarPrecio();
                    li.guardarLibros();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Seleccion Incorrecta");
            }
        }while(x!=0);

    }

}
