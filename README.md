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

I oppgave 1 så gikk vi frem ved å ...

I oppgave 2 så brukte vi en ... til å ...

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

8

9

10
