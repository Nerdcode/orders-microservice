package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class Inventory {

    @Id
    private String id;

    private String itemName;

    //TODO
    //Can be extended to store other parameters
    //like type(fashion, electronics, grocery), models, colors, sizes n etc

}
