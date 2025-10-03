public class Hebra implements Runnable{
    private char caracter;
    public Hebra(char c) {
        this.caracter = c;
    }


    @Override
    public void run() {
        System.out.println("Hebra " +caracter);
        System.out.println("Hebra " +caracter);
        System.out.println("Hebra " +caracter);
    }
}
