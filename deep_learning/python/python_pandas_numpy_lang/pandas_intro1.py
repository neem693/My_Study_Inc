
# coding: utf-8

# In[1]:


# 패키지 설치가 안되어 있으면 pip 명령을 수행하여 설치를 해야 합니다.
# jupyter notebook 에서는 !(느낌표) 로 시작하면 외부 명령어를 수행한다는 의미입니다.
#! pip install pandas


# In[1]:


import numpy as np  ## 백터, 행렬 데이터 전문 모듈 numpy
import pandas as pd  ## 고수준 데이터 모델 (DataFrame) 모듈 pandas
import matplotlib.pyplot as plt  ## 차트 그리기 모듈 matplotlib

import myfunc as my
my.display('class1.csv 읽기 ')

df = pd.read_csv('class1.csv', encoding='utf-8')


my.display('칼럼이름들')

print('칼럼이름들', list(df.columns) ) 

print(df)


# In[2]:


df


# In[6]:


print(list(df.index))


# In[7]:


df[['이름','국어']]
print(type(df['국어']))
print(type(df.국어))


# In[8]:


kuk = df[['국어']]
print(type(kuk))


# In[8]:


print(df[0:5])
df['국어']


# In[10]:


df.iloc[1]


# In[12]:


#df
df[df.국어 < 50]


# In[12]:

my.display("df[(df.국어 >= 70) | (df.영어 >= 70)]")
print(df[(df.국어 >= 70) | (df.영어 >= 70)])


# In[13]:





my.display("df.query('국어 >= 70 & 영어 >= 70')")
print(df.query("국어 >= 70 & 영어 >= 70"))


# In[14]:


df[['국어', '영어']]


# In[14]:


subjects = ['국어', '영어', '수학', '과학']

df[subjects].sum(axis=0)
print(df[subjects].sum(axis=0))
num_st = df.국어.count()
print(df[subjects].sum(axis=0) / num_st)
print(df[subjects].max(axis=0))



# In[15]:

my.display("총점,평균,최고점 추가")
df['총점'] = df[subjects].sum(axis=1)
df['평균']= df['총점'] / len(subjects)
df['최고점'] = df[subjects].max(axis=1)
print(df)


# In[17]:


#df[['수학']]
print(type(df.수학))
print(type(df['수학']))
print(type(df[['수학']]))


# In[17]:


print('=== 성적순')
df2 = df.sort_values(['영어', '수학'], ascending=[False, False])

print(df2)


# In[ ]:





# In[18]:


# 완전 새롭게 index reset, 정렬
df2.reset_index(inplace=True, drop=True) 
print(df2)


# In[19]:


df2
df2.drop(['총점'], axis=1, inplace=True)
print(df2)


# In[20]:


df2[['이름', '평균']]


# In[21]:


df2.to_csv('sorted_class1.csv', encoding='utf-8', index=False)

