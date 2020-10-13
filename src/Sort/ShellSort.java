package Sort;

/**
 * 希尔排序实现排序算法
 * @author scarecrowCodes
 */
public class ShellSort implements SortAlgAPI {

    @Override
    public void sort(Comparable[] a) {

        int len = a.length;
        int interval = 1;   /*对数组进行排序时，各被排序元素之间的间隔*/
        while (interval < len/3){
            interval = interval * 3 + 1;
        }

        //对数组中间隔为interval的元素进行排序
        while (interval >= 1) {

            for (int i = interval; i < len; i++) {   //i从a[interval]开始，遍历到a[len - 1]以确保每一个元素在循环结束时都符合
                //“间隔interval的元素有序”的特征

                //j从i开始，索引到每一个a[i - k*interval]的元素，其中，k为整数
                for (int j = i; j >= interval; j -= interval) {

                    //如果发现a[i - k*interval] < a[i - (k+1)*interval]，（说明这两处尚未符合“间隔interval的元素有序”的特征）
                    //则执行排序
                    if (SortAlgAPI.less(a[j], a[j - interval])) {
                        SortAlgAPI.exch(a, j, j - interval);
                    }

                }

            }
            //缩小各被排序元素之间的间隔
            interval /= 3;
        }

    }

}
