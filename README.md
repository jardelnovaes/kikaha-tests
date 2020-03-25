# Test Kikaha maven plugin

### Compile
`mvn clean install`

### run
`mvn -f test-app\pom.xml kikaha:run`

### Usage app
http://localhost:8001/  
http://localhost:8001/hello/john  

### Simulate error
Change kikaha version from 2.1.8 to 2.19 on the test-parent pom file.  

compile.  
`mvn clean install`