#include <stdio.h>
#include <stdlib.h>

// function prototype
void f1(int);
void f2(int* p); // 파라미터 적어도 되고 안적어도 됨

int main() {
  int a = 200;
  f1(a);
  printf("a = %d\n", a);
  
  f2(&a); // a의 주소
  printf("a = %d\n", a);
  
  return 0;
}

void f1(int a){
  a = 100;
}

void f2(int* p){
  *p = 100;
}