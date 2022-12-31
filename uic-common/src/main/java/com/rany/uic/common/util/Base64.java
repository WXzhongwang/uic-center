package com.rany.uic.common.util;

/**
 * @Description
 * @Author Wythe
 * @Version V1.0.0
 * @Since 1.0
 * @Date 02/05/2021
 */
public final class Base64 {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int SIX = 6;
    private static final int EIGHT = 8;
    private static final int ONE_SIX = 16;
    private static final int TWO_FIVE = 25;
    private static final int TWO_FOUR = 24;
    private static final int TWO_SIX = 26;
    private static final int FIVE_ONE = 51;
    private static final int FIVE_TWO = 52;
    private static final int SIX_ONE = 61;
    private static final int SIX_TWO = 62;
    private static final int SIX_THREE = 63;
    private static final int SIX_FOUR = 64;
    private static final int ONE_TWO_EIGHT = 128;
    private static final int NEGATIVE_ONE_TWO_EIGHT = -128;
    private static final char PAD = '=';
    private static final byte[] BASE_64_ALPHABET = new byte[ONE_TWO_EIGHT];
    private static final char[] LOOK_UP_BASE_64_ALPHABET = new char[SIX_FOUR];

    static {
        for (int i = ZERO; i < ONE_TWO_EIGHT; ++i) {
            BASE_64_ALPHABET[i] = -ONE;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            BASE_64_ALPHABET[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            BASE_64_ALPHABET[i] = (byte) (i - 'a' + TWO_SIX);
        }

        for (int i = '9'; i >= '0'; i--) {
            BASE_64_ALPHABET[i] = (byte) (i - '0' + FIVE_TWO);
        }

        BASE_64_ALPHABET['+'] = SIX_TWO;
        BASE_64_ALPHABET['/'] = SIX_THREE;

        for (int i = ZERO; i <= TWO_FIVE; i++) {
            LOOK_UP_BASE_64_ALPHABET[i] = (char) ('A' + i);
        }

        for (int i = TWO_SIX, j = ZERO; i <= FIVE_ONE; i++, j++) {
            LOOK_UP_BASE_64_ALPHABET[i] = (char) ('a' + j);
        }

        for (int i = FIVE_TWO, j = ZERO; i <= SIX_ONE; i++, j++) {
            LOOK_UP_BASE_64_ALPHABET[i] = (char) ('0' + j);
        }
        LOOK_UP_BASE_64_ALPHABET[SIX_TWO] = '+';
        LOOK_UP_BASE_64_ALPHABET[SIX_THREE] = '/';
    }

    private static boolean isWhiteSpace(char octect) {
        return (octect == 0x20 || octect == 0xd || octect == 0xa || octect == 0x9);
    }

    private static boolean isPad(char octect) {
        return (octect == PAD);
    }

    private static boolean isData(char octect) {
        return (octect < ONE_TWO_EIGHT && BASE_64_ALPHABET[octect] != -ONE);
    }

    /**
     * Encodes hex octects into Base64
     *
     * @param binaryData Array containing binaryData
     * @return Encoded Base64 array
     */
    public static String encode(byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }

        int lengthDataBits = binaryData.length * EIGHT;
        if (lengthDataBits == ZERO) {
            return "";
        }

        int fewerThan24bits = lengthDataBits % TWO_FOUR;
        int numberTriplets = lengthDataBits / TWO_FOUR;
        int numberQuartet = fewerThan24bits != ZERO ? numberTriplets + ONE : numberTriplets;
        char[] encodedData = null;

        encodedData = new char[numberQuartet * FOUR];

        byte k = ZERO;
        byte l = ZERO;
        byte b1 = ZERO;
        byte b2 = ZERO;
        byte b3 = ZERO;

        int encodedIndex = ZERO;
        int dataIndex = ZERO;

        for (int i = ZERO; i < numberTriplets; i++) {
            b1 = binaryData[dataIndex++];
            b2 = binaryData[dataIndex++];
            b3 = binaryData[dataIndex++];

            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & NEGATIVE_ONE_TWO_EIGHT) == ZERO) ? (byte) (b1 >> TWO) : (byte) ((b1) >> TWO ^ 0xc0);
            byte val2 = ((b2 & NEGATIVE_ONE_TWO_EIGHT) == ZERO) ? (byte) (b2 >> FOUR) : (byte) ((b2) >> FOUR ^ 0xf0);
            byte val3 = ((b3 & NEGATIVE_ONE_TWO_EIGHT) == ZERO) ? (byte) (b3 >> SIX) : (byte) ((b3) >> SIX ^ 0xfc);

            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[val1];
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[val2 | (k << FOUR)];
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[(l << TWO) | val3];
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[b3 & 0x3f];
        }

        // form integral number of 6-bit groups
        if (fewerThan24bits == EIGHT) {
            b1 = binaryData[dataIndex];
            k = (byte) (b1 & 0x03);
            byte val1 = ((b1 & NEGATIVE_ONE_TWO_EIGHT) == ZERO) ? (byte) (b1 >> TWO) : (byte) ((b1) >> TWO ^ 0xc0);
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[val1];
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[k << FOUR];
            encodedData[encodedIndex++] = PAD;
            encodedData[encodedIndex++] = PAD;
        } else if (fewerThan24bits == ONE_SIX) {
            b1 = binaryData[dataIndex];
            b2 = binaryData[dataIndex + ONE];
            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & NEGATIVE_ONE_TWO_EIGHT) == ZERO) ? (byte) (b1 >> TWO) : (byte) ((b1) >> TWO ^ 0xc0);
            byte val2 = ((b2 & NEGATIVE_ONE_TWO_EIGHT) == ZERO) ? (byte) (b2 >> FOUR) : (byte) ((b2) >> FOUR ^ 0xf0);

            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[val1];
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[val2 | (k << FOUR)];
            encodedData[encodedIndex++] = LOOK_UP_BASE_64_ALPHABET[l << TWO];
            encodedData[encodedIndex++] = PAD;
        }
        return new String(encodedData);
    }

    /**
     * Decodes Base64 data into octects
     *
     * @param encoded string containing Base64 data
     * @return Array containind decoded data.
     */
    public static byte[] decode(String encoded) {
        if (encoded == null) {
            return null;
        }

        char[] base64Data = encoded.toCharArray();
        // remove white spaces
        int len = removeWhiteSpace(base64Data);

        if (len % FOUR != ZERO) {
            return null;// should be divisible by four
        }

        int numberQuadruple = (len / FOUR);

        if (numberQuadruple == ZERO) {
            return new byte[ZERO];
        }

        byte[] decodedData = null;
        byte b1 = ZERO;
        byte b2 = ZERO;
        byte b3 = ZERO;
        byte b4 = ZERO;
        char d1 = ZERO;
        char d2 = ZERO;
        char d3 = ZERO;
        char d4 = ZERO;

        int i = ZERO;
        int encodedIndex = ZERO;
        int dataIndex = ZERO;
        decodedData = new byte[(numberQuadruple) * THREE];

        for (; i < numberQuadruple - ONE; i++) {

            if (!isData((d1 = base64Data[dataIndex++])) || !isData((d2 = base64Data[dataIndex++]))
                    || !isData((d3 = base64Data[dataIndex++])) || !isData((d4 = base64Data[dataIndex++]))) {
                return null;
            } // if found "no data" just return null

            b1 = BASE_64_ALPHABET[d1];
            b2 = BASE_64_ALPHABET[d2];
            b3 = BASE_64_ALPHABET[d3];
            b4 = BASE_64_ALPHABET[d4];

            decodedData[encodedIndex++] = (byte) (b1 << TWO | b2 >> FOUR);
            decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << FOUR) | ((b3 >> TWO) & 0xf));
            decodedData[encodedIndex++] = (byte) (b3 << SIX | b4);
        }

        if (!isData((d1 = base64Data[dataIndex++])) || !isData((d2 = base64Data[dataIndex++]))) {
            return null;// if found "no data" just return null
        }

        b1 = BASE_64_ALPHABET[d1];
        b2 = BASE_64_ALPHABET[d2];

        d3 = base64Data[dataIndex++];
        d4 = base64Data[dataIndex++];
        if (!isData((d3)) || !isData((d4))) {// Check if they are PAD characters
            if (isPad(d3) && isPad(d4)) {
                if ((b2 & 0xf) != ZERO)// last FOURBYTE bits should be zero
                {
                    return null;
                }
                byte[] tmp = new byte[i * THREE + ONE];
                System.arraycopy(decodedData, ZERO, tmp, ZERO, i * THREE);
                tmp[encodedIndex] = (byte) (b1 << TWO | b2 >> FOUR);
                return tmp;
            } else if (!isPad(d3) && isPad(d4)) {
                b3 = BASE_64_ALPHABET[d3];
                if ((b3 & 0x3) != ZERO)// last TWO bits should be zero
                {
                    return null;
                }
                byte[] tmp = new byte[i * THREE + TWO];
                System.arraycopy(decodedData, ZERO, tmp, ZERO, i * THREE);
                tmp[encodedIndex++] = (byte) (b1 << TWO | b2 >> FOUR);
                tmp[encodedIndex] = (byte) (((b2 & 0xf) << FOUR) | ((b3 >> TWO) & 0xf));
                return tmp;
            } else {
                return null;
            }
        } else { // No PAD e.g 3cQl
            b3 = BASE_64_ALPHABET[d3];
            b4 = BASE_64_ALPHABET[d4];
            decodedData[encodedIndex++] = (byte) (b1 << TWO | b2 >> FOUR);
            decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << FOUR) | ((b3 >> TWO) & 0xf));
            decodedData[encodedIndex++] = (byte) (b3 << SIX | b4);

        }
        return decodedData;
    }

    /**
     * remove WhiteSpace from MIME containing encoded Base64 data.
     *
     * @param data the byte array of base64 data (with WS)
     * @return the new length
     */
    private static int removeWhiteSpace(char[] data) {
        if (data == null) {
            return ZERO;
        }

        // count characters that's not whitespace
        int newSize = ZERO;
        int len = data.length;
        for (int i = ZERO; i < len; i++) {
            if (!isWhiteSpace(data[i])) {
                data[newSize++] = data[i];
            }
        }
        return newSize;
    }
}
