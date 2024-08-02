package org.mslowko.tbf.assetbuilder.dto;

import lombok.Data;
import org.mslowko.tbf.assetbuilder.model.sub.ItemType;
import org.mslowko.tbf.assetbuilder.model.sub.Stat;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;

@Data
public class ItemDTO {
    private ItemType type;
    private String name;
    private Stat stat;
    private int rangeMin;
    private int rangeMax;
    private Tier tier;
}
