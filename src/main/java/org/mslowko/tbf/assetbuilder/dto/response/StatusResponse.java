package org.mslowko.tbf.assetbuilder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusResponse {
    private Status status;
    private boolean tierB;
    private boolean tierA;
    private boolean tierS;
}
