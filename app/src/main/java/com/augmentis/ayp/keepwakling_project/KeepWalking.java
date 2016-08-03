package com.augmentis.ayp.keepwakling_project;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Theerawuth on 8/3/2016.
 */
public class KeepWalking {
    private UUID id;
    private String title;
    private Date date;

    public KeepWalking() {
        this(UUID.randomUUID());
    }

    public KeepWalking(UUID id) {
        this.id = id;
        date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
