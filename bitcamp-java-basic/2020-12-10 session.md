# Reflection API

## reflect/ex01/Exam01
```java
// Reflection API : 클래스 로딩
package com.eomcs.reflect.ex01;

class A {
  static int i;

  static void m() {
    i = 100;
  }

  static {
    System.out.println("A 클래스 로딩!");
  }
}


public class Exam01 {

  public static void main(String[] args) throws Exception {
    // 클래스 로딩
    // => 클래스가 로딩되어 있지 않다는 조건 하에서
    // 1) 클래스의 스태틱 멤버(변수,메서드,중첩클래스)를 사용할 때
    // 2) new 명령을 사용하여 인스턴스를 생성하려 할 때

    // 3) Class.forName()을 이용하여 임의로 클래스를 로딩할 때!
    //
    // 클래스 로딩 과정에서 하는 일
    // => 스태틱 변수를 준비한다.
    // => 스태틱 블록을 실행한다.

    // 하드에서 메서드 메모리(jvm의 메서드 에어리에 영역)에 A.class파일을 로딩 

    //    A.i = 100; // 클래스 로딩 확인!
    //    A.m(); // 클래스 로딩 확인!
    //    new A(); // 클래스 로딩 확인!
    //    new A(); // 클래스는 중복으로 로딩되지 않는다.
    //    Class.forName("com.eomcs.reflect.ex01.A");
    // 파라미터로 패키지명을 포함한 전체 클래스 이름을 지정해야 한다.
    // 패키지명을 포함한 전체 클래스 이름
    // = fully qualified class name
    // = FQName
    // = QName

    // A obj = null; // 레퍼런스 선언은 클래스 로딩과 상관 없다.
    // A[] arr; // 배열 레퍼런스 선언도 클래스 로딩과 상관 없다.
    // arr = new A[100]; // 레퍼런스 배열도 마찬가지로 클래스 로딩과 상관없다.

  }

}
```

## Exam02

```java
// Reflection API : 중첩 클래스 로딩
package com.eomcs.reflect.ex01;

public class Exam02 {

  static {
    System.out.println("Exam02 로딩됨!");
  }

  static class A {
    static int s_var = 100;
    int i_var = 200;

    static void s_m() {}

    void i_m() {}

    static {
      System.out.println("Exam02의 중첩클래스 A 로딩됨!");
    }
  }

  public static void main(String[] args) throws Exception {
    //    Class.forName("com.eomcs.reflect.ex01.Exam02");
    // => 바깥 클래스가 로딩되었다고 중첩 클래스가 자동으로 로딩되는 것은 아니다.

    // Class.forName("com.eomcs.reflect.ex01.Exam02$A");
    // bin 폴더를 봐라
    // => 중첩 클래스는 "바깥클래스명$중첩클래스명" 형식의 이름을 갖는다.
    // => 중첩 클래스를 로딩하려면 바깥 클래스를 알아야 하기 때문에
    // 이 경우 바깥 클래스도 로딩된다.
    // 주의!
    // => 중첩 클래스의 레퍼런스나 인스턴스를 생성할 때는 클래스 이름에 $를 붙이지 않고 .을 붙인다
    // com.eomcs.reflect.ex01.Ex02.A obj;
    // obj = new com.eomcs.reflect.ex01.Exam02.A();

    // Class.forName("com.eomcs.reflect.ex01.Exam02$A");
    // => 이미 바깥 클래스가 로딩되어 있다면 다시 로딩하지 않는다.
    // => 이미 중첩 클래스가 로딩되어 있다면 다시 로딩하지 않는다.

  }

}
```

## 3

```java
// Reflection API : 클래스 로딩과 "class"라는 스태틱 변수
package com.eomcs.reflect.ex01;

import java.io.File;

public class Exam03 {
  static class A {
    static int s_var = 100;
    int i_var = 200;

    static void s_m() {}

    void i_m() {}

    static {
      System.out.println("A 클래스 로딩!");
    }
  }

  public static void main(String[] args) throws Exception {
    //    Class clazz = A.class;
    // 자바의 모든 클래스는 "class"라는 특별한 스태틱 변수를 갖고 있다.
    // "class" 변수에는 해당 클래스의 정보를 담은 Class 객체의 주소가 저장되어 있다.
    // 즉 다음 코드와 같은 값을 리턴한다.
    //    Class clazz = Class.forName("com.eomcs.reflect.ex01.Exam03$A");
    // 위 두개는 결국 같다
    //
    // 하지만 이 방식으로 클래스를 로딩하면 static {} 블록을 실행하지 않는다.
    // 물론 스태틱 멤버를 사용하는 최초의 순간에는 static 블록이 실행될 것이기 때문에
    // "클래스 로딩 후 스태틱 블록 실행" 명제는 지켜진다.

    // 이 방법이 forName()을 호출하는 것 보다 안 좋은 이유는?
    // forName()의 파라미터는 문자열이다.
    // 즉 외부에서 문자열을 입력 받아 해당 클래스를 임의로 로딩할 수 있지만,
    // "class"라는 스태틱 변수를 사용하는 것은
    // 자바 소스 안에 명확히 해당 클래스를 지정(하드코딩)해야 하기 때문에
    // 임의로 다른 클래스를 로딩하는 코드를 작성할 수 없다.
    // 즉 다른 클래스를 로딩하고 싶으면 소스 코드를 다음과 같이 직접 변경해야 한다.

    Class clazz2 = String.class;
    Class clazz3 = System.class;
    Class clazz4 = File.class;
  }

}
```

