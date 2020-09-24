package com.questionbank.uidservice.api.domain.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Data
public class UidRequest implements Serializable {

    @NotNull
    @Min(0)
    Long datacenterId;

    @NotNull
    @Min(0)
    Long machineId;

}
