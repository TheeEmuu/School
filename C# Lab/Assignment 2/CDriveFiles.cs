using System;
using System.IO;

class CDriveFiles{
    static void Main(){
        Console.Write("Please input a file name: ");
        string path = Console.ReadLine();
        string[] directories = Directory.GetDirectories("C:\\");

        using(StreamWriter outputFile = new StreamWriter(path)){
            foreach (string item in directories){
                outputFile.Write(item + "     " + 
                File.GetLastAccessTime(item) + "     " +
                File.GetLastWriteTime(item) + "\n");
            }
        }
    }
}