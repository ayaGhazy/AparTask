# AparTask
this project is a maven testng project </br>
Assumptions only will run **English** Website </br>
you can run it through  **run.xml** or **Runner2.java** located in /src/test/java
## Configurations
please check **main/resources/web.properties** for configurations
## Data
for all object Repository "elements locators" exists in /test/resources/object RepositorySheetname.csv </br>
for all test data exists in /test/resources/testdata.csv
## Browser selection
for chrome , change in web.properties browserName=**ch** and firefox browserName=**ff**
## Report
Report using allure report ### allure generate allure-results --clean && allure open 
## Environment and tools
this project use it is mandatory to have below installed on machine before run </br>
1- java 8 </br>
2- maven </br>
3- allure report </br>
## Run 
1- make sure you have  right configuration on main/resources/web.properties </br>
2- **Maven** </br>
run through *mvn clean install* </br>
3- from any ide </br>
Right click on run.xml or runner.java and select "Run" </br>
4- to generate report from cmd *allure generate allure-results --clean && allure open* </br>


