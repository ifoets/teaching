package com.udemy.basic.generic.creation;

/***
 * A generic interface can implemented by a non generic class only if only
 * define the particular class/interface as a type parameter
 */

/* generic interface */
interface ISInterface<T> {
}

interface ISInter1<T> {
}

interface ISInter2 {
}

class SClass1<T> {

}

class SClass2 {

}

interface ISInterface3<T> {
}

class SClass3<T> implements ISInterface3<T> {

}

//public class SClass implements ISInterface<T>{
//here  <T> must be any defined class of interface

//public class SClass implements ISInterface<Integer> fine

//public class SClass extends SClass1<String> fine

//public class SClass extends SClass2 fine

//public class SClass extends SClass1<T> not fine

//public class SClass implements ISInterface<TISInter> TISInter is generic so not fine

//public class SClass implements ISInterface<ISInter2> this is fine ISInter2 is not generic

//public class SClass extends SClass1<String> implements ISInterface<Integer> fine

//public class SClass extends SClass1<String> implements ISInterface<String> fine

//public class SClass extends SClass1<ISInterface<Integer>> implements ISInterface<SClass1<String>> fine
//}

//public class SClass extends SClass1<ISInterface<Integer>> implements ISInterface<SClass1<String>> {

//}

/*
 * /* generic class can extends or implements a non generic type /* non generic
 * class
 */
//public class SClass<T> extends SClass1<ISInterface<Integer>> implements ISInterface<SClass1<String>> fine

//public class SClass<T> extends SClass1<ISInterface<T>> implements ISInterface<SClass1<T>> fine

//public class SClass<T> extends SClass1<ISInterface<X>> implements ISInterface<SClass1<Y>> not fine X Y must be type T

//public class SClass<T> extends SClass2 implements ISInter2 this is fine

//public class SClass<T> extends SClass1<T> implements ISInter2  fine

//public class SClass<T> extends SClass2 implements ISInterface<T> fine

//public class SClass<T> extends SClass3<T> implements ISInterface3<T> this is also fine
//here both SClass<T> and SClass3<T> implements ISInterface3<T>
//just the parameter Type must be same

//public class SClass<T> extends SClass3<T> implements ISInterface3<Integer> 
//or public class SClass<T> extends SClass3<T> implements ISInterface3<X>
//or public class SClass<T> extends SClass3<ISInterface3<T>> implements ISInterface3<SClass3<T>>
//these are not fine one palace SClass<T> saying implements Integer and other place SClass3<T> saying implements as MT>
//because of mismatch parameter these not work at all

//public class SClass<ISInterface1<T>> extends SClass3<ISInterface1<T>> implements ISInterface3<ISInterface1<T>>
//or public class SClass<Integer> extends SClass3<ISInterface1<T>> implements ISInterface3<ISInterface1<T>>
//not fine base class parameter should be non defined parameter
public class SClass<T> extends SClass3<T> implements ISInterface3<T> {
}