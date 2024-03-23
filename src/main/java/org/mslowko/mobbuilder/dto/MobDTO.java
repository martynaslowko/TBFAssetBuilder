package org.mslowko.mobbuilder.dto;

import lombok.Data;
import org.mslowko.mobbuilder.model.Tier;

@Data
public class MobDTO {
    private String name;
    private Tier tier;
    private int hp;
    private int damage;
    private int exp;
}
