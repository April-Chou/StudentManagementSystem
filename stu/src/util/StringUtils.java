package util;

public  class StringUtils {
	
//	判断string是否为空和null
//	String的父类是CharSequence
//	判断最好的方法是== null或者length，因为equal效率低
//	另外要把null放在前面
//	写成static这样类名.方法就可以调用了
//	  在Java世界里，经常被提到静态这个概念，static作为静态成员变量和成员函数的修饰符，意味着它为该类的所有实例所共享，也就是说当某个类的实例修改了该静态成员变量，其修改值为该类的其它所有实例所见。最近一个项目里频繁用到static修饰的内部类，再读了一下《Effective Java》才明白为什么会用static来修饰一个内部类也就是本文的中心——静态类。
//
//	  如果一个类要被声明为static的，只有一种情况，就是静态内部类。如果在外部类声明为static，程序会编译都不会过。在一番调查后个人总结出了3点关于内部类和静态内部类（俗称：内嵌类）
//
//	1.静态内部类跟静态方法一样，只能访问静态的成员变量和方法，不能访问非静态的方法和属性，但是普通内部类可以访问任意外部类的成员变量和方法
//
//	 
//
//	2.静态内部类可以声明普通成员变量和方法，而普通内部类不能声明static成员变量和方法。
//
//	 
//
//	3.静态内部类可以单独初始化: 
//	写成静态方法
	public static boolean isEmpty(CharSequence sequence) {
		return sequence == null || sequence.length() == 0;
		
	}
	

}
