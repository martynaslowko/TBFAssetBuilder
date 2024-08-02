package org.mslowko.tbf.assetbuilder.service;

import org.mslowko.tbf.assetbuilder.dto.response.Status;
import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.model.exception.AssetTierNotAvailableException;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;

import java.util.List;
import java.util.Random;

public interface AssetService<U, V> {

    Random random = new Random();

    default StatusResponse getStatusResponse(boolean tierB, boolean tierA, boolean tierS) {
        List<Boolean> tiers = List.of(
                tierB,
                tierA,
                tierS
        );
        Status status = tiers.contains(false) ? Status.UNAVAILABLE : Status.READY;
        return new StatusResponse(status, tiers.get(0), tiers.get(1), tiers.get(2));
    }

    default U fetchRandomAssetByTier(List<U> assets, Tier tier) {
        if (assets.isEmpty())
            throw new AssetTierNotAvailableException(tier.name());
        return assets.get(random.nextInt(assets.size()));
    }
    U addNewAsset(V assetDTO);
    U buildAsset(int level, boolean isBoss);
}
