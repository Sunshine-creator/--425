package cww0425;
public class testSort {
    public static void  bubbleSort(int [] array){  //冒泡排序
        for (int i = 0; i <array.length ; i++) {
            for(int cur = array.length-1;cur>i;cur--){
                if(array[cur-1] > array[cur]){
                    int temp = array[cur];             //o(n^2),o(1),稳定
                    array[cur]=array[cur-1];
                    array[cur-1]=temp;
                }
            }
        }
    }
    public static void swap(int[] array,int i,int j){     //一会调用堆顶元素
        int temp = array[i];
        array[i]=array[j];
        array[j] = temp;
    }
    public static void fastSort(int [] array){     //快速排序（递归）
//         int tem = array[array.length-1];
//         for(int left =0;left<array.length;left++){
//             for(int right = array.length-1;right>=left;right--){
//
//             }
//         }
        quickHelper(array,0,array.length-1);  //前闭后闭
   }

    private static void quickHelper(int[] array, int left, int right) {
       if(left>=right){  //只有一个元素
           return;
       }
      int index= partition(array,left,right);//left和right重合位置
        quickHelper(array,left,index-1);
        quickHelper(array,index+1,right);   //进行递归调用
    }
    private static int partition(int[] array, int left, int right) {  //
        int i = left;
        int j = left;
        int base = array[right];  //基准值
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;//按基准值分成三部分
            }//i与j重合或者指向大于基准值
            while (i < j && array[j] >= base) {  //找出小于基准值
                j--;
            }
            swap(array, i, j);
        }
        swap(array,i,right);  //重合后一定大于等于基准值然后和基准值进行交换
        return i;
    }
}
