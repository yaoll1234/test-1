import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class IoTest {
	public static void main(String[] args) throws Exception{
		File file = new File("D:\\helloword.txt");
		File file1 = new File("thread.txt");

		System.out.println(file.getAbsolutePath());
		FileReader fileReader = new FileReader(file);
		FileWriter fw = new FileWriter(file1);

		char[] len = new char[3];
		int i = fileReader.read();
		while (i != -1){
			System.out.println("file::::::" + (char)i);
			fw.write((char)i);
			i = fileReader.read();

		}
		fileReader.close();



		fw.close();

		// 文件复制，将D:\\helloword.txt复制到thread.txt

	}

}
