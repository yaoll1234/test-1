import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest1 {

	/**
	 * 字符串“ab”在“acbabedfaabxyzab”中出现的次数
	 * 使用indexOf()获取字串首次出现的位置
	 * 然后在调用从指定位置查找字符串的indexOf(int index,String str)
	 * */

	/**
	 * 字符串的反转“abcdefgh”
	 * 转成char[] 数组
	 */

	public  String reverse(int start,int end,String str){
		if(str != null && str.length()!=0) {
			char[] arr = str.toCharArray();
			for (int x = start, y = end; x < y; start++, end--) {
				char temp;
				temp = arr[x];
				arr[x] = arr[y];
				arr[y] = temp;
			}
			return new String(arr);
		}
		return null;
	}

	/**
	 * 方式二、字符串拼接
	 * @param start
	 * @param end
	 * @param str
	 * @return
	 */
	public String reverse1(int start,int end,String str){
		if(str!= null && str.length()!= 0){
			String subStrig = str.substring(0,start);
			for(int i = end;i>=start;i--){
				subStrig +=str.charAt(i);
			}
			subStrig += str.substring(end+1);
			return subStrig;
		}
		return null;
	}
	public static void main(String[] args ){



		ArrayTest1 arrayTest1 = new ArrayTest1();

		String str = "ab cdefgh";
		String s = String.valueOf(123);

		String all = str.replaceAll("\n", "1234");
		System.out.println("valueOf::::::" + s + "\n" + "字符串转数组" + s.toCharArray() + "\n" + "replaceAll::::" + all);


		//String s = arrayTest1.reverse(3, 5, str);
		//System.out.println("reverse" + s);
		System.out.println("reverse1:::::" + arrayTest1.reverse1(3,5,str));

		// 数组 比较
		int[] a1 = {1,2,3,4};
		int[] b = {1,3,4,6};
		System.out.println(Arrays.equals(a1,b));

		// 数组反转
		int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int i=0,j=arr2.length-1;i<j;i++,j--){
			int temp;
			temp = arr2[i];
			arr2[i] = arr2[j];
			arr2[j] = temp;
		}
		for (int i = 0;i<arr2.length;i++){
			System.out.print(arr2[i] + "\t");
		}
		 //回形数打印
		// 键盘输入
      Scanner getnum = new Scanner(System.in);
		System.out.println("请输入一个数：");
		int num = getnum.nextInt();
		int size = num;
		int start = 0;                                       //起始点坐标
		int end = size-1;                              //终止点坐标
		int values = 1;                                      //每个元素的值
		int arr[][] = new int [size][size];                       //创建二维数组
		while(true) {                                                     //循环打印
			for(int i = start;i <= end;i++) {
				arr[start][i] = values;
				values++;
			}                    //打印第一行


			for(int i = start + 1; i<= end;i++) {
				arr[i][end] = values;
				values++;
			}                      //打印最后一列


			for(int i = end - 1;i >= start;i--) {
				arr[end][i] = values;
				values++;
			}                 //打印最后一行

			for(int i = end - 1; i >= start + 1;i--) {
				arr[i][start] = values;
				values++;     //打印第一列
			}

			start++;
			end--;

			if(start >= end) {
				break;                          //当起始点坐标和终止点坐标相等时跳出
			}
		}


		//奇数回形数
		if(size % 2 != 0) {                              //输入的数为偶数是可以直接打印，当输入的数为奇数是，为最中间的数赋值
			arr[end][start] = values;
		}



		for(int i = 0;i < arr.length ;i++) {                       //遍历输出
			for(int j = 0; j < arr[i].length ;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

		// 给数组赋值1-30的不重复的数 (智数)
		int[] a = new int[6];
		for (int i = 0; i <a.length ; i++) {
			a[i]= (int)(Math.random()*30) +1;
			for (int j = 0; j <i ; j++) {
				if(a[i] == a[j]){
					i--;
					break;
				}
			}
		}
		for (int i = 0; i <a.length ; i++) {
			System.out.print(a[i] + "\t");
		}
		double random= Math.random() * 30 +1;
		System.out.println("math.randon随机数：：：" + random);

		// 杨辉三角输出
	/*	int[][] arr=new int[10][];
		for (int i = 0; i <arr.length ; i++) {
			// 第n行有n+1个元素
			arr[i] = new int[i+1];
			arr[i][0]=arr[i][i]=1;
			for (int j = 1; j <arr[i].length-1 ; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <arr[i].length ; j++) {
				System.out.print(arr[i][j] + " " );
			}
			System.out.println();
		}*/

	// 二分查找
		int[] arr1={1,2,3,4,5,6,7,8,9};
		int head = 0;
		int end1 = arr1.length-1;
		int dest = 8;
		while (head<end1){
			int minddle = (head + end1)/2;
			if(dest == arr1[minddle]) {
				System.out.println("找到了，位置是" + minddle);
				break;
			}else if(arr1[minddle]>dest){
				end1 = minddle-1;
			}else {
				head = minddle + 1;
			}
		}

	}
}
