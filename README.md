<h1 align="center">
  <br>
  <img src="https://github.com/axelriv62/lens-judge/blob/main/app/src/main/resources/img/icon.png" width="200">
  <br>
  <b>Lens Judge</b>
  <br>
  <a href="https://github.com/axelriv62/lens-judge/blob/main/README.md">
    <img src="https://img.shields.io/badge/README-FR-blue">
  </a>
  <a href="https://github.com/axelriv62/lens-judge/blob/main/README-EN.md">
    <img src="https://img.shields.io/badge/README-EN-blue">
  </a>
</h1>

<br>

<p align="center">
  <img src="https://github.com/axelriv62/lens-judge/blob/main/app/src/main/resources/img/screenshot.png" width="1000">
</p>

<br>

*Réalisé par [Axel](https://github.com/axelriv62), [Quentin](https://github.com/quentinltg), [Bylel](https://github.com/SirSweazzyyy) et [Isaac](https://github.com/IsaacDuflos), étudiants de deuxième année (promotion 24-25) de BUT Informatique au sein de l'IUT de Lens.*

<br>

## Présentation

Ce projet a été réalisé dans le cadre d’une SAE (Situation d'Apprentissage et d'Évaluation) du troisième semestre de BUT Informatique.
L’objectif était de concevoir un juge automatique pour les compétitions de programmation en Java, celui doit pouvoir compiler, exécuter et
vérifier si le programme soumis par un  participant répond correctement au problème proposé.

Le principal objectif était d'identifier et d'intégrer un maximum de patrons de conception dans notre projet.

<br>

## Objectifs

Dans le cadre de ce projet, les différents objectifs étaient les suivants :

+ Supporter la compilation et l'exécution de programmes en Java, C, C++ et Python.
+ Valider les réponses fournies en comparant la sortie du programme soumis avec la sortie attendue.
+ Implémenter des stratégies de vérification variées : comparaison stricte, tolérance de précision, insensibilité à la casse/espaces, et tolérance de l’ordre.
+ Permettre l'intégration du juge comme bibliothèque, configurable pour différents problèmes et cas de test.

<br>

## Compilation du JAR
Ouvrez un terminal, placez-vous dans le répertoire racine du projet, et exécutez la commande suivante pour créer le JAR :
```bash
./gradlew shadowJar
```
Le fichier JAR se trouvera dans le répertoire build/libs. Vous devriez voir un fichier nommé lensjudge.jar.
```bash
ls app/build/libs
```
Pour exécuter le JAR, utilisez la commande java -jar suivie du chemin vers le fichier JAR :
```bash
java -jar app/build/libs/lensjudge.jar <source_file_to_test> <input_file> <output_file>
```

<br>

## Pistes d’Amélioration

À l'issue du projet, nous aurions souhaité disposer de davantage de temps pour développer les fonctionnalités suivantes :

+ Améliorer l'interface avec des couleurs et plus de détails sur les vérifications effectuées.
+ Configurer l'exécution pour gérer des limites de temps et de mémoire pour les programmes soumis.
+ Ajouter la possibilité pour l'utilisateur de configurer sa propre stratégie de vérification.

<br>

## Langages, Outils et Logiciels Utilisés

![My Skills](https://go-skill-icons.vercel.app/api/icons?i=java,gradle,git,gitlab&theme=dark)
