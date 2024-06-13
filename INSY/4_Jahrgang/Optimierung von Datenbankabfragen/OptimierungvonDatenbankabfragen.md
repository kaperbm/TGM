# Optimierung von Datenbankabfragen

**Author:** Kacper Bohaczyk

## Voraussetzungen

Virtuelle Maschine - VMWare

​	Ubuntu 22.04
​	Postgresql
​	pgadmin4
​	Importieren der SQL Datenbank



## Beispiel 1

```sql
CREATE INDEX idx_bdatum ON bestellung (bdatum);
SELECT bnr, bstatus, bdatum  
    FROM bestellung
    WHERE TO_CHAR(bdatum, 'YYYY') = '2017';
```

### Aufgabe

Kann die gegebene Query den Index nutzen? Begruende deine Antwort! Falls nein, wie kann man die Query entsprechend aendern? Kann man vielleicht alternativ auch den Index aendern?

### Lösung

Execution Time liegt durchschnittlich bei **3ms** wenn ich den Index verwende, aber ohne Index braucht es auch durchschnittlich **3ms**. Somit ist dieser Index, aufgrund von TO_CHAR(), welches die Sortierung verhindert, nicht effizient.

Um es aber dann effizient zu machen, kann man folgendes machen:

```sql
SELECT bnr, bstatus, bdatum  
    FROM bestellung
    WHERE bdatum >= DATE '2017-01-01' AND bdatum < DATE '2018-01-01';
```

Damit liegt die Execution Time durchschnittlich mit Index bei **0.1ms** und ohne Index bei ca. **1ms**. Das könnte wichtig sein, wenn ich zum Beispiel mehr Daten habe, welche sortiert werden müssen.

## Beispiel 2

```sql
CREATE INDEX idx_zusammen ON bestellung (bstatus, bdatum);	
SELECT id, bstatus, bdatum  
    FROM bestellung
    WHERE bstatus = %
    ORDER BY bdatum DESC
    LIMIT 1;
```

### Aufgabe

Was liefert die gegebene Query als Resultat? Kann sie den Index effizient nutzen? Falls nein, wie muesste man den Index dafuer aendern?

### Lösung

Execution Time liegt durchschnittlich bei **0.04ms** wenn ich den Index verwende, aber ohne Index braucht es auch durchschnittlich **0.7ms**. Somit ist dieser Index effizient.

## Beispiel 3

```sql
CREATE INDEX idx_artikel ON artikel (anr, vstueckz);  

SELECT id, anr, vstueckz  
    FROM artikel
    WHERE anr = %
    AND vstueckz = %;

SELECT id, anr, vstueckz  
    FROM artikel
    WHERE vstueckz = %;
```

### Aufgabe

Koennen die gegebenen Queries den Index effizient nutzen? Begruende deine Antwort. Falls nein, wie muesste man ihn Index dafuer aendern?

### Lösung

Execution Time liegt durchschnittlich bei **0.1ms** wenn ich den Index verwende, aber ohne Index braucht es auch durchschnittlich **1.3ms**. Somit ist dieser Index effizient.

## Beispiel 4

```sql
CREATE INDEX idx_emails ON kunde (email varchar_pattern_ops);

SELECT id from kunde where email like 'rlugner%';
SELECT id from kunde where email like '%moertel.at';  
```

### Aufgabe

Unterscheiden sich die beiden Queries stark in ihrer Performance? Falls ja, warum? Weiters, falls ja, wie sollte man Queries und Index aendern, damit fuer beide der Index genutzt werden kann?

### Lösung

Ja sie unterscheiden sich. Der Index ist für die erste Query effizient da die Suche mit dem Index schneller als die ohne Index ist. Dies gilt aber nicht für die zweite Query, da mit oder oder index die Execution Time ziemlich gleich ist.

Um das aber zu fixen kann man folgendes machen: 

```sql
CREATE INDEX idx_emails_reverse ON kunde (REVERSE(email));
SELECT id from kunde where email like REVERSE('%moertel.at');
```

Durch die Verwendung eines umgekehrten Index kann die Leistungsfähigkeit von Abfragen verbessern, die mit einem festen Präfix beginnen. Wichtig dabei zu beachten dass bei der Query abfrage der Wert auch noch einmal reversed werden muss.

## Beispiel 5

```sql
CREATE INDEX idx_bestellung_2 ON bestellung (bdatum, kunde_id);  

SELECT id, bdatum, kunde_id  
    FROM bestellung
    WHERE bdatum > CURRENT_DATE - INTERVAL '30' YEAR
    AND kunde_id = 42;
```

### Aufgabe

Kann die angegebene Query den Index so effizient wie moeglich nutzen? Falls nein, wie muesste man ihn dafuer aendern?

### Lösung

Es macht keinen so großen Unterschied ob ein Index hier verwendet wird oder nicht, da mit dem Index die Execution Time ca. **0.2ms** beträgt und ohne Index ca. **0.7ms** 

## Beispiel 6

### Aufgabe

Erklaere, wie und warum sich durch die Verwendung von Prepared Statements die Performance einer Query unter Umstaenden auch stark verschlechtern kann.

```sql
SELECT id from bestellung where bdatum > '2017-01-01' and bdatum <= '2017-01-02'
```

### Lösung

Die Verwendung von Prepared Statements kann die Leistung verschlechtern, wenn die Abfragebedingungen stark variieren. Der Grund liegt darin, dass der Abfrageplan bei der Vorbereitung der Abfrage ohne konkrete Werte für die Parameter erstellt wird. Dies kann dazu führen, dass der Plan für bestimmte Parameterwerte ineffizient ist. Dynamische Abfragen können dieses Problem beheben, da sie es dem Datenbankmanagementsystem ermöglichen, Abfragepläne basierend auf den konkreten Parameterwerten zu erstellen.