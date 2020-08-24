package com.vmware.tanzu.car.service;

import com.vmware.tanzu.car.resource.CarResource;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Service of Car
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Validated
public interface CarService {

    /**
     * Create a car
     *
     * @param carResource
     */
    CarResource create(@NotNull @Valid CarResource carResource);

    /**
     * Update a car by Id
     *
     * @param carResource
     */
    void update(@NotNull @Valid CarResource carResource);

    /**
     * Delete a car by Id
     *
     * @param carId
     */
    void delete(@NotNull UUID carId);

}