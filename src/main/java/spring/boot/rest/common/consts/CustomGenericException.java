package spring.boot.rest.common.consts;

import lombok.Data;

@Data
public class CustomGenericException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    public CustomGenericException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
