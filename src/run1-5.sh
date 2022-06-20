clear
javac main/*.java
javac gamePlay/*.java
javac cards/*.java
jar cmf manif.txt Video.jar main/* gamePlay/* cards/*
jar tf Video.jar
java -jar Video.jar -d 1000 cmd.comand OG.deck
java -jar Video.jar -d 1000 cmd.comand 2.deck
java -jar Video.jar -d 1000 cmd.comand 3.deck
java -jar Video.jar -d 1000 cmd.comand 4.deck
java -jar Video.jar -d 1000 cmd.comand 5.deck
