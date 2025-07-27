# Middleware Engineering "Cloud-Datenmanagement" - Taskdescription

## Einführung
Diese Übung zeigt die Anwendung von verteilten Webservices an einer simplen Anforderung.

## Ziele
Das Ziel dieser Übung ist eine Webanbindung zur Benutzeranmeldung umzusetzen. Dabei soll sich ein Benutzer registrieren und am System anmelden können.  
Die Kommunikation zwischen Client und Service soll mit Hilfe einer REST Schnittstelle umgesetzt werden.

## Kompetenzzuordnung
#### GK SYT9 Dezentrale Systeme | Middleware Engineering | Serviceorientiert
* "anhand von bestimmten Anforderungen ein Webservice umsetzen"
#### GK SYT9 Dezentrale Systeme | Datenmanagement | Speicherkonzepte
* "Grundlagen zu zentralen und verteilten Datenspeicher"

## Voraussetzungen
+ Grundlagen einer höheren Programmiersprache
+ Verständnis über relationale Datenbanken und dessen Anbindung mittels ODBC oder ORM-Frameworks
+ Verständnis von Restful Webservices

## Aufgabenstellung
Es ist ein Webservice zu implementieren, welches eine einfache Benutzerverwaltung implementiert. Dabei soll die Webapplikation mit den Endpunkten `/auth/admin/register`, `/auth/signin` und `/auth/verify` erreichbar sein.

### Grundanforderungen

#### Registrierung
Diese soll mit einem Namen, einer eMail-Adresse als BenutzerID, einer Liste an Rollen (ADMIN, READER, MODERATOR) und einem Passwort erfolgen. Dabei soll noch auf keine besonderen Sicherheitsmerkmale Wert gelegt werden, jedoch ist das Passwort nicht unverschlüsselt abzulegen. Die Registrierung der Benutzer kann nur durch Administratoren erfolgen. Die Daten sollen in einem geeigneten Datastore (z.B. relationale Datenbank) abgelegt werden.

Beim initialen Start sollen Benutzer aus einem JSON-File geladen werden können. Dabei dürfen die Passwörter auf keinen Fall unverschlüsselt gespeichert sein.

#### Login
Der Benutzer soll sich mit seiner ID und seinem Passwort entsprechend einloggen können. Bei einem erfolgreichen Login soll eine entsprechende HTTP-Response zurück geben und ein signiertes JWT mitgeliefert werden, die auch die genehmigten Rollen enthält.

#### Verifizierung
`/auth/verify` gibt ein `403 UNAUTHORIZED`zurück, wenn das mitgelieferte JWT nicht der Signatur entspricht. Ansonsten wird eine positive Rückmeldung generiert und die Rolle bestätigt.


Verwenden Sie auf jeden Fall ein gängiges Build-Management-Tool (z.B. Gradle). Dabei ist zu beachten, dass ein einfaches Deployment möglich ist (auch Datenbank mit z.B. file-based DBMS). Überprüfen Sie die Funktionalität mit einfachen Methoden, die einfach nachvollziehbar sind und dokumentieren Sie diese (z.B. mit `curl` Befehlen).

## Fragestellungen
* Welche grundlegenden Elemente müssen bei einer REST Schnittstelle zur Verfügung gestellt werden?
* Wie stehen diese mit den HTTP-Befehlen in Verbindung?
* Welche Datenbasis bietet sich für einen solchen Use-Case an?
* Welche Erfordernisse bezüglich der Datenbasis sollten hier bedacht werden?
* Verschiedene Frameworks bieten schnelle Umsetzungsmöglichkeiten, welche Eckpunkte müssen jedoch bei einer öffentlichen Bereitstellung (Production) von solchen Services beachtet werden?

## Bewertung
Gruppengrösse: 1-2 Person(en)
### Grundanforderungen **überwiegend erfüllt**
- [ ] Dokumentation und Beschreibung der angewendeten Schnittstelle (Framework oder Plain-Implementierung)
- [ ] Aufsetzen und Deployment einer REST-Schnittstelle
### Grundanforderungen **zur Gänze erfüllt**
- [ ] Registrierung von Benutzern mit entsprechender Persistierung
- [ ] Login und Rückgabe eines JWT Tokens

### Classroom Repository
[Hier](https://classroom.github.com/a/t8sGFKJz) finden Sie das Abgabe-Repository zum Entwickeln und Commiten Ihrer Lösung.

## Quellen
* "Creating a Spring Security Key for Signing a JWT Token" [baeldung.com](https://www.baeldung.com/spring-security-sign-jwt-token)
* "Spring Boot JWT REST API Security" [github.com](https://github.com/caglayantolga/springboot-role-based-jwt-security-rest-api)
* "Getting Started with Spring Security and JWT" [reflectoring.io](https://reflectoring.io/spring-security-jwt/)
* "Spring Guides" [spring.io](https://spring.io/guides)
* "Creating a 'hello world' RESTful web service with Spring."; Spring examples; [online](https://github.com/spring-guides/gs-rest-service)
* "Django REST framework"; Tom Christie; [online](http://www.django-rest-framework.org/)
* "Eve. The Simple Way to REST"; Nicola Iarocci; [online](http://python-eve.org/)
* "Heroku makes it easy to deploy and scale Java apps in the cloud"; [online](https://www.heroku.com)

---
**Version** *20241003v4*

