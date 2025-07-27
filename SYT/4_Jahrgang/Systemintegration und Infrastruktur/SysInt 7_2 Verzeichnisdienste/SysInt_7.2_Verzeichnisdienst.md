@author Kacper Bohaczyk
@version 21.11.2023

---
- Installation des OpenLDAP Servers (`slapd`) und weiterer Hilfsmittel (`ldap-utils`)

```
sudo apt install slapd ldap-utils
```

write admin login 2x


- Konfiguration des OpenLDAP Servers für die Domain "syt.tgm.ac.at" (`dpkg-reconfigure slapd`)
```
sudo dpkg-reconfigure slapd
```


In die /etc/ldap/ directory switchen und ldap.conf öffnen
```
cd /
cd etc
cd ldap
nano ldap.conf
```

```
BASE dc=syt.tgm.ac,dc=at
URI ldap://syt.tgm.ac.at ldap://ldap-provider.syt.tgm.ac.at:666
```


- Hinzufügen von Benutzern (mindestens 2, verwende deine persönlichen Daten)

ay
ldapscripts | installieren

```
sudo apt install ldapscripts
```

edit the file /etc/ldapscripts/ldapscripts.conf

- Adjust _SERVER_ and related _SUFFIX_ options to suit your directory structure.
- Here, we are forcing use of _START_TLS_ (**`-ZZ`** parameter). Refer to [LDAP with TLS](https://ubuntu.com/server/docs/service-ldap-with-tls) to learn how to set up the server with TLS support.


```
SERVER=ldap://ldap01.syt.tgm.ac.at
LDAPBINOPTS="-ZZ"
BINDDN='cn=admin,dc=example,dc=com'
BINDPWDFILE="/etc/ldapscripts/ldapscripts.passwd"
SUFFIX='dc=example,dc=com'
GSUFFIX='ou=Groups'
USUFFIX='ou=People'
MSUFFIX='ou=Computers'
```


Estellen von Gruppen und Usern

adden einer Gruppe:

```
sudo ldapaddgroup schuller
```
adden eines Users zur Gruppe

```
sudo ldapaddusertogroup kacper schuller
```

adden einer 2 Gruppe:

```
sudo ldapaddgroup lehrer
```

adden eines 2 Users zur Gruppe

```
sudo ldapaddusertogroup schabel lehrer
```
