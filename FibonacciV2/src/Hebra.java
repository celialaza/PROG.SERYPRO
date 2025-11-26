
    public class Hebra extends Thread {

        private int n;
        private Hebra hebraAnterior;

        private long valorPropio;   // Almacenará F(n)
        private long valorAnterior; // Almacenará F(n-1)

        public Hebra(int n) {
            this.n = n;
        }


        @Override
        public void run() {
            // Casos especiales (base) para 0 y 1
            if (n == 0) {
                valorPropio = 0;
                valorAnterior = 0; // No hay F(-1), pero asignamos 0
            } else if (n == 1) {
                valorPropio = 1;
                valorAnterior = 0; // El F(0) es 0
            } else {
                //Creación recursiva de la hebra anterior
                hebraAnterior = new Hebra(n - 1);
                hebraAnterior.start();

                //Espera activa
                while (hebraAnterior.isAlive()) {

                }

                //Cálculo del término i-ésimo
                // Cuando la hebra anterior (i-1) ha muerto, podemos pedirle sus valores.
                // La hebra i-ésima usa los valores de i-1 e i-2

                // El valor propio de (n-1) es F(n-1)
                long f_n_menos_1 = hebraAnterior.getValorPropio();

                // El valor anterior de (n-1) es F(n-2)
                long f_n_menos_2 = hebraAnterior.getValorAnterior();

                // Calculamos nuestros propios valores
                this.valorPropio = f_n_menos_1 + f_n_menos_2;
                this.valorAnterior = f_n_menos_1; // Guardamos F(n-1) para la hebra siguiente

                System.out.println("Fibonacci " + n + ": " + this.valorPropio);
            }
        }

        // Getters para que otras hebras puedan obtener los resultados
        public long getValorPropio() {
            return valorPropio;
        }

        public long getValorAnterior() {
            return valorAnterior;
        }
    }

