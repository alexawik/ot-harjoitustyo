# Sävellajisovellus

Kirjautuneet käyttäjät vastaavat kysymyksiin sävellajien etumerkeistä ja saavat tästä pisteitä. Admin-salasanalla kirjautuva voi nähdä luettelon kirjautuneista käyttäjistä ja heidän pistemääristään.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Työkirjanpito](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/ty%C3%B6kirjanpito.md)

[Käyttöohje](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/k%C3%A4ytt%C3%B6ohje.md)

[Testausdokumentti](https://github.com/alexawik/ot-harjoitustyo/blob/master/dokumentointi/testaus.md)

## Releaset

[Viikko 6](https://github.com/alexawik/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/alexawik/ot-harjoitustyo/releases/tag/Loppupalautus)

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

### Javadoc

```
mvn javadoc:javadoc
```
Javadoc selaimessa: target/site/apidocs/index.html

### Jarin generointi

```
mvn package
```
Luo jar-tiedoston _otHarkkaSovellus-1.0-SNAPSHOT.jar_ hakemistoon 
_target_.
