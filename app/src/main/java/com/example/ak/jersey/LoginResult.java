package com.example.ak.jersey;

public class LoginResult {

    private int status;
    private String reason;
    private Boolean hasEntity;
    private Boolean closed;
    private Boolean buffered;

    public LoginResult() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getHasEntity() {
        return hasEntity;
    }

    public void setHasEntity(Boolean hasEntity) {
        this.hasEntity = hasEntity;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getBuffered() {
        return buffered;
    }

    public void setBuffered(Boolean buffered) {
        this.buffered = buffered;
    }
}