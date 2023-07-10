package com.pmpsilva.taxapi.app.database.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "taxes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tax implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    @JsonIgnore
    private int id;
    @ApiModelProperty(notes = "name of tax", value = "IVA")
    private String name;

    @ApiModelProperty(notes = "description of tax", value = "normal")
    private String description;

    @ApiModelProperty(notes = "value of tax", value = "0.23")
    private double value;

    @ApiModelProperty(notes = "start date of tax", value = "2019-12-01")
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "end date of tax", value = "2020-12-01")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;
}
