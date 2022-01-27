# TP

## Auteurs

Diallo Ibrahima Sambegou

## Objectif du TP

Pour ce tp il a fallu faire un jeu de l'oie pour cela il a fallu d'abord réfléchir sur la conception de ce qu'il a besoin pour fonctionner, tout d'abord d'un plateau personnalisable avec des cases différentes ayant différentes réaction lorsqu'on tombe dessus. Aussi de joueur qui vont lancer deux dés permettant d'avancer à travers ce plateau. Afin de tout mettre en lien on a créé une classe Game qui contient la méthode play permettant de simuler une partie.

## Les différentes instructions pouvant être réalisé


### La compilation

Afin de pouvoir compiler un dossier souhaité il faut d'abord se rendre dans le dossier src (cd src/) puis effectuer la commande suivante:
	
		../tp/src> javac pack1/SomeClass.java -d ../classes
		
Au moment de la compilation un dossier classes se créera et il y aura tous les fichiers .class
dans le paquetage en question.

### La documentation

Dans le but de savoir comment fonctionne un code il nous faut une documentation et pour cela il faut la générer il faut se diriger à nouveau dans le dossier src  et on éxécute la commande  suivante :

		../tp/src> javadoc -d ../docs -subpackages pack1


### Les tests



#### La compilation des tests

Pour compiler un test il faut d'abord avoir le fichier test4poo.jar permettant d'avoir une interface graphique qui si tous les tests sont valides on aura une barre verte sinon elle est rouge et un texte apparaitra en dessous.

Lors de la compilation on éxécute la commande depuis la racine :

		../tp> javac -classpath test4poo.jar test/SomeTest.java
	ou
		../tp> javac -classpath test4poo.jar test/*.java
		
#### Exécution des tests

Maintenant pour éxécuter les tests on effectue la commande depuis la racine :
	
		../tp> java -jar test4poo.jar SomeTest
		

### Exécution d'un programme

Afin d'éxécuter un programme on passe souvent par le biais d'une classe Main, il faut d'abord ce diriger vers le dossier src puis on compile :
		
		../tp/src> javac pack1/SomeClassMain.java -d ../classes
		
Puis on se dirige vers le dossier classes et on éxécute : 
	
		../tp/classes> java pack1.SomeClassMain
		
### Création d'un fichier .jar

Un fichier **.jar** correspond à une archive d'un "programme java" regroupant les classes du programme afin d'avoir une utilisation et diffusion facilité.

Afin de pouvoir le créer il faut d'abord compiler le programmes comme au dessus puis se diriger dans classes et effectué la commande :

		../tp/classes> jar cvf ../pack1.jar pack1
		
Le c correspond à la création, et v le mode verbose (détail chaque étape) et le f précise le nom du fichier.

On peut consulter le fichier avec la commande :

		../tp> jar tvf pack1.jar
		
Dans ce cas le dossier n'est pas éxécutable pour cela il faut effectuer à la place de la première commande :

		../tp/classes> jar cvfm ../pack1.jar ../manifest-pack1 pack1
		
Le fichier manifest avec le m en plus permettra alors de rendre le fichier éxécutable

Afin d'éxécuter date.jar on effectue la commande :
	
		../tp> java -jar pack1.jar

On aura alors l'éxécution de la classe main.


## Création du fichier goosegame.jar


Pour la création d'un fichier jar de goosegame il faut d'abord compiler dans un fichier classes puis éxécuter la commande :
		../tp/classes> jar cvfm ../goosegame.jar ../manifest-goosegame goosegame

Puis pour éxécuter le fichier jar il faudra faire dans le fichier source avec en paramètre le nombre de joueur:
		../tp> java -jar goosegame.jar <nombre de joueurs>

