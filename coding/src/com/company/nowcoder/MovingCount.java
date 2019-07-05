package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/7/5
 * @description
 * ������һ��m�к�n�еķ���
 * һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
 * ���ʸû������ܹ��ﵽ���ٸ����ӣ�
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return movingcount(threshold, rows, cols, 0, 0, visited);
    }

    public int movingcount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        // �ж��Ƿ�Ϸ�
        if (check(threshold, rows, cols, row, col, visited)) {
            // �Ϸ������÷���λΪtrue
            visited[row * cols + col] = true;
            // �ݹ����������ĸ������Ƿ����
            count = 1
                    + movingcount(threshold, rows, cols, row - 1, col, visited)
                    + movingcount(threshold, rows, cols, row, col - 1, visited)
                    + movingcount(threshold, rows, cols, row + 1, col, visited)
                    + movingcount(threshold, rows, cols, row, col + 1, visited);
        }
        return count;

    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return col >= 0 && col < cols
                && row >= 0 && row < rows
                && !visited[row * cols + col]
                && (getSum(col) + getSum(row) <= threshold);
    }

    public int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }
}
