package org.mslowko.mobbuilder.model.exception;

public class MobTierNotAvailableException extends RuntimeException{
    private static final String ERR_MESSAGE = "Mobs for tier %s not available.";
    public MobTierNotAvailableException(String name) {
        super(String.format(ERR_MESSAGE, name));
    }
}
