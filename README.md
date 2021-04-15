# ENSF409 Final Project

//IMPORTANT NOTE BEFORE RUNNING ANYTHING//

In Main.java on line 44, you will need to change the database URL, username, and password to match that on your computer. This also needs to be done in FileIO.java on line 65.

//MAIN PROGRAM//

On a Windows computer, this program is run with the following commands:

    javac -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Main.java
    java -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Main

or on a Mac:

    javac -cp .:lib/mysql-connector-java-8.0.23.jar:. edu/ucalgary/ensf409/Main.java
    java -cp .:lib/mysql-connector-java-8.0.23.jar:. edu/ucalgary/ensf409/Main

**IMPORTANT NOTE: When entering inputs for the date, no dates before 2021 will be accepted by the program!

//UNIT TESTING//  

To run all unit tests through the Windows command line, the following commands are used:

    javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar  edu/ucalgary/ensf409/InventoryTest.java
    java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.InventoryTest

or on a Mac:

    javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23.jar  edu/ucalgary/ensf409/InventoryTest.java
    java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.InventoryTest

In InventoryTest.java, please replace 'SQLusername' and 'SQLpassword' on lines 30-31 to match the username and password used to login to your local SQL server.
Please also refresh your database 'inventory.sql' before running these tests as there are some tests which remove items from the database. Failure to do so would result in errors as the tests expect a full database. 
Also, many of our tests have outputs that are predicted based on the database inventory.sql that was posted on D2l
These tests are marked with the idenfitier : //*********One of the tests that needs Original database as posted on D2L**********