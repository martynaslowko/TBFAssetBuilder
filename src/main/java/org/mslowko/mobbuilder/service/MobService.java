package org.mslowko.mobbuilder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mslowko.mobbuilder.dto.MobDTO;
import org.mslowko.mobbuilder.model.Mob;
import org.mslowko.mobbuilder.model.MobRepository;
import org.mslowko.mobbuilder.model.Tier;
import org.mslowko.mobbuilder.model.exception.MobTierNotAvailableException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class MobService {
    private final MobRepository repository;
    private final Random random = new Random();

    public Mob buildMob(int level, boolean isBoss) {
        Tier tier;
        if (isBoss)
            tier = Tier.S;
        else
            tier = random.nextInt(100) >= 70
                    ? Tier.A : Tier.B;
        Mob mob = fetchRandomMobByTier(tier);
        scaleStats(mob, level);
        log.debug("Deployed mob: {}", mob);
        return mob;
    }

    public Mob addNewMob(MobDTO mobDTO) {
        if (repository.existsById(mobDTO.getName()))
            throw new IllegalArgumentException("Mob already exists.");
        Mob mob = new Mob(mobDTO);
        repository.save(mob);
        log.info("New mob added: {}", mob);
        return mob;
    }

    public void scaleStats(Mob mob, int level) {
        if (level % 10 != 0) return;
        float multiplier = (level/10.0f + 1f) * 0.5f;
        mob.hp = Math.round(mob.hp * multiplier);
        mob.damage = Math.round(mob.damage * multiplier);
    }

    private Mob fetchRandomMobByTier(Tier tier) {
        List<Mob> mobs = repository.findMobsByTier(tier);
        if (mobs.isEmpty())
            throw new MobTierNotAvailableException(tier.name());
        return mobs.get(random.nextInt(mobs.size()));
    }
}
