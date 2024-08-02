package org.mslowko.tbf.assetbuilder.api;

import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.dto.response.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AssetController<U, V> {
    String SUCCESS = "Asset successfully added.";

    @GetMapping("/status")
    ResponseEntity<StatusResponse> getStatus();

    @GetMapping("/fetch")
    ResponseEntity<U> fetchBasicAsset(@RequestParam("level") int level);

    @GetMapping("/fetch/boss")
    ResponseEntity<U> fetchBossAsset(@RequestParam("level") int level);

    @PostMapping("/add")
    ResponseEntity<SuccessResponse> addNewAsset(@RequestBody V dto);
}
