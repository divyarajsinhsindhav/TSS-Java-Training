package com.tss.library.model;

public enum Category {
    FICTION("Fiction"),
    NON_FICTION("Non-Fiction"),
    SCIENCE("Science"),
    TECHNOLOGY("Technology"),
    HISTORY("History"),
    BIOGRAPHY("Biography"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    HORROR("Horror"),
    EDUCATION("Education"),
    CHILDREN("Children");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
