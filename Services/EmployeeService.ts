import axios from 'axios';

const BASE_URL="http://localhost:9090/api/employees";

export const createEmployeee =(employee:any)=>axios.post(BASE_URL,employee);

export const getAllEmployees =()=>axios.get(BASE_URL);

export const deleteEmployeeById =(id:number)=>axios.delete(BASE_URL+"/"+id);

export const getEmployeeById =(id:number)=>axios.get(BASE_URL+"/"+id);

export const updateEmployeeId=(id:number,employee:any)=>axios.put(BASE_URL+"/"+id,employee);