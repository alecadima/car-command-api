package com.vmware.tanzu.car.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

/**
 * Entity that represent a Car in the domain
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id_car", nullable = false, length = 36)
    private UUID id;
    @Size(min = 1, max = 64)
    @NotBlank
    @Column(name = "nm_assembler", nullable = false, length = 64)
    private String assembler;
    @Size(min = 1, max = 64)
    @NotBlank
    @Column(name = "nm_model", nullable = false, length = 64)
    private String model;
    @NotNull
    @Column(name = "nr_manufacturing_year", nullable = false)
    private Integer manufacturingYear;
    @NotNull
    @Column(name = "nr_model_year", nullable = false)
    private Integer modelYear;

}
