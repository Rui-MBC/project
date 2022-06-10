javac main/*.java
javac gamePlay/*.java
javac cards/*.java
jar cmf manif.txt Video.jar main/* gamePlay/* cards/*
jar tf Video.jar
java -jar Video.jar -d 1000 cmd OG.deck
