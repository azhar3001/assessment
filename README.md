//pagination
http://localhost:8080/listAllEmployeeByPage?page=0&size=10


//get employee info by ID
http://localhost:8080/getEmployeeById?employeeID=2




//save employee

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


//branch ID should be value from 01 - 14
so, it can be triggered by 3rd party API  to get info of branch
