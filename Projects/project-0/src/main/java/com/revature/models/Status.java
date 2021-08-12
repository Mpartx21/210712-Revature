package com.revature.models;

public enum Status {
    pending("pending"),approved("approved"),denied("denied"),nulled("nulled");

    private String status;

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;

    }

    public void setStatus(String status) {
        this.status = status;
    }

    Status(String status) {
        this.status = status;
    }

    public static Status getByType(String status) {
        for (Status statuses : Status.values()) {
            if (statuses.status.equals(status)) {
                return statuses;
            }
        }
        return pending;
    }
}
