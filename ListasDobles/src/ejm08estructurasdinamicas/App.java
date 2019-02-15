
package ejm08estructurasdinamicas;
// Mario David González Contreras y Jesús Moreno Arteaga
import List.doublelinkedlist;
import Node.Node;


public class App {

    //static LinkedList <Double> dobles = new LinkedList<>();
    static doublelinkedlist<Double> dobles = new doublelinkedlist<>();

    public static void fill(int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dobles.add((Double) Math.abs(Math.floor(Math.random() * (n - m + 1) + m)));
            }

        }
    }

    public static void main(String[] args) {

        //LinkedList<Double> dobles = new LinkedList<>();
        dobles.add(23d);
        dobles.add(8d);
        dobles.add(12d);
        dobles.add(34d);
        dobles.add(77d);
        dobles.add(74d);
        //dobles.removeAfter(17d);
        //dobles.addAfter(18d,18d);
        //dobles.rprint();
        
        
        // ------ T A R E A ------
        //dobles.addAfter(74d, 5d);     // --------- TAREA

        //dobles.removeBefore(23d);     // --------- TAREA
        // dobles.addStart(13d);           // --------- TAREA
        /*Node<Double> nodo = new Node<Double>();
        nodo.setValue(18d);
        dobles.addStart(nodo); */         // --------- TAREA   

        dobles.removeBefore(8d);     // --------- TAREA
        //dobles.addStart(13d);           // --------- TAREA
        //Node<Double> nodo = new Node<Double>();
        //nodo.setValue(18d);
        //dobles.addStart(nodo);          // --------- TAREA   

        //dobles.getElementAt(4);          // --------- TAREA
        //dobles.addAt(36d);             // --------- TAREA
        
        /*
        if(dobles.removeBefore(461d))
            System.out.println("Se borro el valor");
        else
            System.out.println("No se puede");
         */
        //dobles.remove(50d);
        //dobles.removeAll(9d);

        //Node<Double> nodo = new Node<Double>();
        //nodo.setValue(18d);
        //dobles.add(nodo);
        //fill(1,2000);
        
        for (Double object : dobles) {   // imprimir la lista
            System.out.println(object);

        }

    }

}
