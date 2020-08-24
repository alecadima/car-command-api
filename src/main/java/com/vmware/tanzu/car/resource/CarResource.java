package com.vmware.tanzu.car.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Car Resource
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarResource {

    private UUID id;
    @Size(min = 1, max = 64)
    @NotBlank
    private String assembler;
    @Size(min = 1, max = 64)
    @NotBlank
    private String model;
    @NotNull
    private Integer manufacturingYear;
    @NotNull
    private Integer modelYear;

}
