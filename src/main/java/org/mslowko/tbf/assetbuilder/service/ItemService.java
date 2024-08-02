package org.mslowko.tbf.assetbuilder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mslowko.tbf.assetbuilder.dto.ItemDTO;
import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.model.Item;
import org.mslowko.tbf.assetbuilder.model.ItemBake;
import org.mslowko.tbf.assetbuilder.model.ItemRepository;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService implements AssetService<Item, ItemDTO> {
    private final ItemRepository repository;

    public StatusResponse getRepositoryStatus() {
        return getStatusResponse(repository.existsByTier(Tier.B),
                repository.existsByTier(Tier.A),
                repository.existsByTier(Tier.S));
    }

    @Override
    public Item addNewAsset(ItemDTO assetDTO) {
        if (repository.existsById(assetDTO.getName()))
            throw new IllegalArgumentException("Mob already exists.");
        Item item = new Item(assetDTO);
        repository.save(item);
        log.info("New item added: {}", item);
        return item;
    }

    public ItemBake getDedicatedItem(int level, boolean isBoss){
        Item item = buildAsset(level, isBoss);
        return bakeItem(item, level);
    }

    @Override
    public Item buildAsset(int level, boolean isBoss) {
        Tier tier;
        if (isBoss)
            tier = random.nextInt(100) >= 90
                    ? Tier.S : Tier.A;
        else
            tier = random.nextInt(100) >= 80
                    ? Tier.A : Tier.B;
        return fetchRandomAssetByTier(repository.findItemsByTier(tier), tier);
    }

    private ItemBake bakeItem(Item item, int level) {
        int levelBonus = level/10;
        int value = random.nextInt(item.range.getMinimum(), item.range.getMaximum()) + levelBonus;
        return new ItemBake(item, value);
    }
}
