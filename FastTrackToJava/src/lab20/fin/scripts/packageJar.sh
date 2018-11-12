#!/bin/bash

# Craete the jar from the classes directory
cd ../../../../out/production/FastTrackToJava
jar -cvf lab20/bank.jar lab20/fin

# Run the BankDemo from the jar
java -cp lab20/bank.jar lab20.fin.com.mycorp.BankDemo
