package ru.mirea.keepitshort.exception;

public class EntityAlreadyExistsException extends BusinessLogicException {

    public EntityAlreadyExistsException(String entityName) {
        super(entityName + " already exists");
    }
}
