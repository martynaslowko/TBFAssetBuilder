package org.mslowko.tbf.assetbuilder.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class SuccessResponse {
    public final String message;
    public final HttpStatus status = HttpStatus.OK;
    public final int code = 200;
    public final Object asset;
}
