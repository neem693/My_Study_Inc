

# if : 두 가지 중에서 한 가지 코드만 선택하는 문법
a = 110

if a%2 == 1:
    print('odd')
else:
    print('even')


    #논리기준 0:false로 잡는다.

if a%2:
    print('odd')
else:
    print('even')

if a:
    print('odd',a)
    print("{}숫자이다.".format(a))

else:
    print('even')
print('-'*30)

# 문제
# 정수 a가 음수인지 양수인지 0인지 출력하는 코드를 만들어 보세요.
if a > 0:
    print('양수')
else:
    # print('음수, 제로')
    if a < 0:
        print('음수')
    else:
        print('제로')

if a > 0:
    print('양수')
elif a < 0:
    print('음수')
else:
    print('제로')

print('finished.')


##등급출력
kor = 85
grade = "F"
if(kor>=90):
    grade="A"
elif(kor>=80):
    grade="B"
elif(kor>=70):
    grade="C"
elif(kor>=60):
    grade="D"



print("국어점수:{0} 등급:{1}".format(kor,grade))



##출력
#국어:85점 등급:B







print('\n\n\n\n\n\n\n\n\n\n\n\n')
