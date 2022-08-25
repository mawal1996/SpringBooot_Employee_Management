package net.cruddemo.springboot.controller;

import net.cruddemo.springboot.SpringbootBackendApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ActiveProfiles("local")  //By default it is set
@SpringBootTest(classes= SpringbootBackendApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAllEmployeeTest(){
        String url="http://localhost:"+port+"/api/p1/employees/empdetailsby";
        UriComponents builder= UriComponentsBuilder.fromHttpUrl(url).build();
        HttpEntity<String> requestEntity=new HttpEntity<>(null,null);
        ResponseEntity<String> response=testRestTemplate.exchange(builder.toString(), HttpMethod.GET,requestEntity, String.class);
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void findByDesignationTest(){
        String url= "http://localhost:"+port+"/api/p1/employees/findByDesignation/Level1";
        UriComponents builder= UriComponentsBuilder.fromHttpUrl(url).build();//to send the query param
        HttpEntity<String> requestEntity=new HttpEntity<>(null,null);
        ResponseEntity<String> response=testRestTemplate.exchange(builder.toString(), HttpMethod.GET,requestEntity, String.class);
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void getEmployeeByExpAndDeskNoTest(){
        String url="http://localhost:"+port+"/api/p1/employees/getEmployeeByExpAndDeskNo/2/c22";
        UriComponents builder= UriComponentsBuilder.fromHttpUrl(url).build();
        HttpEntity<String> requestEntity=new HttpEntity<>(null,null);
        ResponseEntity<String> response=testRestTemplate.exchange(builder.toString(), HttpMethod.GET,requestEntity, String.class);
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode() );
    }
}
