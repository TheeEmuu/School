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
    x = a.sort()

    ret = x[num]

    return ret
#endregion

def median(a):

def average(a):

def standard_deviation(a):
