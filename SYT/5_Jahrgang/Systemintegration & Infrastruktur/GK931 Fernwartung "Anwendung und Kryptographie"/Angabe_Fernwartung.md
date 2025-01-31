# Fernwartung "Anwendung und Kryptographie"

## Einführung
Diese Aufgabe soll die Möglichkeit bieten SSH-Tunnling, ferngesteuerte Desktop-Anwendungen und benutzerfreundliche VPN-Verbindungen zu konfigurieren und zu testen. Dabei sollen die verschiedenen Technologien gegenübergestellt und auf ihre Einsetzbarkeit überprüft werden.

## Ziele
- Einsatz von Secure-Shell zur Weiterleitung von Services über deren Ports.
- Grafische Oberflächen in unsicheren Netzwerken verwenden.
- VPN-Netze einfach und schnell einsetzbar machen.

## Kompetenzzuordnung
**GK SYT9 Systemintegration und Infrastruktur | Fernwartung | Anwendung**  
* "Fernwartungstechniken beschreiben und diese im Unternehmen geeignet einsetzen"

**EK SYT9 Systemintegration und Infrastruktur | Fernwartung | Mathematik**  
* "die mathematischen Grundlagen für Verschlüsselung verstehen und anwenden"


## Aufgabenstellung

### SSH

Die Grundlegende Funktion von SSH ist die Herstellungen einer sicheren Verbindung zwischen zwei Systemen. Üblicherweise werden über diese Verbindung Shell Eingaben und Ausgaben ausgetauscht, was Fernwartung ermöglicht, aber auch andere Dienste können über die SSH-Verbindung übertragen werden.

Richte zwei Instanzen (Docker Container, VMs) ein, die folgend beispielhaft "Client" und "Server" genannt werden. Beide benötigen für die Aufgabe einen laufenden SSH Server (`openssh`). Zur Sicherheit des Servers soll dieser nur bereits bestehende Verbindungen von außerhalb akzeptieren. Nun soll eine Möglichkeit gefunden werden, eine SSH-Verbindung vom Client zum Server herzustellen, ohne die Sicherheit des Servers gegenüber eingehenden Netzwerkverbindungen zu beeinträchtigen.

#### Tunneling

SSH-Tunnel leiten unter anderem beliebige TCP-Verbindungen über die SSH-Verbindung weiter. Sie können daher auch verwendet werden um weitere SSH-Verbindungen weiterzuleiten. Richte also einen SSH-Tunnel vom Server zum Client ein, der es möglich macht, den SSH-Server am Server vom Client aus zu erreichen. Zur (automatischen) Authentifizierung soll das Public-Key-Verfahren verwendet werden, generiere also am Server ein zur Automatisierung geeignetes Schlüsselpar und installiere es am Client.

#### Automatisierte Verbindung

Der Tunnel soll automatisch beim Start des Servers hergestellt werden. Wenn Systemd als Init-System verwendet wird kann dies mit einem Service umgesetzt werden:

```bash
[Unit]
Description=SSH-Tunnel
After=systemd-networkd-wait-online.service
Requires=systemd-networkd-wait-online.service

[Service]
Type=simple
ExecStart= ???
Restart=always
RestartSec=5

[Install]
WantedBy=multi-user.target

```
Es fehlt hierbei noch die **ExecStart** Definition. Welcher Befehl gehört da hinein? Wiederholung: Wie aktiviert man nun dieses Systemd-Service?

*Achtung*: Docker bietet keine Systemd Umgebung (in Docker startet normalerweise nur der Dienst, den man verwenden möchte, KEIN Init-System). Unter Docker muss man stattdessen dafür sorgen, dass der Befehl beim Start des Containers ausgeführt wird (z.B. mit `ENTRYPOINT` und einem Startskript, welches `sshd` von `openssh` startet und den Tunnel aufbaut). Besser wäre die Server-Einheit auf einer virtuellen Instanz (VMware oder Virtualbox) zu installieren, damit die automatisierte Konfiguration leichter umgesetzt werden kann.

#### Fernwartung

Über den bisher erstellten Tunnel gibt es nun eine Möglichkeit den SSH-Server am Server vom Client aus zu erreichen. Die Authentifizierung vom Client zum Server soll auch auf einem Schlüssel basieren, richte also auch hier einen Schlüssel ein, der allerdings für die interaktive Nutzung geeignet ist.

### Webaccessed Desktop Environment

