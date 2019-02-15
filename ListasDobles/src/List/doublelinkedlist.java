
package List;
// Mario David González Contreras y Jesús Moreno Arteaga  
import Excepciones.isEmptyException;
import Node.Node;
import java.util.Iterator;

/**
 *
 * @author icarnegie16
 */
public class doublelinkedlist<T extends Comparable<T>> implements Iterable<T>, Comparable<T> {

    private Node<T> head, tail;
    private long length;

    public doublelinkedlist() {
        head = new Node<>();
        tail = new Node<>();
        length = 0;
    }

    public doublelinkedlist(T value) {
        this();
        Node<T> _new = new Node<>(value);
        head.setNext(_new);
        tail.setBack(_new);
        length++;
    }

    public doublelinkedlist(Node<T> node) {
        this(node.getValue());
    }

    //  METODOS ---------------------------------------
    public boolean add(T value) {
        Node<T> _new = new Node<>(value);
        if (_new == null) {
            return false;
        }
        try {
            isEmpty();
            Node<T> tmp = tail.getBack();
            tmp.setNext(_new);
            _new.setBack(tmp);
            tail.setBack(_new);

        } catch (isEmptyException ee) {
            head.setNext(_new);
            tail.setBack(_new);

        }
        length++;
        return true;
    }

    public boolean add(Node<T> node) {
        return add(node.getValue());
    }

    private boolean isThere(Node<T> node, T value) {
        if (node.getNext() == null) {
            return false;
        } else if (node.getNext().getValue().equals(value)) {
            return true;
        }

        return isThere(node.getNext(), value);
    }

    private Node<T> isThereNode(Node<T> node, T value) {
        if (node.getNext() == null) {
            return null;
        } else if (node.getNext().getValue().equals(value)) {
            return node.getNext();
        }
        return isThereNode(node.getNext(), value);
    }

    public boolean removeAll(T value) {
        boolean flag = false;
        try {
            isEmpty();
            while (isThere(head, value)) {
                remove(value);
                flag = true;
            }
            return flag;
        } catch (isEmptyException e) {
            return flag;
        }
    }

