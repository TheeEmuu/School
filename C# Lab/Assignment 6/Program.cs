// using System;

// class Program{
//     static void Main(string[] args){
//         var video = new Video() { Title = "Video 1" };
//         var videoEncoder = new VideoEncoder();
//         var mailService = new MailService();
//         var messageService = new MessageService();

//         videoEncoder.VideoEncoded += mailService.OnVideoEncoded;
//         videoEncoder.VideoEncoded += messageService.OnVideoEncoded;

//         videoEncoder.Encode(video);
//     }
// }

// public class MailService{
//     public void OnVideoEncoded(object source, VideoEventArgs e){
//         Console.WriteLine("Mailservice: Sending an email..." + e.Video.Title);
//     }
// }

// public class MessageService{
//     public void OnVideoEncoded(object source, VideoEventArgs args){
//         System.Console.WriteLine("MessageService: Sending a text message..." + args.Video.Title);
//     }
// }
