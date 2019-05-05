# Testausdokumentti

Ohjelman toimivuutta on testattu sekä automatisoidusti JUnit-testien avulla että manuaalisesti järjestelmätasolla.

## Sovelluslogiikan testaus

Sovelluksen toimintaa on testattu testiluokkien KayttajatTest, SavellajitTest ja TehtavanSuoritusTest avulla.
Nämä ovat pakkauksen ot.operations luokkia testaavia JUnit-testejä, joidenka kautta myös pakkauksen ot.domain luokkien toimivuutta on testattu.

### Testauskattavuus

Käyttöliittymän ulkopuolella testauksen rivikattavuus on 94% ja haarautumakattavuus 95%. Testaamatta jäävät try-catch -tilanteet, joissa tiedostoa ei voida lukea.

<img 
src="https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/images/testikattavuus.png">

## Järjestelmätestaus

Sovelluksen asennusta on testattu käyttöohjeen mukaisesti. Määrittelydokumentin toiminnallisuus on käyty läpi ja esimerkiksi virheellisten syötteiden antamista on testattu.

## Laatuongelmat

Ohjelman käyttämä tieto sävellajeista on tallennettuna tekstitiedostoon kuten myös käyttätiedot. Jos ohjelman yrittää käynnistää ilman näitä tiedostoja, ne luodaan juurikansioon, mutta ohjelma ei käynnisty ilman tietoa sävellajeista (toki tällöin ohjelma on myös täysin hyödytön).
Sävellajit olisi myös voinut tallentaa oikeaan tietokantaan.