```java
// Reflection API : 클래스 로딩과 "class"라는 스태틱 변수
package com.eomcs.reflect.ex01;

import java.util.Scanner;

class X {
  static {
    System.out.println("X 클래스 로딩");
  }
}


class Y {
  static {
    System.out.println("Y 클래스 로딩");
  }
}


class Z {
  static {
    System.out.println("Z 클래스 로딩");
  }
}


public class Exam04 {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    //    System.out.println("로딩할 클래스명을 입력하시오? ");
    //    String className = keyScan.nextLine();
    //    keyScan.close();

    // forName()은
    // 이렇게 프로그램 아규먼트나 키보드 입력을 통해
    // 클래스 이름을 입력 받아서 로딩할 수 있다.
    //    Class.forName(className);

    // 그러나 다음과 같이 "class" 변수를 사용하게 되면
    // 코드로 이름을 고정하기 때문에 임의의 클래스를 로딩할 수 없다.
    // 다른 클래스를 가져오려면 소스 코드를 변경해야 한다.
    Class clazz = Y.class;
  }

}



```

Y.class 로도 클래스 로딩?

## 2-1 클래스의 이름(정보)를 알아낼수잇다
```java
// 클래스 정보 추출 - 클래스 이름 알아내기
package com.eomcs.reflect.ex02;

public class Exam01 {

  static class A {}

  static Object obj = 


      public static void main(String[] args) throws Exception {
    // 알바없어 그냥 클래스 정보야 
    Class<?> clazz = Class.forName("java.lang.String");

    // 클래스의 타입 객체를 통해 클래스 정보를 추출할 수 있다.
    System.out.println(clazz.getSimpleName()); // String
    System.out.println(clazz.getName()); // java.lang.String
    System.out.println(clazz.getCanonicalName()); // java.lang.String
    System.out.println(clazz.getTypeName()); // java.lang.String

    System.out.println("----------------");

    // 2) 중첩 클래스
    // 알바없어 그냥 클래스 정보야 
    Class<?> clazz2 = Class.forName("com.eomcs.reflect.ex02.Exam01$A");

    // 클래스의 타입 객체를 통해 클래스 정보를 추출할 수 있다.
    System.out.println(clazz2.getSimpleName()); // A
    System.out.println(clazz2.getName()); // com.eomcs.reflect.ex02.Exam01$A
    System.out.println(clazz2.getCanonicalName()); // com.eomcs.reflect.ex02.Exam01.A
    System.out.println(clazz2.getTypeName()); // com.eomcs.reflect.ex02.Exam01$A

    // 3) 익명 클래스
    // 알바없어 그냥 클래스 정보야 
    Class<?> clazz3 = obj.getClass(); // 익명 클래스의 인스턴스로부터 클래스 정보 추출

    // 클래스의 타입 객체를 통해 클래스 정보를 추출할 수 있다.
    System.out.println(clazz3.getSimpleName()); // 없음
    System.out.println(clazz3.getName()); // com.eomcs.reflect.ex02.Exam01$1
    System.out.println(clazz3.getCanonicalName()); // null
    System.out.println(clazz3.getTypeName()); // com.eomcs.reflect.ex02.Exam01$1 

  }
}
```

## 2-2 그 클래스의 수퍼클래스 정보를 알아낼수있다
## 2-3 그 클래스의 public 중첩클래스 및 중첩?인터페이스 정보를 알아낼수있다
## 2-4 그 클래스의  모든 중첩 클래스 및 중첩?인터페이스 정보를 가져온다. 메서드 안에 정의된 로컬 클래스는 대상이 아니다.
## 2-5 그 클래스가 어떤 인터페이스를 구현했는지 알 수 있다
## 2-6 그 클래스의 패키지 정보를 알아낼수 있다



해당 메서드를 못찾으면 null이아니라 예외를 발생시킴

생성자를 못찾으면 null이 아니라 예외를 발생시킴

가변파라미터
(Object... ) 0개이상 넘기면 됨

-parameter 옵션없이 컴파일하면 원래이름을 알아낼수없다
[L 배열 표시(list)
[C character 배열



# Annotation
클래스 파일에 남길수있는 주석

용도
1 소스코드에서 특정 값을 쉽게 추출할 수 있다
 => 소스 코드에서 이 주석을 읽어 다른 소스 파일을 생성할 때 사용한다.
2 class 파일에 주석을 남길 수 있다.
=> 실행 시에 추출하여 사용할 수 있다.

CLASS
SOURCE
RUNTIME : 얘만 추출가능 : 실행중에 리플렉션api로 추출할수잇는 유일한애

프로퍼티를 지정하지 않아도 된다는것 : 프로퍼티가 없거나, 있다하더라도 기본값이 잇거나(예: @Controller)

프로퍼티명이 value일때는 이름 생략가능하다
예) ("홍길동")




- - - - - - - - - - - 
날짜 데이터를 파라미터로 받는 경우 ProjectController 를 참고하세요. 여러 개의 번호를 파라미터로 받는 경우에도 참고하세요.

- - - - - - - - - - - -

# Spring WebMVC 핵심 엔진
Front Controller : DispatcherServlet
- client 요청을 제어
  - 페이지 컨트롤러 실행
  - 뷰 컴포넌트 실행
  - 예외 처리
- MVC 아키텍쳐를 지원

IoC container : ApplicationContext
- 객체 생성 및 관리

# Spring IoC
inversion of control : 역제어
일반적인 명령어 실행은 위에서 아래로 순차적으로 실행한다 의 반대 : 역제어
순차적으로 실행한다 = 사용하는 쪽에서 객체를 준비한다
역제어 = 외부에서 사용할 객체를 제공한다, 특정 상태에 놓일 때 메서드가 호출된다

IoC의 예
1) DI             : 외부에서 주입 <=>사용하는 쪽에서 객체를 준비
2) Event Listener : 특정 상태에 놓일때 메서드가 호출 됨 <=> 개발자가 명시적으로 메서드 호출함
예) 리스너 : 서버가 시작되면 SC가 호출함? DS가 호출함?

