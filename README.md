Commandes pour lancer:
- find * -name "*.java" > sources.txt
- javac @sources.txt
- java simulator.Simulator scenario.txt

Supprimer les fichiers .class:
- find . -type f -name "*.class" -delete
