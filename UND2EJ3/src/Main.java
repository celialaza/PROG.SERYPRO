public static void main(String[] args){
    VariableCompartida vc=new VariableCompartida(0);

    HebraSet h1=new HebraSet(vc);
    HebraGet h2=new HebraGet(vc);

    Thread t1=new Thread(h1);
    Thread t2=new Thread(h2);

    t1.start();
    t2.start();

    /*Se usan t1.join() y t2.join() para que el main espere a que ambas hebras
     terminen antes de mostrar el valor final de v. */

    /*try{
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }*/

}