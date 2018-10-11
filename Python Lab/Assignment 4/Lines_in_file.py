def main():
    line_count = 0
    f = open("CountTheLines", "r")

    lines = f.readlines();
    for x in lines:
        line_count += 1

    print(line_count)

    f.close()


main()
