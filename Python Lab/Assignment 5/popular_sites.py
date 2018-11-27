import operator

sites = {}

def load_file():
    logfile = "popular sites"

    f = open(logfile, "r")

    log = f.read().splitlines()
    f.close()

    return log


def add_site(site):
    log_entry = site.split()

    if log_entry[0] in sites:
        sites[log_entry[0]] = sites[log_entry[0]] + 1
    else:
        sites[log_entry[0]] = 1


def main():
    log = load_file()

    for i in log:
        add_site(i)

    ranking = sorted(sites.items(), key=operator.itemgetter(1), reverse=True)

    with open("Top 10 Sites.txt", "w",) as f:
        for i in range(0, 10):
            f.write((str)(ranking[i]) + "\n")


main()
