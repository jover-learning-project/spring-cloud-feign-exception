package com.questionbank.userservice.service;

import com.questionbank.uidservice.api.UidApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@FeignClient(name = "uid-service-provider")
public interface UidService extends UidApi {

}
