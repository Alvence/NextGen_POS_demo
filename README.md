# NextGen_POS_demo
This project is created based on case study of NextGen POS of "Applying UML and Patterns, 3rd edition by Craig Larman". For demonstration on subject SWEN30006 at The University of Melbourne

all product specifications are stored in this folder (one product per file) in the following format:
itemId = XX
price = XX
description = XXXX

To compile:
1, mkdir bin (only if bin folder doesn't exist)
2, javac -sourcepath src -d bin src/com/unimelb/swen30006/nextgen/domain/Main.java 

To run:
java -classpath bin com.unimelb.swen30006.nextgen.domain.Main
