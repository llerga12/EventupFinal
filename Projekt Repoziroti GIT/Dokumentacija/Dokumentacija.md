Sadržaj

1. Opis sustava

1.1.	Uloge i odgovornosti u timu

2.	Analiza sustava

2.1.	Analiza zahtjeva

2.2.	Korisničke priče

2.3.	UML dijagrami aktivnosti	

2.4.	UML sekvencijalni dijagrami	

3.	Dizajn sustava	

3.1.	Grafičko sučelje	

3.2.	Model podataka	

3.3.	Relacijska shema baze podataka	

3.4.	UML dijagram klasa	

3.5.	API pristupne točke	

4.	Implementacija sustava	

4.1.	Primjeri spajanje na bazu	

4.2.	Prikaz dijelova programskog koda	

4.3.	Pakiranje, isporuka i konfiguracija aplikacije	

4.4.	Primjeri korištenja aplikacije	

4.5.	Udaljeni sustav za kontrolu verzija	

5.	Korisnička dokumentacija	

5.1.	Namjena aplikacije	

5.2.	Preuzimanje i instalacija	

5.3.	Pokretanje aplikacije	

5.4.	Korištenje aplikacije	

6.	Zaključak	




# 1	Opis sustava 


Svrha informacijskog sustava očituje se u jednostavnijoj organizaciji festivala i drugih kulturnih manifestacija. Sustav omogućava organizatorima festivala/kulturnih događanja brže i jednostavnije pretraživanje baze podataka izvođača koje bi se angažiralo za specifično događanje te izvođačima (koji su u bazi podataka) omogućava pronalazak mogućih gaža te pojednostavljuje komunikaciju s organizatorima. Funkcionalnosti sustava su u pregledu baze podataka izvođača i organizatora, mogućnost filtriranja izvođača prema žanru, cijeni ili drugim kriterijima koji su bitni organizatorima, pregled detaljnijih informacija o izvođačima (njihove biografije, diskografije, fotografije, videa, promo materijale…) kao i organizatorima (vrsta događanja, opis događanja, vrijeme, mjesto, uvjeti). Sustav omogućava otvaranja profila (izvođača i organizatora) na kojem bi bilo moguće unijeti biografije, diskografije, fotografije, videozapise, ponude (cijena, uvjeti, tehnički zahtjevi) i druge relevantne informacije bitne izvođačima i organizatorima. Isto tako, omogućava se izvođačima i organizatorima festivala da komuniciraju jednostavnim i učinkovitim načinom i pregovaraju o detaljima nastupa na jednom mjestu. Sustav rješava probleme kao što su poteškoće u pronalasku i dogovaranju nastupa, pristupa informacija, komunikaciji (olakšavanje načina komunikacije između izvođača i organizatora, smanjenje nesuglasica, transparentnost u procesu dogovaranja) te organizacijske poteškoće (kalendar nastupa/festivala, dolazak izvođača, mogući smještaj i ostali uvjeti, dogovor oko cijene itd.).
Kao desktop aplikacija, svrha će biti unos podataka o organizatorima festivala te potencijalnim izvođačima. 

# 1.1	Uloge i odgovornosti u timu
(popis članova tima i odgovornosti)

Projektnu dokumentaciju kao i projekt EventUp radim sama iako sam do sada radila s timom u kojem su studenti Bačinić, Mišković, Lerga i Semialjac. Kompletni rad na projektnu i projektna dokumentacija bit će samostalan rad kao i testiranje aplikacije odnosno provjera funkcionalnosti i performansi. 

*Do poglavlja 2.4. prikazani su podaci i dokumentacija dosadašnjeg projekta EventUp. Za potrebe izrade ovog projekta koristit će se manji broj relacija te je prikaz ovog projekta vidljiv od poglavlja 2.4. 

# 2	Analiza sustava

2.1	Analiza zahtjeva 
Iz opisa sustava nađene su sljedeće funkcionalnosti koje sustav mora zadovoljiti, s aspekta korisnika sustava:


