# myRetailApp
This is a simple restful api with two endpoints, one to retrive product data and one to update product price. This application 
is built in SpringBoot using gradle. 

#Prerequistes
1. Jdk 1.8
2. Gradle
3. No firewall running on the lacal system as the application needs to connect to a cloud based Mondo DB.

#Steps to run the application on your local machine
1. Download the project
2. Go to the project root folder in the command prompt or terminal(for mac) and type 'gradle build'. This would download 
   all the dependencies.
3. One the dependencies are pulled, inside the project root folder, run gradle bootRun and let the spring context start the application.


