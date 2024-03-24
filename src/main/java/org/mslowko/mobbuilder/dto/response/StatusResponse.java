package org.mslowko.mobbuilder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.mslowko.mobbuilder.dto.Status;

@Data
@AllArgsConstructor
public class StatusResponse {
    private Status status;
    private boolean tierB;
    private boolean tierA;
    private boolean tierS;
}
