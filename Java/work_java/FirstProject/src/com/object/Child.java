package com.object;
    
//부모 클래스, Super, base, Parent 클래스
class Parent{
    String name="Taek";
    String addr="here";
    //생성자
    Parent(){
        System.out.println("Parent 생성자");
    }
    String getName() {
        return name;
    }
    String getAddr() {
        return addr;
    }
    
}
//자식 클래스, sub, derived, child 클래스
public class Child extends Parent{
    String email="wosl0205@daum.net";
    //생성자
    Child(){
        System.out.println("Child 생성자");
    }
    //Method Overriding : 상속받은 메소드 중 자식 클래스에 맞게 재정의 하는일
    //리턴타입, 메소드 이름, 파라미터가 동일해야함
    String getName() {
        return "택진";
    }
    void callSuper() {
    	System.out.println(super.getName());
    }
    
    @Override
    String getAddr() {
        // TODO Auto-generated method stub
        return "요기";
    }
    
    public static void main(String[] args) {
        Parent c=new Child();
        
        System.out.println(c.getName());
        System.out.println(c.getAddr());
        //static 안에서는 this, super 키워드 사용불가
        
        //형변환
        Child c2 = (Child)c;
        c2.callSuper();
    }
}