package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/8
 */

class BaseException extends Exception {}
class DerivedException extends BaseException {}

public class PreciseRethrow {
    /**
     * 在Java7之前，如果遇到异常，则只能重新抛出该类型的异常，这导致在Java7中修复的代码不精确
     * 在Java7之后，实际上抛出了更具体的DerivedException，即使捕获的是BaseException，
     * 也能返回更具体的DerivedException类型
     *
     * @throws DerivedException
     */
    void catcher() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (BaseException e) {
            throw e;
        }
    }
}
