package kmp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordon on 16/11/25.
 */
public class KMPSearchRemember {

    public static void main(String[] args) {
        searchs("gordon rawboye is a handsome boy".toCharArray(), "boy".toCharArray()).forEach(System.out::println);
    }




























    public static int[] step1(char[] pattern){
        int i =0,j = -1,len = pattern.length;
        int[] ret = new int[len+1];
        ret[i]=j;
        while (i < len){
            while (j >=0 && pattern[i]!=pattern[i]) j = ret[j];
            i++;
            j++;
            ret[i]=j;
        }
        return ret;
    }

    public static List<Integer> searchs(char[] src,char[] pattern){
        int i = 0 , j = 0, lenS = src.length,lenP = pattern.length;
        List<Integer> ret = new ArrayList<>();
        int[] ref = step1(pattern);
        while (i < lenS){
            while (j >=0 && src[i]!=pattern[j]) j = ref[j];
            i++;
            j++;
            if(j==lenP){
                ret.add(i-lenP);
                j = ref[j];
            }
        }
        return ret;
    }




















}