# 2.2	Korisničke priče
Popis i opis korisničkih priča
## ADMINISTRATOR
1. Administrator kreira sučelje aplikacije kako bi se njome što jednostavnije koristilo.
2. Administrator se prijavljuje u sustav kako bi mogao koristiti funkcionalnosti sustava za koje ima ovlasti.
3. Administrator ima pregled svih aktivnih korisničkih računa i njihovih aktivnosti na platformi, kako bi mogao osigurati sigurnost i integritet sustava.
4. Administrator šalje obavijesti korisnicima o ažuriranju podataka kako bi podaci u aplikaciji bili relevantni i pouzdani.
5. Administrator može upisivati nove korisnike.
6. Administrator može brisati korisnike koji nisu aktivni na stranici više od određenog vremena.
7. Administrator može kreirati nove funkcije te poboljšavati aplikaciju, kako bih osigurao da platforma uvijek bude inovativna i relevantna za korisnike.
8. Administrator može pregledavati i uređivati postavke i izgled aplikacije.
9. Administrator nudi podršku korisnicima, uključujući odgovaranje na upite i pitanja, rješavanje problema i pružanje savjeta za optimalno korištenje aplikacije.
10. Administrator može kreirati pravila korištenja i politika privatnosti, kako bih osigurao da aplikacija bude u skladu s važećim zakonima i propisima.
11. Administrator ima pristup podacima o performansama aplikacije, kako bi se osigurao optimalan rad aplikacije te ukoliko su potrebna unaprjeđenja aplikacije.
12. Administrator osigurava da su aplikacije dostupne na svim uređajima te da funkcioniraju u skladu s drugim aplikacijama unutar sustava.
13. Administrator testira aplikaciju kako bi unaprijed uočili potencijalne probleme u radu aplikacije.
14. Administrator upravlja pristupom tj. dopuštenjima koja daju prava korisnicima ili grupama korisnika da vide određene podatke s drugih profila.
15. Administratori nadziru aplikacijske logove, te uz njihovu pomoć prate aktivnosti korisnika bez narušavanja privatnosti korisnika.
16. Administratori upravljaju incidentima i problemima koji nastaju ili su usko vezani uz aplikaciju ili njeno korištenje.
17. Administratori organiziraju i koordiniraju prevođenje aplikacije i korisničkih profila na druge jezike te tako smanjuju jezične barijere.
18. Administrator prati korištenje resursa aplikacije kako bi se osiguralo da aplikacija ne preoptereti sustave korisnika, a ni servere na kojima se nalazi.
19. Administrator planira upravljanje održavanjem, zakazuje datume i vrijeme kada će se raditi ažuriranja/backupovi na sustavu.
20. Administrator konfigurira aplikaciju tako da bude prilagođena korisničkim zahtjevima.
21. Administrator čita recenzije i prati komentare korisnika te iz njihovih kritika planira unaprjeđenja sustava.


## KORISNIK - ORGANIZATOR


