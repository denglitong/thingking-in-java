package com.dlt;

import com.google.common.base.*;

import static com.google.common.base.Verify.*;

/**
 * @autor denglitong
 * @date 2019/9/15
 */
public class GuavaAssertions {
    public static void main(String[] args) {
        verify(2+2 == 4);

        try {
            verify(1+2 == 4);
        } catch (VerifyException e) {
            System.out.println(e);
        }

        try {
            verify(1+2 == 4, "Bad match");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        try {
            verify(1+2==4, "Bad match: %s", "not 4");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        String s = "";
        s = verifyNotNull(s);
        s = null;
        try {
            verifyNotNull(s);
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        try {
            verifyNotNull(s, "Should't be null: %s", "arg s");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
    }
}
