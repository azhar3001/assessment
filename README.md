1. sample-sample of CRUD transaction
  
// save employee
http://localhost:8080/saveEmployee2

//sample request
{
  "firstName": "Siti Aminah",
  "lastName": "Salim",
  "email": "siti.aminah@example.com",
  "phoneNumber": "012-3456789",
  "hireDate": "2023-01-01",
  "jobTitle": "Software Engineer",
  "salary": 75000,
  "branchID": "01",
  "isActive": true
}

//get all
http://localhost:8080/listAll

//delete
http://localhost:8080/deleteEmployee?employeeID=4


2. pagination
http://localhost:8080/listAllEmployeeByPage?page=0&size=10


3. 3rd party API
//branch ID should be value from 01 - 14
so, it can be triggered by 3rd party API  to get info of branch
http://localhost:8080/getEmployeeById?employeeID=2

sample response:
{
    "employee": {
        "employeeID": 2,
        "firstName": "Siti Aminah",
        "lastName": "Salim",
        "email": "siti.aminah@example.com",
        "phoneNumber": "012-3456789",
        "hireDate": "2023-01-01",
        "jobTitle": "Software Engineer",
        "salary": 123.00,
        "branchID": "01",
        "isActive": true
    },
    "branch": {
        "branchName": "Johor",
        "branchCity": "Johor Bahru",
        "branchPic": "Hasni Mohammad"
    }
}



