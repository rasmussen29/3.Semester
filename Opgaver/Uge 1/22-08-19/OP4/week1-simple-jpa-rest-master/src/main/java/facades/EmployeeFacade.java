package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}
    
    public Employee createEmployee(String name, String address, Integer salary){
        Employee emp = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
            return emp;
        }finally {
            em.close();
        }
    }
    
    public Employee getEmployeeById (int id){
         EntityManager em = emf.createEntityManager();
        try{
            Employee emp = em.find(Employee.class,id);
            return emp;
        }finally {
            em.close();
        }
    }
    
    public Employee getEmployeeByName (String name){
         EntityManager em = emf.createEntityManager();
        try{
            Employee emp = em.find(Employee.class,name);
            return emp;
        }finally {
            em.close();
        }
    }
    
    
    
    public List<Employee> getAllEmployees(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query = em.createQuery("Select employee from Employee employee",Employee.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    
    public List<Employee> getAllEmployeeWithHighestSalary(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Employee> query = em.createQuery("SELECT employee FROM Employee employee WHERE employee.salary = (SELECT MAX(employee.salary) FROM Employee employee",Employee.class);
            return query.getResultList();
        }finally {
            em.close();
        } 
       
    }
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
