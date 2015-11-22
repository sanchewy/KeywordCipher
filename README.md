# KeywordCipher
This is a java keyword cipher program for CSCI 215.

This program will take in a keyword and shift the alphabet around, placing the keyword at the front it as follows:

Keyword: mystic 
Original Alphabet: a b c d e f g h i j k l m n o p q r s t u v w x y z 
Cypher Alphabet: m y s t i c a b d e f g h j k l n o p q r u v w x z

With the newly derived cipher alphabet, a given message will be encoded by replacing the constituent letters with 
letters in like position from the cipher alphabet.

Message: Attack at dawn Encoded message: mqqmsf mq tmvj

The program will include a GUI with text fields for inputting the keyword and for adding or copying messages and 
encrypted messages. It will also have encrypt and decrypt functions (and buttons on the interface). To decrypt you will 
need the keyword used in the encryption process. 

***As an afterthought, I added a feature allowing you to shift the keyword alphabet over a specified amount after creating it. Essentially, this is like preforming a Caesar cipher after preforming a keyword cipher.***
