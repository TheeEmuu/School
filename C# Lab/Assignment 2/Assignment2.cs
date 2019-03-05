using System;
using System.Collections.Generic;
using System.IO;

namespace Assignment_2{
    class Assignment2{
        static void Main(String[] args){
            CDriveFiles();
        }

        static void VowelCount(){
            int total = 0;

            var vowels = new HashSet<char> {'a', 'e', 'i', 'o', 'u'};

            Console.Write("Please input a sentence: ");
            string input = Console.ReadLine();

            for(int i = 0; i < input.Length; i++){
                if(vowels.Contains(input[i]))
                    total++;
            }

            Console.WriteLine("There are " + total + " vowels in the sentence");
        }

        static void LinesInFile(){
            int lines = 0;
            var fileStream = new FileStream(@"file.txt", FileMode.Open, FileAccess.Read);

            using(var streamReader = new StreamReader(fileStream)){
                while(streamReader.ReadLine() != null){
                    lines++;
                }
            }

            Console.WriteLine("The file has " + lines + " lines");
        }

        static void CDriveFiles(){
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
}
