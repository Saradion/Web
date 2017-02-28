package challenges.challenge1;

import challenges.CompiLoader;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by saradion on 17/01/17.
 */
public class Chall1 {
    private int[] summit;
    private int height = 11;

    private final int size = 10;

    public Chall1() {
        summit = new int[size];

        for(int i = 0; i < size; i++) {
            summit[i] = i+1;
        }

        shuffleArray(summit);
    }

    public void run(String fileURI, String classURI) {
        Class<?> customClass = CompiLoader.compileAndLoad(fileURI, classURI);
        try {
            Object solver = customClass.newInstance();
            for (int i = 0; i < size; i++) {
                Method findMax = customClass.getMethod("findMax", int[].class);
                int computedMax = (int) findMax.invoke(solver, summit);
                System.out.println(computedMax);
                summit[computedMax] = 0;
                height--;
                List<Integer> summitList = new ArrayList<>();
                for(Integer elem : summit) {
                    summitList.add(elem);
                }
                if(height <= Collections.max(summitList)) {
                    throw new Exception("Failure!!");
                }
                System.out.println(Collections.max(summitList));
            }
            System.out.println("Problem Solved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
