Viikkotehtävä 3 Kotlin

Selitä MVVM, miksi se on hyödyllinen Compose-sovelluksissa.

Compose-sovelluksissa MVVM on hyödyllinen, koska käyttöliittymä perustuu tilaan. ViewModel hallitsee sovelluksen tilaa ja Compose-näkymä reagoi automaattisesti sen muutoksiin. Tämä tekee koodista selkeämpää, helpommin testattavaa ja paremmin ylläpidettävää sekä auttaa säilyttämään datan esimerkiksi näytön käännössä.

Kerro miten StateFlow toimii.

StateFlow on Kotlin Coroutines -kirjaston osa, jota käytetään tilan hallintaan. Se on hot flow, eli se on aina aktiivinen ja sillä on aina nykyinen arvo. Kun arvo muuttuu, kaikki sitä keräävät (collect) saavat uuden arvon automaattisesti.

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
