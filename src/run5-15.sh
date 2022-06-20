clear
javac main/*.java
javac gamePlay/*.java
javac cards/*.java
jar cmf manif.txt Video.jar main/* gamePlay/* cards/*
jar tf Video.jar
java -jar Video.jar -d 1000 cmd.comand 5.deck
java -jar Video.jar -d 1000 cmd.comand 6.deck
java -jar Video.jar -d 1000 cmd.comand 7.deck
java -jar Video.jar -d 1000 cmd.comand 8.deck
java -jar Video.jar -d 1000 cmd.comand 9.deck
java -jar Video.jar -d 1000 cmd.comand 10.deck
java -jar Video.jar -d 1000 cmd.comand 11.deck
java -jar Video.jar -d 1000 cmd.comand 12.deck
java -jar Video.jar -d 1000 cmd.comand 13.deck
java -jar Video.jar -d 1000 cmd.comand 14.deck
java -jar Video.jar -d 1000 cmd.comand 15.deck