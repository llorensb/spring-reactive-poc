package be.lemonade.reactive.poc.repo;

import be.lemonade.reactive.poc.model.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team, String> {}
