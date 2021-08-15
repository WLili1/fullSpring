package kuli.wzq.springframework.beans;

/**
 * @author kuli.wzq
 * @since 2021-08-15 下午4:46
 */
public class BeansException  extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