1. Korisnik (Organizator) se putem internetske stranice ili mobilne registrira putem OIB-a.
2. Korisnik (Organizator) se putem internetske stranice ili mobilne aplikacije prijavljuje e-mailom i lozinkom.
3. Korisnik (Organizator) se prijavljuje u sustav kako bi mogao koristiti funkcionalnosti sustava za koje ima ovlasti.
4. Korisnik (Organizator) odabire izvođače iz baze podataka u aplikaciji.
5. Korisnik (Organizator) kreira profil i objavljuje informacije o festivalu kojeg organizira, kako bi ga izvođači mogli lakše pronaći i kontaktirati.
6. Korisnik (Organizator) unosi informacije o početku i završetku festivala, mjestu, dogovorenim izvođačima i uvjetima koje pruža.
7. Korisnik (Organizator) može pregledavati popis dostupnih izvođača u mobilnoj aplikaciji, tako da može odabrati izvođače koji odgovaraju stilu i vrsti glazbe kojeg želi uključiti u festival.
8. Korisnik (Organizator) može pregledavati popis dostupnih izvođača u desktop aplikaciji, tako da može odabrati izvođače koji odgovaraju stilu i vrsti glazbe kojeg želi uključiti u festival.
9. Korisnik (Organizator) može vidjeti detaljne informacije o izvođačima, uključujući biografiju, diskografiju, videozapise i recenzije, tako da može donijeti odluku o angažiranju izvođača.
10. Korisnik (Organizator) može vidjeti detalje o nastupu izvođača, uključujući njihove tehničke
zahtjeve, vrijeme nastupa i opremu koju je potrebno osigurati, kako bi mogao pravovremeno
organizirati sve potrebne resurse.
11. Korisnik (Organizator) preko Google maps alata može pregledati lokacije na kojima je izvođač
nastupio.
12. Korisnik (Organizator) preko Google maps alata može dodati lokaciju na svoj profil kako bi
izvođačima bilo vidljivo mjesto festivala/događanja.
13. Korisnik (Organizator) ima mogućnost primanja zahtjeva izvođača za posebnim zahtjevima ili
željama za nastup, tako da može prilagoditi svoj festival specifičnim zahtjevima izvođača.
14. Korisnik (Organizator) može pregledati ponudu i odgovoriti na ponudu izvođača, tako da mogu
pregovarati o datumu, vremenu, mjestu i drugim detaljima nastupa.
15. Korisnik (Organizator) vidi informacije o plaćanju i rokovima plaćanja za nastup koje je
postavio izvođač.
16. Korisnik (Organizator) vidi sve buduće i prošle nastupe izvođača na festivalima, tako da može
upravljati svojim rasporedom.
17. Korisnik (Organizator) putem chata u aplikaciji izravno kontaktira izvođača kako bi mogao brže doći do potrebnih informacija.
18. Korisnik (Organizator) vidi recenzije drugih organizatora o izvođaču, kako bi mogao procijeniti kvalitetu izvođača i komunikacije s izvođačem koji bi trebao nastupati na festivalu.
19. Korisnik (Organizator) može ugovoriti uslugu (nastupa, sudjelovanja na festivalu) s izvođačima.
20. Korisnik (Organizator) može ocijeniti izvođače koji su nastupili na festivalu, kako bi mogao podijeliti svoje iskustvo s drugim organizatorima festivala.
21. Korisnik (Organizator) može unositi, mijenjati i brisati svoje podatke kako bi isti bili ažurni.


## KORISNIK - IZVOĐAČ


1. Korisnik (Izvođač) se putem internetske stranice ili mobilne aplikacije registrira putem OIB-a, e-maila i broja telefona.
2. Korisnik (Izvođač) se putem internetske stranice ili mobilne aplikacije prijavljuje e-mailom i lozinkom.
3. Korisnik (Izvođač) se prijavljuje u sustav kako bi mogao koristiti funkcionalnosti sustava za koje ima ovlasti.
4. Korisnik (Izvođač) kreira profil i objavljuje informacije o sebi, svojoj glazbi, nastupima i dostupnosti, tako da ga organizatori festivala mogu lakše pronaći i kontaktirati.
5. Korisnik (Izvođač) odabire festivale iz baze podataka u aplikaciji.
6. Korisnik (Izvođač) može pregledavati popis dostupnih festivala u mobilnoj aplikaciji, tako da može odabrati festival na kojemu će nastupati.
7. Korisnik (Izvođač) može pregledavati popis dostupnih festivala u desktop aplikaciji, tako da može odabrati festival na kojemu će nastupati.
8. Korisnik (Izvođač) pretražuje pomoću tražilice dostupne festivale kako bi mogao ponuditi svoje usluge i dogovoriti nastup s potencijalnim organizatorima festivala.
9. Korisnik (Izvođač) može primati obavijesti o novim ponudama za nastupe, kako bi mogao odabrati gdje želi nastupati.
10. Korisnik (Izvođač) može vidjeti informacije o detaljima festivala, uključujući vrijeme početka i završetka, tehničke uvjete koje organizator ispunjava, kako bi mogao pripremiti svoj nastup.
11. Korisnik (Izvođač) preko Google maps alata može pregledati lokacije planiranih festivala.
12. Korisnik (Izvođač) ima mogućnost slanja zahtjeva organizatorima festivala za posebnim zahtjevima ili željama za svoj nastup, kako bi mogao prilagoditi svoj nastup specifičnim zahtjevima festivala.
13. Korisnik (Izvođač) može pregledavati ponude i odgovoriti na ponudu organizatora festivala, kako bi mogao pregovarati o datumu, vremenu, mjestu i drugim detaljima nastupa.
14. Korisnik (Izvođač) može vidjeti informacije o plaćanju i rokovima plaćanja za nastup, kako bi lakše mogao planirati svoj proračun.
15. Korisnik (Izvođač) može vidjeti sve svoje buduće i prošle nastupe na festivalima, kako bi mogao upravljati svojim rasporedom i provjeriti svoju dostupnost za nove ponude za nastupe.
16. Korisnik (Izvođač) putem chata u aplikaciji izravno kontaktira organizatora kako bi mogao brže doći do potrebnih informacija.
17. Korisnik (Izvođač) može pregledavati recenzije drugih izvođača o festivalu, kako bi mogao procijeniti kvalitetu festivala na kojem bi trebao nastupati.
18. Korisnik (Izvođač) može ugovoriti uslugu (nastupa, sudjelovanja na festivalu) s organizatorima.
19. Korisnik (Izvođač) može ocijeniti festival na kojemu je nastupio, kako bi mogao podijeliti svoje iskustvo s drugim izvođačima i organizatorima festivala.
20. Korisnik (Izvođač) može unositi, mijenjati i brisati svoje podatke kako bi isti bili ažurni.
 
