/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors.*;
import java.util.stream.Streams.*;
import java.util.stream.IntStream.*;

public class Bench {
    
    public static void main(String... args){
        //テスト用データ作成
        Random r = new Random(2111);
        //List<String> data = intRange(0, 1_000_000)
        List<String> data = range(0, 1_000_000)
            .mapToObj(i->
                r.ints().limit(20)
                    .map(n -> Math.abs(n) % 36)
                    .map(code -> (code < 10) ? '0' + code : 'A' + code - 10)
                    .mapToObj(ch -> String.valueOf((char)ch))
                    .collect(toStringBuilder())
                    .toString())
            .collect(toList());
        data.stream().limit(3).forEach(System.out::println);
        //1M3FX39ONOSZR9HEZT1E
        //E3X2WPI2F0IHUKIOR52L
        //BSG6JSN37Q1L9VJUBKRO

        //処理と名前を設定
        List<Function<List<String>, Long>> procs = 
                Arrays.asList(
                    Bench::streamSum, Bench::parallelSum, Bench::proceduralSum);
        List<String> names = Arrays.asList("Stream Sum", "Parallel Sum", "Procedurarl Sum");

        //処理結果を確認
        procs.stream()
                .map(proc -> proc.apply(data))
                .forEach(System.out::println);
        //14795382494128
        
        //何度かまわしておく
        //intRange(0, 3).forEach(i -> {
        range(0, 3).forEach(i -> {
            procs.forEach(proc -> proc.apply(data));
        });
        //ベンチ実行
        zip(procs.stream(), names.stream(), 
            (proc, name) -> String.format("-- %s --%n%.3f",
                    name,
                    //intRange(0, 10)
                    range(0, 10)
                        .mapToLong(i -> bench(proc, data))
                        .substream(3)//最初の３回は切り捨て
                        .average().orElse(0) / 1000 / 1000 / 1000)//ナノ秒を秒に
        ).forEach(System.out::println);
    }
    
    public static Long bench(Function<List<String>, Long> proc, List<String> data){
        long start = System.nanoTime();
        proc.apply(data);
        return System.nanoTime() - start;
    }
    
    public static long streamSum(List<String> data){
        return data.stream()
                .map(d -> d.replaceAll("[^0-9]", ""))//数字以外を取り除く
                .filter(d -> !d.isEmpty())
                .filter(d -> d.chars().map(ch -> ch - '0').sum() < 30)//数字の合計が30より小さい
                .mapToLong(d -> Long.parseLong(d)).sum();
    }

    public static long parallelSum(List<String> data){
        return data.parallelStream()
                .map(d -> d.replaceAll("[^0-9]", ""))//数字以外を取り除く
                .filter(d -> !d.isEmpty())
                .filter(d -> d.chars().map(ch -> ch - '0').sum() < 30)//数字の合計が30より小さい
                .mapToLong(d -> Long.parseLong(d)).sum();
    }

    public static long proceduralSum(List<String> data){
        long result = 0;
        for(final String d : data){
            String numOnly = d.replaceAll("[^0-9]", "");
            if(numOnly.isEmpty()) continue;
            int total = 0;
            for(char ch : numOnly.toCharArray()){
                total += ch - '0';
            }
            if(total >= 30) continue;
            long value = Long.parseLong(numOnly);
            result += value;
        }
        return result;
    }
}