페이지 컨트롤러에 서비스 객체를 AC가 아닌 DS가 주입함?

# SpringIoc에서 사용하는 기술

Spring WebMVC의 핵심 엔진
- DS
- AC

DS와 AC의 핵심 기술
- reflection API : 클래스 이름만 알고있으면 객체를 자동 생성
- Annotaion : 애노테이션에 따라서 메서드를 구분해서 호출함

# SpringIoC
SpringIoC Container가
어떻게 객체를 만드는지 어떻게 메서드를 호출하는지

나는 IoC컨테이너를 쓰고 싶다
근데 호출 규칙!이있다
그게 바로 ApplicationContext이다

IoC컨테이너는 Spring Framework의 설정정보를 읽는다 

강사님 ex01/a/Exam01 실행했는데
parserconfigurationException 뜸
난 안뜸
불필요한 implementation들 주석 막으심(build.gradle) -> 해결?

# SpringIoC 컨테이너와 XML 설정파일

SpringIoC 컨테이너는 객체 생성 및 관리를 한다
그래서 다른말로 BeanContainer라고 한다
SpringIoC 컨테이너는 *.XML또는 *.class에 있는
빈의 정보를 읽고 빈의 정보에 따라서 객체 생성을 한다

1. ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
        "com/eomcs/spring/ioc/ex01/a/application-context.xml");
중요한건 xml이 클래스패쓰에 있다
그리고 클래스패쓰이기때문에 루트부터 적어가면 된다

2. 클래스패쓰가 아닌 다른 폴더에 설정파일이 있을 경우
Exam02

3. 클래스에다 적어놧으니 읽어서 빈 생성해

AnnotationConfigApplicationContext는
애노테이션 처리에 필요한 도구 4개를 기본 포함
org.springframework.context.annotation.internalConfigurationAnnotationProcessor = 
org.springframework.context.annotation.ConfigurationClassPostProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor = 
org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
org.springframework.context.event.internalEventListenerProcessor = 
org.springframework.context.event.EventListenerMethodProcessor
org.springframework.context.event.internalEventListenerFactory = 
org.springframework.context.event.DefaultEventListenerFactory
설정파일 역할을 하는 Java Config 클래스의 객체도 포함
appConfig = com.eomcs.spring.ioc.ex01.d.AppConfig
총 5개
Java Config는 맨앞의 글자를 소문자로 하는 이름을 가진다

객체를 만들고 싶으면 객체를 만드는 메서드를 만들어놓고 @Bean 애노테이션을 붙이자
애노테이션을 떼면? 아무의미없는 메서드가 됨
Car 만들어서 c1이라는 이름으로 저장해
(e.Exam02)

f.Exam01 실행 오류 : 이중정의
Car, Engine 클래스 복사해서 f밑에 넣자
<context:component-scan base-package="com.eomcs.spring.ioc.ex01.f"/> 이렇게 .f를 붙이자(f라는 패키지만 한정해서 뒤져라)
Car Engine 클래스에 @Component 붙여라
설정이 참 어렵다
어제는 잘됐는데 오늘ㄹ은 또 안됨
Car Engine 문제가 아니엇음 Car Engine 지워라
문서로 가서 똑같은 소스코드 복붙해서 비교해라
한줄한줄 비교해라
xsd가 xml 태그 규칙을 담고 있는 파일이다
xml schema definition
      https://www.springframework.org/schema/beans/spring-beans.xsd
      https://www.springframework.org/schema/context/spring-context.xsd"
이런식으로 https를 붙여야됨

@Component가 붙은 클래스에 대해서만 객체 자동생성
그리고 자동생성 명령어가 
<context:component-scan base-package="com.eomcs.spring.ioc.ex01"/>
ex01 다뒤져서 클래스 선언부에 @Component 등의 애노테이션이 붙은 클래스를 찾아 인스턴스를 생성하여 보관한다

용어 : xml Config, java Config
jvm이 보는건 .class이지 .java가 아니다
.class에 애노테이션 들어있다
그걸 보고 생성하는거다

그럼 보관된 객체를 어떻게 꺼내냐
id나 타입을 파라미터로 주면 꺼낼 수 있다

보관소에 해당 이름의 객체가 없으면
NoSuchBeanDefinitionException
이렇게 예외를 발생함
null을 리턴하는게 아님

## ex02 객체 생성, id, 별명
### a
<bean> 태그 사용법

### b 

bean의 이름을 지정하는 다양한 방법
- id를 쓰던가 별명을 쓰던가 둘 중에 하나만 하자
bean의 별명을 알아내기
- String[] aliases = iocContainer.getAliases("c5"); // c5의 별명을 알아내라
bean의 별명을 알아내기: id만 설정한 경우
- 별명이 없다
bean의 별명을 알아내기: name만 설정한 경우
- 별명이 없다
bean의 별명을 알아내기: 별명만 여러 개인 경우
- 첫번째 별명이 id고 나머지가 별명이다
bean의 별명을 알아내기: 별명만 여러 개인 경우
- 별명을 지을 때 : 은 구분자로 사용할 수 없다
객체를 꺼낼때는 id나 별명 모두 사용할 수 있다

### c 
빈 생성 정책
- 설정안하면 디폴트가 singleton
빈 생성 정책 : singleton 객체
- 무조건 한개 미리 만들어놓고 끝
빈 생성 정책 : prototype 객체
- 미리만들어놓는게 아니고 getBean()할때마다 생성, 그래서 여러개 생성될수있다

