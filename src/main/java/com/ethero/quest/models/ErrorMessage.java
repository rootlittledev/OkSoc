package com.ethero.quest.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    private int errorCode;

    private String errorMessage;
    private String errorDocumentation;

    public ErrorMessage() {
    }

    public ErrorMessage(int errorCode, String errorMessage, String errorDocumentation) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDocumentation = errorDocumentation;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDocumentation() {
        return errorDocumentation;
    }

    public void setErrorDocumentation(String errorDocumentation) {
        this.errorDocumentation = errorDocumentation;
    }
}
