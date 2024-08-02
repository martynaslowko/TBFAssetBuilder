package org.mslowko.tbf.assetbuilder.api;

import lombok.RequiredArgsConstructor;
import org.mslowko.tbf.assetbuilder.dto.MobDTO;
import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.dto.response.SuccessResponse;
import org.mslowko.tbf.assetbuilder.model.Mob;
import org.mslowko.tbf.assetbuilder.service.MobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mobs")
@RequiredArgsConstructor
public class MobController implements AssetController <Mob, MobDTO>{
    private final MobService mobService;

    @Override
    public ResponseEntity<StatusResponse> getStatus() {
        return ResponseEntity.ok(mobService.getRepositoryStatus());
    }

    @Override
    public ResponseEntity<Mob> fetchBasicAsset(@RequestParam("level") int level) {
        return ResponseEntity.ok(mobService.buildAsset(level, false));
    }

    @Override
    public ResponseEntity<Mob> fetchBossAsset(@RequestParam("level") int level) {
        return ResponseEntity.ok(mobService.buildAsset(level, true));
    }

    @Override
    public ResponseEntity<SuccessResponse> addNewAsset(@RequestBody MobDTO dto) {
        return ResponseEntity.ok(new SuccessResponse(SUCCESS, mobService.addNewAsset(dto)));
    }
}
