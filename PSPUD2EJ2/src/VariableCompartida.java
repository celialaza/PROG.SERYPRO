public class VariableCompartida {
private int v;

    public VariableCompartida(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
    public void incV(){
        this.v++;
    }

    @Override
    public String toString() {
        return "VariableCompartida{" +
                "v=" + v +
                '}';
    }
}
