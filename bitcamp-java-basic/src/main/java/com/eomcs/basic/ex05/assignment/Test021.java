package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//# 과제2 : 다섯 개의 정수 값을 입력 받고 최소, 최대 값을 구하라.
//실행 예)
//입력? 4 17 -1 6 9
//최소값: -1
//최대값: 17
//
public class Test021 {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in);
    
    System.out.print("입력? \n");
    int[] no = new int[5];
    int min;
    int max;
    
    for(int i =0; i<no.length; i++) {
    
        no[i]=keyInput.nextInt();
        keyInput.nextLine();
    }

    keyInput.close();
    
    if(no[0]<=no[1]){
      if(no[0]<=no[2]){
        if(no[0]<=no[3]){
          if(no[0]<=no[4]){
            min = no[0];
          } else {
            min = no[4];
          }
        } else {
          if(no[3]<=no[4]){
            min = no[3];
          } else {
            min = no[4];
          }
        }
      } else {
        if(no[2]<=no[3]){
          if(no[2]<=no[4]){
            min = no[2];
          } else {
            min = no[4];
          }
        } else {
          if(no[3]<=no[4]){
            min = no[3];
          } else {
            min = no[4];
          }
        }
      } 
    } else {
      if(no[1]<=no[2]){
        if(no[1]<=no[3]){
          if(no[1]<=no[4]){
            min = no[1];
          } else {
            min = no[4];
          }
        } else {
          if(no[3]<=no[4]){
            min = no[3];
          } else {
            min = no[4];
          }
        }
      } else {
        if(no[2]<=no[3]){
          if(no[2]<=no[4]){
            min = no[2];
          } else {
            min = no[4];
          }
        } else {
          if(no[3]<=no[4]){
            min = no[3] ;
          } else {
            min = no[4];
          }
        }
      }
    }
    
    if(no[0]>=no[1]){
      if(no[0]>=no[2]){
        if(no[0]>=no[3]){
          if(no[0]>=no[4]){
            max = no[0];
          } else {
            max = no[4];
          }
        } else {
          if(no[3]>=no[4]){
            max = no[3];
          } else {
            max = no[4];
          }
        }
      } else {
        if(no[2]>=no[3]){
          if(no[2]>=no[4]){
            max = no[2];
          } else {
            max = no[4];
          }
        } else {
          if(no[3]>=no[4]){
            max = no[3];
          } else {
            max = no[4];
          }
        }
      } 
    } else {
      if(no[1]>=no[2]){
        if(no[1]>=no[3]){
          if(no[1]>=no[4]){
            max = no[1];
          } else {
            max = no[4];
          }
        } else {
          if(no[3]>=no[4]){
            max = no[3];
          } else {
            max = no[4];
          }
        }
      } else {
        if(no[2]>=no[3]){
          if(no[2]>=no[4]){
            max = no[2];
          } else {
            max = no[4];
          }
        } else {
          if(no[3]>=no[4]){
            max = no[3] ;
          } else {
            max = no[4];
          }
        }
      }
    }
    
    System.out.printf("최소값: %d\n", min);
    System.out.printf("최소값: %d\n", max);
    
  }
}
