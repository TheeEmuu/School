string = input("Please input a string to be alphabetized: ")

translate = str.maketrans("","", ".,;:-\"/?")

string = str.translate(string, translate)
string = string.lower()

string = sorted(string.split(), key=str.lower)

for x in string:
    print(x, end=" ")