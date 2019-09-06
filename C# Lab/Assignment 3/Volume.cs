using System;

class Volume{
    enum volume {low = 1, medium, high};

    static void Main(string[] args){
        Console.Write("Please input a volume level (1, 2, or 3): ");
        int level = Int32.Parse(Console.ReadLine());

        volume loud = (volume)level;
        Console.WriteLine("Volume is " + loud.ToString());
    }
}