# 2.3	Relacijski Model podataka



# 2.4	Relacijska shema baze podataka

## Opis relacijskog modela

Organizator **(Sifra_organizatora (PK), Naziv_organizatora, Kontakt_organizatora, Lokacija_organizatora)** 

Potvrda_uvjeta **(Sifra_potvrde (PK), Datum_potvrde, Status_potvrde, Sifra_uvjeta (FK1))**

Zahtjevi_nastup **(Sifra_organizatora (PK, FK1), Sifra_izbodaca (PK, FK2), Datum_zahtjeva, Status_zahtjeva)**

Izvodac **(Sifra_izvodaca (PK), Ime_izvodaca, Prezime_izvodaca, UmjetnickoIme_izvodaca, Kontakt_izvodaca)**

Racun **(Sifra_racuna (PK), Datum_racuna, Iznos_racuna, Sifra_organizatora (FK1), Sifra_nastupa (FK2))**

Nastup **(Sifra_nastupa (PK), Datum_nastupa, Mjesto_nastupa, Sifra_izvodaca (FK1)) Uvjeti_nastupa (Sifra_uvjeta (PK), Datum_uvjeta, Status_uvjeta)**

Naziv: **Organizator**

Opis sheme relacije: **Ova relacija sadrži informacije o organizatorima događaja.**

Primarni ključ: **Sifra_organizatora**

Sekundarni ključ: **Nema**

Naziv atributa	**Opis atributa	Ograničenja**

Sifra_organizatora	J**edinstveni identifikator organizatora**	-

Naziv_organizatora	**Naziv organizatora**	-

Kontakt_organizatora	**Kontaktni podaci organizatora**	-

Lokacija_organizatora	**Lokacija organizatora**	-

Naziv: Potvrda_uvjeta
Opis sheme relacije: Informacije o potvrdi uvjeta izvođača (od strane organizatora)
Primarni ključ: Sifra_potvrde
Sekundarni ključ: Sifra_uvjeta
Naziv atributa	Opis atributa	Ograničenja
Sifra_potvrde	Jedinstveni identifikator potvrde	-
Datum_potvrde	Datum kada je potvrda izdana	-
Status_potvrde	Trenutni status potvrde	-
Sifra_uvjeta (FK1)	Jedinstveni identifikator uvjeta (vanjski ključ)	Ograničenje vanjskog ključa - ukoliko se pokuša brisati (delete) postavi restrikciju, a za update postavi kaskadu.

Naziv: Zahtjevi_nastup
Opis sheme relacije: Informacije o zahtjevima nastupa izvođača prema organizatoru
Primarni ključ: Sifra_organizatora, Sifra_izvodaca
Sekundarni ključ: Sifra_organizatora, Sifra_izvodaca
Naziv atributa	Opis atributa	Ograničenja
Sifra_organizatora (PK, FK1)	Jedinstveni identifikator organizatora (vanjski ključ)	-
Sifra_izvodaca (PK, FK2)	Jedinstveni identifikator izvođača (vanjski ključ)	-
Datum_zahtjeva	Datum kada je zahtjev podnesen	-
Status_zahtjeva	Trenutni status zahtjeva	-

