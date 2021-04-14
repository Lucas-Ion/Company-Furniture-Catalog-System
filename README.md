# ENSF409 Final Project

On a Windows computer, this program is run with the following commands:

    javac -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Main.java
    java -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Main

or on a Mac:

    javac -cp .:lib/mysql-connector-java-8.0.23.jar:. edu/ucalgary/ensf409/Main.java
    java -cp .:lib/mysql-connector-java-8.0.23.jar:. edu/ucalgary/ensf409/Main

To run all unit tests through the Windows command line, the following commands are used:

    javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar  edu/ucalgary/ensf409/InventoryTest.java
    java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.InventoryTest

or on a Mac:

    javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23.jar  edu/ucalgary/ensf409/InventoryTest.java
    java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.InventoryTest
