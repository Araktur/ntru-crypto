/******************************************************************************
 * NTRU Cryptography Reference Source Code
 * Copyright (c) 2009-2013, by Security Innovation, Inc. All rights reserved.
 *
 * Copyright (C) 2009-2013  Security Innovation
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *********************************************************************************/
package com.securityinnovation.jNeo.inputstream;

import org.junit.Test;
import static org.junit.Assert.*;

import static com.securityinnovation.jNeo.digest.DigestAlgorithm.*;


public class MGF1TestCase {

    // Value taken from 
    // ftp://ftp.rsasecurity.com/pub/pkcs/pkcs-1/pkcs-1v2-1-vec.zip
    // (in oaep-int.txt, dbMask = MGF-1(SHA-1, seed))
    @Test public void test_positive_sha1()
    {
        byte seed[] = {
            (byte)0xaa, (byte)0xfd, (byte)0x12, (byte)0xf6, (byte)0x59,
            (byte)0xca, (byte)0xe6, (byte)0x34, (byte)0x89, (byte)0xb4,
            (byte)0x79, (byte)0xe5, (byte)0x07, (byte)0x6d, (byte)0xde,
            (byte)0xc2, (byte)0xf0, (byte)0x6c, (byte)0xb5, (byte)0x8f
        };
        byte expectedOut[] = {
            (byte)0x06, (byte)0xe1, (byte)0xde, (byte)0xb2, (byte)0x36,
            (byte)0x9a, (byte)0xa5, (byte)0xa5, (byte)0xc7, (byte)0x07,
            (byte)0xd8, (byte)0x2c, (byte)0x8e, (byte)0x4e, (byte)0x93,
            (byte)0x24, (byte)0x8a, (byte)0xc7, (byte)0x83, (byte)0xde,
            (byte)0xe0, (byte)0xb2, (byte)0xc0, (byte)0x46, (byte)0x26,
            (byte)0xf5, (byte)0xaf, (byte)0xf9, (byte)0x3e, (byte)0xdc,
            (byte)0xfb, (byte)0x25, (byte)0xc9, (byte)0xc2, (byte)0xb3,
            (byte)0xff, (byte)0x8a, (byte)0xe1, (byte)0x0e, (byte)0x83,
            (byte)0x9a, (byte)0x2d, (byte)0xdb, (byte)0x4c, (byte)0xdc,
            (byte)0xfe, (byte)0x4f, (byte)0xf4, (byte)0x77, (byte)0x28,
            (byte)0xb4, (byte)0xa1, (byte)0xb7, (byte)0xc1, (byte)0x36,
            (byte)0x2b, (byte)0xaa, (byte)0xd2, (byte)0x9a, (byte)0xb4,
            (byte)0x8d, (byte)0x28, (byte)0x69, (byte)0xd5, (byte)0x02,
            (byte)0x41, (byte)0x21, (byte)0x43, (byte)0x58, (byte)0x11,
            (byte)0x59, (byte)0x1b, (byte)0xe3, (byte)0x92, (byte)0xf9,
            (byte)0x82, (byte)0xfb, (byte)0x3e, (byte)0x87, (byte)0xd0,
            (byte)0x95, (byte)0xae, (byte)0xb4, (byte)0x04, (byte)0x48,
            (byte)0xdb, (byte)0x97, (byte)0x2f, (byte)0x3a, (byte)0xc1,
            (byte)0x4e, (byte)0xaf, (byte)0xf4, (byte)0x9c, (byte)0x8c,
            (byte)0x3b, (byte)0x7c, (byte)0xfc, (byte)0x95, (byte)0x1a,
            (byte)0x51, (byte)0xec, (byte)0xd1, (byte)0xdd, (byte)0xe6,
            (byte)0x12, (byte)0x64
        };

        MGF1 mgf = new MGF1(sha1, 1, false, seed, 0, seed.length);
        byte out[] = new byte[expectedOut.length];
        int offset = 0;

        out[offset++] = (byte) mgf.read();
        out[offset++] = (byte) mgf.read();
        out[offset++] = (byte) mgf.read();
        mgf.read(out, offset, 4);
        offset += 4;
        mgf.read(out, offset, out.length-offset);
        assertArrayEquals(expectedOut, out);
    }



