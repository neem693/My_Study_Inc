
# coding: utf-8

# In[4]:


import pandas as pd  ## 고수준 데이터 모델 (DataFrame) 모듈 pandas
c1 = pd.read_csv('class1.csv')
c2 = pd.read_csv('class2.csv')


# In[5]:


c1


# In[6]:


c2


# In[7]:


c1.수학.max(), c1.수학.mean()


# In[8]:


c2.수학.max(), c2.수학.mean()


# In[9]:


SUBJ = ['국어', '영어', '수학', '과학']


# In[10]:


for s in SUBJ:
    if c1[s].mean() > c2[s].mean():
        print(s, '-->', '1반')
    else:
        print(s, '-->', '2반')


# In[11]:


all_c = pd.concat([c1, c2])


# In[12]:


all_c
    


# In[13]:


c1['반'] = 1
c2['반'] = 2


# In[14]:


c1


# In[15]:


all_c = pd.concat([c1, c2])
all_c


# In[16]:


all_c = pd.concat([c1, c2], ignore_index=True)
all_c


# In[17]:


all_c.영어.describe()


# In[18]:


# all_c['영어_norm'] = (영어점수 - 영어평균) / 영어표준편차
all_c['영어_norm'] = (all_c.영어 - all_c.영어.mean()) / all_c.영어.std()
all_c


# In[19]:


# all_c['영어_norm2'] = (영어점수 - 영어최저) / (영어최고-영어최저)
all_c['영어_norm2'] = (all_c.영어 - all_c.영어.min()) / (all_c.영어.max() - all_c.영어.min())
all_c


# In[20]:


all_c[all_c.영어 > 90]


# In[21]:


all_c[ (all_c.영어 >= 90) & (all_c.수학 >= 80)]


# In[22]:


all_c.query('영어 >= 90 & 수학 >= 80')


# In[23]:


all_c[all_c['영어'] > 90]


# In[24]:


# 컬럼 지정하기
all_c[all_c['영어'] > 90]['이름']


# In[25]:


# 컬럼이 여러 개일때는 list로 지정해야 한다.
all_c[all_c['영어'] > 90][['이름', '영어', '반']]


# In[26]:


all_c[:2]


# In[27]:


all_c[0:10]


# In[29]:


all_c.iloc[10]


# ## pandas의 DataFrame, Series, Numpy의 ndarray

# In[82]:


print(type(all_c))
print(type(all_c.수학))
print(type(all_c.수학.values))


# In[32]:


print(all_c.max()) 
print()
print(all_c.수학.max())  # pandas,  df.max(), 

print(all_c.수학.values.max()) # np.max()


# In[36]:


#all_c
all_c.values[:, 2:6]


# In[3]:


import numpy as np
#all_c.iloc[0].values
np.ndim(all_c)


# In[44]:


all_c.iloc[0].values.shape


# In[87]:


all_c.values


# In[43]:


all_c.values.shape[0]


# In[45]:


all_c.번호.count()

