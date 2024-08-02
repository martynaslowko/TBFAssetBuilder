package org.mslowko.tbf.assetbuilder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mslowko.tbf.assetbuilder.dto.MobDTO;
import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.model.Mob;
import org.mslowko.tbf.assetbuilder.model.MobRepository;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MobService implements AssetService<Mob, MobDTO>{
    private final MobRepository repository;

    public StatusResponse getRepositoryStatus() {
        return getStatusResponse(repository.existsByTier(Tier.B),
                repository.existsByTier(Tier.A),
                repository.existsByTier(Tier.S));
    }

    @Override
    public Mob addNewAsset(MobDTO assetDTO) {
        if (repository.existsById(assetDTO.getName()))
            throw new IllegalArgumentException("Mob already exists.");
        Mob mob = new Mob(assetDTO);
        repository.save(mob);
        log.info("New mob added: {}", mob);
        return mob;
    }

    @Override
    public Mob buildAsset(int level, boolean isBoss) {
        Tier tier;
        if (isBoss)
            tier = Tier.S;
        else
            tier = random.nextInt(100) >= 70
                    ? Tier.A : Tier.B;
        Mob mob = fetchRandomAssetByTier(repository.findMobsByTier(tier), tier);
        scaleStats(mob, level);
        log.debug("Deployed mob: {}", mob);
        return mob;
    }

    public void scaleStats(Mob mob, int level) {
        if (level % 10 != 0) return;
        float multiplier = (level/10.0f + 1f) * 0.5f;
        mob.hp = Math.round(mob.hp * multiplier);
        mob.damage = Math.round(mob.damage * multiplier);
    }
}