    public boolean remove(T value) {
        try {
            isEmpty();
            Node<T> tmp = getPrevElement(head, value);
            if (tmp != null) {
                if (tmp.getNext().getNext() == null && tmp.getNext().getBack() == null) {//es el unico
                    head.setNext(null);
                    tail.setBack(null);
                } else if (tmp.getNext().getBack() == null) { //primero de la lista
                    tmp.getNext().getNext().setBack(null);
                    head.setNext(tmp.getNext().getNext());
                } else if (tmp.getNext().getNext() == null) {      //ultimo de la lista
                    tmp.setNext(null);
                    tail.setBack(tmp);
                } else {
                    tmp.setNext(tmp.getNext().getNext());
                    tmp.getNext().setBack(tmp);
                }
                length--;
                System.gc(); //llamamos al
                return true;
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }
    }

    private Node<T> getPrevElement(Node<T> node, T value) {
        if (node.getNext() == null) {
            return null;
        }
        if (node.getNext().getValue().equals(value)) {
            return node;
        } else {
            return getPrevElement(node.getNext(), value);
        }
    }

    public boolean remove(Node<T> node) {
        return remove(node.getValue());
    }

    
    /*Métodos de search... ya no
=======
    /*Metoodos search ya no
>>>>>>> f53c9f8 Equipo de: Mario David González Contreras y Jesús Moreno Arteaga
    //search encuentra el nodo y regresa el nodo buscando por el inicio
    private boolean search(Node<T> head) {return false;}

    //search encuentra el nodo y regresa el nodo buscando por el final
<<<<<<< Upstream, based on origin/master
    private boolean rsearch(Node<T> tail) {return false;}
    */
    public boolean addAt(T value, int position) {
        try {
            isEmpty();
            Node<T> tmp = getElementAt(position);
            tmp.setValue(value);
        } catch (Exception e) {
        }
        return false;
    }   // ------------------ TAREA OK OK OK    

    public boolean addAt(Node<T> node, int position) {
        return addAt(node.getValue(),position);
        
    }   // ------------------ TAREA OK OK OK

    public boolean addAfter(T after, T value) {
        try {
            isEmpty();
            Node<T> _new = new Node<>(value);
            Node<T> tmp = isThereNode(head, after);

            if (tmp.getNext() == null) {
                add(_new);
                length++;
                return true;
            } else {
                _new.setNext(tmp.getNext());
                tmp.getNext().setBack(_new);
                tmp.setNext(_new);
                _new.setBack(tmp);
                length++;
                return true;
            }

        } catch (isEmptyException e) {
            return false;
        }

    }   // ------------------ TAREA   OK OK OK

    public boolean addBefore(T before, T value) {
        try {
            isEmpty();
            Node<T> tmp = isThereNode(head, before);
            if (tmp == null) {
                return false;
            } else {
                Node<T> _node = new Node<T>(value);
                if (tmp.getBack() == null) { //es el inicio de la lista

                    tmp.setBack(_node);
                    head.setNext(_node);
                    _node.setNext(tmp);
                    //_node.setBack(null);
                } else {
                    tmp.getBack().setNext(_node);
                    _node.setBack(tmp.getBack());
                    tmp.setBack(_node);
                    _node.setNext(tmp);
                }
                length++;
                return true;
            }
        } catch (isEmptyException w) {
            return false;
        }
    }

    public boolean removeAfter(T value) {
        try {
            isEmpty();
            Node<T> tmp = isThereNode(head, value);
            if (tmp != null && tmp.getNext() != null) {
                return removeFrom(tmp);
            } else {
                return false;
            }

        } catch (isEmptyException e) {
            return false;
        }
    }

    private boolean removeFrom(Node<T> node) {
        Node<T> tmp = node;
        if (tmp.getNext() == null) {
            return false;
        } else {
            if (tmp.getNext().getNext() == null) {
                tmp.setNext(null);
                tail.setBack(tmp);

            } else {
                tmp.setNext(tmp.getNext().getNext());
                tmp.getNext().setBack(tmp);
            }
            return true;
        }
    }

    public boolean removeBefore(T value) {
 try {
            isEmpty();
            Node<T> tmp = new Node<>(value);
            Node<T> tmp1 = getPrevElement(head, value);
            if (isThere(head, value)) {
                if (tmp.getBack() == null) {  // si es el primero en la lista
                    return false;
                } else if(tmp.getBack().getBack()==null) {
                    tmp.setBack(null);
                    remove(getPrevElement(head, value));
                    tmp.setNext(tmp);
                    return true;
                }else{
                    tmp.setBack(tmp1.getBack());
                    remove(getPrevElement(head, value));
                    tmp1.getBack().setNext(tmp);
                return true;
                }
            } else {
                return false;
            }
        } catch (isEmptyException e) {
            return false;
        }
    }    // ------------------ TAREA  OK OK OK

    public boolean addStart(T value) {
        try {
            isEmpty();
            Node<T> tmp = new Node<>(value);
            //Node<T> tmp1 = getPrevElement(head, value);
            head.getNext().setBack(tmp);
            tmp.setNext(head.getNext());
            head.setNext(tmp);
            tmp.setBack(head);
            return true;
        } catch (isEmptyException e) {
            return false;
        }
    }   // ------------------ TAREA  OK OK OK

    public boolean addStart(Node<T> node) {
        return addStart(node.getValue());
    }

    public Node<T> getElementAt(int position) {
        try {
            isEmpty();

            Node<T> tmp = head.getNext();
            T tmp1 = null;
            int cont = 0;
            if (position >= length) {
                System.err.println("Posición inexistente");
                return null;
            }
                
            for (cont = 0; cont < position - 1; cont++) {
                tmp = tmp.getNext();
                tmp1 = tmp.getValue();
                tmp.setValue(tmp1);
            }
            System.out.println("El valor en esa posición es: " + tmp.getValue());
            return tmp;
        } catch (Exception e) {
        }

        return null;
    }   // ------------------ TAREA OK OK OK

    public boolean isEmpty() throws isEmptyException {  //saber si la lista esta lleno o no
        if (head.getNext() == null) {
            throw new isEmptyException("La lista esta vacia");
        } else {
            return true;
        }
    }

    public long length() {
        return this.length();
    }

    //imprimir al reves
    public void rprint() {
        rprint(tail);
    }

    private void rprint(Node<T> node) {
        if (node.getBack() == null) {
            return;
        } else {
            System.out.println(node.getBack().getValue());
        }
        rprint(node.getBack());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cpy = head.getNext(), sub_head;

            @Override
            public boolean hasNext() {
                if (cpy == null) {
                    return false;
                } else {
                    sub_head = cpy;
                    cpy = cpy.getNext();
                    return true;

                }

            }

            @Override
            public T next() {
                return sub_head.getValue();
            }
        };
    }

    @Override
    public int compareTo(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
