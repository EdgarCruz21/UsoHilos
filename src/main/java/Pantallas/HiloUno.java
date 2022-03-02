package Pantallas;

public class HiloUno {
}

class NumerosHilos extends Thread {

    int numeroInicial;

    public NumerosHilos(int unNumero) {
        numeroInicial = unNumero;
    }

    public void run() {
        for (int i = numeroInicial; i < 25; i++) {
            System.out.println(getName());
            Principal.mostrarNumero(i);
            if (i == 999) {
                i = numeroInicial;
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException w) {
                Principal.detener(Principal.t);
            }
        }
    }
}

class NumerosHilos2 extends Thread {

    int numeroInicial;
    Thread hilo;

    public NumerosHilos2(int unNumero, Thread hilo) {
        numeroInicial = unNumero;
        this.hilo = hilo;
    }

    public void run() {
        try {
            hilo.join();
        } catch (InterruptedException e) {
        }
        for (int i = numeroInicial; i < 999999999; i++) {
            System.out.println(getName());
            Principal.mostrarNumero2(i);
            if (i == 999) {
                i = numeroInicial;
            }

        }
    }
}
