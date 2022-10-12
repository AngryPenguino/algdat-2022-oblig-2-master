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

    public DobbeltLenketListe() { //Tar utgangspunkt i kompendiet, programkode 3.3.4
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }
    //Oppave 1
    public DobbeltLenketListe(T[] a) {

        this();                                                                  //Starter konstruktøren over ^. "DobbeltLenketListe()"
        nullSjekk(a);                                                            //Bruker hjelpefunksjonen nullsjekk for å passe på at det ikke kommer inn nullverdier

        hode = hale = new Node<>(null);                                    //Midlertidig node for å lage lenken.
        for(T verdi : a){
            if(verdi != null){
                hale = hale.neste = new Node<>(verdi, hale, null);        //Hvis verdien ikke er null, legger til en ny node på enden av listen.
                antall++;                                                      //Øker telleren for antallet i listen
            }
        }
        //Koden for å fjerne "hode = hale = new Node<>(null) siden den kun var midlertidig.
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
        Objects.requireNonNull(verdi);  //Sjekker at verdi ikke er null
        if (antall == 0) hode = hale = new Node<T>(verdi, null,null); //Hvis det er ingenting i listen legg til ny node av verdi...
        //...hvor både hode og hale er null
        else hale = hale.neste = new Node<T>(verdi,hale,null );   //Hvis ikke, legg ny node i hale.neste
        endringer++;        //Øker endringer med 1
        antall++;           //Øker antall med 1
        return true;
    }
    //Tar utgangspunkt i Programkode 3.3.2 f) i kompendiet
    //Oppgave 5
    @Override
        public void leggInn(int indeks, T verdi) //Utgangspunkt fra kompendiet programkode 3.3.2 g)
        {
            Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

            indeksKontroll(indeks, true);

            if (tom())                              // tom liste
            {
                hode = hale = new Node<>(verdi, null, null);
            }
            else if (indeks == 0)                   // ny verdi forrest
            {
                hode = hode.forrige = new Node<>(verdi, null, hode);
            }
            else if (indeks == antall)              // ny verdi bakerst
            {
                hale = hale.neste = new Node<>(verdi, hale, null);
            }
            else                                    // ny verdi på plass indeks
            {
                Node<T> p = finnNode(indeks);     // ny verdi skal til venstre for p
                p.forrige = p.forrige.neste = new Node<>(verdi, p.forrige, p);
            }

            antall++;            // ny verdi i listen
            endringer++;   // en endring i listen
        }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    //Hjelpemetoder til oppgave 3
    private Node<T> finnNode(int indeks){               //Kode fra kompendiet, programkode 3.3.3 a)

        Node<T> finnN;                                  //Initialiserer variabel

        if(indeks < antall / 2){                        //Om indeksen til tallet er mindre en full antall / 2.
            finnN = hode;                               //Så blir finnN (variablen) satt til starten av rekken.
            for(int i = 0; i < indeks; i++){            //Går gjennom for løkke til vi kommer til indeks nummeret.
                finnN = finnN.neste;                    //Setter variablen finnN til neste tallet i rekken til vi kommer til ønsket node.
            }
        }
        else{                                           //Hvis ikke indeks < antall / 2.
            finnN = hale;                               //Starter vi søket fra enden av rekken i stedet.
            for(int i = antall - 1; i > indeks; i--){   //Løper gjennom for-løkken, denne gangen bakfra.
                finnN = finnN.forrige;                  //Setter variablen finnN til det forrige tallet i rekken til vi kommer til den ønskede noden.
            }
        }

        return finnN;                                   //Returnerer den ønskede noden.



    }
    private static <T> void nullSjekk(T verdi){         //Om verdien som skal inn er null, ingen verdi, så blir det sendt error
        if (verdi == null){
            throw new NullPointerException("Ikke lov med null verdier");
        }
    }
    private static void fratilKontroll(int antall, int fra, int til){
        if(fra < 0){        //Om fra er mindre enn 0 så får vi error, kan ikke starte på en negativ verdi.
            throw new IndexOutOfBoundsException("Fra: '" + fra + "' er negativ :)");
        }
        if(til > antall){   //Om til er større enn antall verdier så får vi error.
            throw new IndexOutOfBoundsException("Til: '" + til + "' er større enn antall: '" + antall + "'");
        }
        if(fra > til){      //Om fra er større enn til så får vi error. Start større enn slutt er kult.
            throw new IllegalArgumentException("Fra: '" + fra + "' er større enn til: '" + til + "'. Intervallet finnes ikke.");
        }
    }

    //Oppgave 3
    //Koden til hent og oppdater fra kompendiet, programkode 3.3.3 b)
    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);       //Sjekker indeksen
        return finnNode(indeks).verdi;              //Returnerer verdien til indeksen
    }
    //Til oppgave 3
    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);        //Sjekker indeksen
        nullSjekk(nyverdi);                          //Sjekker at indeksene ikke er null


        Node<T> oppdater = finnNode(indeks);         //Bruker finnNode til å finne noden som skal endres
        T verdiGammel = oppdater.verdi;              //Setter gammel verdi til den oppdaterte verdien
        oppdater.verdi = nyverdi;                    //Og den oppdaterte verdien er nå den nye verdien


        endringer++;
        return verdiGammel;                          //Returnerer den gamle verdien
    }
    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);                           //Gjør en test om intervall start til slutt er lovlig

        DobbeltLenketListe <T> liste = new DobbeltLenketListe<>();  //Oppretter en liste
        Node<T> subL = finnNode(fra);                               //Bruk finnNode til å hente indeksen lik fra
        for(int i = fra; i < til; i++){                             //Går gjennom for-løkken fra fraverdi til tilverdi
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
        Node<T> p = hode;

        for (int indeks = 0; indeks < antall; indeks++){
            if (p.verdi.equals(verdi)) return indeks;
            p = p.neste;
        }
        return -1;
    }


    //Oppgave 6
    private T fjernNode(Node<T> p)  // private hjelpemetode
    {
        if (p == hode)
        {
            if (antall == 1) hode = hale = null;      // kun en verdi i listen
            else (hode = hode.neste).forrige = null;  // fjerner den første
        }
        else if (p == hale) (hale = hale.forrige).neste = null;  // fjerner den siste
        else (p.forrige.neste = p.neste).forrige = p.forrige;    // fjerner p

        antall--;     // en mindre i listen
        endringer++;  // en endring

        return p.verdi;
    }

    @Override
    public boolean fjern(T verdi) //Fra kompendiet løsningsforslag oppgave 3 i avsnitt 3.3.3
    {
        if (verdi == null) return false;  // ingen nullverdier i listen

        for (Node<T> p = hode; p != null; p = p.neste)
        {
            if (p.verdi.equals(verdi))
            {
                fjernNode(p);   // bruker den private hjelpemetoden
                return true;
            }
        }
        return false;  // verdi ligger ikke i listen
    }

    @Override
    public T fjern(int indeks) //Programkode 3.3.3 c) fra kompendiet
    {
        indeksKontroll(indeks, false);

        return fjernNode(finnNode(indeks)); // bruker de to hjelpemetodene
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
        endringer ++;
    }

    public void nullstill2(){
        while (antall > 0){
            fjern(0);
        }
    }
    //Oppgave 2a
    @Override
    public String toString() {
        if(antall == 0){
            return "[]";        //Hvis listen er tom returnerer []
        } else {
            StringBuilder streng = new StringBuilder(); //Oppretter StringBuilder
            streng.append('[');                         //Legger til [ på starten
            Node<T> a = hode;                           //Starter på hode
            while (a != null){                          //Loop går gjennom fra starten
                streng.append(a.verdi);                 //Legger til a.verdi, "," og et mellomrom.
                streng.append(',');
                streng.append(' ');
                a = a.neste;
            }
            streng.deleteCharAt(streng.lastIndexOf(","));   //Fjerner ekstra komma og mellomrom
            streng.deleteCharAt(streng.lastIndexOf(" "));
            streng.append(']');                                //Legger til siste ]
            return streng.toString();                          //Returnerer som streng
        }
    }
    //Oppgave 2a
    public String omvendtString() {
        if(antall == 0){
            return "[]";        //Hvis listen er tom returnerer []
        }
        StringBuilder omvendtStreng = new StringBuilder(); //Oppretter StringBuilder
        omvendtStreng.append('[');                         //Legger til [ på starten
        Node<T> a = hale;                                  //Starter på hale
        while (a != null){                                 //Loop går gjennom fra slutten
            omvendtStreng.append(a.verdi);                 //Legger til a.verdi, "," og et mellomrom.
            omvendtStreng.append(',');
            omvendtStreng.append(' ');
            a = a.forrige;
        }
        omvendtStreng.deleteCharAt(omvendtStreng.lastIndexOf(","));    //Fjerner ekstra komma og mellomrom
        omvendtStreng.deleteCharAt(omvendtStreng.lastIndexOf(" "));
        omvendtStreng.append(']');                                         //Legger til siste ]
        return omvendtStreng.toString();                                   //Returnerer som streng
    }


    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }
    //Oppgave 8
    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
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
            indeksKontroll(indeks, false);
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }
        //Oppgave 8
        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {                                   // Tokk utgangspunkt i programkode 3.3.4
            if (!hasNext()) {
                throw new NoSuchElementException("ingen flere noder i listen");
            } else {
                if (iteratorendringer != endringer) {
                    throw new ConcurrentModificationException("Endringer har blitt gjort med listen");
                } else {

                    Objects.requireNonNull(denne, "Objektet kan ikke være et null-objekt");

                    fjernOK = true;

                    T temp = denne.verdi;                  // Lagrer verdien i "denne"
                    denne = denne.neste;                    // Flytter "denne" til neste

                    return temp;
                }
            }
        }
        //Oppgave 9
        @Override
        public void remove() {
            if (fjernOK == false){throw new IllegalStateException();}  //Sjekk om metoden kan kalles
            if (iteratorendringer != endringer) {throw new ConcurrentModificationException();} //Hvis iteratorendringer og endringer ikke er samme kast unntak
            fjernOK = false;
            if(denne==null){        //Hvis denne er null kalles fjernNode på hale
                fjernNode(hale);
            } else {fjernNode(denne.forrige);}  //Hvis ikke kalles fjernNode på den forrige
            iteratorendringer++;                //Øker iteratorendringer
        }
    }
        // class DobbeltLenketListeIterator
    //Oppgave 10
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        if (liste.tom()) return;
        for(int i = 0; i < liste.antall(); i++){                            // for loop for å loopet gjennom array
            for(int j = 0; j < liste.antall(); j++){                        // nestet for loop for å sjekke hver hele array for hver del
                if((c.compare(liste.hent(i), liste.hent(j))) < 0){          // sammenligning mellom hvert punkt ved hjelpå av compare
                    T temp = liste.hent(i);                                 // foreløpig variabel for i
                    liste.oppdater(i,liste.hent(j));                        // oppdaterer i for j ved hjelp av oppdater
                    liste.oppdater(j,temp);                                 // legger så inn den foreløpige verdien i j
                }
            }
        }
    }

} // class DobbeltLenketListe


