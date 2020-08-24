package com.vmware.tanzu.car.service;

import com.vmware.tanzu.car.domain.Car;
import com.vmware.tanzu.car.exception.CarNotFoundException;
import com.vmware.tanzu.car.repository.CarRepository;
import com.vmware.tanzu.car.resource.CarResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.function.Function;

/**
 * Implementation of Car Service
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Convert entity to Mode (Domain->Resource)
     */
    private Function<Car, CarResource> mapEntityToResource = car ->
            CarResource.builder()
                    .id(car.getId())
                    .assembler(car.getAssembler())
                    .model(car.getModel())
                    .manufacturingYear(car.getManufacturingYear())
                    .modelYear(car.getModelYear())
                    .build();
    /**
     * Convert Resource to Entity (Resource-> Entity)
     */
    private Function<CarResource, Car> mapResourceToEntity = carResource ->
            Car.builder()
                    .id(carResource.getId())
                    .assembler(carResource.getAssembler())
                    .model(carResource.getModel())
                    .manufacturingYear(carResource.getManufacturingYear())
                    .modelYear(carResource.getModelYear())
                    .build();

    /**
     * @see CarService#create(CarResource)
     */
    @Override
    @Transactional
    public CarResource create(CarResource carResource) {
        return createOrUpdate(carResource);
    }

    /**
     * @see CarService#update(CarResource)
     */
    @Override
    @Transactional
    public void update(CarResource carResource) {
        checkCarExists(carResource.getId());
        createOrUpdate(carResource);
    }

    /**
     * @param carId
     * @see CarService#delete(UUID)
     */
    @Override
    @Transactional
    public void delete(UUID carId) {
        checkCarExists(carId);
        carRepository.deleteById(carId);
    }

    /**
     * Check if the Car with id provided exist in the database
     *
     * @param idCar
     */
    private void checkCarExists(UUID idCar) {
        Boolean exists = carRepository.existsById(idCar);
        if (!exists) {
            throw new CarNotFoundException();
        }
    }

    /**
     * Create Or Update a Car
     *
     * @param carResource
     * @return
     */
    private CarResource createOrUpdate(CarResource carResource) {
        Car car = mapResourceToEntity.apply(carResource);
        car = carRepository.save(car);
        log.debug("Saving Car {} ", car.getId());
        return mapEntityToResource.apply(car);
    }

}