array to list
    int[] spam = new int[] { 1, 2, 3 };
    Arrays.asList(spam)

1. binary gap
    import java.util.stream.*;
    import java.lang.Integer;
    import java.util.*;

    class Solution {
        public int solution(int N) {
            String binaryString = Integer.toBinaryString(N);
            char[] binaryChars = Integer.toBinaryString(N).toCharArray();
            List<Integer> list = IntStream.range(0, binaryChars.length)
                    .mapToObj(i-> binaryChars[i] =='1' ? i : -1)
                    .filter(i -> i>-1)
                    .collect(Collectors.toList());
            if(list.size()==1) return 0;
            return IntStream.range(0, list.size()-1)
                    .mapToObj(i-> list.get(i+1) - list.get(i)-1)
                    .max(Comparator.comparing(i -> i))
                    .get();
        }
    }

2. frequency value of array
    a. 44点
    import java.util.stream.*;
    import java.util.*;
    import java.lang.*;

    class Solution {
        public int solution(int[] A) {
            List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
            
            List<Integer> test = IntStream.rangeClosed(0, list.size()-1)
                .filter(i -> Collections.frequency(list, list.get(i)) == 1)
                .mapToObj(i-> list.get(i))
                .collect(Collectors.toList());
            return test.get(0);
        }
    }

    b. 
    b1. sort Arrays
            Arrays.sort(A);
    b2.
        import java.util.*;
        import java.lang.*;
        import java.util.stream.*;

        class Solution {
            public int solution(int[] A) {
                Arrays.sort(A);
              
                for(int i=0; i<A.length; i+=2) {
                    if(i==(A.length-1)) return A[i];
                    if(A[i]!=A[i+1]) return A[i];
                }
                
                return -1;
            }
        }

3. CyclicRotation
    3.1 list to int[]
        indexes.stream().mapToInt(i->).toArray();
    3.2 
import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] A, int K) {
        int len = A.length;
        List<Integer> indexes = IntStream.rangeClosed(0, len-1)
            .mapToObj(i -> ((K+i)%len) % len)
            .collect(Collectors.toList());
        
        int[] result = new int[len]; 
        for(int i=0; i<len; i++) {
            result[indexes.get(i)] = A[i];
        }
        
        return result;
    }
}

4. minial part sum of an array
import java.util.*;
import java.util.stream.*;
import java.lang.*;

class Solution {
    public int solution(int[] A) {
        int sum = Arrays.stream(A).sum();        
        int sub_sum = 0;
        int best = Integer.MAX_VALUE;
        
        int tmp;
        int index = 0;
        for(int i=0; i<A.length-1; i++) {
            sub_sum += A[i];
            tmp = Math.abs(sum-2*sub_sum);
            if(best > tmp) {
                index = i;
                best = tmp;
            }
        }
        
        return best;
    }
}

5. find missing element of arrays
    get min value by stream of array 

    5.1 55%
limport java.util.*;
import java.util.stream.*;
import java.lang.*;

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        List<Integer> list = IntStream.range(0, len)
                    .filter(i->A[i]>0)
                    .mapToObj(i-> A[i])
                    .sorted(Comparator.comparing(i->i))
                    .collect(Collectors.toList());
        
        if(list.size()<1) return 1;
        else if (list.get(0)!=1){
            return 1;
        } else {      
            int min = IntStream.range(1, list.size())
                            .mapToObj(i -> 
                                 list.get(i) - list.get(i-1)>1 ?
                                    list.get(i-1)+1 :
                                    Integer.MAX_VALUE
                            )
                            .min(Comparator.comparing(i -> i))
                            .get();
            return (min==Integer.MAX_VALUE) ?
                            list.get(list.size()-1)+1 : min;
        }
    }
}

    5.2 

