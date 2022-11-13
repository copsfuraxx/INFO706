# Compte-rendu TP INFO706 - La gestion d'un parking
 
> ***Thomas VATE***
>
> ***Jules FINCK***
>
> ***Amandine GROS***

---

## **Choix d'implantation**

Les models :

- `Ticket` : 

    * Le ticket à son id(`int`).

    * Une date d'entrée qui est initialisé à la création du ticket et une date de sortie qui sera remplie lors de la sortie du parking. Ce sont des `LocalDateTime` pour éviter les problèmes liées aux fuseau horaire.

    * Une `List` de `Payement` en `OneToMany` comme un ticket peut avoir plusieur payements.

    * Une méthode `getTotalMontant()` pour recuperer le total payé sur ce ticket.

    * Une méthode `getPrice(LocalDateTime now)` pour récuper la somme à payer pour sortir.

    * Une méthode `minutesBetween(LocalDateTime from, LocalDateTime to)` qui retourne le nombre de minute entre deux dates.

    * Une méthode `isValid(LocalDateTime now)` pour verifier si le ticket est valable pour sortir du parking.

- `Payement` :

    * Un payement à son id(`int`)

    * Un type de payement(`PayementType` => un type énumératif)
    
    * Une date(`LocalDateTime`)
    
    * Un montant(`double`) *dans l'idée c'est en €*

    * une methode `isValid(LocalDateTime now)` qui retourne vrai si le paiement à été effectué il y a moins de 15 minutes
---

## **Utilisation de l'application**

Pour l'utilisation de l'application il suffira d'aller sur l'url `localhost:8080`, suivit du nom d'une des trois bornes suivantes :

### `/Born1`

C'est la première borne auquelle l'utilisateur (en l'occurence un chauffeur) est confronté.

**Utilisation** : Cliker sur le bouton "`prendre un ticket`" pour récuperer son ticket avec son code.

### `/Born2`

Cette borne sert à payer

**Utilisation** : Entrer le numero du ticket. Une nouvelle page s'ouvrira montrant un résumé de la periode de parking, suivi d'un montant à payer. Il suffit de choisir son mode de paiement et de clicker sur "`Effectuer le paiement`" pour payer. Une nouvelle page s'ouvre avec le reçu si l'utilisateur a décidé d'en récupérer un.

### `/Born3`

Cette borne sert de vérification si l'utilisateur à bien payé.

**Utilisation** : Entrer le numéro du ticket. Si valide, la barrière s'ouvre, sinon la barrière reste fermée.