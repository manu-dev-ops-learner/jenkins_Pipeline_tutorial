#Import
import random
#from emoji import emojize
#import sys

#Function
def plus_ou_moins():

    #User and Computer choices
    user_number = int(input("Entrez un chiffre entre 0 et 9 : "))
    random_number = random.randint(0,9)

    #Compare user given number with number choices by computer
    while (user_number != random_number):

        #When user number > 9
        if (user_number > 9):    
            print("Oups, entre 0 et 9 on a dit !", "\U0001F605")
            user_number = int(input("Allez une autre chance, entrez un chiffre entre 0 et 9 : "))
        
        else : 
            #print(emojize(":smiling_face_with_sunglasses:"))   
            print ("\U0001F605")
            user_number = int(input("Pas de bol, retentez un chiffre entre 0 et 9 :" ))
    

    if (user_number==random_number) :
        print ('Bravo vous avez vu juste !', "\N{winking face}")
    #else :
        #print("Nul, l'ordi a choisi", random_number)
    
#print(sys.version)
#Add execption on float and string
#UI For final User
#Run it in docker and in VM Docker container

#Function call
#plus_ou_moins()
    
