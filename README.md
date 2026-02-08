Viikkotehtävä 4 kotlin

Selitä lyhyesti:
Mitä tarkoittaa navigointi Jetpack Composessa.
- Navigointi Jetpack Composessa tarkoittaa siirtymistä eri näkymien välillä sovelluksessa.

Mitä ovat NavHost ja NavController.
-NavController hallitsee navigointia, eli tietää missä näkymässä ollaan ja mahdollistaa siirtymisen toiseen näkymään.
-NavHost määrittelee navigaatiokartan mitkä näkymät sovelluksessa on ja mikä Composable näytetään kussakin reitissä.

Miten sovelluksesi navigaatiorakenne on toteutettu (Home ↔ Calendar).
-NavHost määrittelee reitit ROUTE_HOME ja ROUTE_CALENDAR.
-Home -> Calendar painikkeella kutsutaan navController.navigate(ROUTE_CALENDAR)
-Calendar -> Home painikkeella kutsutaan navController.navigate(ROUTE_HOME)

Kuvaa arkkitehtuuri:
Miten MVVM ja navigointi yhdistyvät (yksi ViewModel kahdelle screenille).
-MVVM ja navigointi yhdistyvät siten, että navigointi vaihtaa vain näkymää, ei dataa.

Miten ViewModelin tila jaetaan kummankin ruudun välillä.
-ViewModel toimii yhteisenä lähteenä, jota molemmat ruudut käyttävät.

Selitä lyhyesti:
Miten CalendarScreen on toteutettu (miten tehtävät ryhmitellään / esitetään kalenterimaisesti).

-CalendarScreen vastaa vain esitystavasta, kun taas dialogit hoitavat käyttäjän syötteen.

Miten AlertDialog hoitaa addTask ja editTask.

-AddTask- ja EditTask-toiminnot on toteutettu AlertDialogilla, joka avautuu ViewModelin tilan perusteella. Dialogit keräävät käyttäjän syötteen ja välittävät sen ViewModelille, joka vastaa tehtävien lisäämisestä ja päivittämisestä.



Viikkotehtävä 1 kotlin

Android-sovellus, jossa voi:

Lisätä uusia tehtäviä
Merkitä tehtäviä tehdyksi tai tekemättömäksi
Suodattaa tehtäviä tilan mukaan (kaikki / tekemättömät / tehdyt)
Lajitella tehtävät päivämäärän mukaan
Esimerkkitehtävät mockTasks
Funktiot tehtävien käsittelyyn: lisääminen, tila-muutos, suodatus ja lajittelu
Käyttöliittymä Composella, listanäkymä ja napit toimintoihin

Asennus ja ajaminen

1.Kloonaa projekti
2.Avaa Android Studiossa
3.Aja sovellus Android laitteessa tai emulaattorissa

