def main():
    stack = []

    with open("Stack", "r") as f:
        for line in f:
            word = line.strip("\n")

            if word == "POP":
                stack.pop()
            else:
                stack.append(word)

        for i in stack:
            print(i)


main()
