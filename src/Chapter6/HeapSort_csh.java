package Chapter6;

import java.util.Scanner;

public class HeapSort_csh {
    public static void ArrayToHeap(int[] array,int size){
        int max=size-1;
        while(max>0){
            int index=(max-1)/2;
            if(max%2==0){ // 짝수
                if(array[max]>=array[index] && array[max]>=array[max-1]){
                    int temp=array[max];
                    array[max]=array[index];
                    array[index]=temp;
                }else if(array[max-1]>=array[index] && array[max-1]>=array[max]){
                    int temp=array[max-1];
                    array[max-1]=array[index];
                    array[index]=temp;
                }
                max=max-2;
            }else{ // 홀수
                if(array[max]>=array[index]){
                    int temp=array[max];
                    array[max]=array[index];
                    array[index]=temp;
                }
                max=max-1;
            }
        }
        
        boolean check=false;
        int i = 0;
        while(i<size-1){
            int leftIndex=(i*2+1<=size-1)?i*2+1:-1;
            int rightIndex=(i*2+2<=size-1)?i*2+2:-1;
            if(leftIndex!=-1&&array[i]<=array[leftIndex]){
                check=true;
                break;
            }
            if(rightIndex!=-1&&array[i]<=array[rightIndex]){
                check=true;
                break;
            }
            i=i+1;
        }
        if(check) ArrayToHeap(array,size);
    }

    public static void heapSort(int array[],int size){
        int index=size-1;
        while(index>0) {
            ArrayToHeap(array, index+1);
/*            for(int i=0;i<index+1;i++){
                System.out.println(array[i]);
                System.out.println("/   \\");

            }*/
            int swap=array[0];
            array[0]=array[index];
            array[index]=swap;
            index=index-1;
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 입력 : ");
        int size=sc.nextInt();
        int[] array = new int[size];
        for(int i=0;i<size;i++)
            array[i]=sc.nextInt();
        heapSort(array,size);
        for(int i=0;i<size;i++)
            System.out.print(array[i]+" ");
    }
}
