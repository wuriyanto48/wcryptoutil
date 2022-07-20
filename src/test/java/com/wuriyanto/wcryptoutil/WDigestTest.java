package com.wuriyanto.wcryptoutil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WDigestTest extends TestCase {
    
    public WDigestTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(WDigestTest.class);
    }

    public void testMd5() {
        String expected = "5eb63bbbe01eeed093cb22bb8f5acdc3";
        try {
            String actual = WDigest.md5("hello world".getBytes());

            assertEquals(expected, actual);
        } catch(Exception e) {
            assertNull(e);
        }
    }

    public void testSha1() {
        String expected = "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed";
        try {
            String actual = WDigest.sha1("hello world".getBytes());

            assertEquals(expected, actual);
        } catch(Exception e) {
            assertNull(e);
        }
    }

    public void testSha256() {
        String expected = "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9";
        try {
            String actual = WDigest.sha256("hello world".getBytes());

            assertEquals(expected, actual);
        } catch(Exception e) {
            assertNull(e);
        }
    }

    public void testSha384() {
        String expected = "fdbd8e75a67f29f701a4e040385e2e23986303ea10239211af907fcbb83578b3e417cb71ce646efd0819dd8c088de1bd";
        try {
            String actual = WDigest.sha384("hello world".getBytes());

            assertEquals(expected, actual);
        } catch(Exception e) {
            assertNull(e);
        }
    }

    public void testSha512() {
        String expected = "309ecc489c12d6eb4cc40f50c902f2b4d0ed77ee511a7c7a9bcd3ca86d4cd86f989dd35bc5ff499670da34255b45b0cfd830e81f605dcf7dc5542e93ae9cd76f";
        try {
            String actual = WDigest.sha512("hello world".getBytes());

            assertEquals(expected, actual);
        } catch(Exception e) {
            assertNull(e);
        }
    }
}
