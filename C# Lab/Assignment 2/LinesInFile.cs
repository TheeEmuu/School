using System;
using System.IO;

class LinesInFile{
    static void Main(string[] args){
        int lines = 0;
        var fileStream = new FileStream(@"file.txt", FileMode.Open, FileAccess.Read);

        using(var streamReader = new StreamReader(fileStream)){
            while(streamReader.ReadLine() != null){
                lines++;
            }
        }

        Console.WriteLine("The file has " + lines + " lines");
    }
}