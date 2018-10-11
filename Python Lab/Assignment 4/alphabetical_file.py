while True:
    try:
        file_name = input("Please input a file to be opened: ")
        f = open(file_name, "r")
        break
    except IOError:
        print("Error: Couldn't find file, please try again.\n\n")
        continue

words_in_file = f.read().split(" ")
f.close()
no_dupes = []
for x in words_in_file:
    if x not in no_dupes:
        no_dupes.append(x)

string = ""
for x in no_dupes:
    string += (x + " ")

translate = str.maketrans("", "", ".,;:-\"/?")

string = str.translate(string, translate)
string = string.lower()

string = sorted(string.split(), key=str.lower)

for x in string:
    print(x, end=" ")
