
# coding: utf-8

# In[1]:


for n in [1,2,3]:
    print (n, "난 널 사랑해")


# In[2]:


#### Lists
integer_list = [1, 2, 3]
heterogeneous_list = ["string", 0.1, True]
list_of_lists = [ integer_list, heterogeneous_list, [] ]
list_length = len(integer_list) # equals 3
list_sum = sum(integer_list) # equals 6


# In[3]:


## n-th element
x = list(range(10)) # is the list [0, 1, ..., 9]
zero = x[0] # equals 0, lists are 0-indexed
one = x[1] # equals 1
nine = x[-1] # equals 9, 'Pythonic' for last element
eight = x[-2] # equals 8, 'Pythonic' for next-to-last element
x[0] = -1 # now x is [-1, 1, 2, 3, ..., 9]


# In[4]:


## slice of list (range)
first_three = x[:3] # [-1, 1, 2]
three_to_end = x[3:] # [3, 4, ..., 9]
one_to_four = x[1:5] # [1, 2, 3, 4]
last_three = x[-3:] # [7, 8, 9]
without_first_and_last = x[1:-1] # [1, 2, ..., 8]
copy_of_x = x[:] # [-1, 1, 2, ..., 9]


# In[5]:


## in operator
1 in [1, 2, 3] # True
0 in [1, 2, 3] # False


# In[6]:


## operation to list
x = [1, 2, 3]
x.extend([4, 5, 6]) # x is now [1,2,3,4,5,6]


# In[7]:


x = [1, 2, 3]
y = x + [4, 5, 6] # y is [1, 2, 3, 4, 5, 6]; x is unchanged


# In[8]:


x = [1, 2, 3]
x.append(0) # x is now [1, 2, 3, 0]

##
x, y = [1, 2] # now x is 1, y is 2
_, y = [1, 2] # now y == 2, didn't care about the first element


# In[9]:


list(range(10))


# In[10]:


list(range(1,10))


# In[11]:


list(range(1,10,2))


# In[12]:


list(range(20,1,-1))


# In[13]:


X = [i*0.1 for i in range(50)]   
Y = [x*2 + 1  for x in  X]


# In[14]:


print(X[:5])


# In[15]:


a=[1,2,3]
b=[4,5,6]
list(zip(a, b))
for x,y in zip(a,b):
    print(x,y)


# In[16]:


t = (10,20)   
t


# In[17]:


type(t)


# In[18]:


tt = [10, 20]
type(tt)


# In[19]:


x,y = t
print(x, y)


# In[20]:


X = [i*0.1 for i in range(50)]   
w = 2.5
b = 5   
Y = [x*w + b   for x in X]
import numpy as np
X2 = np.array(X)
Y2 = np.array(Y)


# In[23]:


print(type(X), type(X2))
print(X2.shape)
X3 = X2.reshape( (10,5)  )
print(X3.shape)
print(X3.shape[0], X3.shape[1])

