# Le problème 2-SAT en Java


## Binôme
*Ce travail est réalisé dans le cadre du TP1 d'Algorithmique par les deux étudiants :*

- [ ] **BENABDELKADER Marouane**
- [ ] **DAIM Imad**

*L3 informatique - Groupe 2.*

*2024-2025.*

*Luminy.*


## Contenu du fichier README
### [Rapport](#rapport)
- Problèmes rencontrés.
- Pourquoi cette méthode résout le problème 2-SAT.
- Complexité.
- Le choix des structures de données.

### [Guide d'utilisation](#guide-dutilisation-1)
- Prérequis.
- Installation.
- autre.


## Rapport
### Problèmes rencontrés :
A remplir.

### Pourquoi cette méthode résout le problème 2-SAT :
Rappelons que la méthode abordée dans ce TP consiste à construire un graphe d'implications à partir d'un fichier texte en format DIMACS, et puis appliquer l'algorithme de Kosaraju pour trouver les composantes fortement connexes.

Une composante fortement connexe est un sous-ensemble de sommets dans lequel chaque sommet est accessible depuis tous les autres sommets de cette composante.

Si deux sommets sont dans la même composante, cela signifie qu'ils sont mutuellement accessibles via des implications, et donc, si un littéral **x** et sa négation **¬x** apparaissent dans la même composante, cela implique que **x => ¬x** et **¬x => x** , ce qui est contradictoire, car si **x** est vrai, alors **¬x** doit aussi être vrai, ce qui est impossible puisque **x** et **¬x** ne peuvent pas être vrais simultanément.

Du coup, en vérifiant qu'un littéral **x** et sa négation **¬x** ne se trouvent pas dans une même composante, on garantit que la formule est cohérente et donc potentiellement satisfaisable.

### Complexité :
La résolution du problème se fait en temps **polynomial**, en fait, l'algorithme de Kosaraju repose sur l'exécution de deux parcours en profondeur (DFS) sur un graphe et son transposé. Un DFS s'exécute en **O(V+E)**, ce qui signifie qu'il est linéaire par rapport au nombre de sommets **V** et au nombre d'arêtes **E** du graphe. Comme les deux étapes sont linéaires, alors la complexité globale reste **O(V+E)**, ce qui est polynomial puisque c'est un cas particulier de **O(n^k)**.

### Le choix des structures de données :
A remplir.


## Guide d'utilisation
### Prérequis :
**Java Development Kit (JDK)**: Assurez-vous d'avoir installé la version 21 ou ultérieure du JDK.
### Installation :
1. **Cloner le dépôt :**
Clonez ce dépôt Git sur votre machine locale en utilisant la commande suivante dans le terminal :
    ```
    git clone https://etulab.univ-amu.fr/b24027319/2sat-graph-solver.git
    ```
2. 

### Commandes :

### autre :
