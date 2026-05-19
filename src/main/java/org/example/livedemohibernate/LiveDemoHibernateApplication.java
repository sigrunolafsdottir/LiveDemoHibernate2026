package org.example.livedemohibernate;

import org.example.livedemohibernate.Bank.Models.Customer;
import org.example.livedemohibernate.Bank.Models.KPI;
import org.example.livedemohibernate.Bank.Repos.CustomerRepo;
import org.example.livedemohibernate.Bank.Repos.KPIRepo;
import org.example.livedemohibernate.Book.Book;
import org.example.livedemohibernate.Book.BookRepo;
import org.example.livedemohibernate.Tomten.Models.Child;
import org.example.livedemohibernate.Tomten.Models.Surveillance;
import org.example.livedemohibernate.Tomten.Repos.ChildRepo;
import org.example.livedemohibernate.Tomten.Repos.SurveillanceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiveDemoHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveDemoHibernateApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner init(KPIRepo kpiRepo, CustomerRepo customerRepo) {
        return (args) -> {
            KPI kpi1 = new KPI(45);
            KPI kpi2 = new KPI(1);
            KPI kpi3 = new KPI(567);

            kpiRepo.save(kpi1);
            kpiRepo.save(kpi2);
            kpiRepo.save(kpi3);

            Customer c1 = new Customer(null, "John", "Drottninggatan", kpi1);
            Customer c2 = new Customer(null, "Kalle", "Drottninggatan", kpi2);
            Customer c3 = new Customer(null, "Nisse", "Drottninggatan", kpi3);

            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);

        };
    }

*/

    /*
    //works if surveillance attribute, in child, cascades
    @Bean
    public CommandLineRunner demo(ChildRepo childRepo, SurveillanceRepo surRepo){
        return (args) -> {

            Child child1 = new Child("Doris", "Drottninggatan 23", new Surveillance(true, 456));
            childRepo.save(child1);

        };
    }

     */



    /*
    //correct use when Surveillance attribute, in child, does NOT cascade
    @Bean
    public CommandLineRunner demo(ChildRepo childRepo, SurveillanceRepo surRepo){
        return (args) -> {

            Surveillance s1 = new Surveillance(false, 5);
            Surveillance s2 = new Surveillance(true, 34);
            Surveillance s3 = new Surveillance(true, -3);

            surRepo.save(s1);
            surRepo.save(s2);
            surRepo.save(s3);

            Child child1 = new Child("Anna", "Drottninggatan 23", s1);
            Child child2 = new Child("Bertil", "Drottninggatan 23", s2);
            Child child3 = new Child("Ceci", "Drottninggatan 23", s3);

            childRepo.save(child1);
            childRepo.save(child2);
            childRepo.save(child3);
        };
    }

*/


/*
    @Bean
    public CommandLineRunner demo(BookRepo repo){
        return (args) -> {
            repo.save(new Book("Röda rummet", "Strindberg"));
            repo.save(new Book("Inferno", "Strindberg"));
            repo.save(new Book("Hemsöborna", "Strindberg"));
            repo.save(new Book("Herr Arnes Penningar", "Lagerlöf"));
        };
    }
    */

}
