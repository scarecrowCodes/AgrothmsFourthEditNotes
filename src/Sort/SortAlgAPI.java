package Sort;

/**
 * 排序算法的接口
 * @author scarecrowCodes
 */
public interface SortAlgAPI {

    //对Comparable数组从小到大排序
    void sort(Comparable[] a);

    //判断v是（返回true）否（返回false）小于w
    static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    //转换数组a中索引为i处与索引为j处的元素在a中的位置
   static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //由于无法直接在接口中重写toString方法，改为使用display方法定义如何展示被排序的元素
    static void show(Comparable[] a){

        //在单行中打印元素，每打印五个换一行
        int cnt = 0;
        for(Comparable ele: a){
            System.out.print(ele);
            if(++ cnt > 4){
                System.out.println();
                cnt = 0;
            }
        }

    }

    //判断被排序的元素是（返回true）否（返回false）已经有序
    static boolean isSorted(Comparable[] a){

        for(int i = 1; i < a.length; i ++){
            if(less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;

    }

}
