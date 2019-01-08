name: "should get all departments"  
request:  
  method: GET
  url: /department
  headers:
    Content-Type: application/json
response:  
  status: 200
  body:
   [
    {
        "id": "dep1",
        "name": "Test",
        "description": "abc"
    }
]
  headers:
    Content-Type: application/json