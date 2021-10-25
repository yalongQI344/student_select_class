#include <iostream>

#include <list>

using namespace std;


//学生是一个Observer类。当学生成绩发生改变时，为这些需获得通知的对象定义一个更新接口。
class Student

{

public:

    virtual void Update(int) = 0;

};

//老师是一个Subjets类，提供注册和删除观察者对象的接口。

class Teacher

{

public:

    virtual void Attach(Student*) = 0;

    virtual void Detach(Student*) = 0;

    virtual void Notify() = 0;

};



class Concrete_Student1 : public Student

{

public:

    Concrete_Student1(Teacher* pSubject) : m_pSubject(pSubject) {}



    void Update(int value)

    {

        cout << "Concrete_Student1 get the update. New Grade:" << value << endl;

    }



private:

    Teacher* m_pSubject;

};



class Concrete_Student2 : public Student

{

public:

    Concrete_Student2(Teacher* pSubject) : m_pSubject(pSubject) {}



    void Update(int value)

    {

        cout << "Concrete_Student2 get the update. New Grade:" << value << endl;

    }



private:

    Teacher* m_pSubject;

};



class Concrete_Teacher  : public Teacher

{

public:

    void Attach(Student* pObserver);    //允许观察者

    void Detach(Student* pObserver);    //删除观察者

    void Notify();



    void SetState(int grade)

    {

        m_gade = grade;

    }



private:

    std::list<Student*> m_ObserverList;

    int m_gade;

};



void Concrete_Teacher::Attach(Student* pObserver)

{

    m_ObserverList.push_back(pObserver);

}



void Concrete_Teacher::Detach(Student* pObserver)

{

    m_ObserverList.remove(pObserver);

}



void Concrete_Teacher::Notify()

{

    std::list<Student*>::iterator it = m_ObserverList.begin();

    while (it != m_ObserverList.end())

    {

        (*it)->Update(m_gade);

        ++it;

    }

}



int main()

{

    // Create Subject

    Concrete_Teacher* Teacher = new Concrete_Teacher();



    // Create Observer

    Student* pObserver = new Concrete_Student1(Teacher);

    Student* pObserver2 = new Concrete_Student2(Teacher);



    // Change the grade

    Teacher->SetState(2);



    // 管理该班级同学：

    Teacher->Attach(pObserver);

    Teacher->Attach(pObserver2);



    Teacher->Notify();



    // 删除某一位同学

    Teacher->Detach(pObserver);


    std::cout << "修改成绩，重新通知：" << endl;
    Teacher->SetState(3);

    Teacher->Notify();



    delete pObserver;

    delete pObserver2;

    delete Teacher;

}