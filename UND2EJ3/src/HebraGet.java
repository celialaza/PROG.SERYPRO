public class HebraGet implements Runnable {
        public VariableCompartida vc;
        public HebraGet(VariableCompartida vc){
            this.vc = vc;
        }



        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                int nuevovalor=vc.getVc();
                System.out.println("Nuevo valor con get: "+nuevovalor);
            }

        }}


