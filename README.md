Data-Driven Testing
This project uses JSON data files for data-driven testing. Add your test data to the testdata.json file in the project root.

Example JSON structure:
[
  {"name": "John", "age": 25, "gender": "Male"},
  {"name": "Jane", "age": 30, "gender": "Female"}
]

Tech Stack Used:
Eclipse as IDE
Java Programming language
Selenium
TestNG for data provider facility, Assertion and Test report Generation
Maven Dependencies for JSON and Junit Support
Data Driven Framework 


Running Tests
Right-click on the BaseClass class.
Run as TestNG test.

Assertions
I have used to verify that the actual results on UI match the expected results from JSON data file. Assertions are written using TestNG's assertion methods.

Test Output
![image](https://github.com/Navdeep123422/Automation/assets/99684795/5ec1070a-0c6a-4dca-97a5-a47a83bd1b0d)
