#Import
import random
#import sys

#Function
def plus_ou_moins():

    #User and Computer choices
    user_number = int(input("Entrez un chiffre entre 0 et 9 : "))
    random_number = random.randint(0,9)

    #If user number > 9


    #Compare user given number with number choices by computer
    while (user_number != random_number):

        #When user number > 9
        if (user_number > 9):    
            print("Oups, entre 0 et 9 on a dit !")
            user_number = int(input("Allez une autre chance, entrez un chiffre entre 0 et 9 : "))
        
        else :    
            user_number = int(input("Pas de bol, retentez un chiffre entre 0 et 9 : "))
    

    if (user_number==random_number) :
        print ('Bravo vous avez vu juste !', "\N{winking face}")
    #else :
        #print("Nul, l'ordi a choisi", random_number)
    
#print(sys.version)
#Add execption on float and string

#Function call
#plus_ou_moins()
    
