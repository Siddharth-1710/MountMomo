package MountMomos.repositoey;

import MountMomos.Entity.Momos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MomoRepository extends MongoRepository<Momos,Integer> {
}
