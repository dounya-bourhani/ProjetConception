# ProjetConception

## Partie 1 - Ré-ingénierie du code
* L’affichage des joueurs doit être séparé de leur gestion (déplacements, stratégies, etc.)
* Les changements dans le modèle métier (déplacements) devront être répercutés dans l’affichage.
* L’utilisation d’entrées claviers ou souris entraînera des changements dans le modèle métier en passant par un 
contrôleur.

## Partie 2 - Extension
* Ajouter des éléments de contrôle au jeu pour le faire démarrer, le mettre en pause, etc. On utilisera pour cela des 
widgets javafx tels que des boutons.

* Ajouter ensuite un mécanisme de contrôle des collisions en réfléchissant à son placement dans une architecture MVC. Les collisions peuvent être entre :
    - une balle et un joueur – ce cas doit être géré obligatoirement
    - une balle et les murs
    - une balle et un obstacle
 
* Chaque joueur avec une IA aura une tactique propre qui consiste à :
  - se déplacer aléatoirement
  - suivre le joueur contrôlé par un humain
  
  Faites en sorte que la tactique puisse être changée en cours de partie (via une action utilisateur sur un bouton par exemple).