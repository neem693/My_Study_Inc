
# coding: utf-8

# In[2]:


s3 = ' AAA , BBB , CCC '
print(s3.split()) # 공백이 구분자


# In[ ]:


print(s3.split(',')) # 코마를 구분자로 지정함


# In[ ]:


s3 = ' AAA , BBB , CCC '
print([x.strip() for x in s3.split(',')])


# In[3]:


[x.strip() for x in s3.split(',')]


# In[1]:


f = open('a.txt')
for line in f:
  print(line.rstrip())


# In[3]:


data = [
  'aaa bbb ccc',
  'aaa bb',
  'cc ccc',
  'dddd dd aa',
  'bb ee eee'
]


def doit(data):
  result = []
  no = 1
  for x in data:
    fields = x.split()
    if len(fields) < 3:
        print('이상해요', no, x)
    else:    
        result.append(fields)
    no += 1
  print(result)

doit(data)


# In[21]:


def doit(data):
  result = []
  for x in data:
    if x.startswith('a'):
      result.append(x.split()[0])
  print(result)

doit(data)


# In[32]:


def  do_pushup(withwhom, meal='Kimbob', count=5):
  print('I go with', withwhom)
  for i in range(count):
    print(i, 'I do PUSHUP !')
  print('I eat', meal)

do_pushup('Suji', count=10)


# In[3]:


import time
import datetime

# refer: http://docs.python.org/library/datetime.html

# step = 1 day. use 'date' object
oneday = datetime.timedelta(days=1)
startday = datetime.date(2018, 9, 12)
today = datetime.date.today()

while startday < today:
  print(startday.strftime('%Y-%m-%d'))
  startday += oneday


# In[4]:


import json

b = '{"age": 40, "name": "daehee"}'
c = json.loads(b)
print(type(c))
print(c)

# dump to string
d = json.dumps(c)
print(type(d))
print(d)


# In[5]:


data = [
  'aaa bbb ccc',
  'aaa bb',
  'aaa cc',
  'cc ccc',
  'dddd dd aa',
  'bb ee eee'
]


import collections

a = collections.Counter()

for x in data:
  for word in x.split():
    a[word] += 1

print(a)
print(a.most_common(3))
print(list(a.items()))


# In[1]:


### CSV
mydata = []
f = open('class1.csv', encoding='utf-8')
for line in f:
  line = line.strip()  
  fields = line.split(',')
  mydata.append(fields)
print(mydata)

byname = {}
for record in mydata[1:]:
  byname[record[1]] = record[2:]

for name, scores in byname.items():
    print(name, scores)

