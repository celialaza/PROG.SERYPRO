
    public class VariableCompartida {
        private int v;
        //Indica si se ha establecido un valor para evitar un deadlock.
        private boolean valueSet;

        public VariableCompartida(int v) {
            this.v = v;
            //Inicialmente no hay valor establecido.
            this.valueSet = false;
        }

        public synchronized int getVc( ) {
            //Espera hasta que haya un valor establecido
            while(!valueSet) {
                try {
                    //Espera hasta que el setter notifique.
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int value=v;
            //Marca que el valor haya sido leído
            valueSet = false;


            //Notifica al setter para que continúe
            notifyAll();
            return value;
        }

        public synchronized void setVc(int v) {
            //Espera si el valor anterior no ha sido leído
            while (valueSet) {


                try {
                    //espera hasta que el getter haya leído
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.v = v;
            valueSet = true;//Marca que se ha establecido un valor
            //Notifica al getter para que lea el valor
            notifyAll();
        }

        /*public synchronized void  incVc(){
            this.v++;
        }*/

        @Override
        public String toString() {
            return (""+v);
        }
    }


