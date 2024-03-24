package org.mslowko.mobbuilder.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobRepository extends MongoRepository<Mob, String> {
    List<Mob> findMobsByTier(Tier tier);
    boolean existsByTier(Tier tier);
}