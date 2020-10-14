package Sort;

import inputBox.StdIn;

/**
 * 测试实现排序算法的代码的运行结果是否符合预期
 * @author scarecrowCodes
 */
public class testAlg {

    public static void main(String[] args) {

        //读入数据，到数组a中
        Comparable[] a = new Comparable[45];
        StdIn inStream = new StdIn();
        inStream.input(a, a.length);
        //对a进行排序
        //1、测试希尔排序
        /*
        SortAlgAPI saa = new ShellSort();
        saa.sort(a);
         */
        //2、测试自顶向下的归并排序
        /*
        MergeSort saa = new MergeSort(a);
        saa.sort(a, 0, a.length - 1);
         */
        //判断a是否已经有序
        System.out.println(SortAlgAPI.isSorted(a));;
        //显示a中的元素
        SortAlgAPI.display(a);

    }

}
