package br.com.igbeni.b2w.exception;

/**
 * Created by iggor on 02/08/2017.
 */
public class TriangleException extends NullPointerException {
    public TriangleException() {
        super("Triangle cannot be null!");
    }
}
