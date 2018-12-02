import Stack

stack = Stack.Stack()


def process_file():
    filename = "Input"

    with open(filename, "r") as x:
        for line in x:
            stack_process(line)


def stack_process(line):
    line = str(line.replace('\n', ""))
    if line == "POP":
        stack.pop()
    elif line == "TOP":
        print(stack.top())
    else:
        stack.push(line)


def print_contents():
    print("Stack Contents:")
    for x in range(0, stack.size()):
        print(stack.pop())


def main():
    process_file()
    print_contents()


main()
