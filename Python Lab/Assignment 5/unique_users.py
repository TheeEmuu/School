import operator

users = {}
userSet = {}


def load_file():
    logfile = input("Please enter the name of the log file")

    f = open(logfile, "r")

    log = f.read().splitlines()
    f.close()

    return log


def add_site(site):
    log_entry = site.split()

    ip = log_entry[3]
    site = log_entry[0]

    if ip in users:
        if site not in userSet[ip]:
            users[ip] = users[ip] + 1
            userSet[ip].add(site)
    else:
        users[ip] = 1
        userSet[ip] = set()
        userSet[ip].add(site)

    # if ip in users:
    #     if site in userSet[ip]:
    #         users[ip] + 1
    #     else:
    #         users[ip] = 1
    #         userSet[ip].add(site)
    # else:
    #     users[ip] = 1
    #     userSet
    #     userSet[ip].add(site)




def main():
    log = load_file()

    for i in log:
        add_site(i)

    ranking = sorted(users.items(), key=operator.itemgetter(1), reverse=True)

    with open("Users.txt", "w",) as f:
        for i in ranking:
            f.write((str)(i) + "\n")


main()
