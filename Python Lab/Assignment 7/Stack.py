class Stack:
    def __init__(self):
        self.x = list()
        self.count = 0

    def push(self, a):
        self.x.append(a)
        self.count += 1

    def pop(self):
        ret = self.x.pop()
        self.count -= 1
        return ret

    def top(self):
        return self.x[self.count - 1]

    def size(self):
        return self.count
