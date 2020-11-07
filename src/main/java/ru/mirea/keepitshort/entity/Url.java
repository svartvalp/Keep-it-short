package ru.mirea.keepitshort.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Document("url")
public class Url {
    private String id;
    @NotNull
    @NotEmpty
    private String userId;
    private String urlFrom;
    @NotNull
    @NotEmpty
    private String urlTo;
    private String comment;
}
