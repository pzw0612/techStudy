package com.ifly.edu.uuid;

import com.fasterxml.uuid.*;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.apache.commons.codec.binary.Hex;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.zip.CRC32;

public class UUIDTest {
    public static void main(String[] args) {
        UUID uuid = Generators.randomBasedGenerator().generate();
        System.out.println("uuid = [" + uuid + "]");
        UUID uuid2 = Generators.timeBasedGenerator().generate();
        System.out.println("uuid2 = [" + uuid2 + "]");

        TimeBasedGenerator gen = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        UUID uuid3 = gen.generate();
        System.out.println("uuid3 = [" + uuid3 + "]");
        UUID anotherUuid = gen.generate();
        System.out.println("anotherUuid = [" + anotherUuid + "]");


        CRC32 crc32 = new CRC32();
        crc32.update("anotherUuid".getBytes());
        System.out.println(crc32.getValue());
        System.out.println(Math.abs(crc64.crc64Long(gen.generate().toString())));
        System.out.println(Math.abs(crc64.crc64Long(gen.generate().toString())));

        //System.out.println("new TimeBasedUUIDGenerator().getBase64UUID() = " + new TimeBasedUUIDGenerator().getBase64UUID());


    }
}
