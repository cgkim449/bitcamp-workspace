#include <stdio.h>
#include <stdlib.h>

int main() {

  int i[3]; // 자바랑 다름
  i[0]=100;
  i[1]=200;
  i[2]=300;
  printf("%d %d %d\n", i[0], i[1], i[2]); 
  
  int* p;
  
  p = i; 
  // p = &i[0]; 배열이름 자체가 그 배열의 시작주소를 의미한다, 
  // i : read only 포인터변수(한번정하면 바꿀수 없다)
  
  printf("%d \n", *(p+2)); 
  // C에서는 주소에 연산을 할 수 있으나 자바는 안됨
  // 1 : 1단위로 증가하라(4byte로 증가하라)
  
  //--------------------------------------------------------
  
  //melloc : memory allocation
  
  int* p2 = (int*)malloc(12); 
  // (byte*)malloc(12);
  // malloc(sizeof(int)*3)
  // int배열의 주소!(위에랑 같다)
  
  *p2 = 110;
  *(p2+1) = 220;
  *(p2+2) = 330;
  printf("%d %d %d\n", *p2, *(p2+1), *(p2+2));

  printf("%d %d %d\n", p2[0], p2[1], p2[2]);
  // C는 포인터변수를 마치 배열처럼 사용할 수 있다
  
  printf("%d \n", *(p2+3)); 
  printf("%d \n", p2[3]); 
  // C의 문제1 : 잘못된 메모리에 접근한다
  // C는 내가 만들지 않은 다른 메모리에 엑세스해서 에러안뜨고 쓰레기값이 출력되거나, fault? 에러가 뜬다
  // 이 한계점을 극복하고자 Rust언어 만듬
  
  free(p2); // 꼭 반납해야한다(24시간 서버프로그램 등에서는)
  
  printf("%d %d %d\n", *p2, *(p2+1), *(p2+2));
  //C의 문제2 : 해제된 포인터에 접근한다
    
 
 /* int i1=100, i2=200, i3=300; 
  
  // 주소를 담는 변수 = 포인터
    int* p; //
  p = &i1; // i1의 주소를 놓아라  
  
  printf("%d(%x)--> %d \n", p, p, *p); 
  //*p : 주소로 찾아가서 그 메모리의 값을  
 
  p = &i2;   
  printf("%d(%x)--> %d \n", p, p, *p);  
  
  p = &i3;   
  printf("%d(%x)--> %d \n", p, p, *p);  
  
  *p= 500;
  printf("%d", i3);  */
  
  return 0;
  
}