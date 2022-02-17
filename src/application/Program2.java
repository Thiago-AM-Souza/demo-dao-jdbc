package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao depDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: findById ===");
        Department dep = depDao.findById(6);
        System.out.println(dep);

        System.out.println("=== Test 2: insert ===");
        Department newDep = new Department(null, "Music");
        depDao.insert(newDep);
        System.out.println("Inserted! New Id: " + newDep.getId());

        System.out.println("=== Test 3: update ===");
        dep = depDao.findById(6);
        dep.setName("Food");
        depDao.update(dep);
        System.out.println("Update completed.");

        System.out.println("=== Test 4: findAll ===");
        List<Department> list = depDao.findAll();
        for(Department depItem: list){
            System.out.println(depItem);
        }

        System.out.println("=== Test 5: delete ===");
        depDao.deleteById(8);
        System.out.println("Delete successful.");


    }
}
