package com.ai5suoai.commons;

/**
 * @author chenzhenjia
 * @since 16/7/2
 */
public class Constants {

    public static class Bytes {
        public static final Long BYTE = 1L;
        /**
         * 千字节,其实就是 kb
         */
        public static final Long KILO_BYTE = BYTE * 1024;
        /**
         * 兆字节,其实就是 MB
         */
        public static final Long MEGA_BYTE = KILO_BYTE * 1024;
        /**
         * 吉字节或十亿字节,其实就是 GB
         */
        public static final Long GIGA_BYTE = MEGA_BYTE * 1024;
        /**
         * 太字节,其实就是 TB
         */
        public static final Long TERA_BYTE = GIGA_BYTE * 1024;
        /**
         * 拍字节或拍它字节,其实就是 PB
         */
        public static final Long PETA_BYTE = TERA_BYTE * 1024;
    }

}
