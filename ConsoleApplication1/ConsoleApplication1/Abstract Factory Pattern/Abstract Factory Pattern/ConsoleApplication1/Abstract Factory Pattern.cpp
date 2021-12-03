
//抽象工厂设计模式
/*
 简单实现了学号姓名密码和选课四个功能。
 先抽象了名字 身份号 密码 与 课程
 再具体名字 身份号 密码 与 课程

 然后定义抽象工厂，针对产品族
 具体工厂
*/
#include <iostream>
using namespace std;

//抽象名字
class AbstractName {
public:
	virtual void show() = 0;
};
//抽象身份号
class Abstractid {
public:
	virtual void show() = 0;
};
//抽象密码
class Abstractpasswd {
public:
	virtual void show() = 0;
};
//定义课程
char* course[]{"语文","数学","英语","体育","美术","音乐"};

//抽象选课
class AbstractCourse {
public:
	virtual void Course() = 0;
};

//学生
class StudentName :public AbstractName {
public:
	virtual void show(){
		cout << "学生姓名" << endl;
	}
};
class Studentid :public Abstractid {
public:
	virtual void show() {
		cout << "学生id" << endl;
	}
};
class Studentpasswd :public Abstractpasswd {
public:
	virtual void show() {
		cout << "学生密码" << endl;
	}
};

class StudentCourse :public AbstractCourse {
public:
	virtual void Course() {
		char n;
		cout << "选择课程：（语文、数学、英语、体育、美术、音乐）" << endl;
		cin >> n;
		cout << "您已选择课程" << n << endl;
	}
};

//老师
class TeacherName :public AbstractName {
public:
	virtual void show() {
		cout << "老师姓名" << endl;
	}
};
class Teacherid :public Abstractid {
public:
	virtual void show() {
		cout << "老师id" << endl;
	}
};
class Teacherpasswd :public Abstractpasswd {
public:
	virtual void show() {
		cout << "老师密码" << endl;
	}
};
class TeacherCourse :public AbstractCourse {
public:
	virtual void Course() {
		char n;
		cout << "选择课程：（语文、数学、英语、体育、美术、音乐）" << endl;
		cin >> n;
		cout << "您已选择课程" << n << endl;
	}
};

//管理员
class AdministratorName :public AbstractName {
public:
	virtual void show() {
		cout << "管理员姓名" << endl;
	}
};
class Administratorid :public Abstractid {
public:
	virtual void show() {
		cout << "管理员id" << endl;
	}
};
class Administratorpasswd :public Abstractpasswd {
public:
	virtual void show() {
		cout << "管理员密码" << endl;
	}
};

//抽象工厂 针对信息族
class AbstractFactory
{
public:
	virtual AbstractName* CreateName() = 0;
	virtual Abstractid* Createid() = 0;
	virtual Abstractpasswd* Createpasswd() = 0;
	virtual AbstractCourse* CreateCourse() = 0;
};
//学生工厂
class StudentFactory :public AbstractFactory {
public:
	virtual AbstractName* CreateName() {
		return new StudentName;
	}
	virtual Abstractid* Createid() {
		return new Studentid;
	}
	virtual Abstractpasswd* Createpasswd() {
		return new Studentpasswd;
	}
	virtual AbstractCourse* CreateCourse() {
		return new StudentCourse;
	}
};
//教师工厂
class TeacherFactory :public AbstractFactory {
public:
	virtual AbstractName* CreateName() {
		return new TeacherName;
	}
	virtual Abstractid* Createid() {
		return new Teacherid;
	}
	virtual Abstractpasswd* Createpasswd() {
		return new Teacherpasswd;
	}
	virtual AbstractCourse* CreateCourse() {
		return new StudentCourse;
	}
};

//管理员工厂
class AdministratorFactory :public AbstractFactory {
public:
	virtual AbstractName* CreateName() {
		return new AdministratorName;
	}
	virtual Abstractid* Createid() {
		return new Administratorid;
	}
	virtual Abstractpasswd* Createpasswd() {
		return new Administratorpasswd;
	}
};


void test01() {

	AbstractFactory* factory = NULL;
	AbstractName* name = NULL;
	Abstractid* id = NULL;
	Abstractpasswd* passwd = NULL;
	AbstractCourse* Course = NULL;

	factory = new StudentFactory;
	name = factory->CreateName();
	id = factory->Createid();
	passwd = factory->Createpasswd();
	Course = factory->CreateCourse();

	name->show();
	id->show();
	passwd->show();
	Course->Course();

	delete id;
	delete name;
	delete passwd;
	delete factory;
}


int main()
{
	test01();
}
