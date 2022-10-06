package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        throw new UnsupportedOperationException();
    }
    //Oppave 1
    public DobbeltLenketListe(T[] a) {
        throw new UnsupportedOperationException();
    }

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }
    //Oppgave 1
    @Override
    public int antall() { //🤓🤓🤓🤓🤓🤓🤓🤓

        antall = 0;
        for(int Antall1 :/*T?, Liste? Liste<T>? */){ //Det er no way dette er vanskelig, jeg er bare dum
            antall ++;
        }


        return antall;
    }
    //Oppgave 1
    @Override
    public boolean tom() { //😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎


        boolean tom;
        if(antall == 0){
            tom = true;
        }
        else{
            tom = false;
        }

        return tom;
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new UnsupportedOperationException();
    }
    //Oppgave 5
    @Override
    public void leggInn(int indeks, T verdi) {
            /*Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

            indeksKontroll(indeks, true);        // true: indeks = antall er lovlig

            if (indeks == 0)                     // ny verdi skal ligge først
            {
                hode = new Node<>(verdi, hode);    // legges først
                if (antall == 0) hale = hode;      // hode og hale peker på samme node
            }
            else if (indeks == antall)           // ny verdi skal ligge bakerst
            {
                hale = hale.neste = new Node<>(verdi, null);  // legges bakerst
            }
            else
            {
                Node<T> p = hode;                  // p flyttes indeks - 1 ganger
                for (int i = 1; i < indeks; i++) p = p.neste;

                p.neste = new Node<>(verdi, p.neste);  // verdi settes inn i listen
            }

            antall++;                            // listen har fått en ny verdi */
        }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }
    //Oppgave 3
    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }
    //Til oppgave 3
    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }
    //Oppgave 4
    @Override
    public int indeksTil(T verdi) { //Utgangspunkt fra løsningsforslag fra kompendiet Oppgave
        if(verdi == null){
            return -1;
        }
        Node<T> p = hode;

        for (int indeks = 0; indeks < antall; indeks++){
            if (p.verdi.equals(verdi)) return indeks;
            p = p.neste;
        }
        return -1;
    }


    //Oppgave 6
    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) return false;          // ingen nullverdier i listen

        Node<T> q = hode, p = null;               // hjelpepekere

        while (q != null)                         // q skal finne verdien t
        {
            if (q.verdi.equals(verdi)) break;       // verdien funnet
            p = q; q = q.neste;                     // p er forgjengeren til q
        }

        if (q == null) return false;              // fant ikke verdi
        else if (q == hode) hode = hode.neste;    // går forbi q
        else p.neste = q.neste;                   // går forbi q

        if (q == hale) hale = p;                  // oppdaterer hale

        q.verdi = null;                           // nuller verdien til q
        q.neste = null;                           // nuller nestepeker

        antall--;                                 // en node mindre i listen

        return true;                              // vellykket fjerning
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }
    //Oppgave 7
    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }
    //Oppgave 2
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
    //Oppgave 8
    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }
        //Oppgave 8
        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }
        //Oppgave 9
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator
    //Oppgave 10
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


