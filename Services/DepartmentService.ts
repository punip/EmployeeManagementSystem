import axios from 'axios';

const BASE_URL = "http://localhost:9090/api/departments";

export const createDepartment = (department:any) => axios.post(BASE_URL,department);

export const getAllDepartments = () => axios.get(BASE_URL);

export const updateDepartment = (departmentId: number, department: any) => axios.put(BASE_URL + '/' + departmentId, department);

export const getDepartmentById = (departmentId: number) => axios.get(BASE_URL + '/' + departmentId);

export const deleteDepartment = (departmentId: number) => axios.delete(BASE_URL + '/' + departmentId);