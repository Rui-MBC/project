clear
javac main/*.java
javac gamePlay/*.java
javac cards/*.java
jar cmf manif.txt Video.jar main/* gamePlay/* cards/*
jar tf Video.jar
java -jar Video.jar -d 1000 cmd.comand 78.deck
java -jar Video.jar -d 1000 cmd.comand 76.deck
java -jar Video.jar -d 1000 cmd.comand 77.deck
java -jar Video.jar -d 1000 cmd.comand 78.deck
java -jar Video.jar -d 1000 cmd.comand 79.deck
java -jar Video.jar -d 1000 cmd.comand 80.deck
java -jar Video.jar -d 1000 cmd.comand 81.deck