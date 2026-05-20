package org.example.livedemohibernate.Bank.Controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.boot.test.web.server.LocalServerPort;

//Drar igång webbservern och testar att ett anrop till en faktisk url ger det resultat men vill ha

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class KPIControllerTestaMEDWebbserver{

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void helloWorldTest() {
        restTestClient.get()
                .uri("http://localhost:%d/".formatted(port)+"/helloWorld")
                .exchange()   //Här skickas själva requesten
                .expectBody(String.class)
                .isEqualTo("Hello World");
    }



}
