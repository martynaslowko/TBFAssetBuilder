package org.mslowko.tbf.assetbuilder.dto;

import lombok.Data;
import org.mslowko.tbf.assetbuilder.model.sub.Tier;

@Data
public class MobDTO {
    private String name;
    private Tier tier;
    private int hp;
    private int damage;
    private int exp;
}