### d
익명 객체의 이름
- => FQName#인덱스번호
- => 예) com.eomcs.spring.ioc.ex02.Car#0
- => 익명 객체의 수 만큰 인덱스 번호가 증가한다.
익명 객체의 별명
- 0번째만 별명 생긴다, 나머지는 안생김
  이때 별명은 com.eomcs.spring.ioc.ex02.Car 즉 FQName

## ex03 호출할 생성자를 지정할 수 있다 String!
### a
생성자 호출 확인
### b
생성자의 파라미터 값을 지정하는 방법 II
### c
생성자의 파라미터 값을 형변환 할 수 없는 경우 - 예외 발생
 org.springframework.beans.factory.UnsatisfiedDependencyException
### d
생성자의 파라미터 값을 지정하는 방법 III
- 타입을 지정할 수 는 없으나 실무에서 많이쓰는 방법


## ex04 프로퍼티 값 설정
http:// ... /beans : namespace(자바의 패키지)
이 namespace의 소속태그! : <bean>

xmlns = "http:// ... /beans" : 별명이 없으면 기본 네임스페이스로 사용한다
그래서 <beans>는 네임스페이스 생략하고 <beans>만 쓰는것
(마치 Java의 String 처럼)

네임스페이스 사용예 :
xmlns : okok = "http:// ... /beans/p"
<okok:소속태그>

### XML 네임스페이스와 XML Schema(네임스페이스에 소속된 태그의 정보)
스키마 = 규칙

### a 프로퍼티 값 지정하기
### b 프로퍼티 값 자동 형변환
java.lang.NumberFormatException: For input string: "aaa"
int를 넣어야되는데
// 프로퍼티의 타입이 int 일 경우 XML에 작성한 문자열이
// 자동으로 int 값으로 형변환된다.
// 만약 형변환할 수 없다면 예외가 발생한다.
// 자동 형변환은 primitive type에 대해서만 가능하다.
// 그 외의 타입에 대해서는 문자열을 자동 형변환하지 않는다.
// 형변환하고 싶으면 개발자가 형변환시키는 클래스를 만들어
// 스프링 프레임워크에 등록해야 한다.
### c 프로퍼티에 객체 주입하기
### d 프로퍼티 호출 - 객체 주입 시 객체 생성 순서
### e 의존 객체 주입할 때 즉시 객체 생성하기

<bean id="c1" class="com.eomcs.spring.ioc.ex04.Car">
        <property name="model" value="티코A"/>
        <property name="maker" value="비트자동차"/>
        <property name="cc" value="890"/>
        <property name="engine">
          <!-- id를 안줘도됨 -->
          <bean class="com.eomcs.spring.ioc.ex04.Engine">
            <property name="maker" value="비트자동차"/>
            <property name="valve" value="16"/>
            <property name="cylinder" value="8"/>
          </bean>
        </property>
    </bean>


## ex05 프로퍼티 값 설정
### a 컬렉션 타입의 프로퍼티 값 설정 - 배열
<array> 또는 <list> 사용

### b 컬렉션 타입의 프로퍼티 값 설정 - List<>
<array> 또는 <list> 사용

### c 컬렉션 타입의 프로퍼티 값 설정 - Map<,>
<key><value>sunroof</value></key> 주의

### d 컬렉션 타입의 프로퍼티 값 설정 - Properties
Properties는 객체를 저장할 수 없고 문자열을 저장함
<props>
                <prop key="sunroof">true</prop>
                <prop key="auto">true</prop>
                <prop key="color">black</prop>
                <prop key="blackbox">false</prop>
            </props>


## ex06 객체 생성
### a 팩토리 메서드를 통해 객체를 만들기 - static 메서드 호출
<!-- c1이라는 이름으로 Car 객체가 보관됨 -->
<bean id="c1"
          class="com.eomcs.spring.ioc.ex06.a.CarFactory"
          factory-method="스태틱메서드명">
  <constructor-arg value="티코"/>

팩토리 메서드가 스태틱 메서드여야한다! 중요

### b 팩토리 메서드를 통해 객체를 만들기 - static 메서드 호출 응용
<!-- "yyyy-MM-dd" 형식의 문자열을 가지고 java.sql.Date 객체 만들기 
         자바 코드:
         Date d1 = Date.valueOf("yyyy-MM-dd");
    -->
  <bean id="d1" class="java.sql.Date"
          factory-method="valueOf">
        <constructor-arg value="2020-03-20"/>
  </bean>

### c 팩토리 메서드를 통해 객체를 만들기 : 인스턴스 메서드 호출 
먼저 팩토리 객체를 만든다
      factory-bean="팩토리 객체 id"
      factory-method="메서드명"

### d 팩토리 메서드를 통해 객체를 만들기 : 스프링 규칙에 따라 만들기

