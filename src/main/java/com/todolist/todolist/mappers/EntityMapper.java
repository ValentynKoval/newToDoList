package com.todolist.todolist.mappers;

public interface EntityMapper<E, D>{
    E toEntity(D dto);

    D toDto(E entity);
}
