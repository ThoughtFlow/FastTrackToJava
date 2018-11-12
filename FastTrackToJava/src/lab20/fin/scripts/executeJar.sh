#!/bin/bash

# Craete the jar from the classes directory
jar -ufe ../../../../out/production/FastTrackToJava/lab20/bank.jar lab20.fin.com.mycorp.BankDemo

# Run the BankDemo from the jar
java -jar ../../../../out/production/FastTrackToJava/lab20/bank.jar lab20.fin.com.mycorp.BankDemo
