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
  <img src="https://github.com/axelriv62/lens-judge/blob/main/app/src/main/resources/img/screenshot.png" width="1200">
</p>

<br>

*Realized by [Axel](https://github.com/axelriv62), [Quentin](https://github.com/quentinltg), [Bylel](https://github.com/SirSweazzyyy) et [Isaac](https://github.com/IsaacDuflos), second-year students (year 24-25) in BUT Computer Science.*

<br>

## Presentation

This project was realized as part of a SAE ('Learning and Assessment Situation' in French) during the third semester of the BUT in Computer Science. 
The goal was to design an automatic judge for programming competitions in Java, which can compile, execute, and verify if the program submitted by a participant correctly solves the proposed problem.

The main objective was to identify and integrate as many design patterns as possible into our project.

<br>

## Objectives

The various objectives of this project were:

+ Support compilation and execution of programs in Java, C, C++, and Python.
+ Validate answers by comparing the output of the submitted program with the expected output.
+ Implement various verification strategies: strict comparison, tolerance for precision, case/whitespace insensitivity, and order tolerance.
+ Allow the integration of the judge as a library, configurable for different problems and test cases.

<br>

## Building the JAR
Open a terminal, navigate to the project root directory, and execute the following command to create the JAR:
```bash
./gradlew shadowJar
```
The JAR file will be located in the build/libs directory. You should see a file named lensjudge.jar.
```bash
ls app/build/libs
```
To run the JAR, use the java -jar command followed by the path to the JAR file:
```bash
java -jar app/build/libs/lensjudge.jar <source_file_to_test> <input_file> <output_file>
```

<br>

## Areas for Improvement

At the end of the project, we would have liked to have more time to develop the following features:

+ Improve the interface with colors and more detail on the verifications performed. 
+ Configure execution to handle time and memory limits for submitted programs. 
+ Add the option for users to configure their own verification strategy.

<br>

## Languages, Tools and Software Used

![My Skills](https://go-skill-icons.vercel.app/api/icons?i=java,gradle,git,gitlab&theme=dark)