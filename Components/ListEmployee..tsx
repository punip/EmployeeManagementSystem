import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { deleteEmployeeById, getAllEmployees } from "../Services/EmployeeService";
import { useHistory } from "react-router";

type Employee = {
    id:number,
    firstName:string,
    lastName:string,
    email:string
}



const ListEmployee:React.FC = () => {

    const [employees,setEmployees] = useState<Employee[]>([]);

    useEffect(() => {
        getAllEmployees()
        .then((response) => {
            setEmployees(response.data)
        })
        .catch((error) => console.log(error))
    },[])


    const history =  useHistory();

    const addNewEmployee = () => {
        history.push('/add-employee')
    }

    const updateEmployee = (id:number) => {
        history.push(`/edit-employee/${id}`)
    }

    const removeEmployee = (id:number) => {
        deleteEmployeeById(id)
        .then(() => getAllEmployees()
            .then((response) => setEmployees(response.data)))
        .catch((error) => console.log(error))
}

    return(<>
    <h2>List of Employees</h2>
    <Button variant="primary" onClick={addNewEmployee} >Add Employee</Button>
     <Table striped bordered hover>
      <thead>
        <tr>
          <th>Employee ID</th>
          <th>FirstName</th>
          <th>LastName</th>
          <th>Email</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {
        employees.map((employee) =>
        <tr key={employee.id}>
          <td>{employee.id}</td>
          <td>{employee.firstName}</td>
          <td>{employee.lastName}</td>
          <td>{employee.email}</td>
          <td>
          <Button onClick={() => updateEmployee(employee.id)} variant="primary">Update</Button>{' '}
        <Button onClick={() => removeEmployee(employee.id)} variant="danger">Delete</Button>{' '}
          </td>
        </tr>
    )
}
       
      </tbody>
    </Table>
    </>)
}
export default ListEmployee;