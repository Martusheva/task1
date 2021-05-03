# -*- coding: utf-8 -*-
"""
Created on Sun May  2 19:12:27 2021

@author: Tatiana
"""
import os
import matplotlib.pyplot as plt
path = os.getcwd()+"\out.txt"
print(path)
with open(path,'r',encoding='cp1252') as file:
    entropy=[]
    shareA=[]
    time = []
    field = []
    for line in file:
        line=line.rstrip('\n')
        if line.startswith('Entropy'):
            entropy.append(float(line.split('\t')[1]))
        elif line.startswith('Share'):
            shareA.append(float(line.split('\t')[1]))
        elif line.startswith('Time'):
            time.append(int(line.split('\t')[1]))
        elif line == '':
            field = []
        else:
            line = line.split('\t')
            field.append(line)
            
    plt.plot(time,entropy)
    
    plt.title('Энтропия по времени')
    plt.xlabel('Время')
    plt.ylabel('Энтропия')
    #plt.show()
    plt.savefig('entropy.png')
    plt.close()
    
    
    plt.plot(time,shareA)
    plt.title('Доля мнения А в популяции')
    plt.xlabel('Время')
    plt.ylabel('Доля')
    #plt.show()
    plt.savefig('shareA.png')
    plt.close()
    
    
    #print(entropy)
    #print(shareA)
    #print(field)
    #print(time)