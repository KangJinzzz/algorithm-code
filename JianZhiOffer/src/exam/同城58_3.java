package exam;

import java.util.ArrayList;
import java.util.List;

public class 同城58_3 {

    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        ArrayList<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < arrayA.size() && index2 < arrayB.size()) {
            if (arrayA.get(index1) < arrayB.get(index2)) {
                index1++;
            } else if (arrayA.get(index1) > arrayB.get(index2)) {
                index2++;
            } else {
                list.add(arrayA.get(index1));
                index1++;
                index2++;
            }
        }
        return list;
    }
}