```java
package com.eomcs.spring.ioc.ex06.d;

import org.springframework.beans.factory.FactoryBean;
import com.eomcs.spring.ioc.ex06.Car;

// 스프링 IoC 컨테이너가 정한 규칙에 따라 공장 클래스를 만들면,
// 구현할 때 복잡한 면이 있다.
// 하지만 빈 생성을 설정할 때는 기존 방식 보다 쉽다.
//
// 스프링에서 공장 클래스를 만들 때 제안한 규칙?
// => org.springframework.beans.factory.FactoryBean 인터페이스
//
public class CarFactory implements FactoryBean<Car> {

  String model;

  public CarFactory() {
    System.out.println("CarFactory() 생성자 호출됨.");
  }

  public void setModel(String model) {
    System.out.println("CarFactory.setModel() 호출됨.");
    this.model = model;
  }

  /*
   * 파라미터가 없고 예외를 던진다
   */
  @Override
  public Car getObject() throws Exception {
    System.out.println("CarFactory.getObject() 호출됨.");
    // 객체를 생성해서 리턴하는 팩토리 메서드이다.
    // 스프링 IoC 컨테이너는 이 메서드를 호출할 것이다.
    // 이 방식으로는 객체를 생성할 때 추가적으로 필요한 값을 파라미터로 받을 수 없기 때문에
    // 프로퍼티로 받도록 해야 한다.
    Car c = new Car();
    switch (model) {
      case "티코":
        c.setMaker("대우자동차");
        c.setModel("Tico");
        c.setCc(890);
        return c;
      case "소나타":
        c.setMaker("현대자동차");
        c.setModel("Sonata");
        c.setCc(1980);
        return c;
      case "SM5":
        c.setMaker("르노삼성자동차");
        c.setMaker("SM5");
        c.setCc(1990);
        return c;
      default:
        c.setMaker("비트자동차");
        c.setModel("자바휘웅");
        c.setCc(5000);
        return c;
    }
  }

  /*
   * 얘도 오버라이딩 해야됨
   * 얘를 호출해서
   * 야 너 타입이 뭐야
   * Car.class를 리턴해주자
   */
  @Override
  public Class<?> getObjectType() {
    // getObject()가 생성해주는 객체의 타입 정보를 리턴한다.
    // 이 메서드는 Spring IoC 컨테이너가 타입으로 객체를 찾을 때 사용한다.
    System.out.println("CarFactory.getObjectType() 호출됨.");
    return Car.class;
  }
}
```

<!-- 조심!! CarFactory객체를 만들어서 c1이라고 보관하는구나가 아니다
그럴수도 있고 아닐수도있다
만약 얘가 FactoryBean 인터페이스를 구현한 애라면
그래서 헷갈리지 않게 하기위해서
e : FactoryBean-->
<bean id="c1" class="com.eomcs.spring.ioc.ex06.d.CarFactory">
        <property name="model" value="소나타"/>
    </bean>


### e 팩토리 메서드를 통해 객체를 만들기 : FactoryBean 구현체
<!-- 클래스 이름이 FactoryBean으로 끝나면 
         그 클래스가 FactoryBean 구현체임을 쉽게 눈치챌 수 있다. -->
  <bean id="c1" class="com.eomcs.spring.ioc.ex06.e.CarFactoryBean">
      <property name="model" value="소나타"/>
  </bean>
  <!-- 자바 코드:
          CarFactoryBean carFactory = new CarFactoryBean();
          carFactory.setModel("소나타");
          
          // FactoryBean의 구현체 여부에 따라 "c1" 이라는 이름으로 저장할 객체가 다르다.
          if (carFactory instanceof FactoryBean) {
              objPool.put("c1", carFactory.getObject());
          } else {
              objPool.put("c1", carFactory);
          }
  -->

## ex07
### a 프로퍼티 에디터 - 기본으로 내장된 프로퍼티 에디터
필드가 Date 타입같이 primitive 타입이 아니면?
org.springframework.beans.factory.BeanCreationException
org.springframework.beans.ConversionNotSupportedException
no matching editors or conversion strategy found
자동으로 형변환 해주지 못한다
아니 conversion strategy가 없으면 안넣어주면되지 그런게 아니고 예외를 발생시킨다
즉 스프링 IoC 컨테이너에 String을 Date으로 바꾸는 변환기가 설치되어 있지 않다.

프로퍼티 에디터?
    => String 값을 다른 타입의 값으로 변환하는 객체
    => 개발자가 프로퍼티 에디터를 만들어 등록해야 한다.

### b 프로퍼티 에디터 - String ==> java.sql.Date ; 변환기 없이 처리하기
<!-- String을 java.sql.Date 객체로 바꿔주는 변환기가 없기 때문에
                 직접 Date 객체를 생성해야 한다. (위에서 한 팩토리 메서드)
                 단, 이방식은 날짜 프로퍼티 값을 설정할 때마다 
                 매번 작성해야 하기 때문에 불편하다. 
                 해결책? String을 java.sql.Date 객체로 변환해주는
                 프로퍼티 에디터를 등록하면 된다.-->
### c 프로퍼티 에디터 - 프로퍼티 에디터 만들기, String ==> java.sql.Date ; 변환기 사용하여 처리하기

PropertyEditorSupport 얘만들었으니까 얘 상속받아서 관심잇는 메서드만 오버라이딩하라
setAsText만 오버라이딩하면된다
setValue, getValue는 안해도됨

