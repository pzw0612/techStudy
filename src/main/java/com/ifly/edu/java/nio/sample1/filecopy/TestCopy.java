package com.ifly.edu.java.nio.sample1.filecopy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCopy {

    public static void main(String[] args) throws IOException, InterruptedException {
//        File f2 = new File(TestCopy.class.getResourceAsStream("fileConfig.properties"));
//        File f = new File(TestCopy.class.getClassLoader().getSystemResource("fileConfig.properties").getFile());
//        FileInputStream fIn = new FileInputStream(f);
        
        InputStream fIn = TestCopy.class.getResourceAsStream("fileConfig.properties");
        byte[] buffer = new byte[8192];
        fIn.read(buffer);

        String s = new String(buffer);

        String items[] = s.trim().split("\n");
        List<CommonCopy> fileCopys = new ArrayList<CommonCopy>();
        long start = System.currentTimeMillis();
        for (String item : items) {
            String fromTo[] = item.split(",");
//             CommonCopy fileCopy = new StreamFileCopy(fromTo[0].trim(), fromTo[1].trim());//time used:46551
//             CommonCopy fileCopy = new StreamFileCopyWithBuffer(fromTo[0].trim(), fromTo[1].trim());// time used:43537
//            CommonCopy fileCopy = new NIOFileCopy(fromTo[0].trim(), fromTo[1].trim());//time used:35536
             CommonCopy fileCopy = new MappedFileCopy(fromTo[0].trim(), fromTo[1].trim());//time used:46551

            fileCopys.add(fileCopy);
            Thread copy1 = new Thread(fileCopy);
            copy1.start();
            System.out.println(item);
        }

        while (true) {
            if (fileCopys.isEmpty()) {
                break;
            }
            Iterator<CommonCopy> it = fileCopys.iterator();
            while (it.hasNext()) {
                if (it.next().flag) {
                    it.remove();
                }
            }
            Thread.sleep(500);
        }
        long end = System.currentTimeMillis();
        System.out.println("time used:" + (end - start));

    }
}
