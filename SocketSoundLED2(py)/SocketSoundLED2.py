# -*- coding: utf-8 -*- 

from socket import *

# clientSocket = socket(AF_INET,SOCK_STREAM)
# HOST = "192.168.0.111"
# PORT = 50007


# clientSocket.connect((HOST,PORT))

from select import select
import time            #calling for time to provide delays in program

import pygame
    #import pyglet

import RPi.GPIO as IO  #calling for header file which helps in using GPIO’s of PI
import time       #calling for time to provide delays in program
IO.setwarnings(False)  #do not show any warnings
x=1
y=1
IO.setmode (IO.BCM)  #programming the GPIO by BCM pin numbers. (like PIN29 as'GPIO5')
IO.setup(12,IO.OUT)  #initialize GPIO12 as an output.
IO.setup(22,IO.OUT)  #initialize GPIO22 as an output.
IO.setup(27,IO.OUT)
IO.setup(25,IO.OUT)
IO.setup(17,IO.OUT)
IO.setup(24,IO.OUT)
IO.setup(23,IO.OUT)
IO.setup(18,IO.OUT)
IO.setup(21,IO.OUT)
IO.setup(20,IO.OUT)
IO.setup(26,IO.OUT)
IO.setup(16,IO.OUT)
IO.setup(19,IO.OUT)
IO.setup(13,IO.OUT)
IO.setup(6,IO.OUT)
IO.setup(5,IO.OUT)




#pygame.init()

PORTVALUE = [128,64,32,16,8,4,2,1]
#value of pin in each port 
E=[0B11111110,0B11111110,0B11000000,0B11111110,0B11111110,0B11000000,0B11111110,0B11111110]
F=[0B11111110,0B11111110,0B11000000,0B11111110,0B11111110,0B11000000,0B11000000,0B11000000]
S=[0B00111100,0B01100110,0B01100010,0B00110000,0B00001100,0B01000110,0B01100110,0B00111100]
U=[0B11000011,0B11000011,0B11000011,0B11000011,0B11000011,0B01100110,0B00111100,0B00000000]
V=[0B11000011,0B11000011,0B11000011,0B01100110,0B01100110,0B00111100,0B00011000,0B00011000]
N1=[0B00001000,0B00011000,0B00001000,0B00001000,0B00001000,0B00001000,0B00001000,0B00011100]
N2=[0B00000000,0B00111100,0B01000010,0B00000010,0B00011100,0B00100000,0B01000000,0B01111110]
N3=[0B00000000,0B00111100,0B01000010,0B00000010,0B00111100,0B00000010,0B01000010,0B00111100]
N4=[0B00000100,0B00001100,0B00001100,0B00010100,0B00100100,0B01111111,0B00000100,0B00000100]
N5=[0B00000000,0B01111110,0B01000000,0B01000000,0B01111110,0B00000010,0B00000010,0B01111110]
N6=[0B00000000,0B01111110,0B01000000,0B01000000,0B01111110,0B01000010,0B01000010,0B01111110]
N7=[0B00000000,0B01111110,0B01000010,0B01000010,0B00000010,0B00000010,0B00000010,0B00000010]
N8=[0B00000000,0B01111110,0B01000010,0B01000010,0B01111110,0B01000010,0B01000010,0B01111110]
N9=[0B00000000,0B01111110,0B01000010,0B01000010,0B01111110,0B00000010,0B00000010,0B00000010]
N10=[0B00000000,0B01011110,0B01010010,0B01010010,0B01010010,0B01010010,0B01010010,0B01011110]

def PORT(pin):  #assigning GPIO state by taking 'pin' value
    if(pin&0x01 == 0x01):
        IO.output(21,1)   #if bit0 of 8bit 'pin' is true pull PIN21 low
    else:
        IO.output(21,0)   #if bit0 of 8bit 'pin' is false pull PIN21 high

    if(pin&0x02 == 0x02):
    
        IO.output(20,1)   #if bit1 of 8bit 'pin' is true pull PIN20 low
    else:
        IO.output(20,0)   #if bit1 of 8bit 'pin' is false pull PIN20 high
    
    if(pin&0x04 == 0x04):
        IO.output(26,1)   #if bit2 of 8bit 'pin' is true pull PIN26 low
    else:
        IO.output(26,0)   #if bit2 of 8bit 'pin' is false pull PIN26 high

    if(pin&0x08 == 0x08):
        IO.output(16,1)
    else:
        IO.output(16,0)
    if(pin&0x10 == 0x10):
        IO.output(19,1)
    else:
        IO.output(19,0)
    if(pin&0x20 == 0x20):
        IO.output(13,1)
    else:
        IO.output(13,0)
    if(pin&0x40 == 0x40):
        IO.output(6,1)
    else:
        IO.output(6,0)
    if(pin&0x80 == 0x80):
        IO.output(5,1)
    else:
        IO.output(5,0)

