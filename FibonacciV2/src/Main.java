//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    public static void main(String[] args) {

        int N = 10;


        System.out.println("Número de Fibonacci a calcular: " + N);

        //Creamos la hebra "final"
        Hebra hebraN = new Hebra(N);

        //La iniciamos. Esto desencadenará la creación recursiva.
        hebraN.start();

        try {
            // El hilo principal (main) espera a que la hebraN termine.
            // Usamos join() para una espera eficiente (bloqueante).
            hebraN.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Cuando hebraN ha terminado, imprimimos su valor final
        System.out.println("**");
        System.out.println("**");
        System.out.println("FIBONACCI " + N + ": " + hebraN.getValorPropio());
    }


