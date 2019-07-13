package com.example.myproject;

import com.alibaba.fastjson.JSONObject;
import com.example.myproject.entity.DataDictionaryModel;
import com.example.myproject.entity.DataDictionaryPO;
import com.example.myproject.utils.BeanUtil;
import io.lettuce.core.output.KeyStreamingChannel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class FunctionTest {

    @Test
    public void test(){



        Function<String, Integer> function1 = x -> Integer.valueOf(x);
        Integer apply = function1.apply("4");
//        System.out.println(apply);plusMillis(TimeUnit.HOURS.toMillis(8));
        Instant instant = Instant.parse("2017-03-03T10:37:30.00Z");
        System.out.println(instant.getLong(ChronoField.NANO_OF_SECOND));
        System.out.println(apply);

    }

    @Test
    public void convertBeanTest(){
        List<DataDictionaryModel> model=new ArrayList<>();

        for (int i=0;i<10000;i++){
            DataDictionaryModel model1 = DataDictionaryModel.builder()
                    .dataCode("cord" + i)
                    .dataSubType("cubtype" + i)
                    .remark("beizhu" + i)
                    .build();
            model.add(model1);
        }
        Instant now = Instant.now();
        List<DataDictionaryPO> dataDictionaryPOS = BeanUtil.convertBean(model, DataDictionaryPO.class);
        log.info("convertBean-  {} ms",Duration.between(now,Instant.now()).toMillis());
        //1082  1312 1459 1137 ms stream 1144 1105 1345
        //1085 1043 922  1108 parallelStream
        //1003 997 984  994 parallel
        //1061 946 890  1016 convertBean
//        Instant now1 = Instant.now();
//        List<DataDictionaryPO> dataDictionaryPO = BeanUtil.convertBeanV2(model, DataDictionaryPO.class);
//        log.info("convertBeanv2-  {} ms",Duration.between(Instant.now(),now1).toMillis());
//        System.out.println(model);
    }

    @Test
    public void arraTest(){
//        CollectionUtils.isNotEmpty()
        String s="{\"msg\":null,\"result\":{\"totalSize\":9,\"pageSize\":1000,\"rows\":[{\"dicId\":11500,\"dicKey\":\"status1\",\"systemId\":null,\"dicName\":\"草稿\",\"dicValue\":\"0\",\"descript\":\"\",\"parentId\":11499,\"sn\":1,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560156937000,\"updateBy\":\"01382250\",\"updateTm\":1560156937000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11501,\"dicKey\":\"status2\",\"systemId\":null,\"dicName\":\"部门审批中\",\"dicValue\":\"1\",\"descript\":\"\",\"parentId\":11499,\"sn\":2,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560156963000,\"updateBy\":\"01382250\",\"updateTm\":1560156963000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11502,\"dicKey\":\"status3\",\"systemId\":null,\"dicName\":\"法务审核中\",\"dicValue\":\"2\",\"descript\":\"\",\"parentId\":11499,\"sn\":3,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560156985000,\"updateBy\":\"01382250\",\"updateTm\":1560156985000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11503,\"dicKey\":\"status4\",\"systemId\":null,\"dicName\":\"待安排查新\",\"dicValue\":\"3\",\"descript\":\"\",\"parentId\":11499,\"sn\":4,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560157028000,\"updateBy\":\"01382250\",\"updateTm\":1560157028000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11504,\"dicKey\":\"status5\",\"systemId\":null,\"dicName\":\"已安排查新\",\"dicValue\":\"4\",\"descript\":\"\",\"parentId\":11499,\"sn\":5,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560157050000,\"updateBy\":\"01382250\",\"updateTm\":1560157050000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11505,\"dicKey\":\"status6\",\"systemId\":null,\"dicName\":\"已完成查新\",\"dicValue\":\"5\",\"descript\":\"\",\"parentId\":11499,\"sn\":6,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560157070000,\"updateBy\":\"01382250\",\"updateTm\":1560157070000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11506,\"dicKey\":\"status7\",\"systemId\":null,\"dicName\":\"已安排撰写\",\"dicValue\":\"6\",\"descript\":\"\",\"parentId\":11499,\"sn\":7,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560157087000,\"updateBy\":\"01382250\",\"updateTm\":1560157087000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11507,\"dicKey\":\"status8\",\"systemId\":null,\"dicName\":\"已完成撰写\",\"dicValue\":\"7\",\"descript\":\"\",\"parentId\":11499,\"sn\":8,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560157106000,\"updateBy\":\"01382250\",\"updateTm\":1560157106000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0},{\"dicId\":11546,\"dicKey\":\"status10\",\"systemId\":null,\"dicName\":\"已驳回\",\"dicValue\":\"12\",\"descript\":\"\",\"parentId\":11499,\"sn\":12,\"pkeyPath\":\"proposalStatus\",\"status\":1,\"createBy\":\"01382250\",\"createTm\":1560166853000,\"updateBy\":\"01382250\",\"updateTm\":1560166853000,\"parent\":null,\"currentPage\":null,\"pageSize\":null,\"child\":null,\"hasChild\":0}],\"currentPage\":1,\"empty\":false},\"succ\":\"ok\"}";
        Map map = JSONObject.parseObject(s, Map.class);
        if(map.get("result")!=null){
            Map result = (Map)map.get("result");
            if(result.get("rows")!=null){
                List<Map> rows = (List<Map>)result.get("rows");
                for (Map row : rows) {
                    System.out.println(row.get("dicId"));
                }
            }
        }
    }

    @Test
    public void lqbzTest(){
        List<Double> collect = IntStream.range(0, 3).mapToDouble(value -> 1).boxed().collect(toList());
        System.out.println(collect);
    }

    public static  <T> List<T> parallelStreamlistFilter(List<T> list, Predicate<T> predicate) {
        return list.parallelStream()
                .filter(predicate)
                .collect(toList());
    }

    public static  <T> List<T> streamparallellistFilter(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .parallel()
                .filter(predicate)
                .collect(toList());
    }

    public static  <T> List<T> streamlistFilter(List<T> list, Predicate<T> predicate) {
        return list.stream() //并行处理
                .filter(predicate)
                .collect(toList());
    }

    @Test
    public void filterTest(){
        List<DataDictionaryModel> model=new ArrayList<>();

        for (int i=0;i<10;i++){
            String rem="remark";
            if (i%5==0)
                rem="rr";
            DataDictionaryModel model1 = DataDictionaryModel.builder()
                    .dataCode("cord" + i)
                    .dataSubType("cubtype" + i)
                    .remark(rem)
                    .build();
            model.add(model1);
        }
        model.sort(Comparator.comparing(DataDictionaryModel::getDataCode).reversed());
        Instant now = Instant.now();
        log.info("convertBean-  {} ms",Duration.between(now,Instant.now()).toMillis());
        System.out.println(model);

    }

    @Test
    public void filterTest2(){
        List<String> collect2 = IntStream.range(0, 1_000_000_0).filter(p -> p % 2 == 0).mapToObj(String::valueOf).collect(toList());
        Instant now2 = Instant.now();
        streamlistFilter(collect2, x->x.contains("2"));
        long l2 = Duration.between(now2, Instant.now()).toMillis();
        //streamlistFilter 383 ms 216
        log.info("streamlistFilter {} ms",l2);

    }

    @Test
    public void filterTest2222(){

        List<String> collect1 = IntStream.range(0, 4).filter(p -> p % 2 == 0).mapToObj(String::valueOf).collect(toList());
        Instant now1 = Instant.now();
        collect1.sort(String::compareToIgnoreCase);

        System.out.println(collect1);
        Function<String,Integer> stringKeyStreamingChannel = (String s) -> Integer.parseInt(s);

        //
        streamparallellistFilter(collect1, x->x.contains("2"));
        long l1 = Duration.between(now1, Instant.now()).toMillis();
//        streamparallellistFilter 554 ms 361
        log.info(" streamparallellistFilter {} ms",l1);
    }

    @Test
    public void filterTest22322(){
        List<String> collect = IntStream.range(0, 1_000_000_0).filter(p -> p % 2 == 0).mapToObj(String::valueOf).collect(toList());
        Instant now = Instant.now();
        parallelStreamlistFilter(collect, x->x.contains("2"));
        long l = Duration.between(now, Instant.now()).toMillis();
        //parallelStreamlistFilter 366 ms 573
        log.info(" parallelStreamlistFilter {} ms",l);
    }

    @Test
    public void rangeClosed() {
        Stream<double[]> stream = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
        stream.forEach(x -> {
            System.out.println(Arrays.toString(x));
        });

    }
    @Test
    public void iterateTest(){
        List<Integer> collect = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(20)
                .map(x -> x[0])
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    public void generateTest(){
       new IntSupplier(){

           @Override
           public int getAsInt() {
               return 0;
           }
       };
    }
}
