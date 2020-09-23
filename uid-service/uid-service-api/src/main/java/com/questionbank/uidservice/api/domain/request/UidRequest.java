package com.questionbank.uidservice.api.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Data
public class UidRequest implements Serializable {

    Long datacenterId;

    @NotNull
    Long machineId;

}
