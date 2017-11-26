package id.co.test.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ejb.Stateless;

import id.co.test.entity.Employee;
import java.util.List;

@Stateless
public class EmployeeBean{
    
    @PersistenceContext(unitName="restPU")
    EntityManager entityManager;
    
    public boolean createEmployeeTable(Employee em){
        entityManager.persist(em);
        return true;
    }
    
    public void addEmployee(String name, String address){
        Employee e = new Employee();
        e.setName(name);
        e.setAddress(address);
        entityManager.persist(e);
    }
    
    public void deleteEmployee(String id){
        Query q = entityManager.createQuery("DELETE FROM Employee e WHERE e.id = :id");
        q.setParameter("id", Long.parseLong(id));
        q.executeUpdate();
    }
    
    public void updateEmployee(String id, String name, String address){
        Query q = entityManager.createQuery("UPDATE Employee e SET e.name = :name, e.address = :address WHERE e.id = :id");
        q.setParameter("id", Long.parseLong(id));
        q.setParameter("name",name);
        q.setParameter("address",address);
        q.executeUpdate();
    }
    
    public Employee getEmployeeById(String id){
        Query q = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :id");
        q.setParameter("id", Long.parseLong(id));
        Employee employee = (Employee) q.getSingleResult();
        return employee;
    }
    
    public List<Employee> getEmployees(){
        Query q = entityManager.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = q.getResultList();
        return employees;
    }
    
}













