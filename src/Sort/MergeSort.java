package Sort;

/**
 * 归并排序实现排序算法
 * @author scarecrowCodes
 */
public class MergeSort implements SortAlgAPI {

    //归并排序所需的额外内存空间
    private Comparable[] aux;

    //将两组元素按“从小到大”归并到一起，成为一组新的有序的元素组
    private void merge(Comparable[] a, int lo, int mid, int hi){    //将a[lo, mid]与a[mid+1, hi]归并到一起

        for(int cur = lo; cur <= hi; cur ++){   /*将元素拷贝到额外内存中*/
            this.aux[cur] = a[cur];
        }

        int i = lo, j = mid + 1;
        for(int cur = lo; cur <= hi; cur ++){

            //如果第二组的元素已被取完，则取第一组的元素
            if(j > hi){
                a[cur] = aux[i ++];
            }
            //如果第一组的元素已被取完，取得第二组元素
            else if(i > mid){
                a[cur] = a[j ++];
            }
            //如果两组的元素均未被取完，则分别选择两组元素中较小的那个（也就是排序最靠前的那个），将这两个元素进行比较，取得较小的那
            //个
            else if(SortAlgAPI.less(aux[i], aux[j])){
                a[cur] = aux[i ++];
            }else {
                a[cur] = aux[j ++];
            }

        }

    }

    //递归实现自顶向下的归并排序
    public void sort(Comparable[] a, int lo, int hi){

        //归并算法的核心是“先分后并”，先将被排序的元素拆分到单个，再两两按顺序归并到一起
        if(hi <= lo){   /*如果hi == lo，说明已经拆分到单个了*/
            return;
        }
        //如果尚未拆分到单个，则继续拆分
        int mid = lo + (hi - lo)/2;    /*将当前被排序的元素拆分为两半*/
        //将拆分后的左半边排序
        sort(a, lo, mid);
        //将拆分后的右半边排序
        sort(a, mid + 1, hi);
        //将拆分好的元素进行归并
        merge(a, lo, mid, hi);

    }

    public void sort(Comparable[] a) {

    }

    public MergeSort(Comparable[] a){
        //由于在递归过程中创建数组对象非常耗费时间，所以这里一次性分配归并排序所需的额外内存空间
        aux = new Comparable[a.length];
    }

}
