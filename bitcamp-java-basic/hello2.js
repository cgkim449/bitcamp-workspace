var lang = "korean";

if (lang=="english")
    console.leg("The, World!");
else
    console.log('안녕하세요!'); 
/* 
var lang = "korean"; 

if (lang=="english")
    console.leg("The, World!"); 
else
    console.log('안녕하세요!'); 
인터프리트 방식은 실행할때만 문법 검사, 즉 명령어를 한줄한줄 실행하기전까지 그 문법이 옳지 않은지 검사안함! 
    그래서 장점 : 컴파일 같은거 안함, 인터프리터만 있다면 그대로 바로바로 실행가능(소스파일+인터프리터만 있으면 실행가능)
    단점 : 문법적인게 틀린게 있더라도 그부분을 실행하기전까진 있는지도 모름
        그래서 작은 프로그램을 짤때는 인터프리트 방식은 괜찮은데
        기업에서 짤때는 부적합
*/