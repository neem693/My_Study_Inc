
# coding: utf-8

# In[9]:


a = [1,2,3,5,10]
b2 = list(map(lambda x: x*x, a))

print(b2)
b3 = list(filter(lambda y: y >1, b2))
print(b3)
print(len(b3))


# In[10]:


b = [30,20,10,50]
print("x*x for :",[x*x for x in a])


# In[16]:

import myfunc as my
my.display('a and b')

for x, y in zip(b3, b):
    print(x , y)
[x > y for x, y in zip(b3, b)]


# In[22]:


xx = list(filter(lambda x:x[0]>x[1]  , zip(b3, b) ))
print(xx)
