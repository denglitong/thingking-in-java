package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/13
 */
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    Inning() throws BaseballException {}
    public void event() throws BaseballException {
        // Doesn't actually have to throw anything
    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() {} // Throws no checked exceptions
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

    // OK to add new exceptions for constructors,
    // but you must deal with the base constructor exceptions:
    public StormyInning() throws BaseballException, RainedOut {}
    public StormyInning(String s) throws BaseballException {}

    // regular methods must conform to base class:
    // void walk() throws PopFoul {}

    // interface CANNOT add exceptions to existing methods from the base class:
    // public void event() throws RainedOut {}

    // overridden methods can throw inherited exceptions:
    @Override
    public void atBat() throws PopFoul {}

    // if the method doesn't already exist in the base class, the exception is OK:
    @Override
    public void rainHard() throws RainedOut {}

    // you can choose to not throw any exceptions, even if the base version does:
    // 方法签名并不包括抛出的异常
    @Override
    public void event() {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        // strike not thrown in derived version
        try {
            // what happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // you must catch the exceptions from the base-class version of the method:
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
