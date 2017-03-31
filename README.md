# myRetailApp
This is a simple restful api with two endpoints, one to retrive product data and one to update product price. This application 
is built in SpringBoot using gradle. 

# Prerequistes
1. Jdk 1.8
2. Gradle
3. No firewall should be running on your local machine as the application needs to connect to a cloud based Mondo DB and the firewall may prevent it from doing so.
4. Make sure port 8054 is not running any process in your local machine and is free. If not change the port number in the application.properties file to some other open port.


# Steps to run the application on your local machine
1. Download the project
2. Go to the project root folder in the command prompt or terminal(for mac) and type 'gradle build'. This would download 
   all the dependencies.
3. Once the dependencies are pulled, inside the project root folder, run 'gradle bootRun' and let the spring context start the application.
4. Once the application is running in your local you can open the application home page by accessing the following url:
   http://localhost:8054/swagger-ui.html.
  This open up the RestFul endpoint documentation cum test page, from where you can try the endpoints. The endpoints description is provided in this page.
  
 Note:
 Currently only product id 16696652 and 13860428 have its details in the NoSQL database, so only these product ids can be used in the Swagge UI page. If any other product id is used that might not give the desired data or perform desired operation.	