```java
// 프로퍼티 에디터 만들기
package com.eomcs.spring.ioc.ex07.c;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

// 프로퍼티 에디터 만드는 방법
// => java.beans.PropertyEditor 인터페이스를 구현하면 된다.
// => 그러나 이 인터페이스를 직접 구현하려면 많은 메서드(12개의 메서드)를 모두 구현해야 한다.
// 너무 번거롭다.
// => 그래서 자바는 PropertyEditor를 미리 구현한 PropertyEditorSupport 라는 클래스를 제공한다.
// 따라서 인터페이스를 직접 구현하지 말고 이 클래스를 상속 받아라!
//
// 1) java.beans.PropertyEditorSupports를 상속 받는다.
//
public class CustomDateEditor extends PropertyEditorSupport {
  // 이 메서드는 스프링 IoC 컨테이너가 String 타입의 프로퍼티 값을
  // 다른 타입의 값으로 바꿀 때 호출하는 메서드이다.
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    System.out.println("CustomDateEditor.setAsText()");
    // 파라미터로 넘어온 String 타입의 프로퍼티 값을
    // 원하는 타입(java.sql.Date)의 값으로 바꿔 내부에 저장한다.
    // => 그러면 스프링 IoC 컨테이너를 이 값을 꺼내서 객체에 주입할 것이다.
    this.setValue(Date.valueOf(text));
  }

  // 언제 어떤 메서드가 호출되는지 확인하기 위해 상속 받은 메서드를 오버라이딩 해보자!
  @Override
  public void setValue(Object value) {
    // 이 메서드는 호출되었을 때 그것을 표시하기 위해 오버라이딩 했다.
    System.out.println("CustomDateEditor.setValue()");
    super.setValue(value); // 원래 하던 일을 수행한다.
  }

  @Override
  public Object getValue() {
    // 이 메서드는 호출되었을 때 그것을 표시하기 위해 오버라이딩 했다.
    System.out.println("CustomDateEditor.getValue()");
    return super.getValue(); // 원래 하던 일을 수행한다.
  }
}
```

<!--  String을 이 클래스로 바꾸려면
	                                        이 클래스를 사용해라-->
	            <entry key="java.sql.Date" 
	                   value="com.eomcs.spring.ioc.ex07.c.CustomDateEditor"/>
### d 프로퍼티 에디터 - 프로퍼티 에디터 만들기, String ==> Engine ; 프로퍼티 에디터 변환기를 사용하여 처리하기
<property name="engine" value="비트자동차,16,4"/>
이렇게 ,로 구분된 문자열로 처리하고싶다?
이런식으로 프로퍼티 에디터를 우리 맘대로 만들수있다
문자열이 넘어가면 
,로 잘라서
setValue로 engine객체를 보관하면된다

그래서 프로퍼티 에디터를 만들줄알면
문자열로 아주 간결하게 할 수 있다!

```java
public class CustomEngineEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
String[] values = text.split(",");

    Engine engine = new Engine();
    engine.setMaker(values[0]);
    engine.setValve(Integer.parseInt(values[1]));
    engine.setCylinder(Integer.parseInt(values[2]));

    this.setValue(engine);
```

- - -
 
## ex08 의존 객체 주입 자동화하기
드디어 애노테이션 방법을 소개하게된다  @Autowired!! 의존 객체 주입!!
### a 의존객체 수동 주입 : 자동화 전, XML 설정을 통한 수동 주입이 귀찮다!!!
### b 의존객체 주입 자동화기능!!!! - 셋터에 @Autowired 애노테이션 붙이기
자동화 기능을 할 객체!!!를 등록해라
AutowiredAnnotationBeanPostProcessor이다
BeanPostProcessor를 구현한 객체다
사용방법 : 
셋터 메서드 또는 필드에 @Autowired를 붙이면 된다
@Autowired 애노테이션을 셋터 메서드에 붙였다고 해서 
의존 객체가 자동 주입되는 것이 아니다.
@Autowired 애노테이션이 붙은 셋터에 대해
프로퍼티 값을 자동으로 주입하는 일을 할 객체를 등록해야 한다.

<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
        <!-- Engine 객체를 주입하지 않는다. -->
        <!--  
        <property name="engine" ref="e1"/>
        -->

저거 추가하고 저거 뺀거밖에 차이가 없는데 의존객체가 자동으로 주입됐다

- - -

### c1 Spring IoC 컨테이너에 새 기능!을 추가하고싶다, 근데 새 기능이 IoC 컨테이너가 생성한 객체!!!를 사용해야 한다
빈 생성하고 뭔가를 하고싶다

객체 생성 후에 그 작업을 수행하면 된다!
=> 이렇게 개발자가 컨테이너의 기능을 확장!할 수 있도록
BeanPostProcessor라는 규칙을 제공!한다(BeanPostProcessor객체생성 후처리기)
예) AutowiredAnnotationBeanPostProcessor : 

XML 설정에서 init-method 속성에 지정된 메서드(Car의 init)가 호출되기 전에
postProcessBeforeInitialization 호출되고
XML 설정에서 init-method 속성에 지정된 메서드가 호출된 후에
postProcessAfterInitialization 호출됨

// bean을 생성할때마다 BeanPostProcessor은 호출됨
// 그래서 앱을 실행하면 BeanPostProcessor을 가장 먼저 미리 만들어놓는다
// 그다음에 다른 bean 생성
MyBeanPostProcessor()
Car()
Car.setModel()
Car.setMaker()
Car.setCc()
Car.setAuto()
postProcessBeforeInitialization()
    => c1 : com.eomcs.spring.ioc.ex08.c1.Car
    => Car [model=티코, maker=비트자동차, cc=890, auto=true, createdDate=null, engine=null]
Car.init()
postProcessAfterInitialization()
    => c1 : com.eomcs.spring.ioc.ex08.c1.Car
    => Car [model=티코, maker=비트자동차, cc=890, auto=true, createdDate=null, engine=null]
Engine()
Engine.setMaker()
Engine.setValve()
Engine.setCylinder()
postProcessBeforeInitialization()
    => e1 : com.eomcs.spring.ioc.ex08.c1.Engine
    => Engine [maker=비트자동차, valve=16, cylinder=4]
Engine().init()
postProcessAfterInitialization()
    => e1 : com.eomcs.spring.ioc.ex08.c1.Engine
    => Engine [maker=비트자동차, valve=16, cylinder=4]





