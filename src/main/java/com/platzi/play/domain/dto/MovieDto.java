package com.platzi.play.domain.dto;

import com.platzi.play.domain.Gender;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,
        @Min(value = 45, message = "La duración debe ser mayor a 45 minutos")
        Integer duration,

        Gender gender,
        @PastOrPresent(message = "La fecha de lanzamiento debe ser mayor a la fecha actual")
        LocalDate movieDate,
        @Min(value = 0, message = "El raiting no puede ser menor a 0")
        @Max(value = 10, message = "El raiting no puede ser mayor a 10")
        BigDecimal raiting,
        @AssertTrue(message = "La pelicula debe estar disponible porque es nueva")
        Boolean state
) {
}
