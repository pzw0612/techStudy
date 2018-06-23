/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ifly.edu.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class KafkaSampleProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSampleProducer.class);
    @SuppressWarnings("static-access")
    private static final Option OPTION_TOPIC = OptionBuilder.withArgName("topic").hasArg().isRequired(true).withDescription("Kafka topic").create("topic");
    private static final Option OPTION_BROKER = OptionBuilder.withArgName("broker").hasArg().isRequired(true).withDescription("Kafka broker").create("broker");
    private static final Option OPTION_INTERVAL = OptionBuilder.withArgName("interval").hasArg().isRequired(false).withDescription("Simulated message interval in mili-seconds, default 1000").create("interval");

    private static final ObjectMapper mapper = new ObjectMapper();
    {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) throws Exception {
        logger.info("args: " + Arrays.toString(args));
        OptionsHelper optionsHelper = new OptionsHelper();
        Options options = new Options();
        String topic, broker;
        options.addOption(OPTION_TOPIC);
        options.addOption(OPTION_BROKER);
        options.addOption(OPTION_INTERVAL);
        optionsHelper.parseOptions(options, args);

        logger.info("options: '" + optionsHelper.getOptionsAsString() + "'");

        topic = optionsHelper.getOptionValue(OPTION_TOPIC);
        broker = optionsHelper.getOptionValue(OPTION_BROKER);

        //broker="master:9092,slave1:9092,slave2:9092";
        long interval = 100;
        String intervalString = optionsHelper.getOptionValue(OPTION_INTERVAL);
        if (intervalString != null) {
            interval = Long.parseLong(intervalString);
        }

        List<Integer> ids = new ArrayList();
        ids.add(new Integer(41070));
        ids.add(new Integer(41071));
        ids.add(new Integer(41072));
        ids.add(new Integer(41073));
        ids.add(new Integer(41074));
        ids.add(new Integer(41076));
        ids.add(new Integer(41077));
        ids.add(new Integer(41078));
        ids.add(new Integer(41079));
        ids.add(new Integer(41080));
        ids.add(new Integer(41081));
        ids.add(new Integer(41082));
        ids.add(new Integer(41083));
        ids.add(new Integer(41084));
        ids.add(new Integer(41085));
        ids.add(new Integer(41086));
        ids.add(new Integer(41087));
        ids.add(new Integer(41088));
        ids.add(new Integer(41089));
        ids.add(new Integer(41090));
        ids.add(new Integer(41091));
        ids.add(new Integer(41092));
        ids.add(new Integer(41093));
        ids.add(new Integer(41094));
        ids.add(new Integer(41095));
        ids.add(new Integer(41096));
        ids.add(new Integer(41097));
        ids.add(new Integer(41098));

        List<String> addreses = new ArrayList();
        addreses.add("eHqGVCBjQYYb94hmKPvDKwnJcCvm8iMkWm");
        addreses.add("eBFkZCkq35TcmLmtqovofX5mpSiMc7rFPe");
        addreses.add("eBFkZCkq35TcmLmtqovofX5mpSiMc7rFPe");
        addreses.add("eBFkZCkq35TcmLmtqovofX5mpSiMc7rFPe2");
        addreses.add("eBFkZCkq35TcmLmtqovofX5mpSiMc7rFPe3");
        addreses.add("eBFkZCkq35TcmLmtqovofX5mpSiMc7rFPe4");

        List<BigDecimal> amounts = new ArrayList();
        amounts.add(new BigDecimal(39.995000000000000000));
        amounts.add(new BigDecimal(10.000000000000000000));
        amounts.add(new BigDecimal(1.000000000000000000));

        List<String> txhashs = new ArrayList();
        txhashs.add("777cacbfc67803f95adbe67110165813193cb7473cec64bb0b195c8bf37ab663");
        txhashs.add("82f32b342dc7860afd96b101fe60422427fc2f7218defd72935c7d1622ffa248");
        txhashs.add("1c56b52dccd7d6af88a7b7e7aadcf4d7048719ad0578af1ce460ac4e3d43ecc8");
        txhashs.add("7a4b1c637b026a512a39fa7034beec7ba8e1cf2f507b5b1cbf45a9faa06ea8d7");
        txhashs.add("edd2db5f9bf7ad2d327e07dc35a0a451d5953f86bd6be9a0e4ee1ef093551cf5");
        txhashs.add("4fef30f8b0011441092d904341685e9676a0ab88f08a140186bdefebc5ce8ac2");
        txhashs.add("30acd88ed22523f65a883155857a0aca5da24875d29b44d5c5f032546cb80680");
        txhashs.add("8eb98afe36a7ed7c93444b06cb6df65268740bded8bc76d2aca08c6a5790e224");
        txhashs.add("a6a30f2c24f3830a11974c3b1e31894007751cc9d064a0e9438135f9f3be1188");
        txhashs.add("486edfcaf17da1b905fc6a17f2cb453622c6773bf81f45865b4870dba3125b14");
        txhashs.add("1d5f9544b085425f783f7f088cd4f9ffb98fd9d0ec7f39e8593d1b3e4f2bec90");
        txhashs.add("300a787542708c774432a23940cf3744d2aaba69313bbee502ba06a964f56a21");
        txhashs.add("1795a4f3689e1ebeb1ca5519417ee68505ff01ffc711fe655d0f10dad8fe5b79");
        txhashs.add("ed21e4ed31a210ba153d481ee73f7541fbe1e58fd4bb1888ea0086e604f6f9cf");
        txhashs.add("91d04f1cafbf34dcf1f48dd2f65970f6943d3007e4e21635afdb223f798e9bbf");
        txhashs.add("592f562b6e63505e5793cebad6a905c05b04c3436c7b5c925e4d2706a85128d6");
        txhashs.add("61ddd3b39164f6e5d44b9e9bf4a0d4242a415aa83bef031f9e15bbae7f9462b1");
        txhashs.add("51cf423d552d90c65424bc62ce97070719e1b9272d1d4f0699f4a4b6e71e7225");
        txhashs.add("36ef744c9607b9e3a0d47815fb9bbee7125e5a5e5772d54ec49ca9cf401917ea");

        List<Integer> txindexs = new ArrayList();
        txindexs.add(new Integer("0"));
        txindexs.add(new Integer("1"));

        List<Integer> outputindexs = new ArrayList();
        outputindexs.add(new Integer("1"));
        outputindexs.add(new Integer("2"));
        outputindexs.add(new Integer("3"));
        outputindexs.add(new Integer("4"));
        outputindexs.add(new Integer("5"));
        outputindexs.add(new Integer("6"));
        outputindexs.add(new Integer("7"));
        outputindexs.add(new Integer("8"));
        outputindexs.add(new Integer("9"));

        List<Integer> blockheights = new ArrayList();
        blockheights.add(new Integer(770523));
        blockheights.add(new Integer(772116));
        blockheights.add(new Integer(772219));
        blockheights.add(new Integer(772236));
        blockheights.add(new Integer(772243));
        blockheights.add(new Integer(772254));
        blockheights.add(new Integer(772262));
        blockheights.add(new Integer(772269));
        blockheights.add(new Integer(772273));
        blockheights.add(new Integer(772285));
        blockheights.add(new Integer(772289));
        blockheights.add(new Integer(772290));
        blockheights.add(new Integer(772296));
        blockheights.add(new Integer(772303));
        blockheights.add(new Integer(772305));
        blockheights.add(new Integer(772311));
        blockheights.add(new Integer(772314));
        blockheights.add(new Integer(772315));
        blockheights.add(new Integer(772317));

        List<BigDecimal> txtimes = new ArrayList();
        txtimes.add(new BigDecimal(1));
        txtimes.add(new BigDecimal(0));
        txtimes.add(new BigDecimal(2));
        txtimes.add(new BigDecimal(3));


        List<String> assets = new ArrayList();
        assets.add("EBST");
        assets.add("AAAA");
        assets.add("BBBB");
        assets.add("CCCC");
        assets.add("DDDD");
        assets.add("EEEE");
        assets.add("FFFF");

        List<Integer> statuss = new ArrayList();
        statuss.add(new Integer("1"));
        statuss.add(new Integer("2"));
        statuss.add(new Integer("3"));
        statuss.add(new Integer("4"));
        statuss.add(new Integer("5"));

        List<String> ordernums = new ArrayList();
        ordernums.add("0000000000000000000000000000015266251932930448080026000000000000");
        ordernums.add("0000000000000000000000000000015266251968610448080026000000000001");
        ordernums.add("0000000000000000000000000000015270546950130161680024000000012123");
        ordernums.add("0000000000000000000000000000015270547000340161680024000000012124");
        ordernums.add("0000000000000000000000000000015270547050300161680024000000012125");
        ordernums.add("0000000000000000000000000000015270547100330161680024000000012126");
        ordernums.add("0000000000000000000000000000015270547150360161680024000000012127");
        ordernums.add("0000000000000000000000000000015270547200450161680024000000012128");
        ordernums.add("0000000000000000000000000000015270547250380161680024000000012129");
        ordernums.add("0000000000000000000000000000015270547300430161680024000000012130");
        ordernums.add("0000000000000000000000000000015270547350390161680024000000012131");
        ordernums.add("0000000000000000000000000000015270547400420161680024000000012132");
        ordernums.add("0000000000000000000000000000015270547450450161680024000000012133");
        ordernums.add("0000000000000000000000000000015270547500450161680024000000012134");
        ordernums.add("0000000000000000000000000000015270547550430161680024000000012135");
        ordernums.add("0000000000000000000000000000015270547600440161680024000000012136");
        ordernums.add("0000000000000000000000000000015270547650440161680024000000012137");
        ordernums.add("0000000000000000000000000000015270547700500161680024000000012138");
        ordernums.add("0000000000000000000000000000015270547750480161680024000000012139");
        ordernums.add("0000000000000000000000000000015270547800530161680024000000012140");
        ordernums.add("0000000000000000000000000000015270547850400161680024000000012141");
        ordernums.add("0000000000000000000000000000015270547900400161680024000000012142");
        ordernums.add("0000000000000000000000000000015270547950380161680024000000012143");
        ordernums.add("0000000000000000000000000000015270548000500161680024000000012144");
        ordernums.add("0000000000000000000000000000015270548050530161680024000000012145");
        ordernums.add("0000000000000000000000000000015270548100590161680024000000012146");
        ordernums.add("0000000000000000000000000000015270548150540161680024000000012147");
        ordernums.add("0000000000000000000000000000015270548200530161680024000000012148");
        ordernums.add("0000000000000000000000000000015270548250630161680024000000012149");
        ordernums.add("0000000000000000000000000000015270548300560161680024000000012150");
        ordernums.add("0000000000000000000000000000015270548350570161680024000000012151");
        ordernums.add("0000000000000000000000000000015270548400570161680024000000012152");
        ordernums.add("0000000000000000000000000000015270548450590161680024000000012153");
        ordernums.add("0000000000000000000000000000015270548500610161680024000000012154");
        ordernums.add("0000000000000000000000000000015270548550380161680024000000012155");
        ordernums.add("0000000000000000000000000000015270548600520161680024000000012156");
        ordernums.add("0000000000000000000000000000015270548650370161680024000000012157");
        ordernums.add("0000000000000000000000000000015270548700360161680024000000012158");
        ordernums.add("0000000000000000000000000000015270548750520161680024000000012159");
        ordernums.add("0000000000000000000000000000015270548800560161680024000000012160");
        ordernums.add("0000000000000000000000000000015270548850520161680024000000012161");
        ordernums.add("0000000000000000000000000000015270548900520161680024000000012162");
        ordernums.add("0000000000000000000000000000015270548950550161680024000000012163");
        ordernums.add("0000000000000000000000000000015270549000560161680024000000012164");
        ordernums.add("0000000000000000000000000000015270549050600161680024000000012165");
        ordernums.add("0000000000000000000000000000015270549100550161680024000000012166");
        ordernums.add("0000000000000000000000000000015270549150590161680024000000012167");
        ordernums.add("0000000000000000000000000000015270549200570161680024000000012168");
        ordernums.add("0000000000000000000000000000015270549250590161680024000000012169");
        ordernums.add("0000000000000000000000000000015270549300340161680024000000012170");

        Properties props = new Properties();
        props.put("bootstrap.servers", broker);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        boolean alive = true;
        Random rnd = new Random();
        t_deposit_hive deposit = null;

        int iden=0;
        while (alive == true) {
            //add normal record
            deposit = new t_deposit_hive();
            deposit.setIden(new Long(iden++));
            deposit.setAddress(addreses.get(rnd.nextInt(addreses.size())));
            deposit.setAmount(amounts.get(rnd.nextInt(amounts.size())));
            deposit.setTx_hash(txhashs.get(rnd.nextInt(txhashs.size())));
            deposit.setTx_index(txindexs.get(rnd.nextInt(txindexs.size())));
            deposit.setOutput_index(outputindexs.get(rnd.nextInt(outputindexs.size())));
            deposit.setBlock_height(blockheights.get(rnd.nextInt(blockheights.size())));
            deposit.setTx_time(txtimes.get(rnd.nextInt(txtimes.size())));
            deposit.setAsset(assets.get(rnd.nextInt(assets.size())));
            deposit.setStatus(statuss.get(rnd.nextInt(statuss.size())));
            deposit.setOrdernum(ordernums.get(rnd.nextInt(ordernums.size())));
            deposit.setCreate_time(getUTCTimeStr(new Date()));
            //send message
            ProducerRecord<String, String> data = new ProducerRecord<>(topic, System.currentTimeMillis() + "", mapper.writeValueAsString(deposit));
            System.out.println("Sending 1 message: " + deposit.toString());
            producer.send(data);
            Thread.sleep(interval);


//            if(iden==100){
//                alive=false;
//            }
        }
        producer.close();
    }

    public static Date getUTCTimeStr(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(date);

        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int ms = cal.get(Calendar.MILLISECOND);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute).append(":").append(second).append(".").append(ms) ;
        try{
            return format.parse(UTCTimeBuffer.toString()) ;
            //return UTCTimeBuffer.toString() ;
        }catch(ParseException e)
        {
            e.printStackTrace() ;
        }
        return null ;
    }

}
