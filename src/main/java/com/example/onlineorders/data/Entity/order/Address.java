package com.example.onlineorders.data.Entity.order;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {

        private String street;

        private String alley;

        private String plaqueHome;
}
