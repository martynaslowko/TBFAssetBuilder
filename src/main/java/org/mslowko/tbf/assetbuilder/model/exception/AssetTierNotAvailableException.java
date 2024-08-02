package org.mslowko.tbf.assetbuilder.model.exception;

public class AssetTierNotAvailableException extends RuntimeException{
    private static final String ERR_MESSAGE = "Assets for tier %s not available.";
    public AssetTierNotAvailableException(String name) {
        super(String.format(ERR_MESSAGE, name));
    }
}