Naziv: Izvodac
Opis sheme relacije: Informacije o izvođačima
Primarni ključ: Sifra_izvodaca
Sekundarni ključ: Nema
Naziv atributa	Opis atributa	Ograničenja
Sifra_izvodaca	Jedinstveni identifikator izvođača	-
Ime_izvodaca	Ime izvođača	-
Prezime_izvodaca	Prezime izvođača	-
UmjetnickoIme_izvodaca	Umjetničko ime izvođača	-
Kontakt_izvodaca	Kontakt izvođača	-

Naziv: Racun
Opis sheme relacije: Informacije o računu izdanom organizatoru od strane izvođača
Primarni ključ: Sifra_racuna
Sekundarni ključ: Sifra_nastupa, Sifra_organizatora
Naziv atributa	Opis atributa	Ograničenja
Sifra_racuna	Jedinstveni identifikator računa	-
Datum_racuna	Datum kada je račun izdan	-
Iznos_racuna	Iznos na računu	-
Sifra_organizatora (FK1)	Jedinstveni identifikator organizatora (vanjski ključ)	Ograničenje vanjskog ključa - ukoliko se pokuša brisati (delete) postavi restrikciju, a za update postavi kaskadu.
Sifra_nastupa (FK2)	Jedinstveni identifikator nastupa (vanjski ključ)	Ograničenje vanjskog ključa - ukoliko se pokuša brisati (delete) postavi restrikciju, a za update postavi kaskadu.

Naziv: Nastup
Opis sheme relacije: Informacije o nastupu izvođača
Primarni ključ: Sifra_nastupa
Sekundarni ključ: Sifra_izvodaca
Naziv atributa	Opis atributa	Ograničenja
Sifra_nastupa	Jedinstveni identifikator nastupa	-
Datum_nastupa	Datum kada se nastup održava	-
Mjesto_nastupa	Lokacija nastupa	-
Sifra_izvodaca (FK1)	Jedinstveni identifikator izvođača (vanjski ključ)	Ograničenje vanjskog ključa - ukoliko se pokuša brisati (delete) postavi restrikciju, a za update postavi kaskadu.

Naziv: Uvjeti_nastupa
Opis sheme relacije: Informacije o uvjetima nastupa izvođača
Primarni ključ: Sifra_uvjeta
Sekundarni ključ: Nema
Naziv atributa	Opis atributa	Ograničenja
Sifra_uvjeta	Jedinstveni identifikator uvjeta	-
Datum_uvjeta	Datum kada je uvjet postavljen	-
Status_uvjeta	Trenutni status uvjeta	-


 
Dijagram korištenja (engl. use-case diagram):

 
 
2.5	UML dijagrami aktivnosti

2.6	UML sekvencijalni dijagrami


# 3	Dizajn sustava
# 3.1	Grafičko sučelje
Početni prozor na kojem se nalaze gumbi za unos novih korisnika (Novi organizator, Novi izvođač), unos novog nastupa, izrada novog računa, prikaz svih organizatora, izvođača, nastupa i računa iz baze podataka. Iste funkcionalnosti nalaze se i u traci kao i mogućnost otvaranja novog prozora Pomoć.
 
Slika 1. Početni prozor

Odabirom na gumb Novi organizator ili Organizator Novi organizator, otvara se prozor za unos novog organizatora u bazu podataka. Upisuju se potrebni podaci kao što je jedinstvena šifra organizatora, naziv organizatora, kontakt i lokacija. Uneseni podaci vidljivi su u bazi podataka. 
 
Slika 2. Novi organizator
Odabirom gumba Prikaz organizatora ili Organizator Prikaz organizatora iz baze podataka povlače se svi podaci o unesenim organizatorima te se prikazuju u navedenom prozoru.
 
Slika 3. Prikaz organizatora

