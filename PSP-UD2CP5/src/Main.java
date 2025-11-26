
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        ascensor.start();

        Usuario u1 = new Usuario("Usuario 1", 0, 3);
        Usuario u2 = new Usuario("Usuario 2", 2, -1);
        Usuario u3 = new Usuario("Usuario 3", 1, 5);

        ascensor.agregarUsuario(u1);
        ascensor.agregarUsuario(u2);
        ascensor.agregarUsuario(u3);
    }


