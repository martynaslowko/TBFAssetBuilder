package org.mslowko.tbf.assetbuilder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.mslowko.tbf.assetbuilder.dto.Status;

@Data
@AllArgsConstructor
public class StatusResponse {
    private Status status;
    private boolean tierB;
    private boolean tierA;
    private boolean tierS;
}
