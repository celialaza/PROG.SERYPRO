import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread {
    private List<Integer> lista;

    Nodo(List<Integer> lista) {
        this.lista = lista;
    }
    public List<Integer> getLista() {
        return this.lista;
    }

    @Override
    public void run() {
        // Caso base: la lista tiene 1 o 0 elementos, ya está ordenada.
        if (this.lista.size() <= 1) { //
            return;
        }

        // Caso recursivo: la lista tiene más de 1 elemento
        List<Integer> leftList;
        List<Integer> rightList;

        // 1. Dividir la lista en dos mitades
        int mitad = this.lista.size() / 2;
        // Usamos subList  para crear las nuevas listas
        leftList = new ArrayList<>(this.lista.subList(0, mitad));
        rightList = new ArrayList<>(this.lista.subList(mitad, this.lista.size()));

        // 2. Crear dos hebras hijas
        Nodo leftNodo = new Nodo(leftList);
        Nodo rightNodo = new Nodo(rightList);

        // 3. Iniciar las hebras hijas
        leftNodo.start();
        rightNodo.start();

        // 4. Esperar a que las hebras hijas terminen (ordenen sus mitades)
        try {
            leftNodo.join();
            rightNodo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. Mezclar las dos mitades ya ordenadas
        // Pasamos las listas que han sido ordenadas por las hebras hijas
        mezcla(leftNodo.lista, rightNodo.lista); //
    }

    /**
     * Mezcla dos listas ordenadas (leftList y rightList) en la lista
     * principal de este nodo (this.lista).
     */
    private void mezcla(List<Integer> leftList, List<Integer> rightList) {
        // 1. Vaciar la lista actual para rellenarla con los datos ordenados
        this.lista.clear();

        // 2. Inicializar índices para recorrer las sublistas
        int i = 0;
        int j = 0;

        // 3. Comparar y añadir el elemento más pequeño de cualquiera de las listas
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) <= rightList.get(j)) {
                this.lista.add(leftList.get(i));
                i++;
            } else {
                this.lista.add(rightList.get(j));
                j++;
            }
        }

        // 4. Añadir los elementos restantes de la lista izquierda (si los hay)
        while (i < leftList.size()) {
            this.lista.add(leftList.get(i));
            i++;
        }
        // 5. Añadir los elementos restantes de la lista derecha (si los hay)
        while (j < rightList.size()) {
            this.lista.add(rightList.get(j));
            j++;
        }
    }
}