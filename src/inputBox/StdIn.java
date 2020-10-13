package inputBox;

import java.io.*;

/**
 * 为各种算法便捷地提供大量的输入数据
 * @author scarecrowCodes
 */
public class StdIn {

    //获取一个带有缓冲区的输入流
    public BufferedReader input() throws FileNotFoundException {
        //定义文件路径
        File file = new File("C:\\Users\\34462\\myCodes\\Java\\AlgrothmFourthEditionNotes\\inputBox.txt");
        //返回输入流
        return new BufferedReader(new FileReader(file));
    }

    //向数组中输入数据
    public void input(Comparable[] a, int num){

        //判断所需输入量是否大于数组容量
        if(num > a.length){
            throw new NullPointerException("所需输入量大于数组容量!");
        }

        //从文件中提取数据
        File file = new File("C:\\Users\\34462\\myCodes\\Java\\AlgrothmFourthEditionNotes\\inputBox.txt");
        try (BufferedReader inStream = new BufferedReader(new FileReader(file))){

            for(int i = 0; i < num; i ++){

                String msg = inStream.readLine();
                //将从文件中读出的数据存入数组中
                a[i] = msg;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
