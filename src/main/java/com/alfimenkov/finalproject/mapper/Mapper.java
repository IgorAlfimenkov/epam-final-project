package com.alfimenkov.finalproject.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Mapper<Dto, Entity> implements IMapper<Dto, Entity> {

    private final ModelMapper mapper;

    @Override
    @SuppressWarnings("unchecked")
    public Entity toEntity(Dto dto, Class<?> entity) {
        return Objects.isNull(dto) ? null : (Entity) mapper.map(dto, entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Dto toDto(Entity entity, Class<?> dto) {
        return Objects.isNull(entity) ? null : (Dto) mapper.map(entity, dto);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Dto> setToDto(Set<Entity> setOfEntities, Class<?> dto) {
        return setOfEntities.stream()
                .map((entity) -> (Dto) mapper.map(entity, dto))
                .collect(Collectors.toSet());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Entity> setToEntities(Set<Dto> setOfDto, Class<?> entity) {
        return setOfDto.stream()
                .map((dto) -> (Entity) mapper.map(dto, entity))
                .collect(Collectors.toSet());
    }

}
