package com.springboot.masterclass.customer.dao_layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    private Long id;
    @NotBlank(message = "name must be not empty")
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "password must be not empty")
    private String password;
    @NotBlank(message = "email must be not empty")
    @Email
    private String email;

}
