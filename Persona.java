/**
 * La classe Persona e' un thread che utilizza una variabile condivisa Toilette 
 * il cui accesso e' regolamentato da un semaforo esplicito
 */

public class Persona extends Thread{
    private Toilette bagno;
    private Semaforo s;

    /**
     * Costrutturoe con Parametri
     * @param name Il nome da assegnare alla persona
     * @param bagno La Toilette (risorsa condivisa)
     * @param s Il semaforo condiviso con gli altri thread per sincronizzare l'accesso al bagno
     */
    public Persona(String name, Toilette bagno, Semaforo s) {
        super(name); 
        this.bagno = bagno;
        this.s=s;
    }


  /**
   * Ogni Thread Persona prova ad utilizzare il bagno.
   * Controllare il semaforo prima di entrare, in caso di ROSSO allora attendere
   */
    public void run(){

        long tempoRicercaBagno = (int) (Math.random() * 5000) + 1;
        long tempoUtilizzo = (int) (Math.random() * 5000) + 1;
        try {
          Thread.sleep(tempoRicercaBagno);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("A " +this.getName()+ " gli scappa la pipì e va in bagno");
        
        // PRIMA DI ENTRARE IN BAGNO VERIFICO IL SEMAFORO
        s.P();
        bagno.entra();
        bagno.usa();
        try {
            Thread.sleep(tempoUtilizzo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bagno.esce();
        s.V();
        /*APPENA IL THREAD FINISCE DI USARE LA RISORSA, RICHIAMA LA PRIMITIVA V() DEL SEMAFORO
        RIPORTA IL SEMAFORO A VERDE, E SVEGLIA EVENTUALI THREAD CHE SONO IN CODA */
        


    }
}
