Data-Driven Testing
This project uses JSON data files for data-driven testing. Add your test data to the testdata.json file in the project root.

Example JSON structure:
[
  {"name": "John", "age": 25, "gender": "Male"},
  {"name": "Jane", "age": 30, "gender": "Female"}
]

Running Tests
Right-click on the BaseClass class.
Run as TestNG test.

Assertions
I have used to verify that the actual results on UI match the expected results from JSON data file. Assertions are written using TestNG's assertion methods.
