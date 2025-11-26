import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        double valor = Math.random() * 100;
        int total = (int) valor;
        for (int i = 0; i < total; i++) {
            double num = Math.random() * 100;
            int numero = (int) num;
            lista.add(numero);
        }
        System.out.println(lista);
        Nodo n1 = new Nodo(lista);
        n1.start();
        try {
            n1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(n1.getLista());
    }
}