package id.co.test.rest.ejb.jpa.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class InvokingEmployeeService {

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        //Change username and password with your wildfly's login credential
        String username = "username";
        String password = "password";
        
        //You may user one of the service name in the list below
        //List of services
        String getEmployeesJSON = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeesJSON";
        String getEmployeesXML = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeesXML";
        String getEmployeeByIdJSON = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeeByIdJSON/";
        String getEmployeeByIdXML = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeeByIdXML/";
        String addEmployee = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/addEmployee/";
        String updateEmployee = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/updateEmployee/";
        String deleteEmployee = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/deleteEmployeeById/";;

        try {
            String service;
            String HttpMethod;
            System.out.println("What method do you want to invoke?");
            String req;
            req = input.readLine();

            if (req.equalsIgnoreCase("getEmployeesJSON")) {
                service = getEmployeesJSON;
                HttpMethod = "GET";
            }
            else if (req.equalsIgnoreCase("getEmployeesXML")) {
                service = getEmployeesXML;
                HttpMethod = "GET";
            } else if (req.equalsIgnoreCase("getEmployeesXML")) {
                service = getEmployeesJSON;
                HttpMethod = "GET";
            } else if (req.equalsIgnoreCase("getEmployeeByIdXML")) {
                String param1;
                System.out.print("Input employee id: ");
                param1 = input.readLine();
                service = getEmployeeByIdXML + param1;
                HttpMethod = "GET";
            } else if (req.equalsIgnoreCase("getEmployeeByIdJSON")) {
                String param1;
                System.out.print("Input employee id: ");
                param1 = input.readLine();
                service = getEmployeeByIdJSON + param1;
                HttpMethod = "GET";
            } else if (req.equalsIgnoreCase("addEmployee")) {
                String param1;
                String param2;

                System.out.print("Input employee name: ");
                param1 = input.readLine();

                System.out.print("Input employee address: ");
                param2 = input.readLine();

                service = addEmployee + param1.replace(" ", "%20") + "/" + param2.replace(" ", "%20");
                HttpMethod = "POST";
            } else if (req.equalsIgnoreCase("updateEmployee")) {
                String param1;
                String param2;
                String param3;

                System.out.print("Input employee id: ");
                param1 = input.readLine();

                System.out.print("Input employee name: ");
                param2 = input.readLine();

                System.out.print("Input employee address: ");
                param3 = input.readLine();

                service = updateEmployee + param1.replace(" ", "%20") + "/" + param2.replace(" ", "%20") + "/" + param3.replace(" ", "%20");
                HttpMethod = "PUT";
            } else if (req.equalsIgnoreCase("deleteEmployee")) {
                String param1;

                System.out.print("Input employee id: ");
                param1 = input.readLine();

                service = deleteEmployee + param1.replace(" ", "%20");
                HttpMethod = "DELETE";
            } else {
                service = null;
                HttpMethod = null;
            }

            URL url = new URL(service);
            String encoding = Base64.getEncoder().encodeToString((username+":"+password).getBytes("UTF-8"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HttpMethod);
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream) connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Please input the service name correctly!!");
        }

    }
}
