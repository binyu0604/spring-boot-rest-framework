package spring.boot.rest.common.consts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {type your description }
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
public class RestConst {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ErrorInfo{
        public String ErrorCode;
        public String ErrorMsg;
    }
    public static class ErrorCode {

        public final static String UNKNOWN = "000";
        public final static String VALIDATE_FAIL = "001"; //参数校验失败
        public final static String EMPTY_PARAM = "002"; //参数为空
        public final static String DATABASE_ERROR = "003"; //数据库层面的错误


    }

    public static ErrorInfo[] errorInfos = new ErrorInfo[]{
            new ErrorInfo( ErrorCode.UNKNOWN , "未知错误" )
            ,new ErrorInfo( ErrorCode.VALIDATE_FAIL , "参数校验失败" )
            ,new ErrorInfo( ErrorCode.EMPTY_PARAM , "参数为空" )
            ,new ErrorInfo( ErrorCode.DATABASE_ERROR , "数据库错误" )
    };

    public static class HttpCode {
        public final static String Continue = "100";
        public final static String SwitchingProtocols = "101";
        public final static String Processing = "102";


        public final static String OK = "200";
        public final static String Created = "201";
        public final static String Accepted = "202";

    }
}
