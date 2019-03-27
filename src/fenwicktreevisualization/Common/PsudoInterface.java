package fenwicktreevisualization.Common;

public class PsudoInterface {
    public static int MOVE_UP = 1;
    public static int MOVE_DOWN = 2;
    public static int GET_SUM_UPDATE = 3;
    public static int UPDATE_FW_TREE = 4;
}


//    int getSum(int BITree[], int index)
//    {
//        int sum = 0;
//        index = index + 1;
//        while (index>0)
//        {
//            sum += BITree[index]; //3
//            index -= index & (-index); // 2
//        }
//        return sum;
//    }
//
//    void updateFenwickTree(int BITree[], int n, int index, int val)
//    {
//        index = index + 1;
//        while (index <= n)
//        {
//            BITree[index] += val; // 4
//            index += index & (-index); // 1
//        }
//    }