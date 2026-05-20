package org.example.livedemohibernate.Bank.Controllers;



import org.example.livedemohibernate.Bank.Models.Kategori;
import org.example.livedemohibernate.Bank.Repos.KategoriRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//Här startas INTE webbservern
//snabbare och mer lättivktiga tester utförs

@SpringBootTest
@AutoConfigureRestTestClient
public class KategoriControllerTestJSON {

    @Autowired
    private RestTestClient restTestClient;

    @Autowired
    private KategoriRepo kategoriRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        Kategori c1 = new Kategori(null, "Guld");
        Kategori c2 = new Kategori(null, "Silver");
        Kategori c3 = new Kategori(null, "Platina");

        kategoriRepo.save(c1);
        kategoriRepo.save(c2);
        kategoriRepo.save(c3);
    }

    @AfterEach
    void tearDown() {
        kategoriRepo.deleteAll();
    }


    @Test
    void hämtaAllaKategorierTest() {
        restTestClient.get()
                .uri("http://localhost:8080/Kategori")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].name").isEqualTo("Guld")
                .jsonPath("$[1].name").isEqualTo("Silver")
                .jsonPath("$[2].name").isEqualTo("Platina");
    }

    @Test
    void postaInNyKategoriTest() {

        restTestClient.post()
                .uri("/Kategori")
                .body(new Kategori(null, "Brons"))
                .exchange()
                .expectStatus().isOk();

        List<Kategori> all = kategoriRepo.findAll();

        assertEquals(4, all.size());
        assertEquals("Brons", all.get(3).getName());
    }

    @Test
    void testaKonverteraJSONTillJavaobjektTest() {

        restTestClient.post()
                .uri("/Kategori")
                .body(new Kategori(null, "Brons"))
                .exchange()
                .expectStatus().isOk();

        List<Kategori> all = kategoriRepo.findAll();

        assertEquals(4, all.size());
        assertEquals("Brons", all.get(3).getName());
    }


    @Test
    public void konverteraJSONTillJavaTest(){
        String json =
                restTestClient.get()
                        .uri("/Kategori")
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody(String.class)
                        .returnResult()
                        .getResponseBody();

        List<Kategori> categories =
                objectMapper.readValue(
                        json,
                        new TypeReference<List<Kategori>>() {}
                );

        assertTrue(categories.size() == 3 || categories.size() == 4 );
        assertEquals("Guld", categories.get(0).getName());
        assertEquals("Silver", categories.get(1).getName());

    }


    /*
//Funkar inte efter att vi kopplat på test-databsen, eftersom id:na ändrar sig

    @Test
    void kategoriStaticIdInDatabaseTest() {
        restTestClient.get()
                .uri("http://localhost:8080/Kategori")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].id").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo("Guld")
                .jsonPath("$[1].id").isEqualTo(2)
                .jsonPath("$[1].name").isEqualTo("Silver")
                .jsonPath("$[2].id").isEqualTo(3)
                .jsonPath("$[2].name").isEqualTo("Platina");
    }
     */




}
