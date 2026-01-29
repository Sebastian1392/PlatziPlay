package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenderMapper.class, StateMapper.class})
public interface MovieMapper {

    @Mapping(source = "title", target = "title")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "stringToGender")
    @Mapping(source = "movieDate", target = "movieDate")
    @Mapping(source = "clasification", target = "raiting")
    @Mapping(source = "state", target = "state", qualifiedByName = "stringToBoolean")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "gender", target = "gender", qualifiedByName = "genderToString")
    @Mapping(source = "state", target = "state", qualifiedByName = "booleanToString")
    MovieEntity toEntity(MovieDto movieDto);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "movieDate", target = "movieDate")
    @Mapping(source = "raiting", target = "clasification")
    @Mapping(target = "duration", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "state", ignore = true)
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);
}
