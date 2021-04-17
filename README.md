Full Name : Ufuk Sahinduran

Project Title : NHS help Checker UI test framework

Installation guide: This is a maven project. so It's assumed that the host running this code have Java and maven
installed and JAVA_HOME already set. Here is the guide for maven installation just in 
link : https://maven.apache.org/install.html Project get all dependencies from maven repository. 
So no additional installation needed.

Below are the dependencies are being used for this project :
Selenium, Cucumber, Github Bonigarcia(WebDriverManager)


                        Web Testing:
Comfiguration.properties: This is the file that we can store and manage our data.

Configuration Reader class: this class is read data from Config file.

recources: this directory for storing fature files which contain our scenario

Scenarios: created based on BDD by Gherkin syntax

Driver class: it contains selenium webdriver which I initialised for chrome and firefox driver.

Hook class: this class is for running before and after each and every scenarios. 
I have added scenario name, before and after methods and also implicity wait and maximize screen for UI test.

Cukes Runner class: This class for running our test by cucumber options which contains 
feature file pathway and step definitions pathway.

Step Definitions: EventsStepdef class: This class for running our scenario and steps from feature file. I also
created an Wales class object in order to call instance methods from class.

Wales class: I have created my most of the test methods based on my test steps.

I have also created BrowserUtils class to be able call static wait or explicit wait  which is in the utillities package.

                       