Odabirom na gumb Novi izvođač ili Izvođač Novi izvođač, otvara se prozor za unos novog izvođača u bazu podataka. Upisuju se potrebni podaci kao što je jedinstvena šifra izvođača, ime izvođača, prezime izvođača, umjetničko ime izvođača te kontakt. Uneseni podaci vidljivi su u bazi podataka. 
 
Slika 4. Novi izvođač

Odabirom gumba Prikaz izvođača ili IzvođačPrikaz izvođača iz baze podataka povlače se svi podaci o unesenim izvođačima te se prikazuju u navedenom prozoru.
 
Slika 5. Prikaz izvođača

Odabirom gumba Novi nastup ili Nastup  Novi nastup moguće je unijeti nastup izvođača koji se već nalazi u bazi podataka. U ovoj relaciji postoji vanjski ključ Šifra izvođača, ali se zbog preglednosti samog sučelja u kodu omogućilo da se preko šifre izvođača prikaže naziv izvođača odnosno da se odabere izvođač iz baze podataka. Tu se umjesto standardnog text labela i text fielda koji su se koristili za izradu drugih prozora, koristio combo box. Za unos novog nastupa potrebno je odabrati izvođača iz baze podataka, unijeti datum nastupa, mjesto nastupa te šifru nastupa. Ukoliko šifra nastupa već postoji u bazi podataka, sustav javlja da je potrebno unijeti novu šifru. 
 
Slika 6. Novi nastup

Odabirom gumba Prikaz nastupa ili NastupiPrikaz nastupa iz baze podataka povlače se svi podaci o unesenim nastupima izvođača te se prikazuju u navedenom prozoru.
 
Slika 7. Prikaz nastupa

Odabirom gumba Novi račun ili Račun  Novi račun moguće je izraditi novi račun za organizatora te prema šifri nastupa koja se već nalazi u bazi podataka. U ovoj relaciji postoje dva vanjska ključa Šifra organizatora, kojoj se zbog preglednosti samog sučelja u kodu omogućilo da se preko šifre organizatora prikaže naziv organizatora odnosno da se odabere organizator iz baze podataka, i Šifra nastupa koju je također moguće odabrati iz baze podataka. Tu se umjesto standardnog text labela i text fielda koji su se koristili za izradu drugih prozora, koristio combo box za Organizatora i Šifru nastupa. Za izradu novog računa potrebno je odabrati organizatora iz baze podataka, odabrati šifru nastupa (kojoj je pridružen naziv izvođača pod određenom šifrom nastupa), unijeti datum izrade računa, šifru računa i iznos. Ukoliko šifra računa već postoji u bazi podataka, sustav javlja da je potrebno unijeti novu šifru. 
 
Slika 8. Novi račun
Odabirom gumba Prikaz računa ili RačunPrikaz računa iz baze podataka povlače se svi podaci o unesenim računima te se prikazuju u navedenom prozoru.
 
Slika 9. Prikaz računa

Moguće je i otvoriti prozor Pomoć koji služi za pomoć prilikom korištenja sučelja EventUp-a odnosno javlja što omogućava EventUp te koje je namijenjen. U prozoru Pomoć prikazuje se samo prigodna poruka. 
 
Slika 10. Pomoć 
# 3.2	UML dijagram klasa

 


#### **Klasa Organizator**
Atributi: **sifra_organizatora (PK), naziv_organizatora, kontakt_organizatora, lokacija_organizatora**

Veze: **jedan organizator može imati više računa**

#### **Klasa Izvođač**
Atributi: **sifra_izvodaca (PK), ime_izvodaca, prezime_izvodaca, umjetnickoIme_izvodaca, kontakt_izvodaca**

Veze: **jedan izvođač može imati više nastupa**

#### **Klasa Račun**
Atributi: **sifra_racuna(PK), datum_racuna, iznos_racuna, sifra_organizatora (FK1), sifra_nastupa (FK2)**

Veze: **jedan račun može biti vezan za jednog organizatora, jedan račun može biti vezan za jedan nastup**

#### **Klasa Nastup**
Atributi: **sifra_nastupa (PK), datum_nastupa, mjesto_nastupa, sifra_izvodaca (FK1)**

