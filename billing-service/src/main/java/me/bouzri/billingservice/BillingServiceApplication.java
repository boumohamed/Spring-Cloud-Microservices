package me.bouzri.billingservice;

import me.bouzri.billingservice.feign.CustomerRestClient;
import me.bouzri.billingservice.feign.ProductItemRestClient;
import me.bouzri.billingservice.models.Customer;
import me.bouzri.billingservice.repositories.BillRepository;
import me.bouzri.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
@EnableFeignClients //////////
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository br,
							ProductItemRepository pir,
							CustomerRestClient crc,
							ProductItemRestClient prc)
	{
		return args -> {
			/*Collection<Customer> customers = crc.getCustomers();
			customers.forEach(c -> {
				System.out.println(c.getEmail());
			});*/
			Customer customer = crc.getCustomer(1L);
			System.out.println(customer.getEmail());
			// 43 : 00

		};
	}

}
