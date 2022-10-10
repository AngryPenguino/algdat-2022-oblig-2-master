package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


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
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }
    //Oppave 1
    public DobbeltLenketListe(T[] a) {
        //Test
        this(); //Starter konstruktøren over ^. "DobbeltLenketListe()"
        Objects.requireNonNull(a, "a er null, det kan den ikke være"); //Verdiene kan ikke være null

        hode = hale = new Node<>(null); //Kommentar
        for(T verdi : a){
            if(verdi != null){
                hale = hale.neste = new Node<>(verdi, hale, null); //Hvis verdien ikke er null, legger til en ny node på enden av listen
                antall++; //Øker telleren for antallet i listen
            }
        }
        if(antall == 0){
            hode = hale = null;
        }
        else{
            (hode = hode.neste).forrige = null;
        }

    }
    //Oppgave 1
    @Override
    public int antall() { //🤓🤓🤓🤓🤓🤓🤓🤓

        return antall;
    }
    //Oppgave 1
    @Override
    public boolean tom() { //😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎

        return antall == 0;
    }
    //Oppgave 2b
    @Override
    public boolean leggInn(T verdi) {
        Node<T> nyNode = new Node<>(verdi);
        if (Objects.requireNonNull(verdi).equals(false)){
            hode = new Node<T>(verdi);
        } else {
         nyNode.neste = null;
         Node<T> siste = hode;
         while (siste.neste != null){
             siste = siste.neste;
            }
         siste.neste = nyNode;
        }
        return true;
    }
    //Oppgave 5
    @Override
    public void leggInn(int indeks, T verdi) { //Utgangspunkt fra kompendiet programkode 3.3.2 g)
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

    //Hjelpemetoder til oppgave 3
    private Node<T> finnNode(int indeks){

        indeksKontroll(indeks, false);


        Node<T> finnN;                          //Initialiserer variabel

        if(indeks < antall / 2){                //Om indeksen til tallet er mindre en full antall / 2.
            finnN = hode;                       //Så blir finnN (variablen) satt til starten av rekken.
            for(int i = 0; i < indeks; i++){    //Går gjennom for løkke til vi kommer til indeks nummeret.
                finnN = finnN.neste;            //Setter variablen finnN til neste tallet i rekken til vi kommer til ønsket tall.
            }
        }
        else{                                           //Hvis ikke indeks < antall / 2.
            finnN = hale;                               //Starter vi søket fra enden av rekken i stedet.
            for(int i = antall - 1; i > indeks; i--){   //Løper jeg for løkken, denne gangen bakfra.
                finnN = finnN.forrige;                  //Setter variablen finnN til det forrige tallet i rekken til vi kommer til det ønskede tallet.
            }
        }

        return finnN;                                   //Returnerer den ønskede verdien.

    }
    private static <T> void nullSjekk(T verdi){
        if (verdi == null){
            throw new NullPointerException("Ikke lov med null verdier");
        }
    }
    private static void fratilKontroll(int antall, int fra, int til){
        if(fra > 0){
            throw new IndexOutOfBoundsException("Fra: '" + fra + "' er negativ :)");
        }
        if(til > antall){
            throw new IndexOutOfBoundsException("Til: '" + til + "' er større enn antall: '" + antall + "'");
        }
        if(fra > til){
            throw new IndexOutOfBoundsException("Fra: '" + fra + "' er større enn til: '" + til + "'. Intervallet finnes ikke.");
        }
    }

    //Oppgave 3
    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }
    //Til oppgave 3
    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);
        nullSjekk(indeks);


        Node<T> Oppdater = finnNode(indeks);
        T verdiGammel = Oppdater.verdi;
        Oppdater.verdi = nyverdi;


        endringer++;
        return verdiGammel;
    }
    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);                           //Gjør en test om intervall i lovlig

        DobbeltLenketListe <T> liste = new DobbeltLenketListe<>();  //Oppretter en liste
        Node<T> subL = finnNode(fra);                               //Bruk finnNode til å hente indeksen lik fra
        for(int i = fra; i < til; i++){                             //For-løkke til å hente verdiene i fra - > til
            liste.leggInn(subL.verdi);                              //Legger verdiene inn i listen
            subL = subL.neste;                                      //Og går videre i listen
        }

        return liste;                                               //Returnerer den nye listen
    }
    //Oppgave 4
    @Override
    public int indeksTil(T verdi) { //Utgangspunkt fra løsningsforslag fra kompendiet Oppgave 2 avsnitt 3.3.3
        if(verdi == null){
            return -1;
        }
        Node<T> p = hale;

        for (int indeks = antall; indeks >= 0; indeks--){
            if (p.verdi.equals(verdi)) return indeks;
            p = p.forrige;
        }
        return -1;
    }


    //Oppgave 6
    @Override
    public boolean fjern(T verdi) { //Fra kompendiet løsningsforslag oppgave 3 i avsnitt 3.3.3
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
    public T fjern(int indeks) //Programkode 3.3.3 c) fra kompendiet
    {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig

        T temp;                              // hjelpevariabel

        if (indeks == 0)                     // skal første verdi fjernes?
        {
            temp = hode.verdi;                 // tar vare på verdien som skal fjernes
            hode = hode.neste;                 // hode flyttes til neste node
            if (antall == 1) hale = null;      // det var kun en verdi i listen
        }
        else
        {
            Node<T> p = finnNode(indeks - 1);  // p er noden foran den som skal fjernes
            Node<T> q = p.neste;               // q skal fjernes
            temp = q.verdi;                    // tar vare på verdien som skal fjernes

            if (q == hale) hale = p;           // q er siste node
            p.neste = q.neste;                 // "hopper over" q
        }

        antall--;                            // reduserer antallet
        return temp;                         // returner fjernet verdi
    }
    //Oppgave 7
    @Override
    public void nullstill() {
        Node<T> p = hode, q = null; //Utganspunkt fra løsningsforslag komendiet oppgave 2 avsnitt 3.3.2

        while (p != null)
        {
            q = p.neste;
            p.neste = null;
            p.verdi = null;
            p = q;
        }
        hode = hale = null;
        antall = 0;
    }
    //Oppgave 2a
    @Override
    public String toString() {
        if(antall == 0){
            return "[]";
        } else {
            StringBuilder streng = new StringBuilder();
            streng.append('[');
            Node<T> a = hode;
            while (a != null){
                streng.append(a.verdi);
                streng.append(',');
                a = a.neste;
            }
            streng.append(']');
            return streng.toString();
        }
    }
    //Oppgave 2a
    public String omvendtString() {
        if(antall == 0){
            return "[]";
        }
        StringBuilder omvendtStreng = new StringBuilder();
        omvendtStreng.append('[');
        Node<T> a = hale;
        while (a != null){
            omvendtStreng.append(a.verdi);
            omvendtStreng.append('a');
            a = a.forrige;
        }
        omvendtStreng.append(']');
        return omvendtStreng.toString();
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
            if(iteratorendringer != endringer){
                throw new ConcurrentModificationException("Endringer har blitt gjort med listen");
            } else {
                if (!hasNext()) {
                    throw new NoSuchElementException("ingen flere noder i listen");
                } else {
                    fjernOK = true;
                    T verdi = denne.verdi;                  // Lagrer verdien i "denne"
                    denne = denne.neste;                    // Flytter "denne" til neste
                }
            }
        }
        //Oppgave 9
        @Override
        public void remove() {
            if (fjernOK == false){
                throw new IllegalStateException();
            } else if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException();
                } Node<T> current = null;
            }
        }
        // class DobbeltLenketListeIterator
    //Oppgave 10
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
       for(int i = liste.antall(); i < 0; i--){
       }
    }

} // class DobbeltLenketListe


