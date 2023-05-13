public class App {
    public static void main(String[] args) throws Exception {

        Toilette bagno=new Toilette();
        Semaforo s=new Semaforo(1);
        
        Persona p1=new Persona("topolino", bagno, s);
        Persona p2=new Persona("pippo", bagno, s);
        Persona p3=new Persona("pluto", bagno, s);
        Persona p5=new Persona("paperino", bagno, s);
        Persona p4=new Persona("rana", bagno, s);

        p1.start();p2.start();p3.start();p4.start();p5.start();

       
        
    }
}
