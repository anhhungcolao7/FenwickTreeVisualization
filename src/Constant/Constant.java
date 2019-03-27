package Constant;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class Constant {
    public static final int SIZE_PSEUDOCODE_CONTAINER_TEXT = 20;
    public static final String COLOR_DESCRIPTION_TEXT_PSEUDOCODE_CONTAINER = "F0E6EF";
    public static final String COLOR_PSEUDOCODE_TEXT_PSEUDOCODE_CONTAINER = "000000";
    public static final String COLOR_SELECTED_PSEUDOCODE_TEXT_PSEUDOCODE_CONTAINER = "ffffff";
    public static final String COLOR_SELECTED_PSEUDOCODE_VIEW_BACKGROUND = "000000";
    
    public static final String FONT_PSEUDOCODE_CONTAINER_TEXT = "Arial";
    public static final double TIME_DELAY = 0.5;
    public static final String COLOR_DESCRIPTION_VIEW_BACKGROUND = "d9513c";
    public static final String COLOR_PSEUDOCODE_VIEW_BACKGROUND = "fec515";
    public static final String[] QUICKSORT_PSEUDO_CODE = {
                                                           "int getSum(int BITree[], int index)", // 0
                                                           "    int sum = 0", // 1
                                                           "    index = index + 1", //2
                                                           "    while (index > 0)", // 3
                                                           "        sum += BITree[index]", //4 -3
                                                           "        index -= index & (-index)", //5 - 2
                                                           "    return sum ", // 6
                                                           "                ", // 7
                                                           "    void updateFenwickTree(int BITree[], int n, int index, int val)", //8
                                                           "        index = index + 1", //9
                                                           "        while (index <= n)", // 10
                                                           "            BITree[index] += val", // 11 - 4
                                                           "            index += index & (-index)" // 12 - 1
    };
    public static final int[] QUICKSORT_PSEUDO_CODE_ARRAY_DEFINE = {0,12,5,4,11};
}
