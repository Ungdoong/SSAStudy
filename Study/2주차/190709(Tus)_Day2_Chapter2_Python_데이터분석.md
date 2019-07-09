# 190709(Tus)\_Day2\_Chapter2_Python_데이터분석

## 이론

### Comprehension(리스트로 리스트 만들기)

- ```python
  new_list = [word for word in words]
  ```

### Comprehension에서 특정 요소 제거

- ```python
  new_list = [word for word in words if word.startswith(prefix)]
  ```

### 데이터 정렬

- sorted(변수, key= )
- key
  - abs : 절대값
  - reverse : 역순 (reverse=True 와 동일)

### 그래프 다루기

- Mathematical Plot Library - matplotlib - 파이썬 그래프 라이브러리

## 실습

### 1. 파일 열고 읽기

```python
# 텍스트 파일을 불러옵니다.
corpus = 'corpus.txt'

def print_lines(filename):
    '''
    파일의 내용을 줄 번호와 한 줄씩 출력합니다.
    
    >>> print_lines(corpus)
    1 zoo,768
    2 zones,1168
    3 zone,2553
    '''
    
    line_number = 1
    # 아래 코드를 작성하세요.
    with open('corpus.txt') as corpus:
        for line in corpus:
            print(str(line_number) + " " + line)
            # 1 This is Elice. 와 같이, "(줄번호) (내용)" 형식으로 출력합니다.
            
            line_number += 1
	
    #하위 내용은 enumerate를 사용한 동일한 출력을 나타내는 코드
    #with open('corpus.txt') as corpus:
    #    for index, line in enumerate(corpus):
    #        print(str(index+1) + " " + line)


# 아래 주석을 해제하고 결과를 확인해보세요.  
print_lines(corpus)
```



### 2. 데이터 형태 변환하기

```python
# 텍스트 파일을 불러옵니다.
corpus = 'corpus.txt'

def import_as_tuple(filename):
    '''
    (단어, 빈도수)` 튜플로 구성된 리스트를 리턴합니다.
    
    >>> import_as_tumple(corpus)
    [('zoo', '768'), ('zones', '1168'), ... ] 
    '''
    
    tuples = []
    with open(filename) as file:
        for line in file:
            # 아래 코드를 작성하세요.
            result = line.strip().split(',')
            word = result[0]
            count = result[1]
            t = (word, count)
            
            #t = (result[0], result[1])
            #t = tuple(result)
            
            tuples.append(t)
            
    return tuples


# 아래 주석을 해제하고 결과를 확인해보세요.  
print(import_as_tuple(corpus))
```



### 3. 한 줄 명령어로 데이터 다루기

```python
# 단어 모음을 선언합니다. 수정하지 마세요.
words = [
    'apple',
    'banana',
    'alpha',
    'bravo',
    'cherry',
    'charlie',
]

def filter_by_prefix(words, prefix):
    '''
    prefix로 시작하는 word를 리턴합니다. 

    >>> filter_by_prefix(words, 'a')
    'apple'
    '''
    
    # 아래 코드를 작성하세요.
    new_list = [word for word in words if word.startswith(prefix)]
    
    return new_list


# 아래 주석을 해제하고 결과를 확인해보세요.  
a_words = filter_by_prefix(words, 'a')
print(a_words)
```

### 

### 4. 데이터 정렬하기

```python
# 단어어 해당 단어의 빈도수를 담은 리스트를 선언합니다. 수정하지 마세요.
pairs = [
    ('time', 8),
    ('the', 15),
    ('turbo', 1),
]

def get_freq(pair):
    '''
    (단어, 빈도수) 쌍으로 이루어진 튜플을 받아, 빈도수를 리턴합니다.
    
    >>> get_freq(('time', 8))
    8
    '''
    
    return pair[1]


def sort_by_frequency(pairs):
    '''
    (단어, 빈도수) 꼴 튜플의 리스트를 받아, 빈도수가 낮은 순서대로 정렬하여 리턴합니다.
    
    >>> sort_by_frequency(pairs)
    [('turbo', 1), ('time', 8), ('the', 15)]
    '''
    
    return sorted(pairs, key=get_freq)


# 아래 주석을 해제하고 결과를 확인해보세요.  
print(sort_by_frequency(pairs))
```



### 5. 차트 그리기

```python
# matplotlib의 일부인 pyplot 라이브러리를 불러옵니다.
import matplotlib.pyplot as plt

# 엘리스에서 차트를 그릴 때 필요한 라이브러리를 불러옵니다.
from elice_utils import EliceUtils
elice_utils = EliceUtils()

# 월별 평균 기온을 선언합니다. 수정하지 마세요.
years = [2013, 2014, 2015, 2016, 2017]
temperatures = [5, 10, 15, 20, 17]

def draw_graph():
    '''
    막대 차트를 출력합니다.
    '''
    
    # 막대 그래프의 막대 위치를 결정하는 pos를 선언합니다.
    pos = range(len(years))  # [0, 1, 2, 3, 4]
    
    # 높이가 온도인 막대 그래프를 그립니다.
    # 각 막대를 가운데 정렬합니다.
    plt.bar(pos, temperatures, align='center')
    
    # 각 막대에 해당되는 연도를 표기합니다.
    plt.xticks(pos, years)
    
    # 그래프를 엘리스 플랫폼 상에 표시합니다.
    plt.savefig('graph.png')
    elice_utils.send_image('graph.png')

print('막대 차트를 출력합니다.')
draw_graph()
```

