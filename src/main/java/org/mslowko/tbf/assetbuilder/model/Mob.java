package org.mslowko.tbf.assetbuilder.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.mslowko.tbf.assetbuilder.dto.MobDTO;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("mobs")
public class Mob {
    public @MongoId String name;
    public Tier tier;
    public int hp;
    public int damage;
    public int exp;

    public Mob(MobDTO mobDTO) {
        this.name = mobDTO.getName();
        this.tier = mobDTO.getTier();
        this.hp = mobDTO.getHp();
        this.damage = mobDTO.getDamage();
        this.exp = mobDTO.getExp();
    }
}