def PORTP(pinp):    #assigning GPIO logic for positive terminals by taking 'pinp' value
    if(pinp&0x01 == 0x01): 
        IO.output(12,0)     #if bit0 of 8bit 'pinp' is true pull PIN12 high
    else:
        IO.output(12,1)     #if bit0 of 8bit 'pinp' is false pull PIN12 low
    if(pinp&0x02 == 0x02):
        IO.output(22,0)     #if bit1 of 8bit 'pinp' is true pull PIN22 high
    else:
        IO.output(22,1)     #if bit1 of 8bit 'pinp' is false pull PIN22 low
    if(pinp&0x04 == 0x04):
        IO.output(27,0)     #if bit2 of 8bit 'pinp' is true pull PIN27 high
    else:
        IO.output(27,1)     #if bit2 of 8bit 'pinp' is false pull PIN27 low
    if(pinp&0x08 == 0x08):
        IO.output(25,0)
    else:
        IO.output(25,1)
    if(pinp&0x10 == 0x10):
        IO.output(17,0)
    else:
        IO.output(17,1)
    if(pinp&0x20 == 0x20):
        IO.output(24,0)
    else:
        IO.output(24,1)
    if(pinp&0x40 == 0x40):
        IO.output(23,0)
    else:
        IO.output(23,1)
    if(pinp&0x80 == 0x80):
        IO.output(18,0) #if bit7 of 8bit 'pinp' is true pull PIN18 high
    else:
        IO.output(18,1) #if bit7 of 8bit 'pinp' is false pull PIN18 low


pygame.mixer.init()

clientSocket = socket(AF_INET,SOCK_STREAM)
HOST = "192.168.0.100"
#HOST = "165.229.125.45"
PORTINET = 50008
clientSocket.connect((HOST,PORTINET))

#clientSocket.sendall(bytes("connection\n",'UTF-8'))
HJ = "Hello\n"
count = 0




try:
    while True:
        
        time.sleep(2.2)
        
        count = (count%9)+1
        HE = str(count)+HJ
        clientSocket.sendall(HE)
        print('Send : '+HE)
        data = clientSocket.recv(1024)
        msg = data.decode("utf-8")
        print(msg)
        
        if 'quit' in msg:
            break
        if 'F' in msg:
            print("I got TFail")
            if '1' in msg:
                print("Port 1 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P1F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N1[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '2' in msg:
                print("Port 2 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P2F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N2[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '3' in msg:
                print("Port 3 Fail") 
                bang = pygame.mixer.Sound("/home/pi/Downloads/P3F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N3[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '4' in msg:
                print("Port 4 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P4F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N4[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '5' in msg:
                print("Port 5 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P5F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N5[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '6' in msg:
                print("Port 6 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P6F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N6[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '7' in msg:
                print("Port 7 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P7F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N7[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '8' in msg:
                print("Port 8 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P8F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N8[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '9' in msg:
                print("Port 9 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P9F.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N9[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= F[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);  
        if 'E' in msg:
            print("I got Error")
            if '1' in msg:
                bang = pygame.mixer.Sound("/home/pi/Downloads/P1U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N1[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '2' in msg:
                print("Port 2 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P2U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N2[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '3' in msg:
                print("Port 3 Fail") 
                bang = pygame.mixer.Sound("/home/pi/Downloads/P3U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N3[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '4' in msg:
                print("Port 4 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P4U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N4[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '5' in msg:
                print("Port 5 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P5U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N5[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '6' in msg:
                print("Port 6 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P6U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N6[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '7' in msg:
                print("Port 7 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P7U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N7[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '8' in msg:
                print("Port 8 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P8U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N8[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '9' in msg:
                print("Port 9 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P9U.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N9[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= U[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp); 
        if 'V' in msg:
            print("I got TSuccess")
            if '1' in msg:
                bang = pygame.mixer.Sound("/home/pi/Downloads/P1V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N1[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '2' in msg:
                print("Port 2 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P2V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N2[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '3' in msg:
                print("Port 3 Fail") 
                bang = pygame.mixer.Sound("/home/pi/Downloads/P3V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N3[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '4' in msg:
                print("Port 4 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P4V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N4[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '5' in msg:
                print("Port 5 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P5V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N5[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '6' in msg:
                print("Port 6 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P6V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N6[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '7' in msg:
                print("Port 7 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P7V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N7[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '8' in msg:
                print("Port 8 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P8V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N8[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);    
            elif '9' in msg:
                print("Port 9 Fail")
                bang = pygame.mixer.Sound("/home/pi/Downloads/P9V.wav")
                bang.play()
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= N9[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp);
                for y in range (100):
                    for x in range (8):
                        pin  = PORTVALUE[x]
                        PORT(pin);
                        pinp= V[x]
                        PORTP(pinp);
                        time.sleep(0.0005)
                pinp= 0
                PORTP(pinp); 
        else:
            print(msg)
    clientSocket.close()
except Exception as e:
    print(e)

print("Socket was closed")
