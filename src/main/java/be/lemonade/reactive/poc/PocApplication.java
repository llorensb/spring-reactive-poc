package be.lemonade.reactive.poc;

import be.lemonade.reactive.poc.repo.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}
}
@Component
class SampleTeamsAndProfilesCLR implements CommandLineRunner {

	private TeamRepository teamRepository;

	@Override
	public void run(String... args) throws Exception {
	}




}
