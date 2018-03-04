#Poker Hand 

* To compile and create package: 
 From the project root, run the following command

```
mvn clean package
```

* Then use the following command to read the poker hand file and generate report

```
cat src/main/resources/poker-hands.txt | java -jar target/PokerGame.jar
```
