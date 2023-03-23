#!/bin/bash

## script to determine how many microJoules consumed by $1 command
## via RAPL counters
## (some commands specific to MMU lab linux implementation)
## NB the 'sudo' commands will only work in certain MMU labs
##
## (c) mkbane

# FAIL upon error
trap 'echo run time error encountered at line ${LINE_NO}; exit' ERR

# enable access to RAPL counters
sudo expose-intel-rapl

# set variable for file name of RAPL counter
ENERGYFILE=/sys/class/powercap/intel-rapl\:0/energy_uj

# save initial RAPL counter value
start=`cat $ENERGYFILE`

# run command $1 and all its args
## NB we redirect standard out and error out to a null file
### if dont wnt output: $@ > /dev/null 2>&1
$@

# save final RAPL counter value
finish=`cat $ENERGYFILE`

# calc energy consumed
let uj=finish-start

echo Energy consumed\: ${uj} microJoules

