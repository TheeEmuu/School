using System;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;
using System.Collections.Generic;
using Newtonsoft.Json;
using System.IO;
using System.Text;

namespace Assignment_8{
    public partial class Form1 : Form{
        TextBox input;

        Button submit;

        public Form1(){
            input = new TextBox();
            submit = new Button();

            input.Size = new Size(120, 40);
            submit.Size = new Size(80, 40);

            input.Location = new Point(30, 30);
            submit.Location = new Point(45, 80);

            this.Controls.Add(input);
            this.Controls.Add(submit);

            submit.Text = "Submit";

            AcceptButton = submit;

            submit.Click += new EventHandler(submit_click);

        }

        private void submit_click(object sender, EventArgs e){
            Result result = getCharacter(input.Text);

            result.homeworld = getHomeworld(result.homeworld);
            result.films = getType(result.films);
            result.species = getType(result.species);
            result.vehicles = getType(result.vehicles);
            result.starships = getType(result.starships);

            StringBuilder builder = new StringBuilder();

            builder.AppendLine("Name: " + result.name);
            builder.AppendLine("Height: " + result.height);
            builder.AppendLine("Mass: " + result.mass);
            builder.AppendLine("Hair Color: " + result.hair_color);
            builder.AppendLine("Skin Color: " + result.skin_color);
            builder.AppendLine("Eye Color: " + result.eye_color);
            builder.AppendLine("Birth Year: " + result.birth_year);
            builder.AppendLine("Gender: " + result.gender);
            builder.AppendLine("Homeworld: " + result.homeworld);
            builder.AppendLine("Films:");
            addList(result.films, builder);
            builder.AppendLine("Species:");
            addList(result.species, builder);
            builder.AppendLine("Vehicles:");
            addList(result.vehicles, builder);
            builder.AppendLine("Starships:");
            addList(result.starships, builder);

            MessageBox.Show(builder.ToString());
        }

        private string getHomeworld(string url) {
            using (var webClient = new System.Net.WebClient()) {
                var json = webClient.DownloadString(url);

                return getName(json);
            }

            
        }

        private List<string> getType(List<string> films) {
            List<string> list  = new List<string>();

            using (var webClient = new System.Net.WebClient()) {
                foreach (string url in films) {
                    var json = webClient.DownloadString(url);

                    list.Add(getName(json));
                }
            }

            return list;
        }

        private string getName(string str) {
            string name;

            Console.WriteLine(str);
            JsonTextReader reader = new JsonTextReader(new StringReader(str));

            Console.WriteLine("yes");
            reader.Read();
            reader.Read();
            reader.Read();
            name = Convert.ToString(reader.Value);
            reader.Close();

            return name;
        }

        private void addList(List<String> list, StringBuilder builder) {
            foreach(string x in list) {
                builder.AppendLine("    " + x);
            }
        }

        private Result getCharacter(String name){
            using(var webClient = new System.Net.WebClient()) {
                String url = "https://swapi.co/api/people/?search=" + name;
                var json = webClient.DownloadString(url);

                RootObject gen = JsonConvert.DeserializeObject<RootObject>(json);

                return gen.results[0];
            }
        }
    }

    public class Result {
        public string name { get; set; }
        public string height { get; set; }
        public string mass { get; set; }
        public string hair_color { get; set; }
        public string skin_color { get; set; }
        public string eye_color { get; set; }
        public string birth_year { get; set; }
        public string gender { get; set; }
        public string homeworld { get; set; }
        public List<string> films { get; set; }
        public List<string> species { get; set; }
        public List<string> vehicles { get; set; }
        public List<string> starships { get; set; }
        public DateTime created { get; set; }
        public DateTime edited { get; set; }
        public string url { get; set; }


    }

    public class RootObject {
        public int count { get; set; }
        public object next { get; set; }
        public object previous { get; set; }
        public List<Result> results { get; set; }
    }
}