    // Generated internally, to ensure future code changes don't change
    // behavior
    @Test public void test_positive_sha256()
    {
        byte seed[] = {
            (byte)0xff, (byte)0xfd, (byte)0x12, (byte)0xf6, (byte)0x59,
            (byte)0xca, (byte)0xe6, (byte)0x34, (byte)0x89, (byte)0x32,
            (byte)0x79, (byte)0xe5, (byte)0x07, (byte)0x6d, (byte)0xde,
            (byte)0xc2, (byte)0xf0, (byte)0x6c, (byte)0x21, (byte)0x8f
        };
        byte expectedOut[] = {
            (byte)0x98, (byte)0xc1, (byte)0xa4, (byte)0xfc, (byte)0xb9,
            (byte)0x40, (byte)0x71, (byte)0x15, (byte)0x9b, (byte)0x17,
            (byte)0x6e, (byte)0xa7, (byte)0x01, (byte)0x1e, (byte)0xb6,
            (byte)0x48, (byte)0x57, (byte)0xca, (byte)0xe3, (byte)0xff,
            (byte)0x27, (byte)0x5a, (byte)0xb6, (byte)0x6f, (byte)0xa7,
            (byte)0x38, (byte)0xe8, (byte)0xcb, (byte)0xf7, (byte)0x7a,
            (byte)0x51, (byte)0xe7, (byte)0xd8, (byte)0xa2, (byte)0x17,
            (byte)0x48, (byte)0x0b, (byte)0x78, (byte)0x39, (byte)0x66,
            (byte)0x45, (byte)0x8a, (byte)0x44, (byte)0x59, (byte)0x0a,
            (byte)0xe8, (byte)0x7d, (byte)0x9a, (byte)0x49, (byte)0xd1,
            (byte)0x92, (byte)0xe3, (byte)0xae, (byte)0x7d, (byte)0xb2,
            (byte)0x57, (byte)0xf0, (byte)0xff, (byte)0x94, (byte)0xdd,
            (byte)0xc2, (byte)0xda, (byte)0x35, (byte)0x72, (byte)0x72,
            (byte)0xe5, (byte)0x67, (byte)0x9f, (byte)0x92, (byte)0xb7,
            (byte)0x67, (byte)0x7d, (byte)0x13, (byte)0x23, (byte)0x41,
            (byte)0xac, (byte)0xd2, (byte)0x55, (byte)0x44, (byte)0xd3,
            (byte)0xe6, (byte)0x21, (byte)0xcb, (byte)0xaa, (byte)0xeb,
            (byte)0x80, (byte)0x9d, (byte)0x09, (byte)0x5d, (byte)0x65,
            (byte)0xbb, (byte)0x72, (byte)0x9a, (byte)0x81, (byte)0xa5,
            (byte)0xd8, (byte)0x25, (byte)0x17, (byte)0xba, (byte)0x41,
            (byte)0xd2, (byte)0x52, (byte)0x3b, (byte)0xb2, (byte)0x3a,
            (byte)0x00, (byte)0xae
        };

        MGF1 mgf = new MGF1(sha256, 1, false, seed, 0, seed.length);
        byte out[] = new byte[expectedOut.length];
        int offset = 0;

        out[offset++] = (byte) mgf.read();
        out[offset++] = (byte) mgf.read();
        out[offset++] = (byte) mgf.read();
        mgf.read(out, offset, 4);
        offset += 4;
        out[offset++] = (byte) mgf.read();
        out[offset++] = (byte) mgf.read();
        out[offset++] = (byte) mgf.read();
        mgf.read(out, offset, 4);
        offset += 4;
        mgf.read(out, offset, out.length-offset);
        assertArrayEquals(expectedOut, out);
    }
}
