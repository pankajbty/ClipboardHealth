# ClipboardHealth
Created a Framework for Automated tests

# GIT Instruction
To run the tests in you local we need to clone the repository  by using command
git clone "https://github.com/pankajbty/ClipboardHealth.git"

This Will create a folder in you local with name ClipboardHealth with the framework.

# External Dependencies
After this we have to open the project in IntelliJ IDEA
Make Sure you have the Following things:- 
1. Right version of JAVA for this from Java 8 or Java 11
2. Have Latest Maven
3. Latest Chrome Driver version

OR

We can use the pom.xml dependecies.

# Getting Started 
1. For easiest to run tests is to open testng.xml file.
2. Right click on the File and Click run. 
 
# For running tests through docker
1. Go to the docker-compose folder
2. Then comment the line 23 and uncomment line 25 in AmazonTests.java file
3. Inside docker compose folder run docker-compose -f docker-compose.yml up
4. After the docker is up go to testng.xml file athen right click and run the file.


# Framework explanation
1. I have design it in a modular way, using Page object model approch
2. In the drivers package i have defined the Driver related methods and the wrraper of the selenium methods
3. In the pages package i have defined the different class for each page.
4. In the Amazon package i have defined the tests which is getting executed.  
5. In docker-compose i have defined the docker-compose.yml file


# SUCCESS