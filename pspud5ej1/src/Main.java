
public static void main(String[] args) {
    CifradorPersonalizado app = new CifradorPersonalizado();
    Scanner teclado = new Scanner(System.in);

    System.out.println("--- CIFRADOR PERSONALIZADO ---");
    System.out.print("Introduce el mensaje que deseas proteger: ");

    String original = teclado.nextLine();


    String textoCifrado = app.cifrar(original);
    String textoDescifrado = app.descifrar(textoCifrado);

    System.out.println("\n-----------------------------------");
    System.out.println("Texto Original:  " + original);
    System.out.println("Texto Cifrado:   " + textoCifrado);
    System.out.println("Texto Recuperado: " + textoDescifrado);
    System.out.println("-----------------------------------");

    teclado.close();
}