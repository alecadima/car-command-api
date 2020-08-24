package com.vmware.tanzu.car.api;

import com.vmware.tanzu.car.resource.CarResource;
import com.vmware.tanzu.car.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

/**
 * Car REST API
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = {""}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCar(@RequestBody @Valid CarResource carResource) {
        carResource = carService.create(carResource);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carResource.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{carId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCar(@PathVariable(value = "carId") UUID carId, @RequestBody @Valid CarResource carResource) {
        carResource.setId(carId);
        carService.update(carResource);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable(value = "carId") UUID carId) {
        carService.delete(carId);
        return ResponseEntity.noContent().build();
    }

}