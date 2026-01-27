package com.platzi.play.domain.dto;

import com.platzi.play.domain.Gender;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,
        @PastOrPresent(message = "La fecha de lanzamiento debe ser mayor a la fecha actual")
        LocalDate movieDate,
        @Min(value = 0, message = "El raiting no puede ser menor a 0")
        @Max(value = 10, message = "El raiting no puede ser mayor a 10")
        BigDecimal raiting
) {
}
