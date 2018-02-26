package be.lemonade.reactive.poc.repo;

import be.lemonade.reactive.poc.model.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {}
