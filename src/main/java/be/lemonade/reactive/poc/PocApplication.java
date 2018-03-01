package be.lemonade.reactive.poc;

import be.lemonade.reactive.poc.model.Approval;
import be.lemonade.reactive.poc.model.PersonalData;
import be.lemonade.reactive.poc.model.Profile;
import be.lemonade.reactive.poc.model.Team;
import be.lemonade.reactive.poc.repo.ProfileRepository;
import be.lemonade.reactive.poc.repo.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}
}
@Component
@AllArgsConstructor
class SampleTeamsAndProfilesCLR implements CommandLineRunner {

	private final TeamRepository teamRepository;
	private final ProfileRepository profileRepository;



	@Override
	public void run(String... args) throws Exception {
		teamRepository.deleteAll().subscribe(null, null, ()-> {

			Stream.of("TeamA", "TeamB", "TeamC").forEach(id -> teamRepository.save(new Team(id, new ArrayList<String>(), new ArrayList<Approval>())).subscribe());
			teamRepository.findAll().subscribe(System.out::println);
		});
		profileRepository.deleteAll().subscribe(null, null, ()-> {
			Stream.of("Jordi", "Michael", "Werner").forEach(name -> profileRepository.save(new Profile(UUID.randomUUID().toString(), new ArrayList<Approval>(), new ArrayList<Team>(), new PersonalData(name, name, "", ""))).subscribe());
			profileRepository.findAll().subscribe(System.out::println);
		});
	}





}
