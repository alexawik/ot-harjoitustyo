# Tehtäväsovellus

Kirjautuneet käyttäjät voivat tehdä musiikin teoriaan liittyviä tehtäviä joista saavat pisteitä. Admin-salasanalla kirjautuva voi nähdä luettelon kirjautuneista käyttäjistä ja heidän pistemääristään.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Työkirjanpito](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/ty%C3%B6kirjanpito.md)

## Komentorivikomennot

### Käynnistys

Käynnistäminen projektikansiosta komennolla

```
mvn compile exec:java -Dexec.mainClass=ot.otharkkasovellus.Kayttis
```

### Testaus
Testikattavuusraportti komennolla

```
mvn jacoco:report
```

### Checkstyle

[checkstyle.xml](https://github.com/alexawik/ot-harjoitustyo/blob/master/otHarkkaSovellus/checkstyle.xml)-tiedoston määrittelemät testit suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
``` 
