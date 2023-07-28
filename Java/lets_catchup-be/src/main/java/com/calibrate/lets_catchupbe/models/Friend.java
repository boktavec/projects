package com.calibrate.lets_catchupbe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter @AllArgsConstructor
public class Friend{
    @Id
    private String id;
    private String fullName;

}
