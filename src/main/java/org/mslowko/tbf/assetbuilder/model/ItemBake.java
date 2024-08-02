package org.mslowko.tbf.assetbuilder.model;

import org.mslowko.tbf.assetbuilder.model.sub.ItemType;
import org.mslowko.tbf.assetbuilder.model.sub.Stat;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;

public class ItemBake {
    public ItemType type;
    public String name;
    public Tier tier;
    public Stat stat;
    public int value;

    public ItemBake(Item item, int value){
        this.type = item.type;
        this.name = item.name;
        this.tier = item.tier;
        this.stat = item.stat;
        this.value = value;
    }
}
