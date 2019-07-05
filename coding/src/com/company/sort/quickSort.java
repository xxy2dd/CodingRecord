package com.company.sort;

/**
 * @author xxy
 * @date 2019/7/4
 * @description
 * ���� �� ��һ������һ����׼��Ϊ������ ���С�ڻ�׼ �ұߴ��ڻ�׼
 * Ȼ���ٽ���ߵĿ���һ������ ��������������� �ұߵ�ͬ��
 * ʱ�临�Ӷ� O(nlogn) �����O(n^2)�����ȶ�
 */
public class quickSort {
    public static void main(String[] args){
        quickSort q = new quickSort();
        int[] nums = {10,4,5,10,8,13,12,1,7};
        q.sort(nums);
        for(int i:nums){
            System.out.println(i +" ");
        }
    }
    public void sort(int[] nums){
        if(nums==null||nums.length==0){
            return;
        }
        int len = nums.length;
        // Ϊ�˿��Եݹ���ÿ��ź�������������Ҫ������������һ�����鱾��һ����ָ���±꣬һ����ָ���±�
        quicksort(nums,0,len-1);
    }
    public void quicksort(int[] nums,int left,int right){
        // �ݹ���ֹ����  left>=right
        if(left>=right){
            return;
        }
        // �õ���׼��λ�� ��ʱ ��׼����߶�С�ڻ�׼����׼���ұ߶����ڻ�׼
        // ����ֻ���ٶԻ�׼����ߺ��ұ߷ֱ��ظ����Ź��̼���
        int m = partition2(nums,left,right);
        quicksort(nums,left,m-1);
        quicksort(nums,m+1,right);
    }
    public int partition(int[] nums,int left,int right){
        // ��left��ָ�����Ϊ��׼
        int i = left;
        // ѭ����ֹ���� left<right
        while(left<right){
            // ע�� ��Ҫ���ڲ�ѭ������left<right���������
            // ���rightָ��������ڻ�׼��right--������
            while(left<right&&nums[right]>=nums[i]){
                right--;
            }
            // ���leftָ�����С�ڻ�׼��left++������
            while(left<right&&nums[left]<=nums[i]){
               left++;
            }
            if(left<right){
                // ��������������������ʱ����ǰ��ָ��ָ�����С�ڻ�׼����ָ��ָ��������ڻ�׼ ��������������
                swap(nums,left,right);
            }

        }
        // ������ѭ������ʱ��left==right ��󽻻�left��i��λ�ã�����׼����������Ӧ��λ�ã���ʱ��׼����߶�С�������ұ߶�������
        swap(nums,left,i);
        return left;
    }
    public void swap(int[] nums,int left,int right){
       int temp = nums[left];
       nums[left] = nums[right];
       nums[right] = temp;
    }

    public int partition2(int[] nums,int left,int right){
        // ��left��ָ�����Ϊ��׼
        int mid = nums[left];
        // ѭ����ֹ���� left<right
        while(left<right){
            // ���rightָ��������ڻ�׼��right--������
            while(left<right&&nums[right]>mid){
                right--;
            }
            // ע�� ��Ҫ����left<right���������
            if(left<right){
                nums[left++] = nums[right];
            }
            // ���leftָ�����С�ڻ�׼��left++������
            while(left<right&&nums[left]<mid){
                left++;
            }
            // ע�� ��Ҫ����left<right���������
            if(left<right){
                nums[right--] = nums[left];
            }

        }
        // ������ѭ������ʱ��left==right ��󽫻�׼�������Ӧ��λ�ã���ʱ��׼����߶�С�������ұ߶�������
        nums[left] = mid;
        return left;
    }
}