Veze: **jedan nastup je vezan za jednog izvođača**

# 3.3	API pristupne točke 

U programskom kodu koristi se HTTP zahtjev GET. Radi se o metodi koja pristiže zahtjevom (request) i služi za čitanje podataka. S GET metodom se poziva neimenovana callback funkcija s parametrima request i response. Metoda app.get definirat će rutu '/music koja će obrađivati HTTP GET zahtjeve. Ruta je definirana kao asinkrona funkcija i kao takva veže se uz funkciju await. Await se stavlja ispred funkcije koja čeka promise objekt i koristi se unutar async funkcije. Await zajendo s axios.get omogućuje asinkrono slanje HTTP GET zahtjeva prema vanjskom API-ju. Odgovor koji se vraća klijentu je niz objekata koji su dobiveni parsiranjem CSV datoteke što se postiže pipe funkcijom. 
Greške koje se dogode tijekom slanja zahtjeva hvataju se u try catch bloku. Ako se dogodi greška, vraća odgovor s HTTP statusom 500 i porukom „Došlo je do greške pri dohvaćanju servera ili obrade datoteke“. 
API vraća podatke iz csv datoteke koja se nalazi na vanjskom serveru, koristeći express za obradu HTTP zahtjeva, axios za slanje zahtjeva prema vanjskom API-ju te csv-parser za parsiranje csv datoteka. Testiranje API-ja napravljeno je dohvaćanjem podataka s weba i preusmjeravanjem na web stranicu. Dohvaćeni podaci su u csv-u.
Unutar programskog koda greške koje se dogode tijekom slanja zahtjeva hvataju se u try catch bloku. Ako se dogodi greška, vraća odgovor s HTTP statusom 500 i porukom „Došlo je do greške pri dohvaćanju servera ili obrade datoteke“.
Moguće greške su: u dohvatu podataka u slučaju da vanjski API ne odgovori ili ne vrati grešku. To se rješava try catch blokom. Greška se može javiti i u parsiranju podataka što je moguće riješiti dodatnom provjerom i obradom podataka. Također, greška može biti i nedostatak obrade URL-a ako korisnik posjeti URL koji nije definiran. Tada mi se pojavila poruka o pogrešci (404).























# 4	Implementacija sustava
# 4.1	Primjeri spajanje na bazu

Primjeri spajanja na bazu su vidljivi u skoro svim prozorima, bilo da se radi o unosu podataka u bazu ili prikaza podataka iz baze.
Prikaz unosa podataka u bazu – ORGANIZATOR
 
Slika 11. Prikaz unosa u bazu: Organizator

 
Slika 12. Prikaz u bazi podataka: Organizator





Prikaz unosa podataka u bazu – IZVOĐAČ
 
Slika 13. Prikaz unosa u bazu: Izvođač

 
Slika 14. Prikaz u bazi podataka: Izvođač

Prikaz unosa u bazu podataka – NASTUP 
 
Slika 15. Prikaz unosa u bazu: Nastup
 
Slika 16. Prikaz u bazi podataka: Nastup
Prikaz unosa podataka u bazu – RAČUN
 
Slika 17. Prikaz unosa u bazi: Račun
 
Slika 18. Prikaz u bazi podataka: Račun
 
Prikaz iz baze podataka – ORGANIZATOR
 
Slika 19. Prikaz iz baze podataka: Organizator

Prikaz iz baze podataka – IZVOĐAČ
 
Slika 20. Prikaz iz baze podataka: Izvođač
Prikaz iz baze podataka – NASTUP
 
Slika 21. Prikaz iz baze podataka: Nastup
Prikaz iz baze podataka – RAČUN
 
Slika 22. Prikaz iz baze podataka: Račun

# ć4.2	Pakiranje, isporuka i konfiguracija aplikacije

Pakiranje aplikacije podrazumijeva stvaranje izvršne JAR datoteke koja sadrži sve potrebne komponente (File Export JAVA Runnable JAR file). Nakon što je stvorena JAR datoteka moguće je aplikaciju isporučiti drugima (lokalnom mrežom, USB, cloud…). Kod konfiguracije aplikacije potrebno je postaviti konfiguracijske datoteke (pogotovo ako ih aplikacija koristi za bazu podataka). 

