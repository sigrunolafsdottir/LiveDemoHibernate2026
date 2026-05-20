package org.example.livedemohibernate.Bank.Controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;


//Här startas INTE webbservern
//snabbare och mer lättivktiga tester utförs

@SpringBootTest
@AutoConfigureRestTestClient
public class KPIControllerTestUtanWebbserver {


    @Autowired
    private RestTestClient restTestClient;

    @Test
    void helloWorldTest() {
        restTestClient.get()
                .uri("http://localhost:8080/helloWorld")
                .exchange()   //Här skickas själva requesten
                .expectBody(String.class)
                .isEqualTo("Hello World");
    }


}
