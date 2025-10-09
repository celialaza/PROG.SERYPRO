public class HebraSet implements Runnable{
    public VariableCompartida vc;
    public HebraSet(VariableCompartida vc){
        this.vc = vc;
    }



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            vc.setVc(i);
            System.out.println("Valor asignado con set: "+vc);
        }


    }}



