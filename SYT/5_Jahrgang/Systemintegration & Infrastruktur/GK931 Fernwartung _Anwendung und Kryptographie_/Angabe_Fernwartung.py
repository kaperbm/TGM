# Cloud und Cluster Computing "Grundlagen und Anwendung"

## Einführung

In dieser Aufgabe wird Kubernetes als aktuelle Lösung zum Starten und Verwalten von verteilten Rechnungsresourcen behandelt. Kubernetes bietet sich hier als eine beliebte, konstenlose Open-Source Lösung, die bei den meisten Cloud-Anbietern aber auch im eigenen Einsatz in einer On-Premise Cloud zum Einsatz kommt.

## Ziele

- Einsatz von Orchestrierungs-Engine zur Bereitstellung und Skalierung von Containeranwendungen

## Kompetenzzuordnung

#### GK SYT9 Systemintegration und Infrastruktur | Cluster & Cloud Computing | Grundlagen

 - "die verschiedenen Ansätze für Cloud Computing erklären und konkrete Implementierungen vergleichen"

#### GK SYT9 Systemintegration und Infrastruktur | Cluster & Cloud Computing | Anwendung

 - "in einer Cloud-Umgebung eigene Dienste anbieten und betreiben"

#### EK SYT9 Systemintegration und Infrastruktur | Cluster & Cloud Computing | Anwendung

 - "eine private Cloud Lösung installieren, konfigurieren und darin eigene Dienste anbieten und betreiben"

## Voraussetzung
* Installation von minikube: [minikube start](https://minikube.sigs.k8s.io/docs/start/)

## Aufgabenstellung

### Kubernetes
**Disclaimer** *In Ermangelung des theoretischen Unterrichts, wird bei dieser Laborübung die Unterstützung von Kubernetes in Anspruch genommen. Die Tutorials auf Kubernetes.io werden als Basis für das Training mit der Cluster Engine verwendet.*

Kubernetes ist eine weit verbreitete Open-Source-Container-Orchestrierungs-Engine zur Automatisierung der Bereitstellung, Skalierung und Verwaltung von Containeranwendungen. [1]

*"Containers are a good way to bundle and run your applications. In a production environment, you need to manage the containers that run the applications and ensure that there is no downtime. For example, if a container goes down, another container needs to start. Wouldn't it be easier if this behavior was handled by a system?*

![Kubernetes](https://kubernetes.io/images/docs/Container_Evolution.svg)

*That's how Kubernetes comes to the rescue! Kubernetes provides you with a framework to run distributed systems resiliently. It takes care of scaling and failover for your application, provides deployment patterns, and more. For example: Kubernetes can easily manage a canary deployment for your system."* [2]

![Cluster Architecture](https://kubernetes.io/images/docs/kubernetes-cluster-architecture.svg)

#### Create a Cluster

Ein Kubernetes Cluster besteht aus einem Zentralen Dienst, dem "Control Plane", welches die im Cluster deployten Dienste administriert. Die deployten Dienste selbst werden auf Subinstanzen, sog. "Nodes", veteilt und können damit auf anderen physikalischen Maschinen laufen. [3]

`minkube` ist eine Kubernetes Implementation, die für den lokalen Einsatz z.B. zum Entwickeln & Testen geeignet ist. Zum Einrichten eines Clusters ist es nur notwendig, `minikube` zu installieren und `minikube start` auszuführen. [4] 

#### Deploy an App

Ein Deployment in Kubernetes ist die Anweisung, einen Dienst im Cluster zu starten und zu adminstrieren (Bereitstellen von Resourcen). Das Beispiel Image `gcr.io/google-samples/kubernetes-bootcamp:v1` soll nach diesem Schritt im Cluster laufen. [5]

#### Explore your App

Die Verteilung von einem Dienst im Cluster basiert auf zwei Einheiten: dem Pod und dem Node. Ein Pod ist eine Gruppierung von Containern und deren Resourcen, welche immer zusammen ausgeführt werden. Ein Deployment wird auf die Nodes des Clusters verteilt welche die Pods den Anweisungen entsprechend lokal ausführen. [6]

#### Expose Your App Publicly

Um auf die Dienste von außerhalb eines Pods zugreifen zu können, bietet Kubernetes Services an. Der erstellte Beispiel Container soll nach diesem Schritt von deiner Host-Maschine aus abrufbar sein [7]

#### Scale Your App

Um auf Nutzerlast (oder deren Abwesenheit) entsprechend reagieren zu können, macht es Kubernetes einfach, mehr (oder weniger) Pods für einen Dienst auf den Nodes des Clusters zu starten. Nach diesem Schritt sollen mehrere Pods für den Beispiel Container im Cluster laufen [8]

#### Update Your App

Um eine neue Version eines Containers ohne große Unterbrechungen zur Verfügung zu stellen, führt Kubernetes Änderungen an z.B. dem verwendeten Image *rollend* (rolling) durch. Hierblei bleiben jederzeit nutzbare Container übrig und es werden nicht alle Pods im Cluster gleichzeitig aktualisiert. Nach diesem Schritt soll der Beispiel Dienst der Version `v2` laufen. [9]

## Fragestellung

 1. Wie unterscheiden sich klassische VMs und Container?
 2. Welche Funktionen werden durch Orchestrierung übernommen?
 3. Welchen Zweck erfüllen Nodes in einem Cubernetes Cluster?

## Bewertung

Gruppengröße: 1-2 Person(en)

### Grundanforderungen überwiegend erfüllt

 - [ ] Kubernetes Client installieren und ein lokales Cluster einrichten
 - [ ] einen Dienst im Kubernetes Cluster deployen
 - [ ] Zugang auf den Dienst erhalten

### Grundanforderungen zur Gänze erfüllt

 - [ ] zusätzliche Pods für den Dienst im Cluster starten
 - [ ] den Dienst im Cluster rollend aktualisieren

## Classroom Repository

[Hier](https://classroom.github.com/a/rw8UxoH6) finden Sie das Abgabe-Repository zum Entwickeln und Commiten Ihrer Lösung.

## Help! "Oh, I need somebody ..."

*"Copy&Paste is all you need!"*


## Quellen

 - [1] "Kubernetes Documentation" [online](https://kubernetes.io/docs/home/)
 - [2] "Why you need Kubernetes and what it can do " [online](https://kubernetes.io/docs/concepts/overview/#why-you-need-kubernetes-and-what-can-it-do)
 - [3] "Create a Cluster" [online](https://kubernetes.io/docs/tutorials/kubernetes-basics/create-cluster/cluster-intro/)
 - [4] "minikube start" [online](https://minikube.sigs.k8s.io/docs/start/)
 - [5] "Deploy an app" [online](https://kubernetes.io/docs/tutorials/kubernetes-basics/deploy-app/deploy-intro/)
 - [6] "Viewing Pods and Nodes" [online](https://kubernetes.io/docs/tutorials/kubernetes-basics/explore/explore-intro/)
 - [7] "Expose Your App Publicly" [online](https://kubernetes.io/docs/tutorials/kubernetes-basics/expose/expose-intro/)
 - [8] "Scale Your App" [online](https://kubernetes.io/docs/tutorials/kubernetes-basics/scale/scale-intro/)#
 - [9] "Update Your App" [online](https://kubernetes.io/docs/tutorials/kubernetes-basics/update/update-intro/)

---
**Version** *20241003v2*

