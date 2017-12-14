public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        displayMatrix(mat);
        displayMatrix(reverseRow(mat));
       // displayMatrix(transpose(mat));
    }

    public static int[][] transpose(int [] [] matrix) {

        int temp=-1;
        for(int i= 0; i< matrix.length; i++){
            for(int j= 0; j<matrix[0].length; j++)
            {
                temp =matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
        return matrix;
    }

    public static int[][] reverseRow(int [] [] matrix) {

        int[] temp;

        for (int i = 0, k = matrix.length - 1; i < k; ++i, --k) {
            temp = matrix[i];
            matrix[i] = matrix[k];
            matrix[k] = temp;
        }

        return matrix;
    }



    public static void displayMatrix(int [] [] matrix) {

        System.out.println("Matrix size:" + matrix.length + " "+ matrix[0].length);

        for(int i= 0; i< matrix.length; i++){
            for(int j= 0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    public static void setRowColumnToZeroIfElementZero(int [] [] matrix) {

        System.out.println("Matrix size:" + matrix.length + " "+ matrix[0].length);

        for(int i= 0; i< matrix.length; i++){
            for(int j= 0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0) System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

}