# 4.3	Primjeri korištenja aplikacije

Primjeri korištenja aplikacije prikazani su u prethodnim poglavljima. U aplikaciji je moguće odabrati unos novog organizatora ili izvođača te unijeti sve potrebne podatke koji će se zatim spremiti u bazu podataka (pogledati poglavlje 4). Također, aplikacije se koristi i za unos nastupa izvođača koristeći se podacima iz baze podataka i unošenjem novih podataka te izradom računa za obavljeni nastup. Osim unosa podataka u bazu podataka moguć je prikaz svih stavki iz baze podataka kao što su prikaz svih organizatora, izvođača, unesenih nastupa te izrađenih računa (poglavlje 4). 

# 4.4	Udaljeni sustav za kontrolu verzija
https://github.com/llerga12/EventupFinal.git

# 5	Korisnička dokumentacija
# 5.1	Namjena aplikacije

Aplikacija bi koristila administratorima koji bi vodili bazu podataka za nekog izvođača ili organizatora ili veće kulturno događanje. Omogućuje unos organizatora, izvođača, nastupa te izradu računa i prikaz svih navedenih stavki iz baze podataka. Primjer korištenja je upravljanje organizacijom kulturnih događanja u kojoj je potrebno unijeti nove organizatore, voditi evidenciju izvođača koji će nastupati, zakazivati i organizirati nastupe te kreirati račune za izvedene nastupe. 
5.2	Preuzimanje i instalacija

Da bi se aplikacija preuzela i instalirala potrebno je na računalu imati instaliranu Javu. 

5.3	Pokretanje aplikacije

Aplikacija bi se pokretala dvostrukim klikom na ikonu aplikacije te bi se pritom otvorio početni prozor. 
5.4	Korištenje aplikacije
Dvostrukim klikom na .jar datoteku otvara se početni prozor.
 
 
Klikom na gumb Novi organizator možemo unijeti podatke o novim organizatorima.
 
Klikom na OK javlja se poruka da su podaci uspješno spremljeni (spremljeni su u bazu podataka).
 
Klikom na gumb Prikaz organizatora prikazuju nam se svi organizatori iz baze podataka, uključujući i organizatora kojeg smo posljednje unijeli.
 
Klikom na gumb Novi račun otvara nam se prozor u kojem možemo izraditi novi račun. Odabiremo organizatore koji se nalaze u bazi podataka te šifru nastupa izvođača. Nadalje, unosimo sve ostale potrebne podatke. Klikom na OK javlja se poruka da je račun uspješno spremljen,
 

Klikom na gumb Prikaz računa prikazuju nam se svi stvoreni računi.
 
Klikom na gumb Novi izvođač otvara nam se prozor u kojem imamo mogućnosti unijeti podatke o novom izvođaču u bazu podataka. U slučaju da unesemo šifru koja već postoji u bazi podataka, javit će nam se greška. 
 
Klikom na gumb Prikaz izvođača prikazuju nam se svi izvođači spremljeni u bazi podataka.
 
# 6	Zaključak

"EventUp" je aplikacija koja omogućava administriranje podataka o izvođačima, organizatorima, nastupima i računima vezanim za glazbene festivale diljem Hrvatske. Aplikacija je razvijena s ciljem olakšavanja unosa, pregleda i manipulacije podacima, čime se znatno pojednostavljuje organizacija glazbenih događaja.
Glavne funkcionalnosti aplikacije uključuju: unos novih izvođača i organizatora s detaljnim informacijama, kreiranje novih nastupa te njihovo pregledavanje po datumu i mjestu održavanja, izradu računa za svaki nastup s detaljima o datumu, iznosu i pripadajućem organizatoru, prikaz svih unesenih podataka o izvođačima, organizatorima, nastupima i računima radi brzog i jednostavnog uvida.
Aplikacija je namijenjena administratorima koji su odgovorni za organizaciju glazbenih događaja. Njima pruža alate za učinkovito upravljanje podacima i optimizaciju procesa planiranja, što rezultira boljom organizacijom i transparentnošću u radu.
