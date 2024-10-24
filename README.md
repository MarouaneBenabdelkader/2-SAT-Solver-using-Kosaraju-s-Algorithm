# Le problème 2-SAT en Java


- Pourquoi cette méthode résout le problème 2-SAT.
- Complexité.
- Le choix des structures de données.

### [Guide d'utilisation](#guide-dutilisation-1)
- Prérequis.
- Installation.
- autre.


### Pourquoi cette méthode résout le problème 2-SAT :
Rappelons que la méthode abordée dans ce TP consiste à construire un graphe d'implications à partir d'un fichier texte en format DIMACS, et puis appliquer l'algorithme de Kosaraju pour trouver les composantes fortement connexes.

Une composante fortement connexe est un sous-ensemble de sommets dans lequel chaque sommet est accessible depuis tous les autres sommets de cette composante.

Si deux sommets sont dans la même composante, cela signifie qu'ils sont mutuellement accessibles via des implications, et donc, si un littéral **x** et sa négation **¬x** apparaissent dans la même composante, cela implique que **x => ¬x** et **¬x => x** , ce qui est contradictoire, car si **x** est vrai, alors **¬x** doit aussi être vrai, ce qui est impossible puisque **x** et **¬x** ne peuvent pas être vrais simultanément.

Du coup, en vérifiant qu'un littéral **x** et sa négation **¬x** ne se trouvent pas dans une même composante, on garantit que la formule est cohérente et donc potentiellement satisfaisable.

### Complexité :
La résolution du problème se fait en temps **polynomial**, en fait, l'algorithme de Kosaraju repose sur l'exécution de deux parcours en profondeur (DFS) sur un graphe et son transposé. Un DFS s'exécute en **O(V+E)**, ce qui signifie qu'il est linéaire par rapport au nombre de sommets **V** et au nombre d'arêtes **E** du graphe. Comme les deux étapes sont linéaires, alors la complexité globale reste **O(V+E)**, ce qui est polynomial puisque c'est un cas particulier de **O(n^k)**.

### Le choix des structures de données :
A remplir.
Pour construire le graphe, on a opté pour une liste d'incidence en utilisant une *HashMap* dont les clés définies les différents sommets du graphe, et à chaque sommet on associe une *ArrayList* d'arcs.

- Le choix de *HashMap*: Revient au problème des sommets qui sont représentés par des entiers négatifs qui désignent les négations des littéraux.
- Le choix de *ArrayList*: Lors d'un parcours DFS, on a souvent besoin de parcourir toute la liste d'incidence d'un nœud. Dans ce cas, l'accès rapide à chaque élément favorise l'utilisation d'une ArrayList car l'accès à un élément dans une ArrayList est constant (O(1)).

## Guide d'utilisation
### Prérequis :
**Java Development Kit (JDK)**: Assurez-vous d'avoir installé la version 21 ou ultérieure du JDK.
### Installation :
1. **Cloner le dépôt :**
Clonez ce dépôt Git sur votre machine locale en utilisant la commande suivante dans le terminal :
    ```
    git clone https://etulab.univ-amu.fr/b24027319/2sat-graph-solver.git
    ```


### Commandes :
1. **Compilation du projet :**
   Pour compiler le projet, exécutez la commande suivante dans le terminal :
    ```
    cd chemin_vers_le_dossier\2sat-graph-solver\src
   ```
   après, exécutez la commande suivante :
    ```
    javac -d ../out/production/classes Main.java
    ```
   ```
    javac -d ../out/production/classes Main.java
    ```
2. ** Exécution du programme :**
   Pour exécuter le programme, exécutez la commande suivante dans le terminal :
    ```
    cd ../out/production/classes
    ```
    ```
    java Main <filePath> 
    ```
   o bien utiliser plusieurs fichiers en même temps :
    ```
    java Main <filePath1> <filePath2> <filePath3> ...
    ```
   où **filePath** est le chemin vers fichier texte en format DIMACS contenant la formule 2-SAT à résoudre.

3.  **Utilisation avec jar :**

Pour exécuter le programme en utilisant le fichier jar fourni, exécutez la commande suivante dans le terminal :

Vous devez être dans le dossier `out` :

```bash
cd .\artifacts\2sat_graph_solver_jar\
```

Ensuite, exécutez la commande suivante pour un fichier unique :

```bash
java -jar 2sat-graph-solver.jar <filePath>
```

Vous pouvez également exécuter plusieurs fichiers en même temps avec la commande suivante :

```bash
java -jar 2sat-graph-solver.jar <filePath1> <filePath2> <filePath3> ...
```

