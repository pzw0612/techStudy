package com.ifly.edu.mysql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataGenerator {

    static Random rnd = new Random();

    public static void main(String[] args) {

        StringBuilder sb = null;
        long seq = 1004294968215l;
        boolean isStart =true;
        FileWriter fileWriter =null;

        String fileName="hft_deposit.sql";
        try {
            File file = new File(fileName);
            if(file.exists()){
                file.delete();
            }
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fileWriter==null) return;
        List<String> assets = new ArrayList<>();
        assets.add("ETH"  );
        assets.add("ETP"   );
        assets.add("STORJ");
        assets.add("ETC");
        assets.add("DLT"  );
        assets.add("BTM"  );
        assets.add("ICO"  );
        assets.add("XNC"  );
        assets.add("SNT"  );
        assets.add("BCC"  );
        assets.add("ZEC"  );
        assets.add("LTC"  );
        assets.add("CMC"  );
        assets.add("ZDC"  );
        assets.add("ZGC"  );
        assets.add("BTC"  );
        assets.add("MVC"  );
        assets.add("BTS"  );
        assets.add("OBITS"  );
        assets.add("GXS" );
        assets.add("XRB"  );
        assets.add("NXS"  );
        assets.add("BITCNY" );
        assets.add("BCY"  );
        assets.add("MTX"  );
        assets.add("ECH"  );
        assets.add("AMB"  );
        assets.add("TRX"  );
        assets.add("UFR"  );
        assets.add("DROPS"  );
        assets.add("CL"    );
        assets.add("JRC"   );
        assets.add("XZC"   );
        assets.add("ATN"   );
        assets.add("EOS"   );
        assets.add("IIC"   );
        assets.add("EBST"   );

        List<String> addresses = new ArrayList<>();
        addresses.add("0x00d417b710427d024bac47a544dcf2ff5b82507d");
        addresses.add("0x013019352ca0f9cbb8d05e06b5a889084ea34f5b");
        addresses.add("0x01539f18dc9abb71ab6d541ea43f13e2ca17aaa2");
        addresses.add("0x0154def7d598189d4018167ca0637e885c637f43");
        addresses.add("0x01768d468ea2e60ad035069204bc5b9307a71397");
        addresses.add("0x017f0a009a65049c24537c40e2427f746a59687a");
        addresses.add("0x018ac5c0aab76b03892cab126e3ebd95e6a8628e");
        addresses.add("0x01ed76ed477ba80dc3fc2cf67bad339ecd55b5eb");
        addresses.add("0x0211e9cc7b12497836dadea9383f69cf3881c40b");
        addresses.add("0x03c7d4e92da0bacbd2395d9f754b9cbdd31bf46b");
        addresses.add("0x03ed9e8ca825f8d596f7e04e1e54ff42152a99df");
        addresses.add("0x0403949f6625ed1ba42548e2faea83143cb3707c");
        addresses.add("0x0479357f2230e7022da9525e782bb83ad8da9b9b");
        addresses.add("0x0589e17608a99dc1b11002101da0f9fff21ed508");
        addresses.add("0x05d64fe798c6d0122c66c18251cb563c2da65c7d");
        addresses.add("0x05f69efbd376391f7f0492027d7d8e32a8a46bea");
        addresses.add("0x068393e5baaacfca185c0937fc77f798b78bf505");
        addresses.add("0x07d46bd835ef06d610448c70da21472b9843bb85");
        addresses.add("0x085d6eb5a052c59268c5a517152b4ff0d6e91307");
        addresses.add("0x0910928acf95579f285305b22cf92f0bbf168cfd");
        addresses.add("0x091b43f61428c6f108a26f23b86bf7b717927e14");
        addresses.add("0x094941ae36e4c95989176e9785ce948ceab5445f");
        addresses.add("0x0c5372d985e018a368bcce78b907b231a47e9cab");
        addresses.add("0x0d1e9498ee19f9dc50429c15ad196b3053b7b994");
        addresses.add("0x0d3ba5e86e60d5bc3d5466da3463032f4574d2d0");
        addresses.add("0x0f25b03f1c4d7dac6d54c63104e68c5955b801e0");
        addresses.add("0x0f2e9c945846b8b652cdfda07862e76101a607d8");
        addresses.add("0x1460e1b737881c3be6aff00beb232cca826a0fed");

        List<Integer> amount = new ArrayList<>();
        amount.add(new Integer(1));
        amount.add(new Integer(2));
        amount.add(new Integer(3));
        amount.add(new Integer(4));


        List<String> statuses = new ArrayList<>();
        statuses.add("COMPLETE");


        List<String> hashs = new ArrayList<>();
        hashs.add("8400b833532900c5daab2d8f3b13a71752704b884fd3adbf79f25e0656007367");
        hashs.add("1ad518a74106e6501e40b23af75a57140a0bbbff5b2e647bbee8368f9b4a8b03");
        hashs.add("0x37a5b3e8d1ffa3baa1fb8267a4a3f5e11cef07a284ac365e535d3ff1da75d653");
        hashs.add("0xa39f6de7208217e71fdc8e2ce4c5d32468b842c264520f4215f70e46d7d7861d");
        hashs.add("0x15ef956a384efb83779d7b94df517278e8c3f435933598c712f266f0db6c2c75");
        hashs.add("0x2d58eddb51f5312bb8960394a3e267cfa6bdc2246f35d6894d513ef73c4396f8");
        hashs.add("0xd9b2b90459cfcd3c58d9edeeb7012bc255060aa87241da088f833c251f068240");
        hashs.add("0x79a9badd68b897b66ed00e7664e68357aa053d1089801c5bf51e768d05447acd");
        hashs.add("0x2f55db681bdac66385d76fc8d29ac25ff24f7d225403a1203fcbd46acbfba34b");
        hashs.add("0x9802a44d94f16091249bfe0b631ec0eccf0a5293482b115c99c8833f42935cf9");
        hashs.add("0x754bb6727f9caac2913c714d24bd61b929df8a316b15a2cbc370e6dca03e7d20");
        hashs.add("0x7422fd8343e1babfc9001d74a3fd863de86e11b6406741451d2714a62cb72e43");
        hashs.add("a79ab72483420edf689ef2483a84df7deec19ac9bf8a6aa74b29e96ccdefe436");
        hashs.add("628670d2df7ad2b2d7d9df6812358e77cc2eeb2af5c2a07a96618e6690ad3446");
        hashs.add("a945ed0630875ccec4d6528ca3ab5206aee8cad09ebce83f49d3393b3951c3a6");
        hashs.add("0fa2d16a8563b119419243c02b70bd05dd2eee2acef982df3e5305ef00a06a4d");
        hashs.add("bcad52d0cbfa2edd7bfd77b699a3774aede72b32ce1f9b4b954263a10b87b404");
        hashs.add("99fe82c75ab672b4974d734dd211a6909ab3e21f8418b01e3ae6514c3163aa7e");
        hashs.add("70f975ef7104e33f003386bb4333c2c26c88ea38");
        hashs.add("0x694817f9d0a4447738ab0b9e4546af41662550feed4e234c560dd94f5f83df7c");


        try {
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write("insert into hft_deposit(id, asset,address,amount,status,created_at,hash,access_height,current_height,create_height) values");

            StringBuilder stringBuilder = null;
            for (int i=0; i< 50; i++) {
                try {
                        bw.newLine();
                        seq++;
                        if(isStart){
                            stringBuilder= new StringBuilder("('").append(seq).append("',");
                            isStart=false;
                        }else{
                            stringBuilder= new StringBuilder(",('").append(seq).append("',");
                        }
                        stringBuilder= stringBuilder.append("'").append(assets.get(rnd.nextInt(assets.size()))).append("',");
                        stringBuilder= stringBuilder.append("'").append(addresses.get(rnd.nextInt(addresses.size()))).append("',");
                        stringBuilder= stringBuilder.append("'").append(amount.get(rnd.nextInt(amount.size()))).append("',");
                        stringBuilder= stringBuilder.append("'").append("COMPLETE").append("',");
                        stringBuilder= stringBuilder.append("'").append(dateParese(new Date())).append("',");
                        stringBuilder= stringBuilder.append("'").append(hashs.get(rnd.nextInt(hashs.size()))).append("',");
                        stringBuilder= stringBuilder.append("'").append(787237).append("',");
                        stringBuilder= stringBuilder.append("'").append(787237).append("',");
                        stringBuilder= stringBuilder.append("'").append(787224).append("')");
                        bw.write(stringBuilder.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            bw.write(";");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static  String dateParese(Date date){

        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR,2);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone cstTime = TimeZone.getTimeZone("UTC");
        sdf2.setTimeZone(cstTime);
        try {
            return sdf2.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