### c2 BeanPostProcessor 인터페이스 구현체 만들고 등록하기
IoC 컨테이너가 빈을 생성할 때 마다! 로그를 출력하는! 기능을 만들고 싶다!!!
=> LogBeanPostProcessor 를 만들어 처리한다.

  <!-- 등록 -->
  <bean class="com.eomcs.spring.ioc.ex08.c2.LogBeanPostProcessor"/>
  <!-- id를 줄 필요가없다 id를 내가 사용할일이 없기때문이다 중요한건 등록하는것 -->

### c3 BeanPostProcessor를 이용하여 @Autowired 애노테이션 처리하기
우리만의 MyAutowiredAnnotationBeanPostProcessor 를 만들었으니 참고하라

- - -

### d 의존 객체 주입 자동화하기 - 인스턴스 필드에 @Autowired 애노테이션 붙이기
private 이라도 상관없다.(reflection api 사용하면 되기 때문!)

캡슐화(즉 외부에서 직접 인스턴스 변수에 접근하는 것을 막는 기법)를 위배하는 측면이 있기 때문에
이 방식은 "객체지향을 파괴하는 방식"이라는 비난을 받는다.

### e 의존 객체 주입 자동화하기 - 생성자를 이용하여 의존 객체 주입

Spring IoC 컨테이너로부터 생성자로!! 의존 객체를 주입 받고 싶다면,
그 의존 객체를 생성자에 파라미터로! 선언하라.
@Autowired 는 붙일 필요가 없다. (붙여도 된다)
주의!
=> 이 일 또한 AutowiredAnnotationBeanPostProcessor 객체가 처리한다.


생성자를 통해 의존 객체 주입하기
      => @Autowired 나 @Resource를 사용할 필요가 없다.
      => 스프링 전문가들 사이에서는 이 방식을 권고하기도 한다.
      왜?
생성자의 파라미터로 선언하면 해당 의존 객체!가 필수 항목!!!이 된다.
왜냐면 그 의존객체 없이 생성자를 호출할수 없기 때문이다!
=> 기본 생성자가 없으면! 파라미터를 받는 다른 생성자를 호출하여 의존 객체를 자동주입하려면 그! 객체를 등록해야 한다.
   바로 AutowiredAnnotationBeanPostProcessor
   얘가 이 역할도 한다
### f 의존 객체 주입 자동화하기 - 필수 의존 객체와 선택 의존 객체
org.springframework.beans.factory.UnsatisfiedDependencyException
org.springframework.beans.factory.NoSuchBeanDefinitionException
: 필수의존객체가 없다
### g 의존 객체 주입 자동화하기 - 같은 타입의 의존 객체가 여러개 있을 때 여러개중에서 한개의 의존객체를 지정하는 방법
저번기수에 안떳던 갑자기 org.xml.sax.SAXParseException 뜬다 이건 xml이 잘못됐다는것
xsi:schemaLocation="http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context
https://www.springframework.org/schema/context/spring-context.xsd"

https 붙이는데 namespace에는 안붙여도된다 url만 붙이자

에러
expected single matching bean

xmlns:context="http://www.springframework.org/schema/context"
<context:annotation-config/>
추가했더니

org.springframework.context.annotation.internalConfigurationAnnotationProcessor = 
org.springframework.context.annotation.ConfigurationClassPostProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor = 
org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
org.springframework.context.event.internalEventListenerProcessor = 
org.springframework.context.event.EventListenerMethodProcessor
org.springframework.context.event.internalEventListenerFactory = 
org.springframework.context.event.DefaultEventListenerFactory

우리가 xml읽는게아닌 AppConfig읽을때 자동으로 생성(ex01.Exam02)됐던 4가지 애들이 생성된다


### h 의존 객체 주입 자동화하기 - @Resource = @Autowired + @Qualifier
@Resource(name = "e1")

@Resource 라이브러리 추가해서 gradle eclipse하고 실행했더니
CommonAnnotaion까지 5개됨

- - -


이때까지 xml이었다면
지금부터는 애노테이션이다
## ex09
### a 객체 자동 생성 - @Component 애노테이션
// @Component
// => 스프링 IoC 컨테이너는 이 애노테이션이 붙은 클래스에 대해 객체를 자동 생성한다.
근데 누구 맘대로 자동 생성함?
자동 생성을 하는 애(객체)가 있어야됨!!
<!-- 애노테이션을 처리할 도우미 객체를 등록한다. -->
    <context:annotation-config/>

@Component : 이 객체 만들어서 보관해줘

@Component : 
만약 다음과 같이 객체의 이름을 생략하면 클래스 이름을 객체 이름으로 사용한다.
예) bitcamp.java106.step09.Car => "car"
@Bean일때는 이름? 안지으면 #0되는데
@Component는 아님

@Component("ok")
public class Engine {
}


// 의존 객체는 생성자에서 주입하는 것이 좋다. 
// 의존 객체라는 말에서 이미 그 객체없이는 작업을 수행할 수 없다는 의미이기 때문에 
// 보통 필수 객체이다.
// 따라서 생성자에서 필수 객체를 받게 하는 것이 유지보수에 좋다.
// 즉 의존 객체없이 해당 객체를 생성하는 일을 방지할 수 있다.
  public Car(Engine engine) {
    this.engine = engine;
  }

- - -
b~f xml 똑같음(BeanPostProcessor명이랑 init-method 다를뿐)
a는 수동으로 주입하는 태그 한줄 더 있음

의존객체를 주입하는 방법
- 수동
- 자동 (AutowiredAnnotationBeanPostProcessor) : 의존객체주입 자동화 기능
  - Autowired 안씀 -> 생성자에서
  - Autowired 필드에 선언 : 가장많이씀
  - Autowired 셋터에 선언


  // 의존 객체는 생성자에서 주입하는 것이 좋다. 
  // 의존 객체라는 말에서 이미 그 객체없이는 작업을 수행할 수 없다는 의미이기 때문에 
  // 보통 필수 객체이다.
  // 따라서 생성자에서 필수 객체를 받게 하는 것이 유지보수에 좋다.
  // 즉 의존 객체없이 해당 객체를 생성하는 일을 방지할 수 있다.


