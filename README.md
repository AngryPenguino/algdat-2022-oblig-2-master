# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Nicolai Wahl, S362072, s362072@oslomet.no
* Jonas Robin Øien, s364720, s364720@oslomet.no
* Jakob Elversøe Solberg s364755, s364755@oslomet.no
* Georg Prahl Harbitz s362109, s362109@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Nicolai har hatt hovedansvar for oppgave 1, 3 
* Jakob har hatt hovedansvar for oopgave 4,5 og 6
* Jonas har hatt hovedansvar for oppgave 2 og 9. 
* Georg Har hatt hovedansvar for oppgave 8
* Vi har i fellesskap løst oppgave 7 

# Oppgavebeskrivelse

I oppgave 1 så startet jeg med å lage antall og tom funksjonene. De returnerer henholdsvis antallet objekter og en true/false om tabellen er tom eller ikke.
Deretter lagde jeg en dobbeltlenketliste konstruktor som blir startet i DobbeltLenketListe(T [] a). Bruker en nullsjekk for at det ikke skal være null-verdier i tabellen.
Begynner med en midlertidig node til lenken, så går vi gjennom arrayet a med en for løkke. Om verdiene ikke er null så blir det lagt til en ny node, hale, på enden av listen.
Til slutt fjerner vi den midlertidige hjelpenoden. 

I oppgave 2 så brukte vi en ... til å ...

I oppgave 3a startet jeg med å lage hjelpemetoden finnNode(). Den sjekker først om tallet enten er mindre enn halve lengden til listen. 
Om den er det så startes søket etter noden fra hode. Kjører gjennom en for-løkke til vi kommer til indeksen og setter finnN variablen til neste node til noden er funnet.
Det samme gjøres om vi starter bakfra, halen. Returnerer tilslutt noden.
Lagde deretter hent funksjonen som henter verdien til noden ved hjelp av finnNode hjelpefunksjonen.
Tilslutt lagde jeg oppdater funksjonen som tar inn en indeks og en nyverdi og endrer indeksverdien til den nye verdien.

I oppgave 3b lagde jeg funksjonen subliste som lager en ny liste utifra nodene våres ved hjelp av både finnNode og leggInn funksjonene.
For hver gjennomgang av for-løkken som blir leggInn funksjonen kalt som legger inn verdien fra noden funnet ved hjelp av finnNode funksjonen 
og så går node variablen subL et steg videre i listen. fratilKontroll benyttes for å sjekke at start og slutt kravene er lovlige.


I oppgave 4 skulle vi returnere indeksen til gitt verdi, om den i det hele tatt fantes i den lenkede listen. Vi begynte
med å håndtere ting vi ikke skulle ha med nemlig om verdien var null, da ville vi returnere -1. For å finne indeks til
gitt verdi valgte vi en for-løkke for å traversere gjennom den lenkede listen. Dette gjorde vi ved å si at vår opprettede
node "p" fikk startverdi som hode(først) og p = p.neste etter å hatt sjekket om verdien vi får inn er lik p.verdi ved 
hjelp av equals. Fant den verdien i den lenkede listen kunne vi deretter returnere indeksen vi var på i for-løkken, som
startet på 0 og ville gå så lenge indeks var mindre enn antall (den lenkede listens lengde). Om den hadde gått gjennom 
hele den lenkede listen uten å finne verdien vil gi -1.

For del 2 av oppgaven hvor vi skulle returnere om verdien fantes eller ikke gjennom enten true eller false (boolean),
kalte vi på indeks-metoden hvor parameter-verdien til innholder-metoden ble parameterverdien til indeks-metoden.
Den skulle returnere sannhetstilstand / boolean om returnverdien til den metoden som ble kalt på ble -1 eller ikke.
Hvis den ble true betyr det at verdien inn har blitt sjekket med hver node og returnert indeksen, og hvis man ble -1 
betyr det at den enten er null eller ikke finnes i den lenkede listen.

4

5

6

7

I oppgave 8a startet vi med å lage next(). Den skal først sjekke om listen har en neste verdi. 
Om den har det så sjekker om iteratorendringer er lik endringer og om det også er sant og til slutt sjekker etter null verdier.
Dersom alt dette går gjennom blir fjernOK satt til true og verdien denne blir satt til neste verdi i listen (neste node)

I b) så returnerer Iterator<T> iterator() en ny instans av DobbeltLenketListeIterator()
DobbeltLenketListeIterator er en konstruktor setter variablen "denne" som brukes i next() til hode, starten av listen.

Lager deretter DobbeltLenketListeIterator(int indeks) som nå tar inn en indeks, sjekker om indeksen er lovlig med hjelpefunksjonen indeksKontroll()
så setter variablen "denne" til noden til indeksen vi ønsker ved hjelp av finnNode() funksjonen.

Til slutt i  Iterator<T>  iterator(int  indeks) gjøres det først en indeksKontroll, om det går gjennom returneres
en ny DobbeltLenketListeIterator(int indeks) konstruktor.


9

10
