# ENSF409Project

On my computer (Windows), I compile and run this with the following commands:

    javac -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Main.java
    java -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Main


How to run tests on Mac:
javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23.jar  edu/ucalgary/ensf409/InventoryTest.java

java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.InventoryTest
