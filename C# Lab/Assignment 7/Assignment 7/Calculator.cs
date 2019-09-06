using System;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;

namespace Assignment_7{
    public partial class Calculator : Form{
        TextBox in1;
        TextBox in2;
        TextBox output;

        Button add;
        Button subtract;
        Button multiply;
        Button divide;

        public Calculator(){
            #region TextBoxes
            in1 = new TextBox();
            in2 = new TextBox();
            output = new TextBox();

            in1.Size = new Size(80, 40);
            in1.Location = new Point(30, 30);
            this.Controls.Add(in1);

            in2.Size = new Size(80, 40);
            in2.Location = new Point(60 + 80, 30);
            this.Controls.Add(in2);

            output.Size = new Size(80, 40);
            output.Location = new Point(75, 60);
            this.Controls.Add(output);
            output.ReadOnly = true;
            #endregion

            #region Buttons   
            add = new Button();
            subtract = new Button();
            multiply = new Button();
            divide = new Button();

            Size buttonSize = new Size(40, 40);
            add.Size = buttonSize;
            subtract.Size = buttonSize;
            multiply.Size = buttonSize;
            divide.Size = buttonSize;

            add.Location = new Point(30, 80);
            subtract.Location = new Point(80, 80);
            multiply.Location = new Point(30, 130);
            divide.Location = new Point(80, 130);

            add.Text = "+";
            subtract.Text = "-";
            multiply.Text = "x";
            divide.Text = "/";

            this.Controls.Add(add);
            this.Controls.Add(subtract);
            this.Controls.Add(multiply);
            this.Controls.Add(divide);

            add.Click += new EventHandler(add_Click);
            subtract.Click += new EventHandler(subtract_Click);
            multiply.Click += new EventHandler(multiply_Click);
            divide.Click += new EventHandler(divide_Click);
            #endregion
        }

        private void add_Click(object sender, EventArgs e){
            int a = int.Parse(in1.Text);
            int b = int.Parse(in2.Text);

            output.Text = Convert.ToString(a + b);
        }

        private void subtract_Click(object sender, EventArgs e) {
            int a = int.Parse(in1.Text);
            int b = int.Parse(in2.Text);

            output.Text = Convert.ToString(a - b);
        }

        private void multiply_Click(object sender, EventArgs e){
            int a = int.Parse(in1.Text);
            int b = int.Parse(in2.Text);

            output.Text = Convert.ToString(a * b);
        }

        private void divide_Click(object sender, EventArgs e){
            double a = double.Parse(in1.Text);
            double b = double.Parse(in2.Text);

            output.Text = Convert.ToString(a / b);
        }

        [STAThread]
        public static void Main(){
            Application.EnableVisualStyles();
            Application.Run(new Calculator());
        }
    }
}
