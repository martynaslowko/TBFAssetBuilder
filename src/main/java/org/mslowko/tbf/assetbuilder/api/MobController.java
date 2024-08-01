package org.mslowko.tbf.assetbuilder.api;

import lombok.RequiredArgsConstructor;
import org.mslowko.tbf.assetbuilder.dto.MobDTO;
import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.model.Mob;
import org.mslowko.tbf.assetbuilder.service.MobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mobs")
@RequiredArgsConstructor
public class MobController {
    private final MobService mobService;

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> getStatus() {
        return ResponseEntity.ok(mobService.getRepositoryStatus());
    }

    @GetMapping("/fetch")
    public ResponseEntity<Mob> fetchBasicMob(@RequestParam("level") int level) {
        return ResponseEntity.ok(mobService.buildMob(level, false));
    }

    @GetMapping("/fetch/boss")
    public ResponseEntity<Mob> fetchBossMob(@RequestParam("level") int level) {
        return ResponseEntity.ok(mobService.buildMob(level, true));
    }

    @PostMapping("/add")
    public ResponseEntity<Mob> addNewMob(@RequestBody MobDTO mob) {
        return ResponseEntity.ok(mobService.addNewMob(mob));
    }
}
