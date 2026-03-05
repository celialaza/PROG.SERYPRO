public class CifradoSimetrico {
    private int clave;

    public CifradoSimetrico(int clave) {
        this.clave = clave;
    }

    public String cifrar(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                resultado.append((char) ((caracter - base + clave) % 26 + base));
            } else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }

    public String descifrar(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                resultado.append((char) ((caracter - base - (clave % 26) + 26) % 26 + base));
            } else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
}

