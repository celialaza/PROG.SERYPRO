public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce el mensaje que Ana quiere enviar a Bernardo: ");
    String mensaje = sc.nextLine();

    System.out.print("Introduce la clave simétrica (entero): ");
    int clave = sc.nextInt();

    CifradoSimetrico cifradorAna = new CifradoSimetrico(clave);
    CifradoSimetrico cifradorBernardo = new CifradoSimetrico(clave);

    Ana ana = new Ana(cifradorAna);
    Bernardo bernardo = new Bernardo(cifradorBernardo);
    Atacante atacante = new Atacante();
    CanalInseguro canal = new CanalInseguro(atacante);

    // Ana cifra y envía
    String mensajeCifrado = ana.enviarMensaje(mensaje);
    String mensajeQueLlega = canal.enviar(mensajeCifrado);

    // Bernardo recibe y descifra
    bernardo.recibirMensaje(mensajeQueLlega);

    sc.close();
}