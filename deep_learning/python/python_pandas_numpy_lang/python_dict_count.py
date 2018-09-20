
# coding: utf-8

# ## tuple

# In[1]:


def mysum(x,y):
    return x+y

mysum(10, 7)


# In[2]:


def sum_mul(x,y):
    return x+y, x*y

a = sum_mul(10,7)
print(a)
print('a[0]', a[0])
print('a[1]', a[1])


# In[3]:


x, y = 1, 2 # now x is 1, y is 2
x, y = y, x
print (x, y)


# ## dict, dictionary - key에 의한 index ( java의 Hash map)

# In[3]:


grades = { "Joel" : 80, "Tim" : 95 } # dictionary literal
print(grades)
print(grades['Tim'])
grades['Joel'] = 100
print(grades)
print(grades['Joel'])


# In[4]:


print(grades.get('Joela', 0)) # 없는 key값 -> Exception 발생
len(grades)


# In[5]:


print(grades.keys())
print(grades.values())
print(grades.items())


# In[3]:


document = ['aa', 'a', 'bbb', 'bbb', 'aa', 'c', 'aa']

def way1():
  word_counts = {}

  for word in document:
    if word in word_counts:
      word_counts[word] += 1
    else:
      word_counts[word] = 1
  for k, v in word_counts.items():
    print(k, v)

way1()


# In[ ]:


def way2():
  word_counts = {}
  for word in document:
    try:
      word_counts[word] += 1
    except KeyError:
      word_counts[word] = 1
  for k,v in word_counts.items():
    print(k, v)

way2()


# In[ ]:


def way3():
  word_counts = {}
  for word in document:
    word_counts[word] = word_counts.get(word, 0) + 1
  for k,v in word_counts.items():
    print(k, v)

way3()


# In[ ]:


def way4():
  from collections import defaultdict
  word_counts = defaultdict(int)  # int() produces 0
  for word in document:
    word_counts[word] += 1
  for k,v in word_counts.items():
    print(k, v)

way4()


# In[ ]:


def way_list():
  from collections import defaultdict
  word_list = defaultdict(list)  # int() produces 0
  
  for i, word in enumerate(document):
    word_list[word].append(i)
    
  for k,v in word_list.items():
    print(k, v)

way_list()


# In[ ]:


def way5():
  from collections import Counter
  word_counts = Counter(document)  
  for k,v in word_counts.items():
    print(k, v)

way5()


# ## class 정의 예시. 기본 클래스 dict를 상속 

# In[7]:


class mydict(dict):
    def __init__(self):
        pass
    
    def add(self, word):
        self[word] = self.get(word, 0) + 1
        
    def prn(self):
        for k,v in self.items():
            print(k,v)
    def prn2(self):
        print('===')
        for k in sorted(self.keys(), reverse=True):
            print(k, self[k])
    def prn3(self):
        print('===')
        print(list(self.items()))
        for k, v in sorted(self.items(), key=lambda x:x[1], reverse=True):
            print(k, v)        

mycount = mydict()
mycount.add('bb')
mycount.add('a')
mycount.add('aaa')
mycount.add('bb')
mycount.add('aaa')
mycount.add('aaa')
mycount.prn2()
mycount.prn3()


# ### lambda - inline 함수 정의

# In[ ]:


a = [1,2,3,5,10]

def square(x):
  return x*x

print(square(9))

b1 =  map(square, a)
b1 = list(b1)
print('b1', b1)

# inline, anonymous function ===> lambda
b2 = map(lambda x: x*x, a)
b2 = list(b2)
print('b2', b2)

b3 = filter(lambda y: y > 20, b2)
b3 = list(b3)
print('b3', b3)


