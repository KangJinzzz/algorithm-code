public class Test {
    public static void main(String[] args) {

    }

    //面试题3：数组中重复的数字
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
                return false;
            }
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                if(numbers[i] < 0 || numbers[i] > length - 1) {
                    return false;
                }
            arr[numbers[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

//    if(numbers == null || length <= 0) {
//        return false;
//    }
//    int[] arr = new int[length];
//            for (int i = 0; i < length; i++) {
//        if(numbers[i] < 0 || numbers[i] > length - 1) {
//            return false;
//        }
//    }
//        for(int i = 0; i < length; i++) {
//        while(numbers[i] != i) {
//            if(numbers[i] == numbers[numbers[i]]) {
//                duplication[0] = numbers[i];
//                return true;
//            }
//            int temp = numbers[i];
//            numbers[i] = numbers[temp];
//            numbers[temp] = temp;
//        }
//    }
//        return false;
}

