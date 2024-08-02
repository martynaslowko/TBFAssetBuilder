package org.mslowko.tbf.assetbuilder.model;

import org.mslowko.tbf.assetbuilder.model.sub.Tier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findItemsByTier(Tier tier);
    boolean existsByTier(Tier tier);
}