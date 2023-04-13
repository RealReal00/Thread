//primo metodo per creare i thread
public class StartStopThread extends Thread {
    public boolean running = true;// variabile booleana che si usa per interrompere l'esecuzione dentro al thread

    public StartStopThread(String name) {//costruttore che chiama il costruttore della classe genitore

        super(name);
    }

    @Override
    public void run() {//stampa il nome del thread
        System.out.println(Thread.currentThread().getName() + " started");
        while (running) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " terminated");
    }

    public static void main(String[] args) {
        StartStopThread a = new StartStopThread("Homer");
        StartStopThread b = new StartStopThread("Marge");


        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);

        a.start();
        b.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {

        }

        // Graceful shutdown!
        a.running = false;// serve per terminare i thread
        b.running = false;

        // Ungraceful shutdown!
        // a.interrupt();
        // b.interrupt();
    }
}
