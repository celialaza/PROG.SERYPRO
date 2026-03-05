public class CifradorPersonalizado {

    /**
     * Método para cifrar: suma el índice de la posición al carácter.
     * @param mensaje Texto original (texto plano).
     * @return Texto transformado (texto cifrado).
     */
    public String cifrar(String mensaje) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            // Aplicamos el algoritmo: carácter + posición actual
            char cifrado = (char) (caracter + i);
            resultado.append(cifrado);
        }

        return resultado.toString();
    }

    /**
     * Método para descifrar: resta el índice de la posición al carácter.
     * @param mensaje Texto cifrado.
     * @return Texto recuperado (texto plano).
     */
    public String descifrar(String mensaje) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            // Operación inversa: carácter - posición actual
            char descifrado = (char) (caracter - i);
            resultado.append(descifrado);
        }

        return resultado.toString();
    }


}