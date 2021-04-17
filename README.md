Full Name : Ufuk Sahinduran

Project Title : NHS help Checker UI testing framework

Installation guide: This is a maven project. so It's assumed that the host running this code have Java and maven
installed and JAVA_HOME already set. Here is the guide for maven installation just in 
link : https://maven.apache.org/install.html Project get all dependencies from maven repository. 
So no additional installation needed.

Below are the dependencies are being used for this project :
Selenium, Cucumber, Github Bonigarcia(WebDriverManager)


                        Web Testing:
configuration.properties: This is the file that we can store and manage our data.

ConfigurationReader class: this class is read data from Config file.

recources: this directory for storing fature file which contains our scenario

Scenarios: created based on BDD by Gherkin syntax

Driver class: it contains selenium webdriver which I initialised for chrome and firefox driver.

Hook class: this class is for running before and after each and every scenarios. 
I have added scenario names, before and after methods and also implicity wait and maximize screen for UI test.

Cukes Runner class: This class for running our test by cucumber options which contains 
feature file pathway and step definitions pathway, dryRun.

Step Definitions: EventsStepdef class: This class for running our scenario and steps from feature file. I also
created an Wales class object in order to call instance methods from class.

Wales class: I have created my most of the test methods based on my test steps.

I have also created BrowserUtils class to be able call useful static methods which is in the utillities package.

                       
-These are the only 2 scenarios for one circumstance for this specific user story but many of the different neagtive and positive scenarios can be added basen on the circumstances.
