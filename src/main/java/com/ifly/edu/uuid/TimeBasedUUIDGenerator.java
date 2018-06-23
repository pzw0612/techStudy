package com.ifly.edu.uuid;

import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

class TimeBasedUUIDGenerator implements UUIDGenerator {
    private final AtomicInteger sequenceNumber;
    private long lastTimestamp;
    private static final byte[] SECURE_MUNGED_ADDRESS = MacAddressProvider.getSecureMungedAddress();

    TimeBasedUUIDGenerator() {
        this.sequenceNumber = new AtomicInteger(SecureRandomHolder.INSTANCE.nextInt());
    }

    private static void putLong(byte[] array, long l, int pos, int numberOfLongBytes) {
        for(int i = 0; i < numberOfLongBytes; ++i) {
            array[pos + numberOfLongBytes - i - 1] = (byte)((int)(l >>> i * 8));
        }

    }

    public String getBase64UUID() {
        int sequenceId = this.sequenceNumber.incrementAndGet() & 16777215;
        long timestamp = System.currentTimeMillis();
        synchronized(this) {
            timestamp = Math.max(this.lastTimestamp, timestamp);
            if (sequenceId == 0) {
                ++timestamp;
            }

            this.lastTimestamp = timestamp;
        }

        byte[] uuidBytes = new byte[15];
        putLong(uuidBytes, timestamp, 0, 6);
        System.arraycopy(SECURE_MUNGED_ADDRESS, 0, uuidBytes, 6, SECURE_MUNGED_ADDRESS.length);
        putLong(uuidBytes, (long)sequenceId, 12, 3);

        assert 9 + SECURE_MUNGED_ADDRESS.length == uuidBytes.length;

        return Base64.getUrlEncoder().withoutPadding().encodeToString(uuidBytes);
    }

    static {
        assert SECURE_MUNGED_ADDRESS.length == 6;

    }
}
