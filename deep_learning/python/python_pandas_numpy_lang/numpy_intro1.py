import myfunc as my

# coding: utf-8

# ## python list vs. numpy array

# In[1]:

my.display('list출력')

A = list(range(10))
print(type(A))
print(A)


# In[2]:

my.display('numpy 출력')

import numpy as np
A2 = np.array(A)
print(type(A2))
print(A2)


# In[3]:

print("차수:",A2.ndim)
print("요소수:",A2.shape)


# In[4]:
my.display('AA 출력')

AA = [[1,2,3], [4,5,6]]
print(len(AA))
print(len(AA[0]))

print(type(AA))
print(AA)


# In[5]:

my.display('AA numpy 출력')
AA2 = np.array(AA)
print(type(AA2))
print("차수",AA2.ndim)
print("요소수",AA2.shape)
print(AA2)


# # shape

# In[6]:

my.display('B numpy 출력')
B = np.array(range(24))


# In[7]:


print(B.shape)
print(B.shape[0])
print(B)


# In[8]:
my.display('B reshape(-1,4) 출력')

B2 = B.reshape((-1,4))
print(B.shape)
print(B2.shape)
print(B2)

print(B2.shape[0],B2.shape[1])

# In[9]:

my.display('B reshape(-1,4,3) 출력')
B3 = B.reshape((-1, 4, 3))
print(B3.shape)
print(B3)



my.display('numpy 인덱스사용법 ')
# ## numpy array - 인덱스 사용법

# In[ ]:


data = [[67, 87, 90, 98],
[45, 45, 56, 98],
[95, 59, 96, 88],
[65, 94, 89, 98],
[45, 65, 78, 98],
[78, 76, 98, 89],
[87, 67, 65, 56],
[89, 98, 78, 78],
[100, 78, 56, 65],
[99, 89, 87, 87],
[98, 45, 56, 54],
[65, 89, 87, 78]]


# In[ ]:


arr = np.array(data)


# In[ ]:

my.display('arr')
print(arr)


# In[ ]:

my.display('arr[0]')
print(arr[0]) # row 0


# In[ ]:

my.display('arr[0][2]')
print(arr[0][2]) # row 0, col 2


# In[ ]:

my.display('arr[0,2]')
print(arr[0,2])


# In[ ]:

my.display('arr[:2]')
print(arr[:2]) # from 0 till 2 - row 0, 1


# In[ ]:

my.display('arr[:2,2:]')
print(arr[:2, 2:])


# In[ ]:

my.display('arr[:2,-2:]')
print(arr[:2, -2:])


# ## operation on array

# In[ ]:


import numpy as np
A = np.array(range(20))
AA = A/20
AAA = A < 10


# In[ ]:

my.display('AA : A/20')
print(AA)


# In[ ]:

my.display('AAA : A < 10')
print(AAA)

