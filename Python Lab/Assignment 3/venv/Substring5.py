#see if a is a substring of b
def substring(a,b):
    substring_length = len(a)
    for i in range(0, len(b)):
        if a == b[i:i + substring_length]:
            print("\"%s\" is a substring of \"%s\"" % (a,b))
            print("\t" + b[:i] + "[" + b[i: i + substring_length] + "]" + b[i + substring_length:])


strings = []

print("You will enter 5 strings below:")
strings.append(str(input("Please input a string: ")))
strings.append(str(input("Please input a string: ")))
strings.append(str(input("Please input a string: ")))
strings.append(str(input("Please input a string: ")))
strings.append(str(input("Please input a string: ")))

for x in strings:
    for y in strings:
        if x == y:
            continue
        substring(x,y)