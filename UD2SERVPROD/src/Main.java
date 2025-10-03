

/* La justificación de que se mezclen las letras y salgan cada vez que se ejecuta el programa
en orden distintos es que con la teoría de los hilos, las tres hebras ("tareas") se realizan simultáneamente,
 y es el sistema operativo el que se encarga de alternarlas para optimizar los recursos.
 */
public static void main(String[] args){
    Hebra h1=new Hebra('a');
    Hebra h2=new Hebra('b');
    Hebra h3=new Hebra('c');
    Thread t1=new Thread(h1);
    Thread t2=new Thread(h2);
    Thread t3=new Thread(h3);
    t1.start();
    t2.start();
    t3.start();
    System.out.println("El método main ha finalizado");

    }

