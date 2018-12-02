import math as m

def main():
    a = int(input("Please input the coefficient a: "))
    b = int(input("Please input the coefficient b: "))
    c = int(input("Please input the coefficient c: "))

    try:
        x = (-b + m.sqrt(b**2 - 4 * a * c)) / (2 * a)
        y = (-b - m.sqrt(b**2 - 4 * a * c)) / (2 * a)

        if x == y:
            print("x = " + str(x))
        else:
            print("x = " + str(x) + " or " + str(y))

    except ValueError:
        print("Determinant is negative")
    except:
        print("Error")


main()
