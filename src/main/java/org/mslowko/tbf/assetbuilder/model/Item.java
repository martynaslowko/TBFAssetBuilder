package org.mslowko.tbf.assetbuilder.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.Range;
import org.mslowko.tbf.assetbuilder.dto.ItemDTO;
import org.mslowko.tbf.assetbuilder.model.sub.ItemType;
import org.mslowko.tbf.assetbuilder.model.sub.Stat;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("items")
public class Item {
    public ItemType type;
    public @MongoId String name;
    public Tier tier;
    public Stat stat;
    public Range<Integer> range;

    public Item(ItemDTO itemDTO) {
        this.type = itemDTO.getType();
        this.name = itemDTO.getName();
        this.tier = itemDTO.getTier();
        this.stat = itemDTO.getStat();
        this.range = Range.of(itemDTO.getRangeMin(), itemDTO.getRangeMax());
    }
}
