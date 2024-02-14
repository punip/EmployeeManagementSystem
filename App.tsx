import React from 'react';
import Navigation from './Components/Navigation';
import { Route, Switch } from 'react-router';
import ListDepartment from './Components/ListDepartment';
import ListEmployee from './Components/ListEmployee.';
import Department from './Components/Department';
import Employee from './Components/Employee';

const Home = () => {
  return(<>
  <h1>Employee Management System</h1>
  </>)
}
function App() {
  return (<>
    <Navigation/>
    <Switch>
      <Route exact path="/"><Home/></Route>
      <Route exact path="/department"><ListDepartment/></Route>
      <Route exact path="/employee"><ListEmployee/></Route>
      <Route exact path="/edit-department/:id"><Department/></Route>
      <Route exact path="/department"><ListDepartment/></Route>
      <Route exact path="/add-department"><Department/></Route>
      <Route exact path="/add-employee"><Employee/></Route>
      <Route exact path="/edit-employee/:id"><Employee/></Route>
      <Route exact path="/employee"><ListEmployee/></Route>
    </Switch>
  </>
  );
}

export default App;
