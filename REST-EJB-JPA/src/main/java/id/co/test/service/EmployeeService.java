package id.co.test.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import javax.ejb.EJB;

import id.co.test.entity.Employee;
import id.co.test.bean.EmployeeBean;

import id.co.test.config.Config;
import java.util.List;

@Path("employee")
public class EmployeeService extends Config {

    @EJB
    EmployeeBean empBean;

    //Insert employee with response status in JSON format
    @POST
    @Path("addEmployee/{name}/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmployee(@PathParam("name") String name, @PathParam("address") String address) {
        empBean.addEmployee(name, address);
        return "{\"status\":\"ok\"}";
    }

    //Update employee with response status in JSON format
    @PUT
    @Path("updateEmployee/{id}/{name}/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateEmployee(@PathParam("id") String id, @PathParam("name") String name, @PathParam("address") String address) {
        empBean.updateEmployee(id, name, address);
        return "{\"status\":\"ok\"}";
    }

    //Retrieve employee by id with JSON or XML format
    @GET
    @Path("getEmployeeByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByIdJSON(@PathParam("id") String id) {
        return empBean.getEmployeeById(id);
    }

    @GET
    @Path("getEmployeeByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Employee getEmployeeByIdXML(@PathParam("id") String id) {
        return empBean.getEmployeeById(id);
    }

    //Retrieve employees with JSON or XML format
    @GET
    @Path("getEmployeesJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeesJSON() {
        return empBean.getEmployees();
    }

    @GET
    @Path("getEmployeesXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getEmployeesXML() {
        return empBean.getEmployees();
    }

    //Delete employee by id with response status in JSON format
    @DELETE
    @Path("deleteEmployeeById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteEmployeeById(@PathParam("id") String id) {
        empBean.deleteEmployee(id);
        return "{\"status\":\"ok\"}";
    }

}