SSH kann auch die Weiterleitung von X-Window Anwendung über die Konfiguratin (sshd-config) **X-Forwarding** aktivieren. Dabei würde nur der Output von einzelnen Anwendungen über die SSH-Verbindung weitergeleitet werden. *Virtual Network Connection (VNC)* ist eine Möglichkeit die gesamte X-Window Umgebung des Window-Manager mit entsprechende Clients über das Netzwerk zu übertragen. Anleitungen und Konfigurationsmöglichkeiten sind im [Arch-Wiki](https://wiki.archlinux.org/title/TigerVNC) einzusehen.

Um mehreren Benutzern den Zugriff auf graphische Oberflächen zu gestatten, kann z.B. über [Apache Guacamole](https://guacamole.apache.org/) der Desktop auf einer HTTPS Seite bereitgestellt werden.

Die Aufgabenstellung zeigt eine einfache Umsetzung einer Desktopumgebung im Browser mit [webtop](https://github.com/linuxserver/docker-webtop), die über einen Docker-Container konfiguriert und gestartet werden kann. Es soll eine einfache Benutzerkennung mit entsprechendem Volumen für das Home-Directory im Host-System bereitgestellt werden. Dabei soll eine resourcenschonende Desktopumgebung ausgewählt werden (z.B. arch und xfce4).

#### Remote Desktop Tools
Um auf den entfernten Rechner einer anderen Person zuzugreifen und dieser bei administrativen Tätigkeiten zu unterstützen, bieten sich zwei einfache Lösungen an: TeamViewer und Anydesk. Unterschiede bei den Sicherheitsaspekten könnten zu einer dieser Lösung tendieren, welche wäre diese?

Nach der Installation von AnyDesk soll eine Verbindung zum Gruppenmitglied erfolgen, um die Standard-Einstellungen zu testen.

### VPN

*Virtual Private Network (VPN)* ist ein Mechanismus um eine sichere Verbindung zwischen Netzwerken und entfernten Rechner in ungesicherten Umgebungen anzubieten. Die Topologie und die dahinter steheden Kryptographie Verfahrn sind in dieser Grafik aufgelistet: ![VPN Topologie](https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/VPN_classification-en.svg/1920px-VPN_classification-en.svg.png)

Die Auswahlkriterien sind dabei immer von den schon bestehenden Netzwerkstrukturen abhängig.

Eine schnelle und einfache Möglichkeit eine sichere VPN Verbindung zu konfigurieren ist [Wireguard](https://www.wireguard.com/). Es soll eine Docker-Instanz konfiguriert werden, um das Service einfach deployen zu können. Welche Default-Einstellungen sind dabei zu beachten bzw. welches Kryptographie-Verfahren wird dabei verwendet? Es soll dokumentiert werden, wie ein Client über den QR-Code bzw. über die Config-Datei sich mit dem Service verbinden lässt.


#### VPN@home with Dynamic-DNS

Heimnetzzugänge bekommen in bestimmten Intervallen eine neue IP-Adresse zugeordnet und haben daher keine konstante IP-Adresse, über die man auf eigene Geräte bzw. Dienste zugreifen kann. Dynamic-DNS Dienste wie [No-IP](https://noip.com/) bieten die Möglichkeit einen DNS-Eintrag kontinuierlich mit der IP-Adresse zu aktualisieren.

Der [No-IP Update-Client](https://my.noip.com/dynamic-dns/duc) kann verwendet werden um einen lokalen Rechner (z.B. einen Raspberry PI) im Internet bereitstellen. Installiere dazu den Update Client auf dem Raspberry-Pi und schließe die Einrichtung ab, sodass No-IP die öffentliche IP des Raspberry-Pis erhält. Um den, wie im vorherigen Schritt eingerichteten, Wireguard-Server jetzt erreichbar zu machen, fehlt nur noch eine Port-Weiterleitung in der Konfiguration des Heimrouters, welche den für Wireguard konfigurierten Port von außerhalb and den Raspberry-Pi weiterleitet.

Um noip automatisch zu starten empfiehlt sich wieder einen Systemd-Service unter `/etc/systemd/system/noip2.service` zu erstellen:

```shell
[Unit]
Description=No-ip.com dynamic IP address updater
After=network.target
After=syslog.target

[Install]
WantedBy=multi-user.target
Alias=noip.service

[Service]
ExecStart=/usr/local/bin/noip2
Restart=Always
Type=forking
```

und anschließend mit

```bash
# systemctl daemon-reload
# systemctl start noip2.service
# systemctl enable noip2.service
```

zu starten und für den Autostart zu markieren.

## Fragestellungen

1. Was ist der Vor- bzw. Nachteil bei der Verwendung von Passwörtern im Key-Authentication Verfahren?
2. Wie kann man verschiedene Keys bei verschiedenen SSH-Connections einsetzen?
3. Was ist VNC und wie kommt es zum Einsatz?
4. Wie kann man mit einem Browser eine Desktop-Umgebung einsetzen?
5. Welche Kryptographie-Protokolle kommen bei Wireguard zum Einsatz? Wo werden diese beschrieben?
6. Welchen Ansatz verfolgt Wireguard bei der Bearbeitung von unauthentifizierten Packages? Tipp: *Silence is a Virtue*

## Bewertung
Gruppengrösse: 1-2 Person(en)

### Grundanforderungen überwiegend erfüllt
- [ ] SSH Tunnel erstellen
- [ ] Webaccess auf Desktop Umgebung eingerichtet
- [ ] Standard-Einstellungen von AnyDesk dokumentiert

### Grundanforderungen zur Gänze erfüllt
- [ ] automatisierte Verbindung von SSH-Server auf Zwischenstation
- [ ] Einrichtung von Wireguard

## Classroom Repository
[Hier](https://classroom.github.com/a/2g-IYfsy) finden Sie das Abgabe-Repository zum Entwickeln und Commiten Ihrer Lösung.

## Help! "Oh, I need somebody ..."

### SSH

#### IP-Tables auf Docker

In docker: `--cap-add NET_ADMIN --cap-add NET_RAW`

In docker compose:

```yaml
services:
    [name]:
        cap_add:
            - NET_ADMIN
            - NET_RAW
```

#### IP-Tables zur Isolation

```bash
# iptables -A INPUT -s localhost -j ACCEPT # Accept all connections from localhost
# iptables -A INPUT -p tcp -m conntrack --ctstate INVALID,NEW -j REJECT # Reject new and invalid TCP Connections
```

#### SSH Key generieren
`ssh-keygen`, Konfigurationswerte dem Einsatzzweck entsprechend wählen (Leer lassen für Standardwerte), erzeugt `~/.ssh/id_rsa` (private key) `~/.ssh/id_rsa.pub` (public key).

#### SSH key teilen
Den public key in die Datei `~/.ssh/authorized_keys` auf dem Zielserver kopieren. Dies kann vereinfacht werden mit dem Befehl `ssh-copy-id`.

#### SSH Tunnel aufbauen
`ssh -L` (Leitet von lokal zu entfernt weiter) und `ssh -R` (Leitet von entfernt zu lokal weiter)

#### Automatisiert
```shell
ExecStart=/bin/bash -c "ssh -N -R [host@remote:]port@remote:host@local:port@local remote-address"
```

Wenn host@remote leer oder '*' ist, dann empfängt SSH auf allen Adressen Verbindungen.

## Quellen
* "AnyDesk vs TeamViewer: Remote desktop software comparison" Brenna Miles, TechRepublic [online](https://www.techrepublic.com/article/anydesk-vs-teamviewer/)
* https://wiki.archlinux.org/title/OpenSSH
* https://docs.docker.com/engine/reference/run/#runtime-privilege-and-linux-capabilities
* https://docs.docker.com/compose/compose-file/compose-file-v3/#cap_add-cap_drop
* https://linux.die.net/man/8/iptables
* https://linux.die.net/man/1/ssh
* https://wiki.archlinux.org/title/TigerVNC
* https://guacamole.apache.org/
* https://hub.docker.com/r/linuxserver/webtop
* https://github.com/linuxserver/docker-webtop
* https://en.wikipedia.org/wiki/Virtual_private_network
* https://www.researchgate.net/publication/345681297_Paper-Comparison_of_VPN_Protocols_at_Network_Layer_Focusing_on_Wire_Guard_Protocol_Comparison_of_VPN_Protocols_at_Network_Layer_Focusing_on_Wire_Guard_Protocol/link/611288dc1e95fe241ac1fcbe/download
* https://www.wireguard.com/protocol/
* https://www.wireguard.com/papers/wireguard.pdf
* https://noip.com
* https://my.noip.com/dynamic-dns/duc (nur angemeldet erreichbar!)

---
**Version** *20241003v2*

