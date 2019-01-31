# JAVAWeb-Advanced
进阶
# 基础

标签（空格分隔）： 进阶
---

## 封装
<code>private</code>
- 不用封装的话直接调用属性进行赋值，当需要修改比如属性的类型时，会导致直接调用的全部要修改
- 如果用封装的话，可以在类当中修改
- 其他情况在set中加一些判断条件，然后供外部调用

## 继承
<code>extends</code>*向上转型*
- 子类继承父类，父类对子类来说是透明的
- 一般父类的属性用protected，子类在其他包也能够继承，这样继承破坏了封装，
- 子类不能继承父类的构造器，编译器会默认给子类调用父类的构造器（前提：父类有默认构造器）
- 如果父类没有默认构造器，我们就要必须显示的使用super()来调用父类构造器

## 多态
<code>Person person = new Man();</code>
- 在多态中必须存在有继承关系的子类和父类。
- private方法对子类不可见，如果子类定义了一个和父类private方法相同的方法，实为新增方法
- 定义了一个指向子类的父类引用类型，那么它除了能够引用父类的共性外，还可以使用子类强大的功能
- 对于子类中存在而父类中不存在的方法，该引用是不能使用的，尽管是*重载*(构造参数不同)该方法。
- 若子类*重写*（方法体改变）了父类中的某些方法，在调用该些方法的时候，必定是使用子类中定义的这些方法（动态连接、动态调用）

```
public class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

public class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }
}

public class C extends B{

}

public class D extends B{

}

public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));      
    }
}

1--A and A
2--A and A
3--A and D
4--B and A
5--B and A
6--A and D
7--B and B
8--B and B
9--A and D
```

---

## 四舍五入

- Math.round()：根据“round”的字面意思“附近、周围”，可以猜测该函数是求一个附近的整数，看下面几个例子就明白。

 - 小数点后第一位<5
正数：Math.round(11.46)=11
负数：Math.round(-11.46)=-11
 
 - 小数点后第一位>5
正数：Math.round(11.68)=12
负数：Math.round(-11.68)=-12
 
 - 小数点后第一位=5
正数：Math.round(11.5)=12
负数：Math.round(-11.5)=-11
总结：（小数点后第一位）大于五全部加，等于五正数加，小于五全不加。

- Math.ceil()：根据“ceil”的字面意思“天花板”去理解；
例如：
Math.ceil(11.46)=Math.ceil(11.68)=Math.ceil(11.5)=12
Math.ceil(-11.46)=Math.ceil(-11.68)=Math.ceil(-11.5)=-11
 
- Math.floor()：根据“floor”的字面意思“地板”去理解；
例如：
Math.ceil(11.46)=Math.ceil(11.68)=Math.ceil(11.5)=11
Math.ceil(-11.46)=Math.ceil(-11.68)=Math.ceil(-11.5)=-12
###Math.random()
指定范围的随机数[m,n]的公式：Math.random()*(n-m+1)+m；

## 序列号克隆
- clone()
- 利用序列化实现对象的拷贝
```
public class CloneUtils {
     @SuppressWarnings("unchecked")
     public static <T extends Serializable T clone(T obj){
         T cloneObj = null;
         try {
             //写入字节流
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             ObjectOutputStream obs = new ObjectOutputStream(out);
             obs.writeObject(obj);
             obs.close();

             //分配内存，写入原始对象，生成新对象
             ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
             ObjectInputStream ois = new ObjectInputStream(ios);
             //返回生成的新对象
             cloneObj = (T) ois.readObject();
             ois.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return cloneObj;
     }
 }
```

## 抽象类和接口
### 抽象类
- 定义的抽象类一定是用来继承的
- 抽象类不能被实例化，实例化的工作应该交由它的子类来完成，它只需要有一个引用即可。
- 抽象方法必须由子类来进行重写
- 只要包含一个抽象方法的抽象类，该方法必须要定义成抽象类，不管是否还包含有其他方法。
- 抽象类中可以包含具体的方法，当然也可以不包含抽象方法。
- 子类中的抽象方法不能与父类的抽象方法同名。
- abstract不能与final并列修饰同一个类。
### 接口
- Interface的所有方法访问权限自动被声明为public
- 接口中的“成员变量”会自动变为为public static final
- 实现接口的非抽象类必须要实现该接口的所有方法。抽象类可以不用实现。

 > 一个子类只能存在一个父类，但是可以存在多个接口
