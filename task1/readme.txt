Скопируйте информацию ниже в файл "input.txt", чтобы посмотреть как работает программа для матрицы 5х5 с упертым по середине, 
x	5
y	5
Count_a	12
Count_b	13
Count_Conformists	12
Count_Nonconformists	13
Count_Stubborn_A	1
Count_Stubborn_B	1
coordinates_stubborn_A	2;2
cordinates_stubborn_B	2;2


Скопируйте информацию ниже в файл "input.txt", чтобы посмотреть как работает программа для матрицы 5х5 из креста упертых агентов,
x	5
y	5
Count_a	12
Count_b	13
Count_Conformists	12
Count_Nonconformists	13
Count_Stubborn_A	9
Count_Stubborn_B	9
coordinates_stubborn_A	0;2	1;2	2;0	2;1	2;2	2;3	2;4	3;2	4;2
cordinates_stubborn_B	0;2	1;2	2;0	2;1	2;2	2;3	2;4	3;2	4;2

Скопируйте информацию ниже в файл "input.txt", чтобы посмотреть как работает программа для матрицы 5х5 из упертых агентов и не упертый посередине
x	5
y	5
Count_a	12
Count_b	13
Count_Conformists	12
Count_Nonconformists	13
Count_Stubborn_A	24
Count_Stubborn_B	24
coordinates_stubborn_A	0;0	0;1	0;2	0;3	0;4	1;0	1;1	1;2	1;3	1;4	2;0	2;1	2;3	2;4	3;0	3;1	3;2	3;3	3;4	4;0	4;1	4;2	4;3	4;4
cordinates_stubborn_B	0;0	0;1	0;2	0;3	0;4	1;0	1;1	1;2	1;3	1;4	2;0	2;1	2;3	2;4	3;0	3;1	3;2	3;3	3;4	4;0	4;1	4;2	4;3	4;4

Скопируйте информацию ниже в файл "input.txt", чтобы посмотреть как работает программа для матрицы 5х5 с одним нонконформистом,
x	5
y	5
Count_a	25
Count_b	0
Count_Conformists	24
Count_Nonconformists	1
Count_Stubborn_A	0
Count_Stubborn_B	0
coordinates_stubborn_A	0;0
cordinates_stubborn_B	0;0

Скопируйте информацию ниже в файл "input.txt", чтобы посмотреть как работает программа для матрицы 5х5 с одним конформистом,
x	5
y	5
Count_a	25
Count_b	0
Count_Conformists	1
Count_Nonconformists	24
Count_Stubborn_A	0
Count_Stubborn_B	0
coordinates_stubborn_A	0;0
cordinates_stubborn_B	0;0

Чтобы посмотреть как работает программа для матрицы 10х10 со случайным набором агентов и их мнениями, удалите файл "input.txt" из папки.

чтобы начать запустите файл "start.bat", в файле "out.txt" будут выведены поля с мнениями, где * - упертый агент, значения энтропии и доли мнения А
В файлах "entropy.png", "shareA.png" будут сохранены графики изменения энтропии и доли мнения А соответственно