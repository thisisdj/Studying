package hello.jdbc.repository.ex;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryEx;

import java.sql.SQLException;

public class MyDbException extends RuntimeException {
    public MyDbException() {

    }

    public MyDbException(String message) {
        super(message);
    }

    public MyDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDbException(Throwable cause) {
        super(cause);
    }
}
