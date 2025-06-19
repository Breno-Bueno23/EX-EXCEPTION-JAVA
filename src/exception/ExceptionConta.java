package exception;

import java.io.Serializable;

public class ExceptionConta extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionConta(String msg) {
        super(msg);
    }
}
