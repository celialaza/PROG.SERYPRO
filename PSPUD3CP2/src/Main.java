
public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando 3 clientes de chat...");


        ClienteChat cliente1 = new ClienteChat("Cliente1");
        ClienteChat cliente2 = new ClienteChat("Cliente2");
        ClienteChat cliente3 = new ClienteChat("Cliente3");


        Thread t1 = new Thread(cliente1);
        Thread t2 = new Thread(cliente2);
        Thread t3 = new Thread(cliente3);

        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los clientes finalizaron.");
    }
}