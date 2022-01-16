package com.EthioPharmacy.EthioPharmacy.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @NotBlank(message = "medicine name can not be empty")
    private String medName;

    @NotBlank(message = "medicine price can not be empty")
    @Pattern(regexp = "^[$][0-9]+$")
    private String medPrice;

    @NotBlank(message = "description must be provided")
    @Size(min=10 , message = "descrption must be at least 10 character")
    private String medDescription;
}
