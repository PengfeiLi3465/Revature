## Expense Reimbursement System
This is an expense reimbursement system. For a small company/group. This program will allow employees to create reimbursement requests.All Managers can view these requests and approve or deny them. When they approve/deny they
can optionally leave a message.

### key features
- Employee
    - An employee can login to see their own reimbursements, past and pending
    - An employee can submit a reimbursement with an amount and a reason
- Manager
    - A Manager can view all reimbursements past and pending
    - A Manager can appove or deny any reimbursement
    - Managers can view a 'statistics' page. That includes information like what employee spends the most money, mean expenditure cost etc...

### Technical and testing notice
- Backend developed in Javalin
- Backend: RESTful web service
- AWS postgres RDS used to persist information
- All DAO methods have a test
- All Service methods with logic have a test

### Technical used
- Java
- JavaScript
- HTML
- CSS
- JDBC
- PostgreSQL
- Javalin
- Maven
- JUnit4
- Log4J
