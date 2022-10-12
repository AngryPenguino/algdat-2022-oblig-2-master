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

I oppgave 2a startet vi med bare å lage en enkel sjekk får å sjekke om listen var tom. Deretter opprettet vi en stringbuilder.
Vi startet med bare å appende det vi viste skulle først, altså "[", og det vi viste skulle sist "]".
Deretter lagde vi en loop som gikk gjennom listen å la til alle noder. Og så appendet vi komma og mellomrom for å få ønsket svar.
For at det ikke skulle være ekstra tegn på slutten fjernet vi det siste komma og det siste mellomrommet.

I den andre metoden i 2a gjorde vi bare det samme, men vi snudde løkken. Altså at den gikk fra slutten, mot starten.

I oppgave 2b fikk vi hjelp av Programkode 3.3.2 f) fra kompendiet, og fikk den til å også øke endringer.

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

I oppgave 5 skulle vi legge inn en node basert på indeks og verdi. Den sjekker først om det er en null-verdi den får inn
og vil da kaste en exception hvis det er tilfellet. Deretter gjør den en indekskontroll ved å kalle på indekskontroll-
metoden. Denne sjekker om vi har lovlige argumenter. Vi sjekker om listen er tom og hvis det er tilfellet vil den verdien
som legges inn være både hode og hale med nullpekere både til neste og forrige. Hvis indeks er 0 altså først skal legge 
en node før den nå værende hode ved å si at hode = hode.forrige og forrige-pekeren til den nye noden være null. 
Hvis indeks er lik antall (siste posisjon i listen) vil vi legge en node til hale hvor neste-pekeren skal være null.
Hvis indeks hverken er 0 eller antall (siste eller sist) kaller vi på finnNode-metoden og setter verdien til venstre 
for vår nye instansierte node. Endringer og antall øker.

I oppgave 6 skulle vi slette noder basert på verdi og indeks. I verdi metoden var framgangsmåten lik som i oppgave 4 hvor 
vi traverserte gjnnom den lenkede listen samtidig som vi sammenlignet om vi var kommet til verdien som ble gitt inn
som parameter, og deretter kalle på en hjelpemetode. Oppsettet av for-loopen var annerledes enn oppgave 4 hvor vi nå
traversert i selve for loop oppsettet og ikke paralellt med indeks. Hjelpemetoden sjekker om verdien du ønsker å fjerne 
er hode/første verdien i den lenkede listen og setter at hode og hale er null hvis det kun er én verdi i listen og
gjør den første noden er nå den første nodens neste og setter den til null hvis noden er først i listen. Den gjlr en 
sjekk om noden er sist og hvis den hverken er først eller sist. Fjern indeks-metoden finner vi noden ved indeks ved hjelp
av finnNode-metoden lagd i oppgave 3. Da får vi en node og ikke kun en indeks som vi nå kan legge inn i fjernNode-moetoden

I oppgave 7 nullstilte vi den lenkede listen med to versjoner. Den første har vi en while-loop som går så lenge p ikke
er null. I løkken blir p sin neste og verdi satt til null for å så bli til q, en hjelpnode vi la til sammen med p som har
verdi som p.neste. Med denne hjelpenoden kan vi traversere gjennom listen hvor vi steg for steg nuller ut p.verdi og 
p.neste og gjør p til q som gjør at vi kan fortsette og gjøre det samme igjen helt til p!= null(slutten av listen).
Deretter tar vi at både hode og hale er lik null, antall er 0 og øker endringer.

I den andre versjonen har vi også en while-loop men som går så lenge antall er mindre enn 0. For hver syklys/inkrement
vil den kalle på fjern-metoden med indeks 0 som parameter. Den vil da ta bort noden som står på indeks 0 noe som vil
minke antallet for hver gang og kjøres helt til antall > 0.

8

I oppgave 9 startet vi med å følge kravene i oppgaven om at hvis metoden ikke kan kalles skal den kaste IllegalStateException,
og ConcurrentModificationException dersom iteratorendringer ikke er lik endringer.
Deretter settes fjernOK til false og vi kaller fjernNode på enten hale eller dennes forrige
avhengig av om noden vi er på er null eller ikke.

Vi startet oppgave 10 med å sjekke om listen er tom og returnere dersom den var det.
Deretter kjører vi en bobblesortering hvor vi bruker c.compare for å sammenligne. 
