
# CryptoVault Backend

CryptoVault Backend est l’API serveur de l’application **CryptoVault**, une plateforme permettant la gestion d’un portefeuille de cryptomonnaies.  
Elle prend en charge la logique métier, la persistance des données et la communication entre la base de données et l’interface frontend.

Voici le lien du frontend :https://github.com/BradLeneus/projetCryptoVaultFrontend/tree/dev

---

## 🔹 Fonctionnalités principales

- Gestion des utilisateurs  
- Gestion du portefeuille (ajout, modification, suppression d’actifs)
- Suivi de la valeur des cryptomonnaies
- Communication avec le frontend CryptoVault

---

## 🔹 Technologies utilisées

- **Java**
- **Spring Boot**
- **Maven**
- **MariaDB**

---

## Configuration de la base de données (MariaDB)

Avant de démarrer l’application, MariaDB doit être installé et en fonctionnement.

### 1. Création de la base de données

Dans un terminal ou un client MariaDB, exécuter la commande suivante :

```sql
CREATE DATABASE fullstack;
````

La base de données **doit porter ce nom**, car elle est attendue par la configuration du projet.

### 2. Configuration des identifiants

Vérifier que les identifiants MariaDB correspondent à la configuration de `application.properties` ou `application.yml`.

Exemple (`application.properties`) :

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/fullstack
spring.datasource.username=root
spring.datasource.password=VOTRE_MOT_DE_PASSE

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


---

##  Installation

### 1. Cloner le projet

```bash
git clone https://github.com/BradLeneus/projetCryptoVaultBackend.git
cd projetCryptoVaultBackend
git checkout dev
```

### 2. Installer les dépendances

```bash
mvn clean install
```

---

##  Démarrage de l’API

S’assurer que la base de données MariaDB est en fonctionnement, puis lancer l’application :

```bash
mvn spring-boot:run
```

Une fois démarrée, l’API est accessible à l’adresse suivante :

 **[http://localhost:8586](http://localhost:8586)**


## Vous devez lancer le backend avant le frontend
