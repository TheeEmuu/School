

#ifndef PROJECT_8_BASE_H
#define PROJECT_8_BASE_H


class Base {
public:
    Base(int s);
    virtual ~Base();
    virtual void adjust();

    virtual double print();
private:
    int size;
};


#endif //PROJECT_8_BASE_H
