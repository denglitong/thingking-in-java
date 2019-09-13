package com.denglitong.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @autor denglitong
 * @date 2019/9/13
 */
public class MessyExceptions {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream(new File("Messyexceptions.java"));
        } catch (IOException e) {
            // Handle contents
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // handle the close() error
                }
            }
        }
    }
}
