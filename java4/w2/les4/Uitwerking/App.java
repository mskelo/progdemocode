/**
 * TINPRO04-4 Les 4 // Threads stoppen
 * 20240422 // m.skelo@hr.nl
 * 
 * Hieronder worden de Threads Foo, Bar en Baz op drie verschillende manieren gestopt.
 * Alleen kan de code van de threads zelf daar nog niet mee omgaan, en crasht dit.
 * 
 * Pas de code van de drie classes aan zodat het programma niet meer crasht.
 * Sommige moeten hier geschreven worden, andere in de betreffende class.
 * Regels met `//TODO` moeten ingevuld worden.
 */

  public class App {
    public static void main(String[] args) {
        try {
            Thread foo = new Foo();
            Thread bar = new Bar();
            Thread baz = new Baz();

            foo.start();
            //** 1. - Stop Thread Foo met behulp van interrupt()
            foo.interrupt();

            //** Wacht totdat Thread foo klaar is
            foo.join();

            bar.start();
            //** 2. - Stop Thread Bar met behulp van een boolean flag
            // TODO: Ga naar Bar.java

            //** Wacht nu totdat Thread bar klaar is
            bar.join();

            baz.start();
            //** 3. - Stop Thread Baz door hem het einde van run() te laten bereiken
            //**      op een andere creatieve manier.
            // TODO: Verzin zelf een manier: hier en/of in Baz.java

            //** Wacht weer totdat Thread baz klaar is
            baz.join();

        // = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = //

            //** BONUS - Stop onderstaande thread met Thread.stop() (DEPRECATED)
            //**         Wat schreeuwt de compiler naar je als je dat doet?
            Thread f00 = new Foo();
            f00.stop();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}