import java.util.*;
import java.util.stream.*;
import java.lang.*;

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        List<Integer> list = IntStream.range(0, len)
                    .filter(i->A[i]>=0)
                    .mapToObj(i-> A[i])
                    .sorted(Comparator.comparing(i->i))
                    .collect(Collectors.toList());
        
        int lenList = list.size();
        switch(len) {
            case 0: return 1;
            case 1: return list.get(0)==1 ? 2 : 1;
            default:
                ListIterator<Integer> it = list.listIterator();
                int preV = 0; 
                int curV;
        
                while(it.hasNext()) {
                    curV = it.next();
                    if(curV-preV > 1)
                       break; 
                    preV = curV;
                }
                return preV+1;
        }
    }
}

5.3
import java.util.*;
import java.util.stream.*;
import java.lang.*;

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        
        if(A[len-1]<0) return 1; 
        
        List<Integer> list = IntStream.range(0, len)
                    .filter(i->A[i]>=0)
                    .mapToObj(i-> A[i])
                    .collect(Collectors.toList());
        int lenList = list.size();
        
        switch(lenList) {
            case 0: return 1;
            case 1: return list.get(0)==1 ? 2 : 1;
            default:
                ListIterator<Integer> it = list.listIterator();
                int preV = 0; 
                int curV;
        
                while(it.hasNext()) {
                    curV = it.next();
                    if(curV-preV > 1)
                       break; 
                    preV = curV;
                }
                return preV+1;
        }
    }
}

6. 
// you can also use imports, for example:
import java.util.*;
import java.util.stream.*;
import java.lang.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8        
        int count = 0;
        int[] B = new int[X];
                
        for(int i=0; i<A.length; i++) {
            if(B[A[i]-1]!=1) {
                count+=1;
                if(count==X) return i;
                B[A[i]-1] = 1;
            }
        }
        
        return -1;
    }
}

7. 7min / find purmutation
// you can also use imports, for example:
import java.util.*;
import java.lang.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        Arrays.sort(A);
        
        for(int i=0; i<len; i++) {
            if((i+1)!=A[i]) return 0;
        }
        
        return 1;
    }
}

8. MaxCounters
8.1 77%
import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int[] result = new int[N];
        
        int max = 0;
        int index = 0;
        for(int i=0; i<len; i++) {
            if(A[i]>=1 && A[i]<=N) {
                index = A[i]-1;
                result[index]++;
                if(result[index]>max)
                    max = result[index];
            } else {
                Arrays.fill(result, max);
                // for(int j=0; j<N; j++)
                    // result[j] = max;
            }   
        }
        
        return result;
    }
}
8.2 perfect
class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        
        int min = Integer.MIN_VALUE;
        int tmin = 0;
        
        int length = A.length;
        
        for(int i = 0; i < length; ++i) {
            int index = A[i] - 1;
            if(index == N) {
                min = tmin;
            } else {
                if(counters[index] < min) {
                    counters[index] = min;
                }
                
                ++counters[index];
                
                if(tmin < counters[index]) {
                    tmin = counters[index];
                }
            }
        }
        
        for(int i = 0; i < counters.length; ++i) {            
            if(counters[i] < min) {
                counters[i] = min;
            }
        }
        
        return counters;
    }
}

9. Compute number of integers divisible by k in range [a..b]
9.1
class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int result = B/K-A/K;
        if(A/K==0 && B/K==0)
            result =  0;
        else if(A/K==0 && B/K!=0) 
            result =  B/K ;
        else if(A/K!=0 && B/K!=0)
            result = (B/K-A/K);  
        
        return A%K==0? result+1 : result;
    }
}

10. PassingCars
// you can also use imports, for example:
import java.util.*;
import java.util.stream.*;
import java.lang.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        
        if(len==1) return 0;
        
        int result = 0;
        int sum = Arrays.stream(A).sum();
        
        for(int i=0; i<len; i++) {
            if(result>1000000000) {
                result = -1;
                break;
            }
            if((len-i+1)==sum) break;
            
            if(A[i] == 0) {
                result += sum;
            }
            if(A[i] == 1) sum--;        
        }
        
        return result;
    }
}

11.
