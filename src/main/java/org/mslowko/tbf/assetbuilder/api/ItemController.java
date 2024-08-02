package org.mslowko.tbf.assetbuilder.api;

import lombok.RequiredArgsConstructor;
import org.mslowko.tbf.assetbuilder.dto.ItemDTO;
import org.mslowko.tbf.assetbuilder.dto.response.StatusResponse;
import org.mslowko.tbf.assetbuilder.dto.response.SuccessResponse;
import org.mslowko.tbf.assetbuilder.model.ItemBake;
import org.mslowko.tbf.assetbuilder.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController implements AssetController <ItemBake, ItemDTO>{
    private final ItemService itemService;

    @Override
    public ResponseEntity<StatusResponse> getStatus() {
        return ResponseEntity.ok(itemService.getRepositoryStatus());
    }

    @Override
    public ResponseEntity<ItemBake> fetchBasicAsset(int level) {
        return ResponseEntity.ok(itemService.getDedicatedItem(level, false));
    }

    @Override
    public ResponseEntity<ItemBake> fetchBossAsset(int level) {
        return ResponseEntity.ok(itemService.getDedicatedItem(level, true));
    }

    @Override
    public ResponseEntity<SuccessResponse> addNewAsset(ItemDTO dto) {
        return ResponseEntity.ok(new SuccessResponse(SUCCESS, itemService.addNewAsset(dto)));
    }
}
