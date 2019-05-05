# Arkkitehtuurikuvaus

## Rakenne

### Pakkaukset
Ohjelman pakkausrakenne:

<img src="https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/images/packages.jpg" width="300">

### Luokkien väliset yhteydet

Ohjelman luokkien väliset suhteet ja attribuutit:

<img src="https://yuml.me/1eacb2c9.jpg">

## Toiminnallisuus

Keskeisimmät toiminnallisuudet:

Käyttäjän kirjautuessa luodaan tilapäisesti uusi Kayttaja-olio, jota verrataan Kayttajat-listan olioihin.

<img src="https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/images/kirjautumissekvenssi.png">


Kun käyttäjä vastaa kysymykseen, vastausta verrataan ratkaisuun, ja oikeasta vastauksesta annetaan yksi piste.

<img src="https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/images/vastaussekvenssi.png">

### Tiedostot

Ohjelma lukee tarvitsemansa sävellajit tekstitiedostosta jota ei voi ohjelmasta käsin muokata (tämä ei olisi suotavaakaan). Käyttäjien tiedot luetaan myös tekstitiedostosta, johon tiedot myös tallennetaan kun uusia käyttäjiä lisätään, sekä ohjelman sulkeutuessa, pisteiden tallentamiseksi.

### Rakenteen heikkoudet

Käyttöliittymässä jonkin verran sovelluslogiikkaa jonka voisi refaktoroida ulkopuolelle. Tällaisenaan sovelluksen käyttötarkoituksia ei voi suuresti laajentaa ilman rakenteellisia muutoksia. Olisi myös mielekkäämpää jos sävellajit luettaisiin db- eikä txt-tiedostosta.
