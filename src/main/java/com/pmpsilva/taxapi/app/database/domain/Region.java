package com.pmpsilva.taxapi.app.database.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "regions")
public class Region implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ApiModelProperty(notes = "code of region", value = "PT_MA")
    private String code;
    @ApiModelProperty(notes = "name of region", value = "Madeira")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

}
