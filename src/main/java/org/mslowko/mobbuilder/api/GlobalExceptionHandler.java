package org.mslowko.mobbuilder.api;

import lombok.extern.slf4j.Slf4j;
import org.mslowko.mobbuilder.dto.response.ErrorResponse;
import org.mslowko.mobbuilder.model.exception.MobTierNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MobTierNotAvailableException.class})
    public ResponseEntity<Object> handleMobTierNotAvailableException(MobTierNotAvailableException e) {
        return parseError(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        return parseError(HttpStatus.BAD_REQUEST, e);
    }

    private ResponseEntity<Object> parseError(HttpStatus status, Exception e) {
        log.debug("GlobalExceptionHandler has caught and handled an error: {}", e.getMessage());
        return ResponseEntity.status(status).body(new ErrorResponse(status, e));
    }
}
