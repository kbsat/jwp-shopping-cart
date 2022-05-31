package woowacourse.shoppingcart.exception;

public class ForbiddenAccessException extends RuntimeException {

    public ForbiddenAccessException() {
        this("권한이 없는 요청입니다.");
    }

    public ForbiddenAccessException(final String msg) {
        super(msg);
    }
}
