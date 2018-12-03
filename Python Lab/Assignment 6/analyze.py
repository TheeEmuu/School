# region Minimum
def minimum(a):
    num = a[0]

    for x in a:
        if x < num:
            num = x

    return num
# endregion


# region Maximum
def maximum(a):
    num = a[0]

    for x in a:
        if x > num:
            num = x
    return num
# endregion


#region Kth Largest
def k_largest(a, num):
    x = sorted(a)

    ret = x[num]

    return ret
#endregion


#region Median
def median(a):
    x = sorted(a)

    if len(x) % 2 == 0:
        ret1 = x[int(len(x) / 2)]
        ret2 = x[ret1 - 1]

        ret = (ret1 + ret2)/2

    else:
        ret = x[int(len(x) / 2)]

    return ret
#endregion


#region Average
def average(a):
    total = 0
    for x in a:
        total += x

    return total / len(a)
#endregion


#region Standard Deviation
def standard_deviation(a):
    avg = average(a)

    deviation = 0
    for x in a:
        deviation += (x - avg)**2

    return (deviation / len(a))**(1/2)
#endregion