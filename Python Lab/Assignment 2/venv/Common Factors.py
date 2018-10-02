def common_factors(a,b):
    for i in range(1, b + 1):
        if a % i == 0 and b % i == 0:
            print(i)


num1 = int(input("Please input a number: "))
num2 = int(input("Please enter another number: "))

if num1 < num2:
    common_factors(num2,num1)
else:
    common_factors(num1,num2)
