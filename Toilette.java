public class Toilette {
    
    public void entra(){
        System.out.println(Thread.currentThread().getName()+ " entrato in bagno"); 
        // Thread.currentThread() -> restituisce l'oggetto thread che in quel momento esegue l'istruzione
    }

    public void usa(){
        System.out.println(Thread.currentThread().getName()+ " usa il bagno");
        }

    public void esce(){
        System.out.println(Thread.currentThread().getName()+ " esce dal bagno");
       
    }
}
