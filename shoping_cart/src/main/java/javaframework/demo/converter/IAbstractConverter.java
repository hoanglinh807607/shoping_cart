package javaframework.demo.converter;

public interface IAbstractConverter<T,S> {
    T toDto( S entity);
    S toEntity(T dto);
    S toEntity(S entity, T dto);
}
