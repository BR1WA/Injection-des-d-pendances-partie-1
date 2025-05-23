# Injection des Dépendances - Partie 1

Ce projet présente une introduction pratique à l’injection des dépendances en Java, en particulier avec le framework **Spring Boot**.

## 🧠 Objectif

Comprendre les concepts fondamentaux de l’injection de dépendances (IoC - Inversion of Control) à travers un exemple simple, sans utiliser le framework Spring dans cette première partie.

## 📁 Structure du projet

```
src/
├── dao/
│   └── IDao.java
├── metier/
│   ├── IMetier.java
│   └── MetierImpl.java
├── pres/
│   ├── Pres1.java
│   └── Pres2.java
```

* **IDao.java** : Interface de la couche d'accès aux données.
* **MetierImpl.java** : Implémentation de la couche métier utilisant l’injection de dépendance.
* **Pres1.java / Pres2.java** : Classes de test pour illustrer les différents types d’injection.

## ✅ Concepts abordés

* Injection des dépendances par instanciation statique (`new`)
* Injection des dépendances via la réflexion (`Class.forName`)
* Avantages de l’IoC (Inversion of Control)
* Découplage des composants

## ▶️ Exécution

Ce projet peut être exécuté directement en ligne de commande ou via un IDE comme IntelliJ ou Eclipse.

1. Cloner le projet :

   ```bash
   git clone https://github.com/BR1WA/Injection-des-d-pendances-partie-1.git
   ```

2. Ouvrir le projet dans un IDE Java

3. Exécuter `Pres1.java` ou `Pres2.java`

## 💪 Prérequis

* Java JDK 8 ou supérieur
* IDE Java (IntelliJ IDEA recommandé)

## 📚 Ressources

* [Documentation Spring](https://spring.io/docs)
* [Tutoriels YouTube/Enseignants accompagnant ce projet](https://www.youtube.com/watch?v=vOLqabN-n2k)

## 📄 Licence

Ce projet est libre d'utilisation à des fins pédagogiques.
