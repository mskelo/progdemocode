 /**
 * TINPRO04-4 Les 3 // Lesoefening: Parallel Counter
 * 20240415 // m.skelo@hr.nl
 * Zorg dat je met behulp van parallelle CountThreads zo snel mogelijk tot MAX_COUNT telt.
 * 
 * Stappenplan:
 * 1.) Verdeel de taak in kleinere "brokken" van gelijke grootte
 * 2.) Start net zoveel Threads als dat je "brokken" hebt
 * 3.) Wacht totdat _alle_ Threads klaar zijn. Print _daarna_ pas de waarde van Counter.counter
 */

class Counter {
    public static int counter;

    // Negeer "synchronized" voor nu. Komt les 7-8 voorbij.
    // Als je het weghaalt gedraagt het programma zich raar.
    // Mocht je vooruit willen lopen: probeer uit te zoeken waarom het zich raar gedraagt zonder "synchronized".
    public synchronized void verhoog() { 
        Counter.counter++;
        System.out.println(Counter.counter);

    }
}  

class CountThread extends Thread {
    public Counter counter;
    private int COUNT_PER_THREAD = 10;

    public CountThread(Counter counter, int COUNT_PER_THREAD) {
        this.counter = counter;
        this.COUNT_PER_THREAD = COUNT_PER_THREAD;
    }

    @Override
    public void run() { 
        for (int i=0; i<this.COUNT_PER_THREAD; i++) {
            counter.verhoog();
        }
    }
}

public class App { 
    public static void main(String[] args) {
        final int MAX_COUNT = 5000000;
        final int COUNT_PER_THREAD = 10000;
        Counter c = new Counter();
        /**
         * Dit is te langzaam. Dit kan sneller zonder loop, met parallelle Threads.
         * Nu start dit steeds 1 Thread achter elkaar totdat MAX_COUNT is bereikt.
         * 
         * Dit programma geeft nu ook raar (onverwacht) gedrag. 
         * Probeer te ontdekken wat voor gedrag dit is, en los dit op.
         */
        while (Counter.counter < MAX_COUNT) {
            /**
             * Door steeds hetzelfde Counter Object (Counter c) door te geven, 
             * begint hij _niet_ steeds opnieuw met tellen.
             */
            CountThread ct = new CountThread(c, COUNT_PER_THREAD); 
            ct.start();
            /**
             * sleep() is nodig in deze versie, omdat hij anders een nieuwe Thread start, 
             * terwijl een andere misschien de 500 nog moet bereiken
             * Als je meerdere parallelle Threads gebruikt (ipv achter elkaar zoals nu) is sleep() niet nodig
             */
            try                            { Thread.sleep(10); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        
    }
}
