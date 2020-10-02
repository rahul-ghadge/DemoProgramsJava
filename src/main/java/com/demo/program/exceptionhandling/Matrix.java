package exceptionhandling;

public class Matrix {


	public static void main(String[] args) {
		
		int matrix1[][] = new int[3][3];
		int matrix2[][] = new int[2][3];
		
		matrix1[0][0] = 4;
		matrix1[0][1] = 3;
		matrix1[0][2] = 2;
		matrix1[1][0] = 4;
		matrix1[1][1] = 4;
		matrix1[1][2] = 5;
		matrix1[2][0] = 3;
		matrix1[2][1] = 2;
		matrix1[2][2] = 4;
		
		matrix2[0][0] = 5;
		matrix2[0][1] = 6;
		matrix2[0][2] = 7;
		matrix2[1][0] = 2;
		matrix2[1][1] = 1;
		matrix2[1][2] = 5;
		
		
		//no of columns in matrix 1
		int columns_matrix1 = matrix1[0].length;
		
		//no of rows in matrix 2
		int rows_matrix2 = matrix2.length;
		
		
		System.out.println("Matrix One : ");
		for(int row=0; row < matrix1.length; row++) 
		{
			for(int col=0; col< matrix1.length; col++) 
			{	
				System.out.print(matrix1[row][col]+"\t");
			}
			System.out.println();
		}
		
		
		System.out.println("Matrix Two : ");
		for(int row=0; row < matrix2.length; row++) 
		{
			for(int col=0; col< matrix2.length; col++) 
			{	
				System.out.print(matrix2[row][col]+"\t");
			}
			System.out.println();
		}
		
		
		Matrix.addMatrix(matrix1, matrix2);
		Matrix.subMatrix(matrix1, matrix2);
		Matrix.multiplyMatrix(matrix1, matrix2);
		Matrix.transposeMatrix(matrix1);
	}
	
	
	public static void addMatrix(int m1[][], int m2[][]) {
		
		
		
		int resultMatrix[][] = new int[3][3];
		
		try {
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				resultMatrix[row][col] = m1[row][col] + m2[row][col];
			}
		}
		
		System.out.println("Matrix Addition Result : ");
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				System.out.print(resultMatrix[row][col]+"\t");
			}
			System.out.println();
		}
		
		}
		catch(Exception e) {
			System.out.println("Invalid input...");
		}
	}
	
	
  public static void subMatrix(int m1[][], int m2[][]) {
		
		int resultMatrix[][] = new int[3][3];
		
		
		try {
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				resultMatrix[row][col] = m1[row][col] - m2[row][col];
			}
		}
		
		System.out.println("Matrix Subtraction Result : ");
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				System.out.print(resultMatrix[row][col]+"\t");
			}
			System.out.println();
		}
		}
		catch(Exception e) {
			System.out.println("Invalid Input..");
		}
	}
	

  public static void multiplyMatrix(int m1[][], int m2[][]) {
	  
	  try {
		int resultMatrix[][] = new int[3][3];
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{
				for(int m=0; m < m1.length;m++) 
				{
					resultMatrix[row][col] += m1[row][m] * m2[m][col];	
				}
				
			}
		}
		
		System.out.println("Matrix Multiplication Result : ");
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				System.out.print(resultMatrix[row][col]+"\t");
			}
			System.out.println();
		}
		
	  }
	  catch(Exception e) {
		  System.out.println("Invalid Input..");
	  }
	  
	}
	
  
  public static void transposeMatrix(int m1[][]) {
		
		int resultMatrix[][] = new int[3][3];
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				resultMatrix[col][row] = m1[row][col];
			}
		}
		
		System.out.println("Transpose of Matrix One ");
		
		for(int row=0; row < m1.length; row++) 
		{
			for(int col=0; col< m1.length; col++) 
			{	
				System.out.print(resultMatrix[row][col]+"\t");
			}
			System.out.println();
		}
	}
	
}
