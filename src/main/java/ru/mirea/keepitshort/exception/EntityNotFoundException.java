package ru.mirea.keepitshort.exception;

public class EntityNotFoundException extends BusinessLogicException {

    public EntityNotFoundException(String entityName) {
        super(entityName + " not found");
    }
}