### b <context:annotation-config> 태그 생략하기
<!-- component-scan 태그를 추가하면 
         내부적으로 annotation-config 태그가 자동으로 추가된다. 
         따라서 다음과 같이 명시할 필요가 없다. -->
<!-- 
    <context:annotation-config/> 
-->
- - -

### c 객체 자동 생성 - 특정 패키지의 클래스에 대해 객체 생성하지 않기

- - -

## ex10
xmlconfig 대신 java config를 쓰자
### a 클래스를 이용하여 스프링 설정하기 java Config!!! 파일안에 팩토리메서드!!!!!!
@Component 이거 안붙혔는데도 자동으로 AppConfig가 생성됐다
public class AppConfig {
}

 @Component와 같은 애노테이션을 사용할 수 없는 경우
  // Java Config 에서 수동으로 객체를 생성할 수 있다.
  // 방법:
AppConfig.java를 만들어서
  // 1) 객체를 생성하여 리턴하는 메서드를 정의한다.
  // 2) 그리고 그 메서드에 @Bean 애노테이션을 붙인다.

    // @Bean 애노테이션을 붙이면,
  // 스프링 IoC 컨테이너(AnnotationConfigApplicationContext)는
  // 해당 메서드를 호출하고, 그 메서드가 리턴한 객체를 컨테이너에 보관한다.
  // 컨테이너에 보관할 때 객체의 이름은
  // @Bean(객체이름) 에노테이션에 설정된 이름을 사용한다
  // 만약 @Bean 애노테이션에 이름이 없으면,
  // 메서드 이름!!을 사용한다
  그래서 실무에서는 메서드 이름을 만들 클래스의 이름으로(명사로) 한다

### b 클래스를 이용하여 스프링 설정하기 - @Configuration 애노테이션
ApplicationContext iocContainer = //
        new AnnotationConfigApplicationContext(//
            "com.eomcs.spring.ioc.ex10.b");
    // a와 다르게 클래스명이아닌 패키지명을 줬다
    java Configure 파일 이 패키지에 있어

    그리고 App Config에 @Configuration붙여야함
    이걸 떼고 실행하면
    빈이 아무것도 안만들어진다!
    저게 java Configure 파일인지 못알아봐서다!
    패키지명을 지정하면 해당 패키지의 모든 클래스를 찾는다

### c 클래스를 이용하여 스프링 설정하기 - @PropertySource 애노테이션

.propeties파일의 데이터를 쓰고싶다!
1. 통째로 쓰고싶으면 env 객체를 주입받아라 - this.env.getProperty("jdbc.username") 으로 env에서 key로 value값을 꺼낼수있다
2. 특정필드값을 쓰고 싶으면 @Value를 써라 - 필드, 파라미터에 주입할 수 있다


//  @PropertySource 애노테이션을 사용한다.
// => .properties 파일을 메모리에 로딩하는 일을 한다
// => 파일 경로가 클래스 경로!!!!!!를 가리킨다면, 파일 경로 앞에 "classpath:" 접두어를 붙여라
@PropertySource({//
  "classpath:com/eomcs/spring/ioc/ex10/c/jdbc.properties", //
"classpath:com/eomcs/spring/ioc/ex10/c/jdbc2.properties"})

// @PropertySource를 통해 로딩된 프로퍼티 값을 사용하고 싶다면
  // Environment 타입의 객체를 주입 받아라!

  @Autowired
  Environment env;
  야 스프링 IoC 컨테이너 Environment 객체좀 꽂아줘

  // @PropertySource를 통해 로딩된 프로퍼티 값 중에서 특정 값만 필드로 주입 받을 수 있다.
  // => 필드 선언에 @Value 애노테이션을 붙인다.
  // => @Value("${프로퍼티이름}")
  @Value("${jdbc.url}")
  String jdbcUrl;
  // 이렇게 필드!에 주입받을수있다

  @Value("${jdbc2.url}")
  String jdbc2Url;

  @Bean
  public Car car(//
  // 이렇게 파라미터!에 주입받을수있다
      @Value("${jdbc.username}") String username, //
      @Value("${jdbc.password}") String password) {

    System.out.println("car() 호출 :");
    System.out.println("  " + username);
    System.out.println("  " + password);
    return new Car(null);
  }

- - -

## ex11 클래스를 이용하여 스프링 설정하기 - @ComponentScan 사용법

- - -
## ex12 마이바티스 설정
## ex13 AOP 설정
둘다 지금 할 필욘 없다
- - -

# minipmsserver

누가?!!!!!!!!!!!!!!! 누가 패키지 다 뒤져서 객체 만든다? 누가 IoC Container다?
DispatcherServlet이! 얘는 IoC Container(ApplicationContext 구현체)는 아니다
DispatcherSErvlet안에서 IoC Container를 사용한다
DispatcherServlet 소스 뒤져봐라 IoC Container있을거다
없는데요?
슈퍼클래스에 있겠지
WebApplicationContext
뭔가 web기능을 가지고 있는 애겠지
계속 찾아보니까 ApplicationContext 상속한 인터페이스네(서브인터페이스)
얘를 구현한 애가 바로 IoC Container네

- - -
2020/12/15

IoC Container = Bean Container + DI
: 객체 효율적으로 관리 
- 가비지 최소화
- 객체 사용을 쉽게

p,c,xls? 기억

- - - -
